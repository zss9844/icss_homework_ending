package com.icss.meeting.controller;

import com.icss.meeting.service.EmployeeService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //edit author 18301278庄双双
         // 1.从前端获取登录信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String timechoose = request.getParameter("timelength");
        int num = Integer.parseInt(timechoose);
        HttpSession session = request.getSession();
        // 2.带着信息去数据库中进行校验，并得到校验结果
        int login = EmployeeService.checklogin(username, password);
        ServletContext sc = request.getServletContext();
        Object visitcount = sc.getAttribute("vc");
        if (visitcount == null) {
            visitcount = "0";
        }
        int vc = Integer.parseInt(visitcount.toString()) + 1;
        sc.setAttribute("vc", vc);
        if (login == 0) {
            request.setAttribute("error", "用户待审批，请稍候");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (login == 1) {
            //状态正确 可以登陆 跳转到index主页 
            request.getSession().setAttribute("loginUser", EmployeeService.getLoginUser());
            response.sendRedirect(request.getContextPath() + "/index.jsp");
          //将用户名账号密码存入到session中
            session.setAttribute("username",username);
            session.setAttribute("password",password);
          //前端获取的时间，设置对应有效期
            if (num==0){session.setMaxInactiveInterval(0);}
            if (num==10){session.setMaxInactiveInterval(60*60*24*10);}
            if (num==30){session.setMaxInactiveInterval(60*60*24*30);}
        } else if (login == 2) {
            request.setAttribute("error", "用户审批未通过，请重新注册");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (login == 3) {
            request.setAttribute("error", "用户名或者密码输入错误，请重新登录");
            request.getRequestDispatcher("/login.jsp\").forward(request, response);\n" +
                    "        } else if (login == -1) {\n" +
                    "            request.setAttribute(\"error\", \"账号已关闭，登陆失败，请联系管理员\");\n" +
                    "            request.getRequestDispatcher(\"/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
