<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.i18n.LocaleHolder" %>
<%@ page import="util.MoneyTypeConverter" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.Ride" %>
<%@ page import="model.entity.Horse" %>
<%@ page import="model.entity.Bet" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Date" %>
<%@ page import="util.constants.Attributes" %>
<%@ page import="util.DateUtil" %>
<%@ page import="java.util.Locale" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/view/navbar.jsp"/>
    <fmt:requestEncoding value="UTF-8" />
    <fmt:setLocale value="${Attributes.LOCALE}" />
    <fmt:setBundle basename="bookmakers" var="msg"/>
    <title><fmt:message key="history" bundle="${msg}"/></title>
</head>
<style>
    <%@include file="/bootstrap.css" %>
</style>
<body>

<%List<Bet> bets = (List) request.getSession().getAttribute(Attributes.BETS);%>
<h1><fmt:message key="history" bundle="${msg}"/></h1>
<div class="container">
<table class="table table-bordered">
    <thead>
    <tr>
        <th><fmt:message key="bk.email" bundle="${msg}"/></th>
        <th><fmt:message key="start.date" bundle="${msg}"/></th>
        <th><fmt:message key="msg.result" bundle="${msg}"/></th>
        <th><fmt:message key="msg.prediction" bundle="${msg}"/></th>
        <th><fmt:message key="factor" bundle="${msg}"/></th>
        <th><fmt:message key="msg.bet.summ" bundle="${msg}"/></th>
        <th><fmt:message key="msg.passed" bundle="${msg}"/></th>
        <th><fmt:message key="msg.total" bundle="${msg}"/></th>
    </tr>
    </thead>
    <tbody>

        <% for (Bet bet : bets){%>
        <tr>
            <td><%=bet.getRide().getBookmakerEmail()%></td>
            <td><%=DateUtil.dateParser(bet.getRide().getStartDataTime())%></td>
            <td><%=bet.getRide().getResult()%></td>
            <td><%=bet.getHorse().toString()%></td>
            <td><%=bet.getRide().getCoefficient()%></td>
            <td><%=MoneyTypeConverter.longToDouble(bet.getBetSum())%> USD</td>
            <td><%=bet.getPassed()%></td>
            <td><%=MoneyTypeConverter.longToDouble(bet.getTotalSumm())%> </td>
        </tr>
    <%}%>
    </tbody>
</table>
</div>
</body>
</html>
