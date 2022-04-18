<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Course List</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <jsp:include page="facultybody.jsp"/>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto+Mono:ital,wght@0,200;1,700&display=swap');

        h2{
            font-family: 'Roboto Mono', monospace;
        }
    </style>

</head>
<body>


<div id="ctitle">
    <h2>My Courses </h2>
</div>


<div id="container">

    <div id="content">


        <table>
            <tr>
                <th>Course Name</th>
                <th>Section Name</th>
                <th>Student List</th>

            </tr>

            <c:forEach var="scourse" items="${scourses}">



                <c:url var="studentlistlink" value="/faculty/Allstudents">
                    <c:param name="cname" value="${scourse.courseName}"/>
                    <c:param name="section" value="${scourse.coureseSection}"/>
                </c:url>

                <tr>
                    <td> ${scourse.courseName} </td>
                    <td> ${scourse.coureseSection} </td>
                    <td>
                        <a href="${studentlistlink}" class="btn btn-success" >View</a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>




</body>
</html>
