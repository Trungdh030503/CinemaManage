


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : newjs
    Created on : Oct 20, 2022, 9:28:13 AM
    Author     : int.thong.nk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- header section strats -->
        <header class="header_section">
            <div class="container">
                <nav class="navbar navbar-expand-lg custom_nav-container ">
                    <a class="navbar-brand" href="homeController">
                        <span>
                            Cinema
                        </span>
                    </a>

                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class=""> </span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav  mx-auto ">
                            <li class="nav-item">
                                <a class="nav-link" href="homeController">Home </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="menu">Menu</a>
                            </li>
                        </ul>
                        <div class="user_option">
                            <a href="profileController" class="user_link">
                                <i class="fa fa-user" aria-hidden="true"></i>
                            </a>
                            
<!--                            <a class="user_link" href="historyBookingController">
                                <i class="fa fa-ticket" aria-hidden="true" ></i>
                            </a>-->
                            
                            <a class="user_link" href="changePassController">
                                <i class="fa fa-lock" aria-hidden="true" ></i>
                            </a>
                            
                            <c:if test="${sessionScope.id == null}">
                                <a href="loginController" class="order_online">
                                    Login
                                </a> 
                            </c:if>
                            <c:if test="${sessionScope.id != null}">
                                <a href="logoutController" class="order_online">
                                    logout
                                </a> 
                            </c:if>

                        </div>
                    </div>
                </nav>
            </div>
        </header>
        <!-- end header section -->
    </body>
</html>
