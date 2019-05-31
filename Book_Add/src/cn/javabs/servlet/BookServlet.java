package cn.javabs.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 基于IDEA | 采用 Servlet3.0注解方式、即代表不需要再写web.xml
 * @author Mryang
 */
@WebServlet("/myBookServlet")
public class BookServlet extends HttpServlet {
    protected void    doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // alt + enter  快捷键
        // ctrl+alt+↓ 向下复制

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String bookName = request.getParameter("bookName");
        String bookPrice = request.getParameter("bookPrice");
        System.out.println("您输入的内容是:"+bookName+":"+bookPrice);
        response.getWriter().write("我收到数据了！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost( request,  response);
    }
}
