
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.i18n.LocaleHolder" %>
<%@ page import="java.util.Locale" %>

<html>
<head>
    <fmt:requestEncoding value="UTF-8" />
    <fmt:setLocale value="${Attributes.LOCALE}" />
    <fmt:setBundle basename="bookmakers" var="msg"/>
    <title><fmt:message key="msg.404" bundle="${msg}"/></title>
</head>
<style>
    <%@include file="/bootstrap.css" %>
</style>
<body>

<div class="container text-center">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                    <fmt:message key="msg.ops" bundle="${msg}"/></h1>
                <h2>
                    <fmt:message key="msg.404" bundle="${msg}"/></h2>
                <div class="error-details">
                    <fmt:message key="msg.error404" bundle="${msg}"/>
                </div>
                <div class="error-actions">
                    <a href="/" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                        <fmt:message key="msg.gohome" bundle="${msg}"/> </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
