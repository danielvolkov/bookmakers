<%@ page import="util.UrlHolder" %>
<%@ page import="util.Attributes" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 1/24/17
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose your Bet</title>
</head>
<style>
    <%@include file="/bootstrap.css" %>
</style>
<body>
<jsp:include page="/WEB-INF/view/navbar.jsp"/>
<div class="container default-c">
    <div class="col-md-4 col-md-offset-4 panel-default">
        <div class="text-center" style="margin:10%">
            <h1>
                Bet Page
            </h1>
        </div>
        <div class="container">

                <form class="center-block" method="post" action="<%=UrlHolder.MAKE_BET%>">

                    <label class="label-warning"> </label>

                    <div class="form-group">
                        <label>Choose type of Bet:</label>
                        <select class="form-control" name="type">
                            <option>Winner</option>
                            <option>Looser</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Choose Horse:</label>
                        <select class="form-control" name="horse">
                            <c:forEach  var="horse" items="${horses}">
                                <option value="<c:out value="${horse.number}"/>"><c:out value="${horse.toString()}"/></option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Enter Summ:</label>
                        <input type="text" class="form-control" name="<%=Attributes.SUMM%>">
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-lg btn-success">Make Bet</button>
                    </div>

                </form>

        </div>

    </div>

</div>



</body>
</html>
