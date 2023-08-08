<%-- 
    Document   : film
    Created on : Oct 20, 2022, 1:37:31 PM
    Author     : int.thong.nk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../component/setupCss.jsp" %>
    </head>
    <body>
        <!--Header-->
        <div class="hero_area">
            <div class="bg-box">
                <img src="images/cinema.jpg" alt="">
            </div>
            <!-- header section strats -->
            <header class="header_section">
                <div class="container">
                    <nav class="navbar navbar-expand-lg custom_nav-container ">
                        <a class="navbar-brand" href="index.html">
                            <span>
                                Cinema
                            </span>
                        </a>

                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class=""> </span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav  mx-auto ">
                                <li class="nav-item active">
                                    <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="menu.html">Menu</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="about.html">About</a>
                                </li>

                            </ul>
                            <div class="user_option">
                                <a href="" class="user_link">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </a>
                                <form class="form-inline">
                                    <button class="btn  my-2 my-sm-0 nav_search-btn" type="submit">
                                        <i class="fa fa-search" aria-hidden="true"></i>
                                    </button>
                                </form>
                                <a href="" class="order_online">
                                    Login
                                </a>
                            </div>
                        </div>
                    </nav>
                </div>
            </header>
            <!-- end header section -->
            <!-- slider section -->
            <section class="slider_section ">
                <div id="customCarousel1" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="container ">
                                <div class="row">
                                    <div class="col-md-7 col-lg-6 ">
                                        <div class="detail-box">
                                            <h1>
                                                Cinema ticket
                                            </h1>
                                            <p>
                                                Experience the highest quality cinema at Cinema cinemas nationwide. The information page
                                                summarizes the latest movie showtimes and trailers at Cinema Cinemas Vietnam.
                                            </p>
                                            <div class="btn-box">
                                                <a href="" class="btn1">
                                                    Order Now
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item ">
                            <div class="container ">
                                <div class="row">
                                    <div class="col-md-7 col-lg-6 ">
                                        <div class="detail-box">
                                            <h1>
                                                Fast Food Restaurant
                                            </h1>
                                            <p>
                                                Doloremque, itaque aperiam facilis rerum, commodi, temporibus sapiente ad mollitia laborum quam
                                                quisquam esse error unde. Tempora ex doloremque, labore, sunt repellat dolore, iste magni quos
                                                nihil ducimus libero ipsam.
                                            </p>
                                            <div class="btn-box">
                                                <a href="" class="btn1">
                                                    Order Now
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="container ">
                                <div class="row">
                                    <div class="col-md-7 col-lg-6 ">
                                        <div class="detail-box">
                                            <h1>
                                                Fast Food Restaurant
                                            </h1>
                                            <p>
                                                Doloremque, itaque aperiam facilis rerum, commodi, temporibus sapiente ad mollitia laborum quam
                                                quisquam esse error unde. Tempora ex doloremque, labore, sunt repellat dolore, iste magni quos
                                                nihil ducimus libero ipsam.
                                            </p>
                                            <div class="btn-box">
                                                <a href="" class="btn1">
                                                    Order Now
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <ol class="carousel-indicators">
                            <li data-target="#customCarousel1" data-slide-to="0" class="active"></li>
                            <li data-target="#customCarousel1" data-slide-to="1"></li>
                            <li data-target="#customCarousel1" data-slide-to="2"></li>
                        </ol>
                    </div>
                </div>

            </section>
            <!-- end slider section -->
        </div>
        <!--Header-->
        <section class="container text-center mt-5 slidemoviehot">
            <h2>
                Movie Hot In Month
            </h2>
            <div class="d-flex justify-content-center">
                <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                                aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                                aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                                aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner movie">
                        <div class="carousel-item active">
                            <img src="images/describe-your-favorite-movie-avengers-endgame-1024x576.jpg" class="d-block w-100"
                                 style="width: 100px;" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="images/share.png" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="images/kisspng-movie-icons-film-cinema-5afb7b67901b56.5773899315264305675903.jpg" class="d-block w-100" alt="...">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                            data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                            data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </section>

        <!--Viewer-->
        <section class="food_section layout_padding-bottom">
            <div class="container">
                <div class="heading_container heading_center">
                    <h2>
                        Our Menu
                    </h2>
                </div>

                <!-- List Products -->
                <div class="filters-content">
                    <div class="row grid">
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
                                            Veniam debitis quaerat officiis quasi cupiditate quo, quisquam velit, magnam voluptatem repellendus
                                            sed eaque
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
                        <div class="col-sm-6 col-lg-4 all burger">
                            <div class="box">
                                <div>
                                    <div class="img-box">
                                        <img src="images/f2.png" alt="">
                                    </div>
                                    <div class="detail-box">
                                        <h5>
                                            Delicious Burger
                                        </h5>
                                        <p>
                                            Veniam debitis quaerat officiis quasi cupiditate quo, quisquam velit, magnam voluptatem repellendus
                                            sed eaque
                                        </p>
                                        <div class="options">
                                            <h6>
                                                $15
                                            </h6>
                                            <a href="">
                                                <i class="fa-solid fa-magnifying-glass"></i>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-lg-4 all pizza">
                            <div class="box">
                                <div>
                                    <div class="img-box">
                                        <img src="images/f3.png" alt="">
                                    </div>
                                    <div class="detail-box">
                                        <h5>
                                            Delicious Pizza
                                        </h5>
                                        <p>
                                            Veniam debitis quaerat officiis quasi cupiditate quo, quisquam velit, magnam voluptatem repellendus
                                            sed eaque
                                        </p>
                                        <div class="options">
                                            <h6>
                                                $17
                                            </h6>
                                            <a href="">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-lg-4 all dog">
                            <div class="box">
                                <div>
                                    <div class="img-box">
                                        <img src="images/f4.png" alt="">
                                    </div>
                                    <div class="detail-box">
                                        <h5>
                                            Delicious Pasta
                                        </h5>
                                        <p>
                                            Veniam debitis quaerat officiis quasi cupiditate quo, quisquam velit, magnam voluptatem repellendus
                                            sed eaque
                                        </p>
                                        <div class="options">
                                            <h6>
                                                120
                                            </h6>
                                            <a href="">

                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-lg-4 all fries">
                            <div class="box">
                                <div>
                                    <div class="img-box">
                                        <img src="images/f5.png" alt="">
                                    </div>
                                    <div class="detail-box">
                                        <h5>
                                            French Fries
                                        </h5>
                                        <p>
                                            Veniam debitis quaerat officiis quasi cupiditate quo, quisquam velit, magnam voluptatem repellendus
                                            sed eaque
                                        </p>
                                        <div class="options">
                                            <h6>
                                                $10
                                            </h6>
                                            <a href="">

                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-lg-4 all pizza">
                            <div class="box">
                                <div>
                                    <div class="img-box">
                                        <img src="images/f6.png" alt="">
                                    </div>
                                    <div class="detail-box">
                                        <h5>
                                            Delicious Pizza
                                        </h5>
                                        <p>
                                            Veniam debitis quaerat officiis quasi cupiditate quo, quisquam velit, magnam voluptatem repellendus
                                            sed eaque
                                        </p>
                                        <div class="options">
                                            <h6>
                                                $15
                                            </h6>
                                            <a href="">

                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="btn-box">
                    <a href="">
                        View More
                    </a>
                </div>
            </div>
        </section>

        <section class="about_section layout_padding">
            <div class="container  ">

                <div class="row">
                    <div class="col-md-6 ">
                        <div class="img-box">
                            <img src="https://img.freepik.com/premium-vector/vector-movie-cinema-poster-popcorn-tape-glasses_208581-1763.jpg?w=2000" alt="">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="detail-box">
                            <div class="heading_container">
                                <h2>
                                    We Are Cinema
                                </h2>
                            </div>
                            <p>
                                There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration
                                in some form, by injected humour, or randomised words which don't look even slightly believable. If you
                                are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in
                                the middle of text. All
                            </p>
                            <a href="">
                                Read More
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <!--Footer-->
        <%@include  file="../component/footer.jsp"%>
        <!--Footer-->
    </body>
</html>
