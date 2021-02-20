package com.clearlove.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author promise
 * @date 2020/11/19 - 0:01
 */
@WebServlet("/getInfo")
public class getInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().write("<h1>hahahahahahaha</h1>");
//        request.setAttribute("msg","<h1>hahahahahahaha</h1>"+ UUID.randomUUID().toString());
//        request.getRequestDispatcher("/index.jsp").forward(request,response);
        response.getWriter().write("");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
