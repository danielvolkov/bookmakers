<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.i18n.LocaleHolder" %>
<%@ page import="java.util.Locale" %>

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
    <jsp:include page="/WEB-INF/view/navbar.jsp"/>
    <fmt:requestEncoding value="UTF-8" />
    <fmt:setLocale value="${sessionScope[Attributes.LOCALE]}" />
    <fmt:setBundle basename="bookmakers" var="msg"/>

    <title><fmt:message key="signup.title" bundle="${msg}"/></title>
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
                <h1>
                    <fmt:message key="signup.title" bundle="${msg}"/>
                </h1>
            </div>
            <form class="center-block" method="post" action="/signup">
                <label class="label-default">${signupError}</label>
                <div class="form-group">
                    <label><fmt:message key="msg.name" bundle="${msg}"/></label>
                    <input type="text" class="form-control" name="name">
                </div>
                <div class="form-group">
                    <label ><fmt:message key="msg.email" bundle="${msg}"/></label>
                    <input type="email" class="form-control" name="email">
                </div>
                <div class="form-group">
                    <label ><fmt:message key="msg.password" bundle="${msg}"/></label>
                    <input type="password" class="form-control" name="password">
                </div>
                <div class="form-group">
                    <label><fmt:message key="msg.role" bundle="${msg}"/></label>
                    <select class="form-control" name="role">
                        <option>Client</option>
                        <option>Bookmaker</option>
                    </select>
                </div>
            <div class="text-center">
                <button type="submit" class="btn btn-success"><fmt:message key="signup" bundle="${msg}"/></button>
            </div>
            </form>
            <div class="form-group row text-center">
                <h5>
                    <fmt:message key="msg.login" bundle="${msg}"/> <a href="/login"> <fmt:message key="login" bundle="${msg}"/></a>
                </h5>
            </div>
        </div>
    </div>
</div>
</body>
</html>
