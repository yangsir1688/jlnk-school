package cn.javabs.school.servlet;

import cn.javabs.school.entity.User;
import cn.javabs.school.service.UserService;
import cn.javabs.school.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request,  response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        if ("addUser".equals(op)){
            addUser( request,  response);
        }else if ("updateUser".equals(op)){
            updateUser( request,  response);
        }else if("delUser".equals(op)){
            delUser( request,  response);
        }else if("findAllUsers".equals(op)){
            findAllUsers( request,  response);
        }else if("editUser".equals(op)){
            editUser( request,  response);
        }else if("goToAddUserView".equals(op)){
            goToAddUserView( request,  response);
        }else if("userLogin".equals(op)){
            userLogin( request,  response);
        }else if("userLogout".equals(op)){
            userLogout( request,  response);
        }
        else{
            System.out.println("参数传递有误！");
        }

    }

    /**
     * 用户退出
     * @param request
     * @param response
     */
    private void userLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        session.removeAttribute("USER_SESSION");
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    /**
     * 用户登录
     * @param request
     * @param response
     */
    private void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
        }  catch (Exception e) {
            throw  new RuntimeException(e);
        }
        User u = userService.UserLogin(user.getUsername(), user.getPassword());
        if(u!= null){
            HttpSession session = request.getSession();
            session.setAttribute("USER_SESSION",u);// USER_SESSION 是一个记号|标记
            request.getRequestDispatcher("/admin/main.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","用户登录失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 去添加用户页面的方法
     * @param request
     * @param response
     */
    private void goToAddUserView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/addUser.jsp").forward(request,response);
    }

    private void findAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> list = userService.findAllUser();

        request.setAttribute("list",list);
        request.getRequestDispatcher("/admin/UserList.jsp").forward(request,response);
    }

    /**
     * 修改用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int  userId = Integer.parseInt(id);
        User user = new User();
        try {
            user.setId(userId);// user中只要id  有没有username  password ... 都没有
            BeanUtils.populate(user,request.getParameterMap());//  有了username  password ... | 不会管 id的问题
            // user 有 了  id  username  password ...
        } catch (Exception e) {
             throw  new RuntimeException(e);
        }
        int rows = userService.updateUser(user);
        if (rows>0){
            request.setAttribute("msg","修改用户成功");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","修改用户失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    private void delUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        int  userId = Integer.parseInt(id);
        int rows = userService.delUser(userId);
        if (rows>0){
            request.setAttribute("msg","删除用户成功");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","删除用户失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }


    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
            int rows = userService.addUser(user);
            
            if (rows>0){
                request.setAttribute("msg","添加用户成功");
                request.getRequestDispatcher("/message.jsp").forward(request,response);
            }else{
                request.setAttribute("msg","添加用户失败");
                request.getRequestDispatcher("/message.jsp").forward(request,response);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println("id:"+id);
        int  userId = Integer.parseInt(id);
        System.out.println("userId:"+userId);
        User user = userService.findUserById(userId);

        if (user != null){
            request.setAttribute("user",user);
            request.getRequestDispatcher("/admin/updateUser.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","用户数据回显失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }
}
