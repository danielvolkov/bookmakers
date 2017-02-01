<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="controller.i18n.LocaleHolder" %>
<%@ page import="util.constants.Attributes" %>
<%@ page import="model.entity.User" %>
<%@ page import="util.constants.UriHolder" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.Ride" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="util.MoneyTypeConverter" %>
<%@ page import="util.DateUtil" %>
<%@ page import="model.entity.Roles" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>

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
    <jsp:include page="/WEB-INF/view/navbar.jsp"/>
    <fmt:requestEncoding value="UTF-8" />
    <fmt:setLocale value="${Attributes.LOCALE}" />
    <fmt:setBundle basename="bookmakers" var="msg"/>
    <title><fmt:message key="rides" bundle="${msg}"/></title>
</head>
<style>
    <%@include file="/bootstrap.css" %>
</style>
<body>

<%  User user = (User) request.getSession().getAttribute(Attributes.USER);
    String action = "";
    String actionMessage = "";
    ResourceBundle messages = ResourceBundle
            .getBundle("bookmakers", (Locale) request.getSession().getAttribute(Attributes.LOCALE));

    if(user.getRole().equals(Roles.ADMIN)){
        action = UriHolder.END_RIDE;
        actionMessage = messages.getString("btn.admin");
    };
    if(user.getRole().equals(Roles.CLIENT)){
        action = UriHolder.BET;
        actionMessage = messages.getString("btn.client");

    }

%>
<div class="container">
    <div class="text-center">
        <h1 ><fmt:message key="rides" bundle="${msg}"/></h1>
        <h3><fmt:message key="msg.rides" bundle="${msg}"/></h3>
            <% if (user.getRole().equals(Roles.BOOKMAKER)){%>
                <jsp:include page="/WEB-INF/view/bookmakerRide.jsp"/>
            <%}%>
        <label class="label-warning"> ${Error}</label>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th><fmt:message key="rideid" bundle="${msg}"/></th>
            <th><fmt:message key="start.date" bundle="${msg}"/></th>
            <th><fmt:message key="winner" bundle="${msg}"/></th>
            <th><fmt:message key="last" bundle="${msg}"/></th>
            <th><fmt:message key="finished" bundle="${msg}"/></th>
            <th><fmt:message key="bk.email" bundle="${msg}"/></th>
            <th><fmt:message key="max.bet" bundle="${msg}"/></th>
            <th><fmt:message key="factor" bundle="${msg}"/></th>

        </tr>
        </thead>
        <tbody>
        <c:forEach  var="ride" items="${rides}">
        <tr>
            <td>${ride.rideId}</td>
            <td>${DateUtil.dateParser(ride.getStartDataTime())}</td>
            <td>#${ride.winnerId}</td>
            <td>#${ride.looserId}</td>
            <td>${ride.finished}</td>
            <td>${ride.bookmakerEmail}</td>
            <td>${MoneyTypeConverter.longToDouble(ride.getMaxSumm())} USD</td>
            <td>${ride.coefficient}</td>
            <% if (!user.getRole().equals(Roles.BOOKMAKER)){%>
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
