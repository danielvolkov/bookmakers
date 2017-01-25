<%@ page import="util.UrlHolder" %>
<%@ page import="util.Attributes" %><%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 1/24/17
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    If dou you have avialabale rides, you can add time and waiting for bets
    <form  class="form-inline" method="post" action="<%=UrlHolder.ADD_RIDE%>">
        <div class="container">
            <div class="row">
                <div class='col-sm-12'>
                    <label > Enter Ride date and time</label>
                    <input type='text' class="form-control" id='datetimepicker4' name ="date"/>
                    <div class="form-group">
                        <label > Enter Max Summ of Max Bet</label>
                        <input type="text" class="form-control" name="<%=Attributes.MAX_BET%>" >
                    </div>
                    <div class="form-group">
                        <label > Enter Prefeir Coefficient</label>
                        <input type="text" class="form-control" name="<%=Attributes.COEF%>" >
                    </div>
                    <button type="submit" class="btn btn-success">Create new Ride</button>
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
