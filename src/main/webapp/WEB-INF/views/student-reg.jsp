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
                <form action="votersregister" method="post">
                    <div class="input-boxes">
                        <div class="input-box">
                            <i class="fas fa-user"></i>
                            <input type="text"name="username" placeholder="Enter your Username" required>
                        </div>
                        <div class="input-box">
                            <i class="fas fa-envelope"></i>
                            <input type="text" name="email" placeholder="Enter your email" required>
                        </div>
                        <div class="input-box">
                            <i class="fas fa-lock"></i>
                            <input type="password" name="password" placeholder="Enter your password" required>
                        </div>
                        <div class="button input-box">
                            <input type="submit" value="Sumbit">
                        </div>
                        <div class="text sign-up-text">Already have an account? <label for="flip">Login now</label></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%--
<%
    if (request.getSession().getAttribute("success") != null) {
%>

<script>
    Swal.fire(
        'Registration Success!',
        '',
        'success'
    )
</script>


<%

        session=request.getSession();
        session.removeAttribute("success");
        session.invalidate();
    }
%>

<%
    if (request.getSession().getAttribute("error") != null) {
%>

<script>
    Swal.fire({
        icon: 'error',
        title: 'Wrong Password',
        text: 'Try Again!',
    })
</script>


<%
        session=request.getSession();
        session.removeAttribute("error");
        session.invalidate();
    }
%>


<%
    if (request.getSession().getAttribute("notallowed") != null) {
%>

<script>
    Swal.fire({
        icon: 'error',
        title: 'You are not activated yet',
        text: 'Go Back to login Page!',
    })
</script>


<%
        session=request.getSession();
        session.removeAttribute("notallowed");
        session.invalidate();
    }
%>



<%
    if (request.getSession().getAttribute("alreadyvoted") != null) {
%>

<script>
    Swal.fire({
        icon: 'error',
        title: 'Your Vote has Casted already !',
        text: 'Go Back to login Page!',
    })
</script>


<%
        session=request.getSession();
        session.removeAttribute("alreadyvoted");
        session.invalidate();
    }
%>


<%
    if (request.getSession().getAttribute("voted") != null) {
%>

<script>
    Swal.fire(
        'Vote Given!',
        'Go Back to login Page',
        'success'
    )
</script>


<%
        session=request.getSession();
        session.removeAttribute("voted");
        session.invalidate();
    }
%>
--%>




</body>
</html>