<%-- 
    Document   : bookingSuccessfull
    Created on : Nov 2, 2022, 4:41:15 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking Successfull</title>
        <%@include file="../component/setupCss.jsp" %>
    </head>
    <body style="">
        <%@include file="../component/header.jsp" %>
        <div class="card text-center mt-5 mb-5 ms-5 d-flex justify-content-center align-content-center"
             style="width: 90%; height: 300px;">
            <div class="card-body">
                <div>
                    <h5 class="card-title">Congratulations on your successful ticket purchase.</h5>
                    <p class="card-text">Thank you for trusting Cinema. Cinema wishes you happy and comfortable movie watching hours.</p>
                    <p class="mt-3"><i>If you have trouble booking tickets, please contact 0123456789 for help.</i></p>
                    <a href="homeController" class="btn btn-primary">Go home</a>
                </div>
            </div>
        </div>
        <%@include file="../component/footer.jsp" %>
    </body>
</html>
