<%@ page import="com.model.Assignedcourse" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <title>Submit Marks</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-user-style.css">

    <jsp:include page="facultybody.jsp"/>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto+Mono:ital,wght@0,200;1,700&display=swap');

        h2{
            font-family: 'Roboto Mono', monospace;
        }
    </style>
</head>

<body>

<% Assignedcourse assignedcourse = (Assignedcourse) request.getAttribute("assignedcourse"); %>

<div id="container">
    <h2>Submit Marks</h2>
    <form action="updatemarks" method="POST">
        <table>
            <tbody>
            <tr>
                <td><label>Student Name:</label></td>
                <td><%=assignedcourse.getStudentName()%>
                </td>
            </tr>
            <tr>
                <td><label>Student ID:</label></td>
                <td><%=assignedcourse.getStudetid()%>
                </td>
            </tr>
            <tr>
                <td><label>Marks:</label></td>
                <td><input type="text" name="marks" required=""></td>
                <td><input type="hidden" value="<%=assignedcourse.getId()%>" name="id" required=""></td>

            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" class="btn btn-info" value="Update" class="update"/></td>
            </tr>
            </tbody>
        </table>
    </form>
    <div style="clear; both;"></div>


</div>
</body>
</html>




