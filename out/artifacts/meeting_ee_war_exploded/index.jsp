<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/18 0018
  Time: 下午 3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>会议管理系统</title>
    <link rel="stylesheet" href="${APP_PATH}/css/bootstrap.min.css" />
</head>

<body>
<!-- 导航条开始 -->
<div class="navbar navbar-inverse navbar-fixed-top">
    <!-- 内容开始 -->
    <div class="container">
        <!-- 头部开始 -->
        <div class="navbar-header">
            <!--logo开始-->
            <a href="#" class="navbar-brand">
                <img src="${APP_PATH}/img/logo.png" height="100%" />
            </a>
            <!--logo结束-->
            <!--projectName开始-->
            <a href="#" class="navbar-brand">XXX会议管理系统</a>
            <!--projectName结束-->
        </div>
        <!-- 头部结束 -->
        <!-- 头部菜单开始 -->
        <div>
            <!--普通文本开始-->
            <p class="navbar-text">
                欢迎您：
                <a href="#" class="navbar-link">jack</a>
            </p>
            <!--普通文本结束-->

            <!--表单开始-->
            <form class="navbar-form navbar-left visible-xs-block visible-md-block visible-lg-block">
                <div class="form-group">
                    <input type="search" class="form-control" placeholder="请输入搜索关键字" />
                    <input type="submit" class="btn btn-success" value="搜索" />
                </div>
            </form>
            <!--表单结束-->

            <!--退出登录-->
            <a href="#" class="btn btn-danger navbar-btn navbar-right">退出登录</a>
            <!--退出登录-->

        </div>
        <!-- 头部菜单结束 -->
    </div>
    <!-- 内容结束 -->
</div>
<!-- 导航条结束 -->
<!-- 外层容器开始 -->
<div class="container-fluid" style="margin-top: 80px;">
    <!-- 行开始 -->
    <div class="row">
        <!-- 面板组开始 -->
        <div class="panel-group col-md-2" id="accordion">
            <!--面板1-->
            <div class="panel panel-primary">
                <!--面板标题-->
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a href="#one" data-toggle="collapse">个人中心</a>
                    </h4>
                </div>
                <!--面板内容-->
                <div id="one" class="panel-collapse collapse in">
                    <div class="panel-body">
                        <ul>
                            <li class="active">
                                <a href="#news" data-toggle="tab" id="aNews">最新通知</a>
                            </li>
                            <li>
                                <a href="#myOrder" data-toggle="tab" id="aMyorder">我的预定</a>
                            </li>
                            <li>
                                <a href="#meeting" data-toggle="tab" id="aMeeting">我的会议</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!--面板2-->
            <div class="panel panel-primary">
                <!--面板标题-->
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a href="#two" data-toggle="collapse">人员管理</a>
                    </h4>
                </div>
                <!--面板内容-->
                <div id="two" class="panel-collapse collapse in">
                    <div class="panel-body">
                        <ul>
                            <li>
                                <a href="#dept" data-toggle="tab" id="aDept">部门管理</a>
                            </li>
                            <li>
                                <a href="#register" data-toggle="tab" id="aRegister">员工注册</a>
                            </li>
                            <li>
                                <a href="#approval" data-toggle="tab" id="aApproval">注册审批</a>
                            </li>
                            <li>
                                <a href="#selEmp" data-toggle="tab" id="aSelEmp">搜索员工</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!--面板3-->
            <div class="panel panel-primary">
                <!--面板标题-->
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a href="#three" data-toggle="collapse">会议预定</a>
                    </h4>
                </div>
                <!--面板内容-->
                <div id="three" class="panel-collapse collapse in">
                    <div class="panel-body">
                        <ul>
                            <li>
                                <a href="#add" data-toggle="tab" id="aAdd">添加会议室</a>
                            </li>
                            <li>
                                <a href="#sel" data-toggle="tab" id="aSel">查看会议室</a>
                            </li>
                            <li>
                                <a href="#order" data-toggle="tab" id="aOrder">预定会议</a>
                            </li>
                            <li>
                                <a href="#search" data-toggle="tab" id="aSearch">搜索会议</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- 面板组结束 -->

        <!-- 显示内容 -->
        <!-- 主内容区开始 -->
        <div class="col-md-10 tab-content">
            <!-- 显示内容开始 -->
            <!-- 最新通知开始 -->
            <div id="news" class="active tab-pane embed-responsive embed-responsive-16by9">
                <!-- 使用内嵌框架事件页面的跳转 -->
                <iframe id="iNews" class="embed-responsive-item" src="/news.jsp"></iframe>
            </div>
            <!-- 最新通知结束 -->

            <!-- 我的预定开始 -->
            <div id="myOrder" class="tab-pane embed-responsive embed-responsive-16by9">
                <iframe id="iMyorder" class="embed-responsive-item" src="/myorder.jsp"></iframe>
            </div>
            <!-- 我的预定结束 -->

            <!--我的会议开始-->
            <div id="meeting" class="tab-pane embed-responsive embed-responsive-16by9">
                <iframe id="iMeeting" class="embed-responsive-item" src="/meeting.jsp"></iframe>
            </div>
            <!-- 我的会议结束 -->

            <!-- 部门管理结束 -->
            <div id="dept" class="tab-pane embed-responsive embed-responsive-16by9">
                <iframe id="iDept" class="embed-responsive-item" src="/DeptServlet"></iframe>
            </div>
            <!-- 部门管理结束 -->

            <!-- 员工注册结束 -->
            <div id="register" class="tab-pane embed-responsive embed-responsive-16by9">
                <iframe id="iRegister" class="embed-responsive-item" src="/AddEmpServlet"></iframe>
            </div>
            <!-- 员工注册结束 -->

            <!-- 注册审批开始 -->
            <div id="approval" class="tab-pane embed-responsive embed-responsive-16by9">
                <iframe id="iApproval" class="embed-responsive-item" src="/approval.jsp"></iframe>
            </div>
            <!-- 注册审批结束 -->

            <!-- 搜素员工开始 -->
            <div id="selEmp" class="tab-pane embed-responsive embed-responsive-16by9">
                <iframe id="iSelEmp" class="embed-responsive-item" src="/search.jsp"></iframe>
            </div>
            <!-- 搜素员工结束 -->

            <!-- 添加会议开始 -->
            <div id="add" class="tab-pane embed-responsive embed-responsive-16by9">
                <iframe id="iAdd" class="embed-responsive-item" src="/add.jsp"></iframe>
            </div>
            <!-- 添加会议结束 -->

            <!-- 查看会议开始 -->
            <div id="sel" class="tab-pane embed-responsive embed-responsive-16by9">
                <iframe id="iSel" class="embed-responsive-item" src="/SelServlet"></iframe>
            </div>
            <!-- 查看会议结束 -->

            <!-- 我的预定开始 -->
            <div id="order" class="tab-pane embed-responsive embed-responsive-16by9">
                <iframe id="iOrder" class="embed-responsive-item" src="/myorder.jsp"></iframe>
            </div>
            <!-- 我的预定结束 -->

            <!-- 会议搜索开始 -->
            <div id="search" class="tab-pane embed-responsive embed-responsive-16by9">
                <iframe id="iSearch" class="embed-responsive-item" src="/selEmp.jsp"></iframe>
            </div>
            <!-- 会议搜索结束 -->
        </div>
        <!-- 主内容区结束 -->
    </div>
    <!-- 行结束 -->
</div>
<!-- 外层容器结束 -->
<!-- 结尾开始 -->
<div class="modal-footer">
    更多问题联系管理员<br />
    <img src="${APP_PATH}/img/icss.jpg" class="img-rounded" />
</div>
<!-- 结尾结束 -->
<!--引入jquery-->
<script src="${APP_PATH}/js/jquery.min.js"></script>
<!--引入bootstrap的js功能-->
<script src="${APP_PATH}/js/bootstrap.min.js"></script>

<script src="js" type="text/javascript" charset="utf-8"></script>
</body>

</html>