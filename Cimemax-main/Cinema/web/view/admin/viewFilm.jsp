<%-- 
    Document   : updateFilm
    Created on : Nov 2, 2022, 12:32:13 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>

    <body>
        <%@include file="../component/admin_header.jsp"%>
        <!-- Section: Design Block -->
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row d-flex justify-content-center">
                <div class="col-md-6 border">
                    <form action="" method="post" enctype="multipart/form-data">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h4 class="text-right">Movie</h4>
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-12">
                                    <label class="labels">FilmID</label>
                                    <input type="text" readonly class="form-control" 
                                           placeholder="title" value="${film.filmId}" name="filmId">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Title</label>
                                    <input type="text" readonly class="form-control" 
                                           placeholder="title" value="${film.title}" name="title">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Premiere</label>
                                    <input type="date" readonly class="form-control" 
                                           placeholder="premiere" value="${film.premiere}" name="premiere">
                                </div>
                                <div class="col-md-12"><label class="labels">Actor</label>
                                    <input type="text" readonly class="form-control" 
                                           placeholder="actor" value="${film.actor}" name="actor">
                                </div>
                                <div class="col-md-12"><label class="labels">Author</label>
                                    <input type="text" readonly class="form-control" 
                                           placeholder="author" value="${film.author}" name="author"></div>
                                <div class="col-md-12"><label class="labels">Duration</label>
                                    <input type="number" readonly class="form-control"
                                           placeholder="duration" value="${film.time}" name="duration" min="30" max="150">
                                </div>
                                <div class="col-md-12"><label class="labels">Thumbnail</label>
                                    <div class="text-center">
                                        <img src="view/images/${film.image}" style="width: 100%; height: auto" class="rounded" alt="...">
                                    </div>
                                </div>
                                <div class="col-md-12"><label class="labels">Genres</label>
                                    <input type="text" readonly class="form-control" 
                                           placeholder="author" value="${film.genres.name}" name="author">
                                </div>


                                <div class="col-md-12"><label class="labels">Country</label>
                                    <input type="text" readonly class="form-control" 
                                           placeholder="author" value="${film.country.countryName}" name="author">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Description</label>
                                    <textarea class="form-control" readonly name="description" rows="5" wrap="hard">${film.description}</textarea>
                                </div>
                                <div class="col-md-12"><label class="labels">Slide</label>
                                    <div class="text-center">
                                        <img src="view/images/${film.imageSlide}" class="img-fluid" alt="...">
                                    </div>
                                </div>
                            </div>
                            <div class="mt-5 text-center">
                                <a class="btn btn-primary" href="updateFilmController?filmId=${film.filmId}">
                                    Update
                                </a>

                            </div>
                        </div>
                    </form>

                </div>

            </div>
        </div>
        <%@include file="../component/admin_footer.jsp" %>
        <!-- Section: Design Block -->
    </body>

</html>
