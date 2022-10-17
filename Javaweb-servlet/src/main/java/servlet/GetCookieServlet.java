package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

/**
 * @author summer
 * @create 2022-10-17 11:19
 * @Description
 */
public class GetCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 声明响应编码
        resp.setCharacterEncoding("utf-8");
        //resp.setHeader("Co","application");
        resp.setContentType("text/html");
        // 获取输出类
        PrintWriter writer = resp.getWriter();

        // 获取Cookie数组
        Cookie[] cookies = req.getCookies();
        // 定义在上一次cookie查询结果标识
        boolean flag = false;
        for (Cookie cookie:cookies) {
            System.out.println("<h1>"+ "name = "+ cookie.getName()+ ",value = " +cookie.getValue() + "</h1>");
            if(cookie.getName().equals("lastLoginTime")){
                writer.print("<h1>上一次登录时间: "+ cookie.getValue() + "</h1>");
                flag = true;
                break;
            }
        }
        if(!flag){
            writer.print("<h1>first login</h1>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
