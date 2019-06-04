package org.mryang.devtools.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 脚手架
 */
@WebServlet("/baseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        int position = requestURI.lastIndexOf("/");
        String methodName = requestURI.substring(position + 1);

        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            String dispatcherPage = (String) method.invoke(this, req, resp);

            System.out.println("dispatcher的内容是:" + dispatcherPage);// dispatcherPage 就是 return 后的 结果
            if (dispatcherPage !=  null){
                if(dispatcherPage.contains(":")){
                    String[] datas = dispatcherPage.split(":");
                    System.out.println("datas数组的长度是："+datas.length);
                    System.out.println("datas数组的第1个参数是："+datas[0]);// forward
                    System.out.println("datas数组的第2个参数是："+datas[1]);// /mian.jsp
                    if("forward".equals(datas[0])){
                        req.getRequestDispatcher(datas[1]).forward(req,resp);
                    }else if("redirect".equals(datas[0])){
                        resp.sendRedirect(req.getContextPath()+datas[1]);
                    }
                }else{
                    req.getRequestDispatcher(dispatcherPage).forward(req,resp);
                }
            }else{
                System.out.println("error");
            }

        } catch (NoSuchMethodException e) {
           throw new RuntimeException("找不到执行方法，原因可能是调用的servlet的权限不够，更改为public"+e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("IllegalAccessException"+e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("InvocationTargetException"+e);
        }

    }
}
