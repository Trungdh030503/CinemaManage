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


                <div class="filters-content">
                    <div class="row grid">
                        <c:forEach items="${requestScope.films}" var="f">
                            <div class="col-sm-6 col-lg-4 all ${f.genres.name}">
                                <div class="box">
                                    <div>
                                        <div class="img-box">
                                            <img src="view/images/${f.image}" alt="">
                                        </div>
                                        <div class="detail-box">
                                            <h5>
                                                ${f.title}
                                            </h5>
                                            <p>
                                                ${f.description}
                                            </p>
                                            <div class="options">
                                                <h6>
                                                    Time: ${f.time} minute
                                                </h6>
                                                <a href="film?film=${f.filmId}" class="" style="color: black; text-decoration: none">
                                                    <i class="icon fa fa-solid fa-eye"></i>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
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
