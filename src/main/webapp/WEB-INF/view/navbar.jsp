<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="controller.i18n.LocaleHolder" %>
<%@ page import="util.constants.Attributes" %>
<%@ page import="model.entity.User" %>
<%@ page import="model.entity.Roles" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${Attributes.LOCALE}" />
<fmt:setBundle basename="bookmakers" var="msg"/>
<%  User user = (User) request.getSession().getAttribute(Attributes.USER);%>
    <nav class="navbar  navbar-static-top navbar-inverse bg-inverse">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <strong>
            <ul class="nav navbar-nav navbar-left ">
                <li><a href="/"><fmt:message key="logo" bundle="${msg}"/></a></li>
                <c:forEach items="${LocaleHolder.SUPPORTED}" var="locale"> |
                    <a href="${urlParam}${locale.language}">
                            ${locale.language}
                    </a>
                </c:forEach>
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

