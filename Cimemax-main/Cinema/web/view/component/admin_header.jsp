<%-- 
    Document   : admin_jsp
    Created on : Oct 31, 2022, 9:37:59 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!DOCTYPE html>
    <html lang="en">

        <head>
            <meta charset="utf-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
            <meta name="description" content="" />
            <meta name="author" content="" />
            <title>Dashboard - SB Admin</title>
            <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
            <link href="css/styles.css" rel="stylesheet" />
            <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
            <!-- CSS only -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
                  integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        </head>

        <body class="sb-nav-fixed">
            <nav class="navbar navbar-expand-lg navbar-light bg-light" style="font-size: 22px;">
                <a class="navbar-brand" href="adminDashboardController" style="margin-left: 300px;">Admin</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav" style="margin-left: 220px;">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link ms-5" href="adminDashboardController">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link ms-4" href="manageFilmController?title=&date=&genres=&country=&order=filmId&dimesion=asc&page=1">Film</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link ms-4" href="manageShowController?title=&date=&order=showId&dimesion=asc&page=1">Show</a>
                        </li>
                    </ul>
                </div>
                <div style="margin-right: 300px;">
                    <a href="logoutController"><i class="fa fa-solid fa-right-from-bracket"></i></a>
                </div>
            </nav>
        </body>

    </html>
</body>
</html>
