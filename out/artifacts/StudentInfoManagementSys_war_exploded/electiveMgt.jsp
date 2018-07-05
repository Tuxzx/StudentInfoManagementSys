<%@ page import="com.tuxzx.sci.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: tuxzx
  Date: 2018/7/1
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%-- Bootshrap --%>
  <link href="./css/bootstrap.min.css" rel="stylesheet">
  <script src="./js/cus.js"></script>
  <title>学生信息后台管理</title>
</head>
<body>
<% User user = (User) request.getSession().getAttribute("user");%>
<div class="container">
  <div class="row clearfix">
    <div class="col-md-12 column">
      <nav class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">管理员：<%= user.getUsername() %></a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li>
              <a href="./adminMgt.jsp">个人信息</a>
            </li>
            <li>
              <a href="./MgtGetAllUserInfoServlet">学生信息管理</a>
            </li>
            <li>
              <a href="./MgtGetAllCourseInfoServlet">课程信息管理</a>
            </li>
            <li class="active">
              <a href="./MgtGetAllElectiveInfoServlet">学生选课管理</a>
            </li>
            <li>
              <a href="#">学生课程统计信息管理</a>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li>
              <a href="#">安全退出</a>
            </li>
          </ul>
        </div>
      </nav>
      <table class="table table-striped table-hover" id="usertable">
        <%= request.getAttribute("allElective")%>
      </table>
    </div>
  </div>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
          &times;
        </button>
        <h4 class="modal-title" id="myModalLabel">
          学生成绩修改
        </h4>
      </div>
      <div class="modal-body">
        <%--form--%>
          <form role="form" id="modalForm">
            <div class="form-group">
              <label for="uid">学号</label><input type="text" class="form-control" id="uid" name="uid" readonly/>
            </div>
            <div class="form-group">
              <label for="uname">姓名</label><input type="text" class="form-control" id="uname" name="uname" readonly />
            </div>
            <div class="form-group">
              <label for="cid">课程号</label><input type="text" class="form-control" id="cid" name="cid" readonly/>
            </div>
            <div class="form-group">
              <label for="cname">课程名</label><input type="text" class="form-control" id="cname" name="cname" readonly/>
            </div>
            <div class="form-group">
              <label for="result">成绩</label><input type="text" class="form-control" id="result" name="result" />
            </div>
          </form>
          <%--progress--%>
          <div class="progress progress-striped active">
            <div class="progress-bar progress-bar-success" role="progressbar"
                 aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
                 style="width: 0%;" id="progress">
              <span class="sr-only">Saving</span>
            </div>
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
        </button>
        <button type="button" class="btn btn-primary" onclick="updateElectiveInfoAjax()">
          提交更改
        </button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal -->
</div>

<%-- 插入jquery和 bootstrap --%>
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>
