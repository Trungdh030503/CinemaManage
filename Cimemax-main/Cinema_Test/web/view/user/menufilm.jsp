<%-- 
    Document   : menufilm.jsp
    Created on : Oct 20, 2022, 1:17:17 PM
    Author     : int.thong.nk
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../component/setupCss.jsp" %>
    </head>
    <body>
        <!--Header-->
        <%@include file="../component/header.jsp" %>
        <!--Header-->

        <!-- food section -->

        <section class="food_section layout_padding">
            <div class="container">
                <div class="heading_container heading_center">
                    <h2>
                        Menu film
                    </h2>
                </div>

                <ul class="filters_menu">
                    <li class="active" data-filter="*">All</li>
                        <c:forEach items="${requestScope.genres}" var="g">
                        <li data-filter=".${g.name}">${g.name}</li>
                        </c:forEach>

                </ul>

                <div class="filters-content">
                    <div class="row grid">
                        <c:forEach items="${requestScope.films}" var="f">
                            <div class="col-sm-6 col-lg-4 all pizza">
                                <div class="box">
                                    <div>
                                        <div class="img-box">
                                            <img src="images/f1.png" alt="">
                                        </div>
                                        <div class="detail-box">
                                            <h5>
                                                Delicious Pizza
                                            </h5>
                                            <p>
                                                Veniam debitis quaerat officiis quasi cupiditate quo, quisquam velit, magnam voluptatem repellendus sed eaque
                                            </p>
                                            <div class="options">
                                                <h6>
                                                    $20
                                                </h6>
                                                <a href="">

                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="btn-box">
                    <a href="">
                        View More
                    </a>
                </div>
            </div>

        </section>

        <!-- end food section -->

        <!--Footer->
        <%@include file="../component/footer.jsp" %>
        <!--Footer-->

        <!--Script-->
        <%@include file="../component/setupJS.jsp" %>
        <!--Script-->
    </body>
</html>
