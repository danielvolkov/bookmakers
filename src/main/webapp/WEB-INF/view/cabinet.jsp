<%@ page import="util.constants.Attributes" %>
<%@ page import="model.entity.User" %>
<%@ page import="util.MoneyTypeConverter" %>
<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 1/22/17
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cabinet</title>
</head>
<style>
    <%@include file="/bootstrap.css" %>
</style>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"/>

<% User user = (User) request.getSession().getAttribute(Attributes.USER);%>
<div class="col-md-6 col-md-offset-3 " >
    <div class="jumbotron " style="padding: 5%">
        <h1>Cabiet</h1>
        <h3>Hello, <strong><%=user.getName()%></strong></h3>
        <p class="lead">
            Your role is <strong><%=user.getRole().name()%></strong><br>
            Your email is <strong><%=user.getEmail()%></strong><br>
            Your current balance is <strong><%=MoneyTypeConverter.longToDouble(user.getBalance())%> USD </strong><br>
        </p>

        <form class="form-inline" method="post" action="/deposite">
            <div class="form-group">
                <label >Enter deposite summ</label>
                <input type="text" class="form-control" name="deposite">
            </div>
            <button type="submit" class="btn btn-success">Submit deposite summ</button>
        </form>

        <form class="form-inline" method="post" action="/withdraw">
            <div class="form-group">
                <label >Enter withdraw summ</label>
                <input type="text" class="form-control" name="withdraw">
            </div>
            <button type="submit" class="btn btn-primary">Submit withdraw summ</button>
        </form>

    </div>
</div>

</body>
</html>
