<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="util.MoneyTypeConverter" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.Ride" %>
<%@ page import="model.entity.Horse" %>
<%@ page import="model.entity.Bet" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Date" %>
<%@ page import="util.constants.Attributes" %>
<%@ page import="util.DateUtil" %>

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
    <title>History</title>
</head>
<style>
    <%@include file="/bootstrap.css" %>
</style>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"/>
<%List<Bet> bets = (List) request.getSession().getAttribute(Attributes.BETS);%>
<h1>History</h1>
<div class="container">
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Bookmaker`s email</th>
        <th>Ride datatime</th>
        <th>Result</th>
        <th>Predicton</th>
        <th>Factor</th>
        <th>Bet summ</th>
        <th>Is passed?</th>
        <th>Total</th>

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
