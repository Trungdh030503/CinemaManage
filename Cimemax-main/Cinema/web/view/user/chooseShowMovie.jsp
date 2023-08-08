<%-- 
    Document   : chooseShowMovie
    Created on : Nov 1, 2022, 2:58:25 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Schedule movie</title>
        <%@include file="../component/setupCss.jsp" %>
    </head>
    <body>
        <%@include file="../component/header.jsp" %>
        <section class="bg-light">
            <div class="container pb-5">
                <div class="row">
                    <div class="col-lg-5 mt-5">
                        <div class="card mb-3">
                            <img class="card-img img-fluid"
                                 src="view/images/${film.image}"
                                 style="height: 700px; width: auto"
                                 alt="Card image cap" id="product-detail">
                        </div>
                        <div class="row">
                            <!--Start Carousel Wrapper-->

                            <!--End Carousel Wrapper-->

                        </div>
                    </div>
                    <!-- col end -->
                    <div class="col-lg-7 mt-5">
                        <div class="card" style="height: 700px">
                            <div class="card-body">
                                <h1 class="h2">Active Wear</h1>
                                <h4 class="mt-3">Day: </h4>
                                <div class="d-flex flex-wrap">
                                    <c:forEach items="${requestScope.date}" var="d">
                                        <form class="mt-2" action="chooseShowController" method="post">
                                            <input hidden type="date" value="${d}" name="date"/>
                                            <input hidden type="text" value="${filmId}" name="filmId"/>
                                            <button class="ms-1" type="submit">${d}</button>
                                        </form>
                                    </c:forEach>
                                </div>

                                <div class="mt-5">
                                    <h4>Slot: ${show.get(0).showDate}</h4>

                                    <div>
                                        <c:if test="${requestScope.show.size() != 0}">
                                            <c:forEach items="${requestScope.show}" var="s">
                                                <a class="btn btn-primary col-md-2" href="chooseSeatController?showId=${s.showId}">${s.slot.time}</a>
                                            </c:forEach>    
                                        </c:if>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="../component/footer.jsp" %>
    </body>
</html>
