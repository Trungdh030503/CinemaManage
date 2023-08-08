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
                    <form action="updateFilmController" method="post" enctype="multipart/form-data">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h4 class="text-right">Update Movie</h4>
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-12">
                                    <label class="labels">FilmID</label>
                                    <input type="text" readonly class="form-control" 
                                           placeholder="title" value="${film.filmId}" name="filmId">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Title</label>
                                    <input type="text" required class="form-control" 
                                           placeholder="title" value="${film.title}" name="title">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Premiere</label>
                                    <input type="date" required class="form-control" 
                                           placeholder="premiere" value="${film.premiere}" name="premiere">
                                </div>
                                <div class="col-md-12"><label class="labels">Actor</label>
                                    <input type="text" required class="form-control" 
                                           placeholder="actor" value="${film.actor}" name="actor">
                                </div>
                                <div class="col-md-12"><label class="labels">Author</label>
                                    <input type="text" required class="form-control" 
                                           placeholder="author" value="${film.author}" name="author"></div>
                                <div class="col-md-12"><label class="labels">Duration</label>
                                    <input type="number" required class="form-control"
                                           placeholder="duration" value="${film.time}" name="duration" min="30" max="150">
                                </div>
                                <div class="col-md-12"><label class="labels">Thumbnail</label>
                                    <input type="file" class="form-control" 
                                           placeholder="Choose File"  name="file">
                                </div>

                                <div class="col-md-12"><label class="labels">Genres</label>
                                    <select name="genres" class="form-control">
                                        <c:forEach items="${requestScope.genres}" var="g">
                                            <option value="${g.genresId}" <c:if test="${film.genres.genresId == g.genresId}">selected</c:if> >${g.name} </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-12"><label class="labels">Country</label>
                                    <select name="country" class="form-control">
                                        <c:forEach items="${requestScope.country}" var="c">
                                            <option value="${c.code}" <c:if test="${film.country.code == c.code}">selected</c:if>>${c.countryName} </option>
                                        </c:forEach>
                                    </select>
                                </div>


                                <div class="col-md-12">
                                    <label class="labels">Description</label>
                                    <textarea class="form-control" required name="description" rows="5" wrap="hard">${film.description}</textarea>
                                </div>
                                <div class="col-md-12"><label class="labels">Slide</label>
                                    <input type="file" class="form-control" placeholder="Choose File" name="slide">
                                </div>
                            </div>
                            <div class="mt-5 text-center">
                                <button class="btn btn-primary profile-button" type="submit">Save Change</button>
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
