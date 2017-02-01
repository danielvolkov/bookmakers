<%@ page import="util.constants.UriHolder" %>
<%@ page import="util.constants.Attributes" %>
<%@ page import="util.MoneyTypeConverter" %>
<%@ page import="model.entity.User" %>
<%@ page import="model.entity.Ride" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title><fmt:message key="bet.page" bundle="${msg}"/></title>
</head>
<style>
    <%@include file="/bootstrap.css" %>
</style>
<body>


<% String successMsg = (String) request.getAttribute(Attributes.SUCCESS);%>
<% Ride ride = (Ride) request.getSession().getAttribute(Attributes.RIDE);%>
<div class="container default-c">
    <div class="col-md-4 col-md-offset-4 panel-default">
        <div class="text-center" style="margin:10%">
            <h1>
                <fmt:message key="bet.page" bundle="${msg}"/>
            </h1>
        </div>

        <form class="center-block" method="post" action="<%=UriHolder.MAKE_BET%>">

            <label class="label-warning"> </label>

            <div class="form-group">
                <label><fmt:message key="msg.type.bet" bundle="${msg}"/> <%=ride.getCoefficient()%>)</label>
                <select class="form-control" name="<%=Attributes.TYPE%>">
                    <option value="1"><fmt:message key="winner" bundle="${msg}"/></option>
                    <option value="2"><fmt:message key="last" bundle="${msg}"/></option>
                </select>
            </div>

            <div class="form-group">
                <label><fmt:message key="msg.choose.horse" bundle="${msg}"/></label>
                <select class="form-control" name="<%=Attributes.HORSE_ID%>">
                    <c:forEach  var="horse" items="${horses}">
                        <option value="<c:out value="${horse.number}"/>"><c:out value="${horse.toString()}"/></option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label><fmt:message key="msg.entersumm" bundle="${msg}"/> <%=MoneyTypeConverter.longToDouble(ride.getMaxSumm())%> USD)</label>
                <label class="label-warning">${Error}</label>
                <input type="text" class="form-control" name="<%=Attributes.SUMM%>">
            </div>
            <div class="text-center">
                <%if ( successMsg == null) {%>
                <button type="submit" class="btn btn-lg btn-primary"><fmt:message key="btn.client" bundle="${msg}"/></button>
                <%}%>
            </div>

        </form>

            <%if ( successMsg != null) {%>
            <div class="text-center">
            <a href="<%=UriHolder.RIDES%>"><button type="submit" class="btn btn-lg btn-success"><%=successMsg%></button></a>
            </div>
            <%}%>
    </div>

</div>



</body>
</html>
