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
            <li class="active">
              <a href="./adminMgt.jsp">个人信息</a>
            </li>
            <li>
              <a href="./MgtGetAllUserInfoServlet">学生信息管理</a>
            </li>
            <li>
              <a href="./MgtGetAllCourseInfoServlet">课程信息管理</a>
            </li>
            <li>
              <a href="./MgtGetAllElectiveServlet">学生选课管理</a>
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
      <div class="col-md-8 column">
        <h1 class="h1">个人信息</h1>
        <form role="form" action="UserInfoServlet">
          <div class="form-group">
            <label for="uid">账号</label><input type="text" class="form-control" id="uid" name="uid" value="<%=user.getUid()%>" readonly/>
          </div>
          <div class="form-group">
            <label for="username">用户名</label><input type="text" class="form-control" id="username" name="username" value="<%=user.getUsername()%>" />
          </div>
          <%String selected = null;
            if (user.getGender().equals("女")) {
              selected = "selected";
            }%>
          <div class="form-group">
            <label for="gender">性别</label>
            <select class="form-control" id="gender" name="gender">
              <option value="男">男</option>
              <option value="女" <%= selected%>>女</option>
            </select>
          </div>
          <div class="form-group">
            <label for="age">年龄</label><input type="text" class="form-control" id="age" name="age" value="<%=user.getAge()%>" />
          </div>
          <div class="form-group">
            <label for="tel">电话</label><input type="text" class="form-control" id="tel" name="tel" value="<%=user.getTel()%>" />
          </div>
          <div class="form-group">
            <%
              String role = null;
              if (user.getRole() == 0) {
                role = "学生";
              }
              else {
                role = "教师";
              }
            %>
            <label for="role">权限</label><input type="text" class="form-control" id="role" name="role" value="<%= role%>" readonly/>
          </div>
          <button type="submit" class="btn btn-warning">保存</button>
        </form>
      </div>
    </div>
  </div>
</div>


<%-- 插入jquery和 bootstrap --%>
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>
