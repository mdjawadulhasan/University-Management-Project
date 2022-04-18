<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <title>Save User</title>
    <jsp:include page="Adminbody.jsp"/>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-user-style.css">



    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto+Mono:ital,wght@0,200;1,700&display=swap');

        body{
            font-family: 'Roboto Mono', monospace;
        }
    </style>
</head>

<body>



<div id="container">
    <h3>Create Course</h3>
    <form:form action="createcourse" modelAttribute="course" method="POST">
        <table>
            <tbody>
            <tr>
                <td><label>Course name:</label></td>
                <td><form:input path="CourseName" /></td>
            </tr>
            <tr>
                <td><label>Section name:</label></td>
                <td><form:input path="CoureseSection"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" class="btn btn-info" value="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <div style="clear: both;"></div>

    <p>
        <a href="${pageContext.request.contextPath}/admin/Addcourse">Back to Course List</a>
    </p>

</div>
</body>
</html>










