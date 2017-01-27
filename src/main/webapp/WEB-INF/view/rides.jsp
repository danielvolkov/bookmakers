<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="util.constants.Attributes" %>
<%@ page import="model.entity.User" %>
<%@ page import="util.constants.UriHolder" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.Ride" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="util.MoneyTypeConverter" %>
<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 1/22/17
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.min.css">
<script src="http://momentjs.com/downloads/moment.js"></script>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/js/bootstrap-datetimepicker.min.js"></script>

<html>
<head>
    <title>Rides</title>
</head>
<style>
    <%@include file="/bootstrap.css" %>
</style>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"/>

<%  User user = (User) request.getSession().getAttribute(Attributes.USER);
    String action = "";
    String actionMessage = "";

    if(user.getRole().equals(Attributes.ADMIN)){
        action = UriHolder.END_RIDE;
        actionMessage = "Calculate Ride results";
    };
    if(user.getRole().equals(Attributes.CLIENT)){
        action = UriHolder.BET;
        actionMessage = "Make Bet";

    }

%>
<div class="container">
    <div class="text-center">
        <h1 >Rides</h1>
        <h3>Avialable rides for bet`s</h3>
            <% if (user.getRole().equals(Attributes.BOOKMAKER)){%>
                <jsp:include page="/WEB-INF/view/bookmakerRide.jsp"/>
            <%}%>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Ride Id</th>
            <th>Start Time</th>
            <th>Winner</th>
            <th>Looser</th>
            <th>Is finished?</th>
            <th>Bookmaker`s Email</th>
            <th>Max bet</th>
            <th>Factor</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach  var="ride" items="${rides}">
        <tr>
            <td>${ride.rideId}</td>
            <td>${ride.startDataTime}</td>
            <td>#${ride.winnerId}</td>
            <td>#${ride.looserId}</td>
            <td>${ride.finished}</td>
            <td>${ride.bookmakerEmail}</td>
            <td>${MoneyTypeConverter.longToDouble(ride.getMaxSumm())} USD</td>
            <td>${ride.coefficient}</td>
            <% if (!user.getRole().equals(Attributes.BOOKMAKER)){%>
            <td>
            <c:if test="${!ride.finished}">
                <form  class="form-inline" method="post" action="<%=action%>">
                    <input class="hidden" value="<c:out value="${ride.rideId}"/>" name ="<%=Attributes.RIDE%>" >
                    <button type="submit" class="btn btn-success"><%=actionMessage%></button>
                </form>
            </c:if>
            </td>
            <%}%>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>

</html>
