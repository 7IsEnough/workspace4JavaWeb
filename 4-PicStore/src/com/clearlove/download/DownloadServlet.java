package com.clearlove.download;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @author promise
 * @date 2020/12/27 - 18:14
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String file = request.getParameter("file");
        if (file.equals("zip")) {
            // 1.将文件流如何正确交给浏览器
        } else if (file.equals("jpg")){
            // 1.找到图片在服务器中的真实位置 servletContext.getRealPath("资源地址")
            ServletContext context = getServletContext();
            // 2.找到图片所在的真实位置
            String realPath = context.getRealPath("/pics/1.jpg");
            System.out.println(realPath);

            // 设置响应头
            // Content-Disposition: 内容的处理方式  attachment:附件(浏览器就会下载)
            response.setHeader("Content-Disposition","attachment;filename=???");

            // 3.获取要下载的文件的流
            FileInputStream is = new FileInputStream(realPath);
            // 4.将这个输入流写给浏览器
            ServletOutputStream os = response.getOutputStream();
            // 5.输入流写给输出流
            IOUtils.copy(is,os);
            os.close();
            is.close();


        }else {
            response.getWriter().write("ddddd");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
