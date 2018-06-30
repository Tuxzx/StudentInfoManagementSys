<%--
  Created by IntelliJ IDEA.
  User: tuxzx
  Date: 2018/6/28
  Time: 11:11
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
                    Something wrong!
                </h1>
                <p>
                    <%= request.getAttribute("error") %>
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="index.jsp">Home</a>
                </p>
            </div>
        </div>
    </div>
</div>

<%-- 插入jquery和 bootstrap --%>
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>
