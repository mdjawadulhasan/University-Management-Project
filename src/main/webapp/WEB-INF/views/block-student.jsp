<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Block Student</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <jsp:include page="Adminbody.jsp"/>


</head>
<body>


<div id="ctitle">
    <h2>Student List</h2>
</div>


<div id="container">

    <div id="content">

        <table>
            <tr>
                <th>Student ID</th>
                <th>Student Name</th>
                <th>Department</th>
                <th>Email</th>
                <th>Delete</th>
            </tr>

            <c:forEach var="student" items="${students}">
                <c:url var="activelink" value="/admin/blockst">
                    <c:param name="stid" value="${student.id}"/>
                </c:url>

                <tr>
                    <td> ${student.studentID} </td>
                    <td> ${student.studentName} </td>
                    <td> ${student.studentDept} </td>
                    <td> ${student.studentemaIL} </td>
                    <td><a href="${activelink}" class="btn btn-danger">Block</a></td>
                </tr>
            </c:forEach>
        </table>

    </div>

</div>

</body>
</html>
