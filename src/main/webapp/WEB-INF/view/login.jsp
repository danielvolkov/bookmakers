<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.i18n.LocaleHolder" %>
<%@ page import="java.util.Locale" %>
<%@ page import="util.constants.Attributes" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:requestEncoding value="UTF-8" />
    <fmt:setLocale value="${Attributes.LOCALE}" />
    <fmt:setBundle basename="bookmakers" var="msg"/>
    <jsp:include page="/WEB-INF/view/navbar.jsp"/>
    <title><fmt:message key="login.title" bundle="${msg}"/></title>
</head>
<style>
    <%@include file="/bootstrap.css" %>
</style>
<body>

<div class="container default-c">
    <div class="col-md-4 col-md-offset-4 panel-default">
       <div class="text-center" style="margin:10%">
            <h1>
                <fmt:message key="login.title" bundle="${msg}"/>
            </h1>
       </div>
        <div class="panel panel-primary">

            <div class="panel-footer">

                <form class="center-block" method="post" action="/login">

                    <label class="label-warning"> ${loginError}</label>

                    <div class="form-group">
                        <label><fmt:message key="msg.email" bundle="${msg}"/></label>
                        <input type="email" class="form-control" name="email">
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="msg.password" bundle="${msg}"/></label>
                        <input type="password" class="form-control" name="password">
                    </div>

                    <div class="text-center">
                        <button type="submit" class="btn btn-lg btn-success"><fmt:message key="login" bundle="${msg}"/></button>
                    </div>
                </form>
                <div class="form-group row text-center">
                    <h5>
                        <fmt:message key="msg.signup" bundle="${msg}"/>
                        <a href="/signup"> <fmt:message key="signup" bundle="${msg}"/></a>
                    </h5>
                </div>
            </div>
        </div>

    </div>

</div>

</body>
</html>
