<%--
  Created by IntelliJ IDEA.
  User: tuxzx
  Date: 2018/6/28
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%-- Bootshrap --%>
  <link href="./css/bootstrap.min.css" rel="stylesheet">
  <script src="./js/cus.js"></script>
  <title>课程信息</title>
</head>
<body>
<div class="container">
  <div class="row clearfix">
    <div class="col-md-12 column">
      <div class="page-header">
        <h1>
          学生选课 <small>small title</small>
        </h1>
      </div>
        <table class="table table-striped table-hover" id="now">
          <%= request.getAttribute("allCourse")%>
        </table>
      <h3 class="h3">已选课程</h3>
      <table class="table table-striped table-hover" id="added">
        <%= request.getAttribute("selectedCourse")%>
      </table>
    </div>
  </div>
</div>

<%-- 插入jquery和 bootstrap --%>
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>
