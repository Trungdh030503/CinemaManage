<%-- 
    Document   : profile
    Created on : Oct 26, 2022, 4:45:43 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <%@include file="../component/setupCss.jsp" %>
        <style>
            .form-control:focus {
                box-shadow: none;
                border-color:  #003d99
            }

            .profile-button {
                background: rgb(0, 102, 255);
                box-shadow: none;
                border: none
            }

            .profile-button:hover {
                background: #003d99;
                padding: 8px 12px;
            }

            .profile-button:focus {
                background:  #003d99;
                box-shadow: none
            }

            .profile-button:active {
                background:  #003d99;
                box-shadow: none
            }

            .back:hover {
                color: #003d99;
                cursor: pointer
            }

            .labels {
                font-size: 18px
            }

            .form-control{
                margin-bottom: 10px;
                margin-top: -5px;
            }

            .add-experience:hover {
                background:  #003d99;
                color: #fff;
                cursor: pointer;
                border: solid 1px  #003d99
            }
        </style>
    </head>
    <body>
        <!--Header-->
        <%@include file="../component/header.jsp" %>
        <!--Header-->

        <!-- Section: Design Block -->
        <div class="container rounded bg-white mt-5 mb-5 ">
            <div class="row d-flex justify-content-center">
                <div class="col-md-6 border">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Profile Settings</h4>
                        </div>
                        <form action="profileController" method="post">
                            <div class="row mt-3">
                                <div class="col-md-12"><label class="labels">Fullname</label>
                                    <input type="text" class="form-control" placeholder="fullname" value="${requestScope.user.fullname}" 
                                           name="name">
                                </div>
                                <div class="col-md-12"><label class="labels">Email</label>
                                    <input type="text" class="form-control" placeholder="email" value="${requestScope.user.email}" 
                                           readonly>
                                </div>
                                <div class="col-md-12"><label class="labels">Phone</label>
                                    <input type="text" class="form-control" placeholder="phone" value="${requestScope.user.phone}" 
                                           maxlength="11"
                                           minlength="10" name="phone">
                                </div>
                                <div class="col-md-12"><label class="labels">Address</label>
                                    <input type="text" class="form-control" placeholder="address" value="${requestScope.user.address}" 
                                           name="address"></div>
                                <div class="col-md-12"><label class="labels">DOB</label>
                                    <input type="date" class="form-control" placeholder="DOB" value="${requestScope.user.DOB}" name="dob">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Gender</label>
                                    <select name="gender" class="form-control">
                                        <option value = "true" 
                                                <c:if test="${requestScope.user.gender}">
                                                    selected
                                                </c:if>>
                                            Male
                                        </option>
                                        <option value = "false" 
                                                <c:if test="${!requestScope.user.gender}">
                                                    selected
                                                </c:if>>
                                            Female
                                        </option>
                                    </select>
                                </div>

                            </div>
                            <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Save
                                    Profile</button>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
        <!-- Section: Design Block -->

        <!--Footer->
        <%@include file="../component/footer.jsp" %>
        <!--Footer-->

        <!--Script-->
        <%@include file="../component/setupJS.jsp" %>
        <!--Script-->

    </body>
</html>
