package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author summer
 * @create 2022-10-12 19:27
 * @Description
 */
public class LoginServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("我是get请求");
        resp.setCharacterEncoding("UTF-8");
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("userpwd"));
        System.out.println("我要重定向至成功页面");
        resp.sendRedirect("/success.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("我是post请求");
        resp.setCharacterEncoding("UTF-8");
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("userpwd"));
        System.out.println("我要转发至成功页面");
        req.getRequestDispatcher("/success.jsp").forward(req,resp);
    }
}
