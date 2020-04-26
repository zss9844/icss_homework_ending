<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/18 0018
  Time: 下午 3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="${APP_PATH}/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
    <h2 class="page-header">
        个人中心
        <small>我的预定</small>
    </h2>
    <!-- 我的会议开始 -->
    <strong>我预定的会议:</strong>
    <table class="table table-hover">
        <thead>
        <tr class="info">
            <td>会议名称</td>
            <td>会议室</td>
            <td>起始时间</td>
            <td>结束时间</td>
            <td>预定时间</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.mrs}" var="mr">
            <tr>
                <td>${mr.meetingname}</td>
                <td>${mr.roomname}</td>
                <td>${mr.starttime}</td>
                <td>${mr.endtime}</td>
                <td>${mr.reservationtime}</td>
                <td>
                    <a class="clickbutton" href="/meeting/meetingdetail?mid=${mr.meetingid}&type=cancel">查看/撤销</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- 我的会议结束 -->
</div>
<!--引入jquery-->
<script src="${APP_PATH}/js/jquery.min.js"></script>
<!--引入bootstrap的js功能-->
<script src="${APP_PATH}/js/bootstrap.min.js"></script>
</body>
</html>

