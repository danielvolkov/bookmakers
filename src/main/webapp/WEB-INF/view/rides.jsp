<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="util.Attributes" %>
<%@ page import="model.entity.User" %>
<%@ page import="util.UrlHolder" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.Ride" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 1/22/17
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rides</title>
</head>
<style>
    <%@include file="/bootstrap.css" %>
</style>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"/>

<%  User user = (User) request.getSession().getAttribute(Attributes.User);
    String action = "";
    String actionMessage = "";
    if(user.getRole().equals(Attributes.ADMIN)){
        action = UrlHolder.END_RIDE;
        actionMessage = "Calculate Ride results";
    };
    if(user.getRole().equals(Attributes.CLIENT)){
        action = UrlHolder.BET;
        actionMessage = "Make Bet";
    }
    //List<Ride> rides = (List) request.getSession().getAttribute(Attributes.RIDES);

%>
<div class="container">
    <div class="text-center">
        <h1 >Rides</h1>
        <h3>Avialable rides for bet`s</h3>
            <% if (user.getRole().equals(Attributes.BOOKMAKER)){%>
            <div class="row">
            If dou you have avialabale rides, you can add
                <form  class="form-inline" method="post" action="/add/ride">
                    <div class="form-group">
                    <label >Enter ride date and time</label>
                    <input type="text" class="form-control" name="">
                    </div>
                    <button type="submit" class="btn btn-success">Create new Ride</button>
                </form>

            </div>
            <%}%>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Ride Id</th>
            <th>Start Time</th>
            <th>Winner</th>
            <th>Looser</th>
            <th>Status ( Is finished ? )</th>
            <th>Bookmaker`s Email</th>
            <% if (!user.getRole().equals(Attributes.BOOKMAKER)){%>
            <th><%=actionMessage%></th>
            <%}%>

        </tr>
        </thead>
        <tbody>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        </tbody>
    </table>

</body>
</html>
