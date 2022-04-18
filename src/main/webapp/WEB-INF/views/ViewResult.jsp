<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Result</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <jsp:include page="Studentbody.jsp"/>


    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto+Mono:ital,wght@0,200;1,700&display=swap');

        h2{
            font-family: 'Roboto Mono', monospace;
        }
    </style>
</head>
<body>


<div id="ctitle">
    <h2>Result </h2>
</div>


<div id="container">

    <div id="content">


        <table>
            <tr>
                <th>Course Name</th>
                <th>Result</th>
            </tr>

            <c:forEach var="assignedcourse" items="${assignedcourses}">
                <tr>
                    <td> ${assignedcourse.courseName} </td>
                    <td> ${assignedcourse.result} </td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>




</body>
</html>
