<%-- 
    Document   : chooseSeatShow
    Created on : Nov 2, 2022, 3:57:06 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../component/setupCss.jsp" %>
        <style>

            .movie-container {
                margin: 20px 0;
                background-color: #242333;
                color: #fff;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                height: 100vh;
                font-family: "Lato", sans-serif;
                margin: 0;
            }

            .movie-container select {
                background-color: #fff;
                border: 0;
                border-radius: 5px;
                font-size: 16px;
                margin-left: 10px;
                padding: 5px 15px 5px 15px;
                -moz-appearance: none;
                -webkit-appearance: none;
                appearance: none;
            }

            .container {
                perspective: 1000px;
                margin-bottom: 30px;
            }
            .showcase{
                display: flex;
                justify-content: space-between;
            }
            .status{
                margin-left: 10px;
                text-align: center;
                display: flex;
            }
            .seat .small{
                margin-top: 20px;
                font-size: 20px;
            }

            .seat {
                background-color: #444451;
                height: 26px;
                width: 32px;
                margin: 3px;
                font-size: 50px;
                border-top-left-radius: 10px;
                border-top-right-radius: 10px;
            }

            .seat.selected {
                background-color: green;
            }

            .seat.sold {
                background-color: #fff;
            }

            .seat:not(.sold):hover {
                cursor: pointer;
                transform: scale(1.2);
            }

            .showcase .seat:not(.sold):hover {
                cursor: default;
                transform: scale(1);
            }


            .row {
                display: flex;
            }

            .screen {
                background-color: #fff;
                height: 120px;
                width: 100%;
                margin: 15px 0;
                transform: rotateX(-48deg);
                box-shadow: 0 3px 10px rgba(255, 255, 255, 0.7);
            }

            p.text {
                margin: 5px 0;
            }

            p.text span {
                color: rgb(158, 248, 158);
            }

        </style>
    </head>
    <body>
        <!--Header-->
        <%@include file="../component/header.jsp" %>
        <!--Header-->
        <section class="about_section layout_padding">
            <div class="container  ">
                <div class="row">
                    <div class="col-md-12 movie-container">
                        <h4 class="text-center" style="margin-top: -150px; margin-bottom: 100px;">
                            Film: ${show.film.title}. <br/>
                            Slot: ${show.slot.time}. <br/>
                            Time: ${show.film.time} minute.
                        </h4>
                        <div class="showcase">
                            <div class="status">
                                <div class="seat"></div>
                                <small>Available</small>
                            </div>
                            <div class="status">
                                <div class="seat sold"></div>
                                <small>Sold</small>
                            </div>
                            <div class="status">
                                <div class="seat selected"></div>
                                <small>Selected</small>
                            </div>
                        </div>
                        <div class="containers">
                            <div class="screen"></div>
                            <c:set var="i" value="0"/>
                            <c:set var="index" value="0"/>
                            <c:if test="${size == 0}">
                                <c:forEach var="s" begin="1" end="6" step="1">
                                    <div class="row">
                                        <c:forEach var="a" begin="1" end="8" step="1">
                                            <c:set var="i" value="${i = i+1 }"/>
                                            <div class="seat" onclick="choose(this)" id="${i}"></div> 
                                        </c:forEach>
                                    </div>
                                </c:forEach>
                            </c:if>
                            
                            <c:if test="${size != 0}">
                                <c:forEach var="s" begin="1" end="6" step="1">
                                    <div class="row">
                                        <c:forEach var="a" begin="1" end="8" step="1">
                                            <c:set var="i" value="${i = i+1 }"/>
                                            <c:choose>
                                                <c:when test="${i == requestScope.seats.get(index).seatId}">
                                                    <div class="seat sold" id="${i}"></div>
                                                    <c:if test="${index < size -1}">
                                                        <div hidden="">${index = index + 1}</div>  
                                                    </c:if>

                                                </c:when>
                                                <c:otherwise>
                                                    <div class="seat" onclick="choose(this)" id="${i}"></div> 
                                                </c:otherwise>
                                            </c:choose>

                                        </c:forEach>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>

                        <form action="bookingController" method="get" id="formBooking">
                            <input hidden=""  type="text" id="arrSeat" value="" name="arrSeat"/>
                            <input hidden="" type="text" value="${show.showId}" name="showId">
                        </form>
                        <button class=" mt-5 btn btn-primary" onclick="submit()">
                            Submit
                        </button>
                    </div>
                </div>
            </div>
        </section>

        <script>
            const arr = [];

            function choose(a) {
                console.log(a.id);
                const f = arr.findIndex((e) => e == a.id);
                console.log(f);
                if (f == -1) {
                    document.getElementById(a.id).style.backgroundColor = "green";
                    arr.push(a.id)
                    console.log(arr)
                } else {
                    document.getElementById(a.id).style.backgroundColor = "#444451";
                    arr.splice(f, f + 1);
                    console.log(arr);
                }
            }

            function submit() {
                var seat = "";
                for (var item in arr) {
                    seat = seat + arr[item] + ",";
                }

                console.log(seat);
                document.getElementById("arrSeat").value = seat;
                var form = document.getElementById("formBooking");
                form.submit();
            }
        </script>
        <!--Footer->
        <%@include file="../component/footer.jsp" %>
        <!--Footer-->
        <!--Script-->
        <%@include file="../component/setupJS.jsp" %>
        <!--Script-->
    </body>
</html>
