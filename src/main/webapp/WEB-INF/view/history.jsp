<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>History</h1>
<div class="container">
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Bookmaker`s email</th>
        <th>Ride datatime</th>
        <th>Result</th>
        <th>Predicton</th>
        <th>Is passed?</th>
        <th>Factor</th>
        <th>Bet summ</th>
        <th>Total</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach  var="bet" items="${bets}">
        <tr>
            <td><c:out value="${bet.getRide().bookmakerEmail}"/></td>
            <td><c:out value="${bet.getRide().startDataTime}"/></td>
            <td><c:out value="${bet.getRide().getResult()}"/></td>
            <td><c:out value="${bet.getHorse().toString()}"/></td>
            <td><c:out value="${bet.isPassed}"/></td>
            <td><c:out value="${bet.getRide().coefficient}"/></td>
            <td><c:out value="${bet.betSum}"/> USD</td>
            <td><c:out value="${bet.totalSumm}"/>  </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
