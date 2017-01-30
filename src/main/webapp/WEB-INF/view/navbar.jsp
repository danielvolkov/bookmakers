<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="util.constants.Attributes" %>
<%@ page import="model.entity.User" %>
<%@ page import="model.entity.Roles" %><%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 1/20/17
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${sessionScope[AttributesHolder.LOCALE]}" />
<fmt:setBundle basename="bookmakers" var="msg"/>
<%  User user = (User) request.getSession().getAttribute(Attributes.USER);%>
    <nav class="navbar  navbar-static-top navbar-inverse bg-inverse">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <strong>
            <ul class="nav navbar-nav navbar-left ">
                <li><a href="/"><fmt:message key="logo" bundle="${msg}"/></a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-language fa-lg" aria-hidden="true"></i>
                        ${sessionScope.locale.getLanguage().toUpperCase()}
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <c:forEach items="${LocaleHolder.SUPPORTED}" var="lang" >
                            <li><a href="?lang=${lang}">${lang.toUpperCase()}</a></li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>
            <% if (user!=null){%>
            <ul class="nav navbar-nav navbar-right" style="margin-right: 5%">
                <li><a href="/cabinet"><fmt:message key="cabinet" bundle="${msg}"/></a></li>
                <li><a href="/rides"><fmt:message key="rides" bundle="${msg}"/></a></li>
                <% if (!user.getRole().equals(Roles.ADMIN)){%>
                <li><a href="/history"><fmt:message key="history" bundle="${msg}"/></a></li>
                <%}%>
                <li><a href="/logout"><fmt:message key="logout" bundle="${msg}"/></a></li>
            </ul>
                <%}%>
            </strong>
        </div>
    </nav>

