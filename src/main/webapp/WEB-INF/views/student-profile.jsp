<%@ page import="com.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<jsp:include page="Studentbody.jsp"/>



<%
    Student student = (Student) session.getAttribute("student");

%>


<html>
<head>
    <title>Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/Studentprofile.css"/>

</head>
<body>

<form action="update" method="post">
    <div class="container rounded bg-white mt-5 mb-5">
        <div class="row">
            <div class="col-md-3 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5"
                                                                                             width="150px"
                                                                                             src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span
                        class="font-weight-bold"><%=student.getStudentName()%></span><span
                        class="text-black-50"><%=student.getStudentemaIL()%></span><span> </span></div>
            </div>
            <div class="col-md-5 border-right">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="text-right">Profile Settings</h4>
                    </div>
                    <div class="row mt-2">
                        <div class="col-md-6"><label class="labels">Name</label><input type="text" class="form-control"
                                                                                       name="stname"
                                                                                       value="<%=student.getStudentName()%>">
                        </div>
                        <div class="col-md-6"><label class="labels">ID</label><input type="text" name="Stid"
                                                                                     class="form-control"
                                                                                     value="<%=student.getStudentID()%>"
                                                                                     readonly
                        >
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12"><label class="labels">Department</label><input type="text" name="stdept"
                                                                                              class="form-control"
                                                                                              value="<%=student.getStudentDept()%>">
                        </div>
                        <div class="col-md-12"><label class="labels">Session</label><input type="text" name="stsession"
                                                                                           class="form-control"
                                                                                           value="<%=student.getStudentSession()%>">
                        </div>
                        <div class="col-md-12"><label class="labels">Blood Group</label><input type="text" name="stbgrp"
                                                                                               class="form-control"
                                                                                               value="<%=student.getStudentBgrp()%>">
                        </div>
                        <div class="col-md-12"><label class="labels">Gender</label><input type="text" name="stgender"
                                                                                          class="form-control"
                                                                                          value="<%=student.getStudentGender()%>">
                        </div>

                        <div class="col-md-12"><label class="labels"></label><input type="hidden" name="stpass"
                                                                                    class="form-control"
                                                                                    value="<%=student.getStudentpass()%>">
                        </div>

                        <input type="hidden" name="stpk"
                               class="form-control"
                               value="<%=student.getId()%>">

                        <input type="hidden" name="stemail"
                               class="form-control"
                               value="<%=student.getStudentemaIL()%>">


                        <div class="col-md-12"><label class="labels">Active Status</label>
                            <lebel id="labelac"><input type="text"
                                                       class="form-control"
                                                       value="<%=student.getStudentIsActive()%>"></lebel>
                        </div>


                        <div class="mt-5 text-center">
                            <button type="submit" class="btn btn-primary profile-button">Update Profile</button>
                        </div>


                    </div>
                </div>
            </div>
        </div>
    </div>


</form>
<%
    if (student.getStudentIsActive() == 1) {
%>
<script>
    document.getElementById("labelac").innerHTML = "Active";
    document.getElementById("labelac").style.color = "green"
</script>
<%
} else {
%>
<script>
    document.getElementById("labelac").innerHTML = "Not Active"
    document.getElementById("labelac").style.color = "red"
</script>

<%
    }
%>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
