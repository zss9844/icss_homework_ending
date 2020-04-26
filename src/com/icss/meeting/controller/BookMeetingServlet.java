package com.icss.meeting.controller;

import com.icss.meeting.dao.SelDao;
import com.icss.meeting.pojo.Sel;
import com.icss.meeting.service.SelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/BookMeetingServlet")
public class BookMeetingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        List<Sel> list = new SelService().getSels();
        request.setAttribute("mrs", list);
        request.getRequestDispatcher("/myorder.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
