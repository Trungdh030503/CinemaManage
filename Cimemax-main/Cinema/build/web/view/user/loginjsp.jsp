<%-- 
    Document   : loginjsp
    Created on : Oct 20, 2022, 8:44:47 AM
    Author     : int.thong.nk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Basic -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas -->
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="shortcut icon" href="images/161-1616544_popcorn-icon-cinema-flat-icon-png.png" type="">

        <title> Cinema Ticket </title>

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="view/css/bootstrap.css" />

        <!--owl slider stylesheet -->
        <link rel="stylesheet" type="text/css"
              href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <!-- nice select  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css"
              integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ=="
              crossorigin="anonymous" />
        <!-- font awesome style -->
        <link href="view/css/font-awesome.min.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="view/css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="view/css/responsive.css" rel="stylesheet" />

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    </head>
    <body>
        <!-- Section: Design Block -->
        <%@include  file="../component/header.jsp"%>
        <section class="vh-100" style="background-image: url(view/images/cinema.jpg)">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col col-xl-10">
                        <div class="card" style="border-radius: 1rem;">
                            <div class="row g-0">
                                <div class="col-md-6 col-lg-5 d-none d-md-block">
                                    <!--Image left-->
                                    <img src="view/images/movie-night-design-template-eef943492408082d7bbd61673b6f9bf4_screen.jpg" alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem; height: 100%; width: auto;" />
                                </div>
                                <div class="col-md-6 col-lg-7 d-flex align-items-center">
                                    <div class="card-body p-4 p-lg-5 text-black">

                                        <form method="post" action="loginController">

                                            <div class="d-flex align-items-center mb-3 pb-1" >
                                                <h1>Cinema</h1>
                                            </div>

                                            <h2 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign into your
                                                account</h2>

                                            <div class="form-outline mb-4">
                                                <input type="email" id="form2Example17"
                                                       class="form-control form-control-lg" placeholder="Email address" name="email"/>
                                                <label class="form-label" for="form2Example17">Email address</label>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <input type="password" id="form2Example27"
                                                       class="form-control form-control-lg" placeholder="Password" name="pass"/>
                                                <label class="form-label" for="form2Example27">Password</label>
                                            </div>

                                            <div class="pt-1 mb-4">
                                                <button class="btn btn-dark btn-lg btn-block" type="submit">Login</button>
                                            </div>

                                            <p class="mb-5 pb-lg-2" style="color: #393f81;">Don't have an account? <a
                                                    href="registerController" style="color: #393f81;">Register here</a></p>
                                            <a href="#!" class="small text-muted">Terms of use.</a>
                                            <a href="#!" class="small text-muted">Privacy policy</a>
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="../component/footer.jsp" %>
        <!-- Section: Design Block -->
    </body>
</html>
