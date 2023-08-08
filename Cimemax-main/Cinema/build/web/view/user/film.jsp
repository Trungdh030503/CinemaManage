<%-- 
    Document   : film
    Created on : Oct 20, 2022, 1:37:31 PM
    Author     : int.thong.nk
--%>

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
        <section class="bg-light">
            <div class="container pb-5">
                <div class="row">
                    <div class="col-lg-5 mt-5">
                        <div class="card mb-3">
                            <img class="card-img img-fluid" 
                                 src="view/images/${requestScope.film.image}" alt="Card image cap"
                                 style="height: 700px; width: auto"
                                 id="product-detail">
                        </div>
                        <div class="row">
                            <!--Start Carousel Wrapper-->

                            <!--End Carousel Wrapper-->

                        </div>
                    </div>
                    <!-- col end -->
                    <div class="col-lg-7 mt-5" >
                        <div class="card" style="height: 700px">
                            <div class="card-body">
                                <h1 class="h2">${requestScope.film.title}</h1>
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <h6>Genres:</h6>
                                    </li>
                                    <li class="list-inline-item">
                                        <p class="text-muted">
                                            <strong>${requestScope.film.genres.name}</strong>
                                        </p>
                                    </li>
                                </ul>

                                <h6>Description:</h6>
                                <p>${requestScope.film.description}</p>
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <h6>Author :</h6>
                                    </li>
                                    <li class="list-inline-item">
                                        <p class="text-muted"><strong>${requestScope.film.author}</strong></p>
                                    </li>
                                </ul>

                                <ul class="list-inline d-flex">
                                    <li class="list-inline-item">
                                        <h6>Casts:</h6>
                                    </li>
                                    <li class="list-inline-item">
                                        <p class="text-muted">
                                            <strong>${requestScope.film.actor} </strong>
                                        </p>
                                    </li>
                                </ul>

                                <h6>Movie duration: ${requestScope.film.time} minute</h6>
                                <h6 class="mt-4">Language: ${requestScope.film.country.countryName}</h6>
                                <form class="mt-5" action="chooseShowController" method="GET">
                                    <div class="row pb-3">
                                        <div class="col d-grid">
                                            <input hidden type="text" value="${requestScope.film.filmId}" name="filmId"/>
                                            <button type="submit" class="btn btn-success btn-lg">
                                                Buy Ticket
                                            </button>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- end food section -->

        <!--Footer-->
        <%@include  file="../component/footer.jsp"%>
        <!--Footer-->
    </body>
</html>
