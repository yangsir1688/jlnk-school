package cn.javabs.school.servlet;

import cn.javabs.school.entity.News;
import cn.javabs.school.service.NewsService;
import cn.javabs.school.service.impl.NewsServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/newsServlet")
public class NewsServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request,  response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");

        if (op.equals("addNews")){
            addNews(request,response);
        }else if (op.equals("findAllNews")){
            findAllNews(request,response);
        }else  if (op.equals("delNews")){
            delNews(request,response);
        }else if (op.equals("updateNews")){
            updateNews(request,response);
        }else{
            System.out.println("前台的参数写错了，没有找到对应方法");
        }
    }

    private void updateNews(HttpServletRequest request, HttpServletResponse response) {
    }

    /**
     * 删除新闻
     * @param request
     * @param response
     */
    private void delNews(HttpServletRequest request, HttpServletResponse response) {
    }

    private void findAllNews(HttpServletRequest request, HttpServletResponse response) {
    }

    /**
     * 添加新闻
     * @param request
     * @param response
     */
    private void addNews(HttpServletRequest request, HttpServletResponse response) {
//        String title = request.getParameter("title");
//        String description = request.getParameter("description");
//        String content = request.getParametecontentr("content");
//        String createtime = request.getParameter("createtime");
//
        News news = new News();
//        news.setTitle(title);
//        news.setContent(content);


        try {
            BeanUtils.populate( news   ,   request.getParameterMap());
                NewsService newsService =  new NewsServiceImpl();
            int rows = newsService.addNews(news);
            if (rows>0){

            }else{

            }
        } catch (Exception e) {
           throw  new RuntimeException(e);
        }

    }
}
