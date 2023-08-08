<%-- 
    Document   : newFilm
    Created on : Oct 28, 2022, 1:12:02 PM
    Author     : int.thong.nk
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add Show</title>

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>

    <body>
        <%@include file="../component/admin_header.jsp" %>
        <!-- Section: Design Block -->
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row d-flex justify-content-center">
                <div class="col-md-6 border">
                    <form action="updateShowController" method="post">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h4 class="text-right">Update Show</h4>
                            </div>
                            <div class="row mt-3">
                                <c:if test="${requestScope.mess != null}">
                                    <div class="alert alert-danger" role="alert">
                                        ${requestScope.mess.mess}
                                    </div>
                                </c:if>
                                <div class="col-md-12"><label class="labels">Id</label>
                                    <input type="text" class="form-control" readonly value="${show.showId}" name="showId">
                                </div>
                                <div class="col-md-12"><label class="labels">Film</label>
                                    <select name="film" class="form-control">
                                        <c:forEach items="${requestScope.films}" var="f">
                                            <option value="${f.filmId}" <c:if test="${f.filmId == show.film.filmId}">selected</c:if> >
                                                ${f.title}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-12"><label class="labels">Date</label>
                                    <input type="date" required class="form-control"
                                           placeholder="premiere" value="${show.showDate}" name="date">
                                </div>
                                <div class="col-md-12"><label class="labels">Time</label>
                                    <select name="slot" class="form-control">
                                        <c:forEach items="${requestScope.slots}" var="s">
                                            <option value="${s.id}" <c:if test="${s.id == show.slot.id}">selected</c:if>>
                                                ${s.time}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-12"><label class="labels">Theater</label>
                                    <select name="room" class="form-control">
                                        <c:forEach items="${requestScope.rooms}" var="r">
                                            <option value="${r.roomId}" <c:if test="${r.roomId == show.room.roomId}"> selected </c:if> >
                                                ${r.roomName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="mt-5 text-center">
                                <button class="btn btn-primary profile-button" type="submit">Update Show</button>
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
