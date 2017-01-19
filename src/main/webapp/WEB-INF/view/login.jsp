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
    <title>Login page</title>
</head>
<style>
    <%@include file="/bootstrap.css" %>
</style>
<body>
<div class="container ">
    <div class="row">

    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="form-group">
                <h2>
                    Login page
                </h2>
            </div>
            <form class="center-block" method="post" action="./login">

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
        </div>
    </div>
</div>

</body>
</html>
