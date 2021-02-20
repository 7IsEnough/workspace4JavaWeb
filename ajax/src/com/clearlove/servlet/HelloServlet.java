package com.clearlove.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author promise
 * @date 2020/11/18 - 23:30
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HelloServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        doPost(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().write("<h1>哈哈哈哈</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
