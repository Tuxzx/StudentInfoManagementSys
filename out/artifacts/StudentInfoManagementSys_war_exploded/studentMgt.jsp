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
            <li class="active">
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
      <%--<input type="button" class="btn btn-danger" value="添加学生" onclick="openModal()">--%>
      <input type="button" class="btn btn-danger" value="添加学生" onclick="new function() {
        $('#addModal').modal('show');
      }">
      <table class="table table-striped table-hover" id="usertable">
        <%= request.getAttribute("alluserinfo")%>
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
          用户信息修改
        </h4>
      </div>
      <div class="modal-body">
        <%--form--%>
          <form role="form" id="modalForm">
            <div class="form-group">
              <label for="uid">学号</label><input type="text" class="form-control" id="uid" name="uid"/>
            </div>
            <div class="form-group">
              <label for="username">用户名</label><input type="text" class="form-control" id="username" name="username" />
            </div>
            <div class="form-group">
              <label for="password">密码</label><input type="text" class="form-control" id="password" name="password" />
            </div>
            <div class="form-group">
              <label for="gender">性别</label>
              <select class="form-control" id="gender" name="gender">
                <option value="男">男</option>
                <option value="女">女</option>
              </select>
            </div>
            <div class="form-group">
              <label for="age">年龄</label><input type="text" class="form-control" id="age" name="age" />
            </div>
            <div class="form-group">
              <label for="tel">电话</label><input type="text" class="form-control" id="tel" name="tel" />
            </div>
            <div class="form-group">
              <label for="role">权限</label><input type="text" class="form-control" id="role" name="role"/>
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
        <button id="modalsubmit" type="button" class="btn btn-primary" onclick="updateUserInfoAjax()">
          提交更改
        </button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal -->
</div>


<!-- 模态框（Modal） -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
          &times;
        </button>
        <h4 class="modal-title" id="addModalLabel">
          添加新用户
        </h4>
      </div>
      <div class="modal-body">
        <%--form--%>
        <form role="form" id="addmodalForm">
          <div class="form-group">
            <label for="adduid">学号</label><input type="text" class="form-control" id="adduid" name="uid"/>
          </div>
          <div class="form-group">
            <label for="addusername">用户名</label><input type="text" class="form-control" id="addusername" name="username" />
          </div>
          <div class="form-group">
            <label for="addpassword">密码</label><input type="text" class="form-control" id="addpassword" name="password" />
          </div>
          <div class="form-group">
            <label for="addgender">性别</label>
            <select class="form-control" id="addgender" name="gender">
              <option value="男">男</option>
              <option value="女">女</option>
            </select>
          </div>
          <div class="form-group">
            <label for="addage">年龄</label><input type="text" class="form-control" id="addage" name="age" />
          </div>
          <div class="form-group">
            <label for="addtel">电话</label><input type="text" class="form-control" id="addtel" name="tel" />
          </div>
          <div class="form-group">
            <label for="addrole">权限</label><input type="text" class="form-control" id="addrole" name="role"/>
          </div>
        </form>
        <%--progress--%>
        <div class="progress progress-striped active">
          <div class="progress-bar progress-bar-success" role="progressbar"
               aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
               style="width: 0%;" id="addprogress">
            <span class="sr-only">Saving</span>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
        </button>
        <button type="button" class="btn btn-primary" onclick="addNewUserAjax()">
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
