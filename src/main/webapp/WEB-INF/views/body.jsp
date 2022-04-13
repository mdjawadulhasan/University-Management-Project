<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>User List</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/navbar.css"/>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="menu-bar">
    <h1 class="logo"><img src="${pageContext.request.contextPath}/resources/Images/logo.png" alt="Italian Trulli" width="30" height="28"><span> UMS</span></h1>


    <ul>
        <li><a href="#">Hello Jawad</a></li>
        <li><a href="${pageContext.request.contextPath}/course/list">Profile</a></li>
        <%-- <li><a href="#">Give Vote</a></li>
         <li><a href="#">See Result</a></li>--%>
        <li><a href="logoutcandidate">Logout</a></li>
    </ul>

</div>


<center><button type="button" class="btn btn-primary"  onclick="window.location.href='list'; return false;">Add Course</button></center>
<center><button type="button" class="btn btn-success"  onclick="window.location.href='list'; return false;">Assign Course</button></center>
</body>
</html>