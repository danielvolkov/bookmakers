<%@ page import="util.constants.UriHolder" %>
<%@ page import="util.constants.Attributes" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.i18n.LocaleHolder" %>
<%@ page import="java.util.Locale" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${sessionScope[Attributes.LOCALE]}" />
<fmt:setBundle basename="bookmakers" var="msg"/>
<div class="row">
    <fmt:message key="msg.bk.rides" bundle="${msg}"/>
    <form  class="form-inline" method="post" action="<%=UriHolder.ADD_RIDE%>">
        <div class="container">
            <div class="row">
                <div class='col-sm-12'>
                    <label ><fmt:message key="msg.bk.date" bundle="${msg}"/></label>
                    <input type='text' class="form-control" id='datetimepicker4' name ="date"/>
                    <div class="form-group">
                        <label ><fmt:message key="msg.bk.max.summ" bundle="${msg}"/></label>
                        <input type="text" class="form-control" name="<%=Attributes.MAX_BET%>" >
                    </div>
                    <div class="form-group">
                        <label ><fmt:message key="msg.bk.factor" bundle="${msg}"/></label>
                        <input type="text" class="form-control" name="<%=Attributes.COEF%>" >
                    </div>
                    <button type="submit" class="btn btn-success"><fmt:message key="msg.bk.new.ride" bundle="${msg}"/></button>
                </div>
                <script type="text/javascript">
                    $(function () {
                        $('#datetimepicker4').datetimepicker();
                    });
                </script>

            </div>
        </div>


    </form>

</div>
