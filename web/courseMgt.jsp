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
            <li class="active">
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
      <input type="button" class="btn btn-danger" value="添加课程" onclick="new function() {
        $('#addModal').modal('show');
      }">
      <table class="table table-striped table-hover" id="usertable">
        <%= request.getAttribute("allcourse")%>
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
              <label for="cid">课程号</label><input type="text" class="form-control" id="cid" name="cid" readonly/>
            </div>
            <div class="form-group">
              <label for="cname">课程名</label><input type="text" class="form-control" id="cname" name="cname" />
            </div>
            <div class="form-group">
              <label for="cscore">学分</label><input type="text" class="form-control" id="cscore" name="cscore" />
            </div>
            <div class="form-group">
              <label for="theorylesson">理论课时</label><input type="text" class="form-control" id="theorylesson" name="theorylesson" />
            </div>
            <div class="form-group">
              <label for="practicelesson">实践课时</label><input type="text" class="form-control" id="practicelesson" name="practicelesson" />
            </div>
            <div class="form-group">
              <label for="testmethod">考试方式</label><input type="text" class="form-control" id="testmethod" name="testmethod"/>
            </div>
            <div class="form-group">
              <label for="testdate">考试时间</label><input type="text" class="form-control" id="testdate" name="testdate"/>
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
        <button type="button" class="btn btn-primary" onclick="updateCourseInfoAjax()">
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
        <h4 class="modal-title" id="addmyModalLabel">
          添加课程信息
        </h4>
      </div>
      <div class="modal-body">
        <%--form--%>
        <form role="form" id="addmodalForm">
          <div class="form-group">
            <label for="addcid">课程号</label><input type="text" class="form-control" id="addcid" name="cid" />
          </div>
          <div class="form-group">
            <label for="addcname">课程名</label><input type="text" class="form-control" id="addcname" name="cname" />
          </div>
          <div class="form-group">
            <label for="addcscore">学分</label><input type="text" class="form-control" id="addcscore" name="cscore" />
          </div>
          <div class="form-group">
            <label for="addtheorylesson">理论课时</label><input type="text" class="form-control" id="addtheorylesson" name="theorylesson" />
          </div>
          <div class="form-group">
            <label for="addpracticelesson">实践课时</label><input type="text" class="form-control" id="addpracticelesson" name="practicelesson" />
          </div>
          <div class="form-group">
            <label for="addtestmethod">考试方式</label><input type="text" class="form-control" id="addtestmethod" name="testmethod"/>
          </div>
          <div class="form-group">
            <label for="addtestdate">考试时间</label><input type="text" class="form-control" id="addtestdate" name="testdate"/>
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
        <button type="button" class="btn btn-primary" onclick="addCourseInfoAjax()">
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
