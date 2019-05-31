package cn.javabs.servlet;

import cn.javabs.entity.User;
import cn.javabs.service.UserService;
import cn.javabs.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet( request,  response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        // 1. 接收 前台html/jsp 传过来的form表单中的name属性
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");

        System.out.println(username+":"+password+":"+sex);


        //2. 将获取的变量 封装到  user对象中
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setSex(sex);
        System.out.println(u.getUsername());
        UserService userService = new UserServiceImpl();
        int rows = userService.addUser(u);
        if(rows>0){
//            request.setAttribute("msg","添加用户成功！");
//            request.getRequestDispatcher("/message.jsp").forward(request,response);
            response.getWriter().write("添加用户成功！");
        }else{
            response.getWriter().write("添加用户失败！");
//            request.setAttribute("msg","添加用户！");
//            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }
}
