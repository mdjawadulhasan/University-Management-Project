<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <title>Update Course</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-user-style.css">

    <jsp:include page="Adminbody.jsp"/>


    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto+Mono:ital,wght@0,200;1,700&display=swap');

        body{
            font-family: 'Roboto Mono', monospace;
        }
    </style>





</head>

<body>



<div id="container">
    <h3>Update Course</h3>
    <form:form action="updatecourse" modelAttribute="course" method="POST">
        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><form:input path="CourseName"/></td>
            </tr>
            <tr>
                <td><label>Last name:</label></td>
                <td><form:input path="CoureseSection"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" class="btn btn-info" value="Update" class="update"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <div style="clear; both;"></div>

    <p>
        <a href="${pageContext.request.contextPath}/admin/Addcourse">Back to Course List</a>
    </p>

</div>
</body>
</html>




