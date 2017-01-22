<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 1/19/17
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bookmaker`s login page</title>
</head>
<style>
    <%@include file="/bootstrap.css" %>
</style>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"/>
<div class="container default-c">
    <div class="col-md-4 col-md-offset-4 panel-default">
       <div class="text-center" style="margin:10%">
            <h2>
                Login page
            </h2>
       </div>
        <div class="panel panel-primary">

            <div class="panel-footer">

                <form class="center-block" method="post" action="/login">

                    <div class="form-group">
                        <label for="email">Enter your email address:</label>
                        <input type="email" class="form-control" id="email">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Enter your password:</label>
                        <input type="password" class="form-control" id="pwd">
                    </div>

                    <div class="text-center">
                        <button type="submit" class="btn btn-success">Login</button>
                    </div>
                </form>
                <div class="form-group row text-center">
                    <h5>
                        If you already don`t have an account <a href="/signup"> Sign UP</a>
                    </h5>
                </div>
            </div>
        </div>

    </div>

</div>

</body>
</html>
