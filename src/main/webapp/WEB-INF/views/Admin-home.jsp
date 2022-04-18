<%--
  Created by IntelliJ IDEA.
  User: Jawad
  Date: 4/13/2022
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="Adminbody.jsp"/>
<html>
<head>
    <title>ADMIN- HOME </title>
    <style>
        .custom {
            width: 300px !important;
        }
        @import url('https://fonts.googleapis.com/css2?family=Roboto+Mono:wght@200&display=swap');
        .btn{
            font-family: 'Roboto Mono', monospace;
        }
    </style>
</head>
<body>
<center><button type="button" class="btn btn-primary btn-lg custom"  onclick="window.location.href='Addcourse'; return false;">Add Course</button></center>
<br>
<center><button type="button" class="btn btn-success btn-lg custom"  onclick="window.location.href='studentlist'; return false;">Manage Student</button></center>
<br>
<center><button type="button" class="btn btn-danger btn-lg  custom"  onclick="window.location.href='blockstudent'; return false;">Block Student</button></center>
<br>









</body>
</html>
