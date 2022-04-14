<%@ page import="com.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: Jawad
  Date: 4/14/2022
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="Studentbody.jsp"/>
<%
    Student student = (Student) session.getAttribute("student");

%>


<html>
<head>
    <title>Course Registration</title>
    <h2>Hello <%=student.getStudentName()%></h2>
</head>
<body>

</body>
</html>
