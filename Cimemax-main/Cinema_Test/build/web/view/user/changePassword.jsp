<%-- 
    Document   : profile
    Created on : Oct 26, 2022, 10:21:37 AM
    Author     : Admin
--%>

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
                border-color: #003d99
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
                background: #003d99;
                box-shadow: none
            }

            .profile-button:active {
                background: #003d99;
                box-shadow: none
            }

            .back:hover {
                color: #003d99;
                cursor: pointer
            }

            .labels {
                font-size: 16px
            }

            .form-control {
                margin-bottom: 10px;
                margin-top: -5px;
            }

            .add-experience:hover {
                background: #003d99;
                color: #fff;
                cursor: pointer;
                border: solid 1px #003d99
            }
        </style>
    </head>
    <body>
        <!--Header-->
        <%@include file="../component/header.jsp" %>
        <!--Header-->

        <div class="container bg-white mt-5 mb-5">
            <div class="d-flex justify-content-center align-items-center row">
                <div class="col-md-6 border">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Change Password</h4>
                        </div>
                        <form action = "changePassController" method="post">
                            <div class="row mt-3">
                                <div class="col-md-12"><label class="labels">Old-Password</label>
                                    <input type="text" class="form-control" required="true"
                                           placeholder="Old-Password" value="" name="opass">
                                </div>
                                <div class="col-md-12"><label class="labels">New-Password</label>
                                    <input type="text" class="form-control" required="true"
                                           placeholder="New-Password" value="" name = "npass">
                                </div>
                                <div class="col-md-12"><label class="labels">Confirm-Password</label>
                                    <input type="text" class="form-control" required="true" 
                                           placeholder="Confirm-Password" value="" name="cpass">
                                </div>
                            </div>
                            <div class="mt-5 text-center">
                                <button class="btn btn-primary profile-button" type="submit">
                                    Save Changes
                                </button>
                            </div>
                        </form>>
                    </div>
                </div>

            </div>
        </div>

        <!--Footer->
        <%@include file="../component/footer.jsp" %>
        <!--Footer-->

        <!--Script-->
        <%@include file="../component/setupJS.jsp" %>
        <!--Script-->
    </body>
</html>
