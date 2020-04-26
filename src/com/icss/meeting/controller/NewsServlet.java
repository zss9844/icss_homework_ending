package com.icss.meeting.controller;

import com.icss.meeting.pojo.Employee;
import com.icss.meeting.pojo.Meeting;
import com.icss.meeting.pojo.Sel;
import com.icss.meeting.service.MeetingService;
import com.icss.meeting.service.SelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        int loginEmpId = ((Employee) request.getSession().getAttribute("loginUser")).getEmployeeId();
      // 取数据放入列表，传到前端jsp
        List<Meeting> mt7 = MeetingService.getMeeting7Days(loginEmpId);
        List<Meeting> cm =MeetingService.getCanceledMeeting(loginEmpId);
        request.setAttribute("mt7", mt7);
        request.setAttribute("cm", cm);
        request.getRequestDispatcher("/news.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
