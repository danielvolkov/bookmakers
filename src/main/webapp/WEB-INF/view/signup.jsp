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
<div class="container ">
    <div class="row">

    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="form-group">
                <h2>
                Fill the registration form
                </h2>
            </div>
            <form class="center-block" method="post" action="./signup">
                <div class="form-group">
                    <label for="name">Enter your name:</label>
                    <input type="text" class="form-control" id="name">
                </div>
                <div class="form-group">
                    <label for="email">Enter your email address:</label>
                    <input type="email" class="form-control" id="email">
                </div>
                <div class="form-group">
                    <label for="pwd">Enter your password:</label>
                    <input type="password" class="form-control" id="pwd">
                </div>
                <div class="form-group">
                    <label for="pwd">Confirm the password:</label>
                    <input type="password" class="form-control" id="confirm_pwd">
                </div>
                <div class="form-group">
                    <label for="role">Choose your role:</label>
                    <select class="form-control" id="role">
                        <option>Client</option>
                        <option>Bookmaker</option>
                    </select>
                </div>
            <div class="text-center">
                <button type="submit" class="btn btn-success">Register</button>
            </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
