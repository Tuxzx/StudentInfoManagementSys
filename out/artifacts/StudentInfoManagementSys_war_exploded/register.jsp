<%--
  Created by IntelliJ IDEA.
  User: tuxzx
  Date: 2018/6/30
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%-- Bootshrap --%>
  <link href="./css/bootstrap.min.css" rel="stylesheet">
  <title>Title</title>
</head>
<body>
<div class="container">
  <div class="row clearfix">
    <div class="col-md-12 column">
      <div class="jumbotron">
        <h1>
          注册
        </h1>
        <p>
          <a class="btn btn-primary btn-large" href="index.jsp">Home</a>
        </p>
      </div>
      <form role="form" action="RegisterServlet">
        <div class="form-group">
          <label for="uid">学号</label><input required type="text" class="form-control" id="uid" name="uid" placeholder="请输入账号"/>
        </div>
        <div class="form-group">
          <label for="username">用户名</label><input type="text" required class="form-control" id="username" name="username" placeholder="请输入用户名" />
        </div>
        <div class="form-group">
          <label for="password">密码</label><input type="password" required class="form-control" id="password" name="password" placeholder="请输入密码" />
        </div>
        <div class="form-group">
          <label for="ensurepassword">确认密码</label><input type="password" onblur="checkPasswords()" required class="form-control" id="ensurepassword" name="ensurepassword" placeholder="请输入再次输入密码" />
        </div>
        <div class="form-group">
          <label for="gender">性别</label>
          <select class="form-control" id="gender" name="gender">
            <option value="男" selected>男</option>
            <option value="女">女</option>
          </select>
        </div>
        <div class="form-group">
          <label for="age">年龄</label><input type="number" required min="1" max="200" class="form-control" id="age" name="age" placeholder="请输入年龄" />
        </div>
        <div class="form-group">
          <label for="tel">电话</label><input type="text" class="form-control" id="tel" name="tel" placeholder="请输入电话号码" />
        </div>
        <button type="submit" class="btn btn-warning">注册</button>
      </form>
    </div>
  </div>
</div>

<script>
    function checkPasswords() {
        var pass1 = document.getElementById("password");
        var pass2 = document.getElementById("ensurepassword");

        if (pass1.value != pass2.value)
            pass1.setCustomValidity("两次输入的密码不匹配");
        else
            pass1.setCustomValidity("");
    }
</script>
<%-- 插入jquery和 bootstrap --%>
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>
