<%-- 
    Document   : adminDashboard
    Created on : Oct 31, 2022, 8:59:32 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Admin Dashboard</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    </head>

    <body class="sb-nav-fixed">
        <%@include file="../component/admin_header.jsp" %>

        <div id="layoutSidenav">
            <div id="layoutSidenav_content">
                <main style="margin-left: 200px; height: 540px;">
                    <div class="container-fluid px-4">
                        <h1 class="mt-4 ms-5">Dashboard</h1>
                        <ol class="breadcrumb mb-4 ms-5">
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ol>
                        <div class="row d-flex justify-content-around" style="width: 90%;">
                            <div class="col-md-5">
                                <div class="card bg-primary text-white mb-4" >
                                    <div class="card-body">Total Movies: </div>
                                    <h3 class="card-body text-center">${totalFilm * 10} Movies</h3>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="manageFilmController?title=&date=&genres=&country=&order=filmId&dimesion=asc&page=1">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-5">
                                <div class="card bg-warning text-white mb-4" >
                                    <div class="card-body">Total Shows: </div>
                                    <h3 class="card-body text-center">${totalShow * 100} Shows</h3>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="manageShowController?title=&date=&order=showId&dimesion=asc&page=1">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-5">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">Total Users: </div>
                                    <h3 class="card-body text-center">${totalUser * 1000} Users</h3>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-5">
                                <div class="card bg-danger text-white mb-4">
                                    <div class="card-body">Total revenue: </div>
                                    <h3 class="card-body text-center">${totalBooking * 1000000}$</h3>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto ">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2022</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    </body>

</html>
