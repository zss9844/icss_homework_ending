<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/18 0018
  Time: 下午 3:08
  To change this template use File | Settings | File Templates.
--%>
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
        <small>最新通知</small>
    </h2>
    <!-- 我的会议开始 -->
    <strong>未来7天我要参加的会议:</strong>
    <table class="table table-hover">
        <thead>
        <tr class="info">
            <td>会议名称</td>
            <td>会议室</td>
            <td>起始时间</td>
            <td>结束时间</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${mt7}" var="mt">
            <tr>
                <td>${mt.meetingname}</td>
                <td>${mt.roomname}</td>
                <td>${mt.starttime} </td>
                <td>${mt.endtime}</td>
                <td>
                    <a class="clickbutton" href="#">查看详情</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- 我的会议结束 -->
    <!-- 取消会议开始 -->
    <strong>已取消的会议:</strong>
    <table class="table table-hover">
        <thead>
        <tr class="info">
            <td>会议名称</td>
            <td>会议室</td>
            <td>起始时间</td>
            <td>结束时间</td>
            <td>取消原因</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cm}" var="m">
            <tr>
                <td>${m.meetingname}</td>
                <td>${m.roomname}</td>
                <td>${m.starttime} </td>
                <td>${m.endtime}</td>
                <td>${m.canceledreason}</td>
                <td>
                    <a class="clickbutton" href="#">查看详情</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- 取消会议结束 -->
</div>
<!--引入jquery-->
<script src="${APP_PATH}/js/jquery.min.js"></script>
<!--引入bootstrap的js功能-->
<script src="${APP_PATH}/js/bootstrap.min.js"></script>
</body>
</html>
