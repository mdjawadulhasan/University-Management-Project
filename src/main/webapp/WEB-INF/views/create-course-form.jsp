<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <title>Save User</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-user-style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>User Form</h2>
    </div>
</div>

<div id="container">
    <h3>Save User</h3>
    <form:form action="createcourse" modelAttribute="course" method="POST">
        <table>
            <tbody>
            <tr>
                <td><label>Course name:</label></td>
                <td><form:input path="CourseName"/></td>
            </tr>
            <tr>
                <td><label>Section name:</label></td>
                <td><form:input path="CoureseSection"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <div style="clear: both;"></div>

    <p>
        <a href="${pageContext.request.contextPath}/admin/Addcourse">Back to List</a>
    </p>

</div>
</body>
</html>










