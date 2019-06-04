package cn.javabs.school.servlet;

import cn.javabs.school.entity.Admin;
import cn.javabs.school.entity.Admin;
import cn.javabs.school.service.AdminService;
import cn.javabs.school.service.impl.AdminSeviceImpl;
import cn.javabs.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/adminServlet")
public class AdminServlet extends BaseServlet {

    // 实例化 AdminService    为什么要在全局呢！  原因是下放有两个方法{登录、注销} 两个方法都可能用到 、因此定义在全局！
    AdminService adminService  =  new AdminSeviceImpl();
    /**
     * 用户登录
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    protected String userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 接受 前台jsp的参数
        String usercode = request.getParameter("usercode");
        String password = request.getParameter("password");

        System.out.println("接收到的参数有:"+usercode+":"+password);

        // 判断接收到的 参数 是否为空| 如果不为null对象或者不为空字符串 、代表有数据！ 有数据就可以传递到service层
        if(!usercode.equalsIgnoreCase("") || !password.equalsIgnoreCase("")|| usercode != null || password != null){

            // 传递用户名和密码到 adminService 、 返回一个admin对象 属于 Admin 类型 | 原因： 根据有户名和密码查询 返回的是一个用户  则即代表的是Admin
                // 返回的admin 不知道是不是有数据或者没有数据     没有数据就是null
            Admin admin = adminService.login(usercode,password);

            // 判断返回的对象是不是空的！| 如果不是空的，代表有这个用户  能登录！| admin中有usercode和password
            if(admin != null){
                // Session 为Http会话对象、如何获取呢? | 通过请求对象获取session【云端缓存】
                // 通过请求对象获取session【云端缓存】| 将admin存储到云端缓存session  | 因此可以理解为将usercode和password放到 session中去| Session生命周期默认为30min
                // 在云端缓存中 设置 一个标记{记号} 存放admin对象、[用户名和密码]
                request.getSession().setAttribute("ADMIN_SESSION",admin);
                return  "forward:/main.jsp";
            }else{// 否： 是空 {根据用户名和密码查询、没有查询用户} 因此需要调整到登录页面
                return "redirect:/login.jsp";
            }
        }else{// 接受到的参数是空的
            // 通过请求对象 设置一个记号 | 记号的名称是msg 、msg 的内容是"用户名或者密码不许为空！"
            request.setAttribute("msg","用户名或者密码不许为空！");
            // 转发到 message.jsp页面  在在这页面通过El表达式取该记号msg 则将msg其中的内容取出来 显示到页面中！
            return  "forward:/message.jsp";
        }
    }

    /**
     * 用户注销
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    protected String userLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "";
    }
}
