<%@ page import="util.constants.Attributes" %>
<%@ page import="model.entity.User" %>
<%@ page import="util.MoneyTypeConverter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.i18n.LocaleHolder" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/view/navbar.jsp"/>
    <fmt:requestEncoding value="UTF-8" />
    <fmt:setLocale value="${sessionScope[Attributes.LOCALE]}" />
    <fmt:setBundle basename="bookmakers" var="msg"/>
    <title><fmt:message key="cabinet" bundle="${msg}"/></title>
</head>
<style>
    <%@include file="/bootstrap.css" %>
</style>
<body>

<% User user = (User) request.getSession().getAttribute(Attributes.USER);%>
<div class="col-md-6 col-md-offset-3 " >
    <div class="jumbotron " style="padding: 5%">
        <h1><fmt:message key="cabinet" bundle="${msg}"/></h1>
        <h3><fmt:message key="msg.hello" bundle="${msg}"/> <strong><%=user.getName()%></strong></h3>
        <p class="lead">
            <fmt:message key="msg.cabinet.role" bundle="${msg}"/><strong><%=user.getRole().name()%></strong><br>
            <fmt:message key="msg.cabinet.email" bundle="${msg}"/> <strong><%=user.getEmail()%></strong><br>
            <fmt:message key="msg.cabinet.balance" bundle="${msg}"/> <strong><%=MoneyTypeConverter.longToDouble(user.getBalance())%> USD </strong><br>
        </p>

        <form class="form-inline" method="post" action="/deposite">
            <div class="form-group">
                <label ><fmt:message key="msg.cabinet.deposite" bundle="${msg}"/> </label>
                <input type="text" class="form-control" name="deposite">
            </div>
            <button type="submit" class="btn btn-success"><fmt:message key="btn.deposite" bundle="${msg}"/> </button>
        </form>

        <form class="form-inline" method="post" action="/withdraw">
            <div class="form-group">
                <label ><fmt:message key="msg.cabinet.withdraw" bundle="${msg}"/></label>
                <input type="text" class="form-control" name="withdraw">
            </div>
            <button type="submit" class="btn btn-primary"><fmt:message key="btn.withdraw" bundle="${msg}"/></button>
        </form>
        <label class="label-warning"> ${cabinetError}</label>

    </div>
</div>

</body>
</html>
