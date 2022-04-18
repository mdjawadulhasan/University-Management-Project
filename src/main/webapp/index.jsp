<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>UMS- Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="icon" href="resources/Images/ulogo.jpg" type="image/icon type">

    <style type="text/css">

        body{
            margin: 0; height: 100%; overflow: hidden;
        }
        .col-md-12{
            margin-top: 200px;
        }

    </style>
</head>
<body>

<div class="row">
    <div class="col-md-12">
        <center><img class="logo" src="resources/Images/ulogo.jpg" width="200" length="100"></center>
        <br>
        <center><h1>University Management System</h1></center>
    </div>
</div><br><br><br>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">

        <p align="middle">
            <a class="btn btn-warning btn-lg" onclick="window.location.href='admin/login'; return false;">ADMIN</a>
            <a class="btn btn-danger btn-lg" onclick="window.location.href='student/registration'; return false;">STUDENT</a>
            <a class="btn btn-primary btn-lg" onclick="window.location.href='faculty/registration'; return false;">FACULTY</a>
        </p>
    </div>
    <div class="col-md-2"></div>
</div>




</footer>

</body>
</html>