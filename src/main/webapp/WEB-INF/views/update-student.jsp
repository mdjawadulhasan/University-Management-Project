<%@ page import="com.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<jsp:include page="Studentbody.jsp"/>
<%
    Student student= (Student) request.getAttribute("student");

%>

<html>
<head>
    <title>Update</title>
</head>
<body>

</body>
</html>
