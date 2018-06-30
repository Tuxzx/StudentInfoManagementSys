<%--
  Created by IntelliJ IDEA.
  User: tuxzx
  Date: 2018/6/28
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%-- Bootshrap --%>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <title>学生课程信息管理系统-登陆</title>
  </head>
  <body>
    <div class="container">
      <div class="row clearfix">
        <div class="col-md-12 column">
          <div class="jumbotron">
            <h1>
              学生信息管理系统
            </h1>
            <p>
              移动互联1601 涂夏梓莘
            </p>
            <p>
              <a class="btn btn-primary btn-large" href="#">Learn more</a>
            </p>
          </div>
          <%--
          表单内容
          账号输入框 name = "uid" id = "uid"
          密码输入框 name="password id = "password"
          --%>
          <form role="form" action="LoginServlet">
            <div class="form-group">
              <label for="uid">账号</label><input type="text" class="form-control" id="uid" name="uid" />
            </div>
            <div class="form-group">
              <label for="password">密码</label><input type="password" class="form-control" id="password" name="password" />
            </div>
            <div class="checkbox">
              <label><input type="checkbox" />记住密码</label>
            </div>
            <button type="submit" class="btn btn-default">登陆</button>
          </form>
          <a type="submit" class="btn btn-default" href="register.jsp">注册</a>
        </div>
      </div>
    </div>
    <%-- 插入jquery和 bootstrap --%>
    <script src="./js/jquery.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
  </body>
</html>
