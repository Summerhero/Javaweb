package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author summer
 * @create 2022-10-17 11:19
 * @Description
 */
public class RemoveCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 获取Cookie信息
//        Cookie[] cookies = req.getCookies();
//        // 遍历删除最新登录时间Cookie
//        for (Cookie cookie:cookies) {
//            if(cookie.getName().equals("lastLoginTime")){
//                cookie.setMaxAge(0);
//                resp.addCookie(cookie);
//            }
//        }
        Cookie cookie = new Cookie("lastLoginTime","forDelete");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
