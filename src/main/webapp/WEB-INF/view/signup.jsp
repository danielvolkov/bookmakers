<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 17/01/17
  Time: 01:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>

    <!--link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"-->
</head>
<style>
    <%@include file="/bootstrap.css" %>
</style>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"/>
<div class="container ">
    <div class="row">

    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="form-group">
                <h1>
                Fill the registration form
                </h1>
            </div>
            <form class="center-block" method="post" action="/signup">
                <label class="label-default">${signupError}</label>
                <div class="form-group">
                    <label>Enter your name:</label>
                    <input type="text" class="form-control" name="name">
                </div>
                <div class="form-group">
                    <label >Enter your email address:</label>
                    <input type="email" class="form-control" name="email">
                </div>
                <div class="form-group">
                    <label >Enter your password:</label>
                    <input type="password" class="form-control" name="password">
                </div>
                <div class="form-group">
                    <label>Choose your role:</label>
                    <select class="form-control" name="role">
                        <option>Client</option>
                        <option>Bookmaker</option>
                    </select>
                </div>
            <div class="text-center">
                <button type="submit" class="btn btn-success">Register</button>
            </div>
            </form>
            <div class="form-group row text-center">
                <h5>
                    If you already have an account, please <a href="/login"> Login</a>
                </h5>
            </div>
        </div>
    </div>
</div>
</body>
</html>
