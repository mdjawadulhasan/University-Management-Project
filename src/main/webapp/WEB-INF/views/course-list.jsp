
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>User List</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Course List</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <input type="button" value="Add User"
               onclick="window.location.href='course-create-form'; return false;"
               class="add-button">

        <br><br>

        <form:form action="search" method="GET">
            Search user by firstname: <input type="text" name="searchValue" />
            <input type="submit" value="Search" class="add-button" />
        </form:form>



        <table>
            <tr>
                <th>Course Name</th>
                <th>Section Name</th>
                <th>Action</th>
            </tr>

            <c:forEach var="course" items="${courses}">

                <c:url var="updateLink" value="/user/course-update">
                    <c:param name="courseid" value="${course.id}" />
                </c:url>

                <c:url var="deleteLink" value="/user/deletecourse">
                    <c:param name="courseid" value="${course.id}" />
                </c:url>

                <tr>
                    <td> ${course.courseName} </td>
                    <td> ${course.coureseSection} </td>
                    <td>
                        <a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>

</body>
</html>
