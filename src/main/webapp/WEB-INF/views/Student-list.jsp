<%@ page import="com.model.Assignedcourse" %>
<%@ page import="java.util.List" %>
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


</head>
<body>


<div id="ctitle">
    <h2>Student List </h2>
</div>


<div id="container">

    <div id="content">

        <%
            List<Assignedcourse> assignedcourses = (List<Assignedcourse>) request.getAttribute("stcourses");

            if (assignedcourses.size() > 0) {
        %>

        <p class="text-monospace">Course Name : <%=assignedcourses.get(0).getCourseName()%>
        </p>
        <p class="text-monospace">Section: <%=assignedcourses.get(0).getCourseSection()%>
        </p>
        <%}%>

        <table>
            <tr>
                <th>Student ID</th>
                <th>Student Name</th>
            </tr>


           <% if(assignedcourses.size()>0){%>

            <c:forEach var="stcourse" items="${stcourses}">

                <tr>
                    <td> ${stcourse.studetid} </td>
                    <td> ${stcourse.studentName} </td>

                </tr>

            </c:forEach>


            <%}%>


        </table>

    </div>

</div>


</body>
</html>
