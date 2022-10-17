package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @author summer
 * @create 2022-10-17 18:56
 * @Description
 */
public class AddCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String lastTime = simpleDateFormat.format(System.currentTimeMillis());
        System.out.println("时间 = " + lastTime);
        Cookie cookie = new Cookie("lastLoginTime",lastTime);
        cookie.setMaxAge(60*3);
        resp.addCookie(cookie);
    }
}
