package com.clearlove.fileupload;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author promise
 * @date 2020/12/16 - 23:38
 */
public class uploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 文件是以流的方式交给服务器的
//        String username = request.getParameter("username");
//        System.out.println("username " + username);
        // 文件上传的方式是一种新的解析方式
        ServletInputStream inputStream = request.getInputStream();
        // commons-io-2.0.jar 简化所有流操作
//        byte[] temp = new byte[1024];
//        while (inputStream.read() != -1){
//
//        }
        String s = IOUtils.toString(inputStream);
        System.out.println(s);
        response.getWriter().write("ok....");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet1...");
        this.doPost(request, response);
    }
}
