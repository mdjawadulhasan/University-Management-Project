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
    <h2>Available Courses </h2>
</div>


<div id="container">

    <div id="content">

       <%-- <form:form action="searchcourse" method="GET">
            Search user by Coursename: <input type="text" name="searchValue"/>
            <input type="submit" class="btn btn-success" value="Search" class="add-button"/>
        </form:form>--%>



        <table>
            <tr>
                <th>Course Name</th>
                <th>Section Name</th>
                <th>Faculty Name</th>
                <th>Add</th>

            </tr>

            <c:forEach var="course" items="${courses}">

                <c:url var="CrsAddlink" value="/faculty/Addcourse">
                    <c:param name="courseid" value="${course.id}"/>
                </c:url>

                <tr>
                    <td> ${course.courseName} </td>
                    <td> ${course.coureseSection} </td>
                    <td> ${course.facultyName} </td>
                    <td>
                        <a href="${CrsAddlink}" class="btn btn-primary " >Add</a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>


<div id="ctitle">
    <h2>Added Courses </h2>
</div>


<div id="container">

    <div id="content">


        <table>
            <tr>
                <th>Course Name</th>
                <th>Section Name</th>
                <th>Faculty Name</th>
                <th>Add</th>

            </tr>

            <c:forEach var="scourse" items="${scourses}">

                <c:url var="CrsAddlink" value="/faculty/removecourse">
                    <c:param name="courseid" value="${scourse.id}"/>
                </c:url>

                <tr>
                    <td> ${scourse.courseName} </td>
                    <td> ${scourse.coureseSection} </td>
                    <td> ${scourse.facultyName} </td>
                    <td>
                        <a href="${CrsAddlink}" class="btn btn-danger" >Remove</a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>




</body>
</html>
