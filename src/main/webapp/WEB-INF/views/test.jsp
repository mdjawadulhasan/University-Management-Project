<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="CSS/Votersregstyle.css"/>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/studentreg.css"/>

    <link rel="icon" href="${pageContext.request.contextPath}/resources/Images/ulogo.jpg" type="image/icon type">



    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>



    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>

</head>
<body>
<div class="container">
    <input type="checkbox" id="flip">
    <div class="cover">
        <div class="front">
            <div class="text">
                <span class="text-1"><br></span>
                <span class="text-2"></span>
            </div>
        </div>
        <div class="back">
            <img class="backImg" src="${pageContext.request.contextPath}/resources/Images/ulogo.jpg" alt="">
            <div class="text">
                <span class="text-1"> <br> </span>
                <span class="text-2"></span>
            </div>
        </div>
    </div>
    <div class="forms">
        <div class="form-content">
            <div class="login-form">
                <div class="title">Login</div>
                <form action="voterslogin" method="post">
                    <div class="input-boxes">
                        <div class="input-box">
                            <i class="fas fa-user"></i>
                            <input type="text" name="username" placeholder="Enter your Username" required>
                        </div>
                        <div class="input-box">
                            <i class="fas fa-lock"></i>
                            <input type="password" name="password" placeholder="Enter your password" required>
                        </div>

                        <div class="button input-box">
                            <input type="submit" value="Sumbit">
                        </div>
                        <div class="text sign-up-text">Don't have an account? <label for="flip">Sigup now</label></div>
                    </div>
                </form>
            </div>
            <div class="signup-form">
                <div class="title">Signup</div>



                <form:form action="createstudent" modelAttribute="student" method="POST">
        <table>
            <tbody>
            <tr>
                <td><label>Course name:</label></td>
                <td><form:input path="studentID"/></td>
            </tr>
            <tr>
                <td><label>Section name:</label></td>
                <td><form:input path="studentpass"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" class="btn btn-info" value="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <div style="clear: both;"></div>



</div>
</body>
</html>










