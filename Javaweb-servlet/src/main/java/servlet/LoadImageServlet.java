package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author summer
 * @create 2022-10-12 19:59
 * @Description 资源下载
 */
public class LoadImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 带下载资源路径
        String filePath = "C:\\Users\\summer\\Desktop\\美少女2.png";
        // 下载文件名称,即真实路径最后一个斜杠后的子串
        String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
        // 设置响应头，是浏览器支持文件下载
        resp.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName,"utf-8"));
        // 获取文件输入流，从而读取文件
        InputStream inputStream = new FileInputStream(filePath);
        // 获取文件写入流，从而写入
        ServletOutputStream outputStream = resp.getOutputStream();
        // 设置缓存
        byte[] buffer = new byte[1024];
        // 读取长度
        int readLen = 0;
        // 写入文件
        while ((readLen = inputStream.read(buffer)) > 0){
            outputStream.write(buffer,0,readLen);
        }
        // 关闭输入输出流
        inputStream.close();
        outputStream.close();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
