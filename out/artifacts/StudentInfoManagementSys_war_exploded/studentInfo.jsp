<%@ page import="com.tuxzx.sci.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: tuxzx
  Date: 2018/6/14
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%-- Bootshrap --%>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <title>个人信息</title>
  </head>
  <body>
  <% User user = (User)request.getSession().getAttribute("user"); %>
  <div class="container">
    <div class="row clearfix">
      <div class="col-md-12 column">
        <div class="jumbotron well">
          <h1>
            欢迎你
          </h1>
          <p>
            <%= user.getUsername()%>
          </p>
        </div>
        <div class="row clearfix">
          <div class="col-md-8 column">
            <h1 class="h1">个人信息</h1>
              <form role="form" action="InfoServlet">
                <div class="form-group">
                  <label for="uid">学号</label><input type="text" class="form-control" id="uid" name="uid" value="<%=user.getUid()%>" disabled/>
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
                  <label for="role">权限</label><input type="text" class="form-control" id="role" name="role" value="<%= role%>" disabled/>
                </div>
                <button type="submit" class="btn btn-warning">保存</button>
              </form>
          </div>
          <div class="col-md-4 column">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h3 class="panel-title">
                  Menu
                </h3>
              </div>
              <div class="panel-body">
                <a href="/CourseSelectServlet">个人选课</a>
              </div>
              <div class="panel-body">
                <a href="/CourseServlet">课程信息</a>
              </div>
              <div class="panel-body">
                <a href="#">成绩查询</a>
              </div>
              <div class="panel-footer">

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <%-- 插入jquery和 bootstrap --%>
  <script src="./js/jquery.min.js"></script>
  <script src="./js/bootstrap.min.js"></script>
  </body>
</html>
