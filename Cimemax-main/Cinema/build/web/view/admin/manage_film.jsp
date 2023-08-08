<%-- 
    Document   : managa_film
    Created on : Oct 31, 2022, 9:17:24 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Manage Show</title>

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
        <%@include file="../component/admin_header.jsp" %>
        <!-- Section: Design Block -->
        <section class="py-1">
            <!-- style="background-color: white"-->
            <div class="container d-flex " style="min-height: 800px;">
                <div class="col-md-3 border" 
                     style="background-color: #eeeee4; margin-right: 20px; border-radius: 30px; " >
                    <div style="margin-top: 300px">
                        <h3 class="text-center mt-5" >Filter</h3>
                        <form action="manageFilmController" method="get">
                            <div style="margin-left: 30px">
                                <input hidden type="text" value="1" name="page">
                                <div class="mt-3">
                                    <label class="col-md-3">Title: </label>
                                    <input class="col-md-8" type="text" value="${title}" name="title"/>
                                </div>
                                <div class="mt-1">
                                    <label class="col-md-3">Premiere: </label>
                                    <input class="col-md-8" type="date" value="${date}" name="date"/>
                                </div>
                                <div class="mt-1">
                                    <label class="col-md-3">Genres: </label>
                                    <select class="col-md-8"  name="genres">
                                        <option value="" <c:if test="${genres == ''}">selected</c:if> >All</option>
                                        <c:forEach items="${gen}" var="g">
                                            <option value="${g.genresId}" <c:if test="${genres == g.name}">selected</c:if>>${g.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="mt-1">
                                    <label class="col-md-3">Country: </label>
                                    <select class="col-md-8"  name="country">
                                        <option value="" >All Country</option>
                                        <c:forEach items="${coun}" var="c">
                                            <option value="${c.code}" <c:if test="${genres == g.name}">selected</c:if>>
                                                ${c.countryName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="mt-1">
                                    <label class="col-md-3">Order: </label>
                                    <select class="col-md-8"  name="order">
                                        <option value="title" <c:if test="${order == 'title'}">selected</c:if>>Title</option>
                                        <option value="author"<c:if test="${order == 'author'}">selected</c:if>>Author</option>
                                        </select>
                                    </div>
                                    <div class="mt-1">
                                        <label class="col-md-3">Dimesion: </label>
                                        <select class="col-md-8" name="dimesion">
                                            <option value="asc" <c:if test="${dimesion == 'asc'}">selected</c:if>>Ascending</option>
                                        <option value="desc"<c:if test="${dimesion == 'desc'}">selected</c:if>>Descending</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="mt-3 d-flex justify-content-center">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <h3 class="mt-5">List Film Is Active</h3>
                        <div class="d-flex justify-content-between mt-5 ">
                            <a href="createFilmController" class="btn btn-outline-success ">Add more movie</a>
                        </div>
                        <table class="table mt-2" style="height: 100px">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Title</th>
                                    <th scope="col">Premiere</th>
                                    <th scope="col">Author</th>
                                    <th scope="col">Genres</th>
                                    <th scope="col">Country</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${film}" var="f">
                                <tr style="height: 60px">
                                    <th scope="row">${f.filmId}</th>
                                    <th scope="row">${f.title}</th>
                                    <th scope="row">${f.premiere}</th>
                                    <th scope="row">${f.author}</th>
                                    <th scope="row">${f.genres.name}</th>
                                    <th scope="row">${f.country.countryName}</th>
                                    <th scope="row">
                                        <a href="viewFilmController?filmId=${f.filmId}"><i class="fa fa-solid fa-eye"></i></a>
                                        <a style="margin-left: 10px" href="updateFilmController?filmId=${f.filmId}"><i class="fa fa-solid fa-pencil"></i></a>
                                        <button class="btn btn-link" type="button" class="btn btn-primary"
                                                data-bs-toggle="modal" data-bs-target="#exampleModal${f.filmId}"><i
                                                class="fa fa-solid fa-trash mb-1"></i>
                                        </button>
                                    </th>
                                </tr>

                            <div class="modal fade" id="exampleModal${f.filmId}" tabindex="-1"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel"><i class="bi bi-trash-fill"></i>
                                                Delete</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            Are you sure to delete this movie?
                                        </div>
                                        <div class="modal-footer">
                                            <form action="manageFilmController" method="post">
                                                <input hidden type="search" value="${f.filmId}" name="filmId" hidden>
                                                <button type="submit" class="btn btn-primary">Yes</button>
                                                <button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">No</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>                      
                        </tbody>
                    </table>
                    <div class="d-flex justify-content-center">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <c:forEach begin="1" end="${requestScope.total}" step="1" var="i">
                                    <li class="page-item <c:if test="${i == requestScope.page}"> active </c:if> " >
                                        <a class="page-link" href="manageFilmController?page=${i}&title=${title}&date=${requestScope.date}&genres=${genres}&country=${country}&order=${order}&dimesion=${dimesion}">
                                            ${i}
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </nav>
                    </div>
                </div>

            </div>
        </section>
        <%@include file="../component/admin_footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Section: Design Block -->
    </body>

</html>
