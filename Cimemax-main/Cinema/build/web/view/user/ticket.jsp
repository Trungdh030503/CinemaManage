<%-- 
    Document   : ticket.jsp
    Created on : Nov 2, 2022, 5:43:13 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../component/setupCss.jsp" %>
    </head>
    <body>
        <%@include file="../component/header.jsp" %>
        <section class="py-1">
            <!-- style="background-color: white"-->
            <div class="container d-flex " style="min-height: 800px;">
                <div class="col-md-12">
                    <h3 class="mt-5">History Booking</h3>
                    <table class="table mt-2" style="height: 100px">
                        <thead>
                            <tr>
                                <th scope="col">Booking Code</th>
                                <th scope="col">Film Title</th>
                                <th scope="col">Date</th>
                                <th scope="col">Time</th>
                                <th scope="col">Seat</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${history}" var="hs">
                            <tr style="height: 60px">
                                <th scope="row">${hs.bookingId}</th>
                                <th scope="row">${hs.film}</th>
                                <th scope="row">${hs.date}</th>
                                <th scope="row">${hs.time}</th>
                                <th scope="row">
                                    <c:forEach items="${hs.seat}" var="s">
                                        ${s.seatName}
                                    </c:forEach>
                                </th>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </section>

        <%@include file="../component/footer.jsp" %>
    </body>
</html>
