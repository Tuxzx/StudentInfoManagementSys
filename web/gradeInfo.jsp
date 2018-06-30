<%--
  Created by IntelliJ IDEA.
  User: tuxzx
  Date: 2018/6/19
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%-- Bootshrap --%>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <title>课程信息</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    成绩查询 <small>以下为该学期成绩信息</small>
                </h1>
            </div>
            <table class="table table-striped table-hover">
                <%= request.getAttribute("gradeInfo")%>
            </table>
        </div>
    </div>
</div>

<%-- 插入jquery和 bootstrap --%>
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>
