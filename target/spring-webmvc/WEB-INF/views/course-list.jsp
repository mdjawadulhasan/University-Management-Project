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
    <jsp:include page="Adminbody.jsp"/>


</head>
<body>


    <div id="ctitle">
        <h2>Course List</h2>
    </div>


<div id="container">

    <div id="content">

        <form:form action="searchcourse" method="GET">
            Search user by Coursename: <input type="text" name="searchValue"/>
            <input type="submit" value="Search" class="add-button"/>
            <input type="button" value="Add Course"
                   onclick="window.location.href='course-create-form'; return false;"
                   class="add-button">
        </form:form>



        <table>
            <tr>
                <th>Course Name</th>
                <th>Section Name</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>

            <c:forEach var="course" items="${courses}">

                <c:url var="updateLink" value="/admin/course-update">
                    <c:param name="courseid" value="${course.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/admin/deletecourse">
                    <c:param name="courseid" value="${course.id}"/>
                </c:url>

                <tr>
                    <td> ${course.courseName} </td>
                    <td> ${course.coureseSection} </td>
                    <td>
                        <a href="${updateLink}">Update</a>
                    </td>
                    <td><a href="${deleteLink}">Delete</a></td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>

</body>
</html>
