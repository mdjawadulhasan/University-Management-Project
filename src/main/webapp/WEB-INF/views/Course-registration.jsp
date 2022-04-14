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
    <jsp:include page="Studentbody.jsp"/>


</head>
<body>

<div id="ctitle">
    <h2>Offered Courses </h2>
</div>


<div id="container">

    <div id="content">

        <form:form action="searchcourse" method="GET">
            Search user by Coursename: <input type="text" name="searchValue"/>
            <input type="submit" class="btn btn-success" value="Search" class="add-button"/>
        </form:form>



        <table>
            <tr>
                <th>Course Name</th>
                <th>Section Name</th>
                <th>Faculty Name</th>
                <th>Add</th>

            </tr>

            <c:forEach var="course" items="${courses}">

                <c:url var="CrsAddlink" value="/student/registercourse">
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
                <th>Add</th>

            </tr>

            <c:forEach var="assignedcourse" items="${assignedcourses}">

                <c:url var="DltLink" value="/student/deletecourse">
                    <c:param name="courseid" value="${assignedcourse.id}"/>
                </c:url>

                <tr>
                    <td> ${assignedcourse.courseName} </td>
                    <td> ${assignedcourse.courseSection} </td>
                    <td>
                        <a href="${DltLink}" class="btn btn-danger" >Delete</a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>




</body>
</html>
