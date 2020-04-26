package com.icss.meeting.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.icss.meeting.controller.LoginServlet;
import java.io.IOException;

@WebServlet("/RemoveSessionServlet")
public class RemoveSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //消除session中存入的数据，进行退出登陆操作 返回login.jsp
        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("password");
        request.getSession().invalidate();
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
