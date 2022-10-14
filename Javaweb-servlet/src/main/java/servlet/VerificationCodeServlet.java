package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author summer
 * @create 2022-10-12 20:37
 * @Description 生成验证码
 */
public class VerificationCodeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建图片对对象
        Image image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        // 获取图片画笔对象 2D 图片对象
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        // 设置图片的背景颜色
        graphics.setColor(Color.WHITE);
        // 图片颜色填充范围
        graphics.fillRect(0,0,80,20);
        // 给图片写数据
        // 画笔设置颜色
        graphics.setColor(Color.YELLOW);
        // 设置字体
        graphics.setFont(new Font(null,Font.BOLD,20));
        // 写入随机数
        graphics.drawString(makeRandNum(),0,20);
        graphics.dispose();
        // 设置响应返回类型,请求以图片的形式打开
        resp.setContentType("image/jpeg");
        // 网站缓存图片，不让浏览器缓存图片
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        // 把图片写给浏览器
//        ServletOutputStream outputStream = resp.getOutputStream();
        ImageIO.write((RenderedImage) image,"jpg",resp.getOutputStream());
    //    outputStream.close();
    }

    /**
     * 生成八位随机数
     * @return
     */
    private String makeRandNum(){
        Random random = new Random();
        String numString = random.nextInt(9999999) + "";
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 7 -numString.length(); i++) {
            buffer.append("0");
        }
        numString = buffer.toString() + numString;
        return numString;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
