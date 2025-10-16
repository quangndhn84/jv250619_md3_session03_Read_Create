<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/16/2025
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Students</title>
</head>
<body>
<h2>List Students</h2>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Student ID</th>
        <th>Student Name</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%-- Lấy thuộc tính có tên là listStudents trong request   --%>
    <c:forEach items="${listStudents}" var="student" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
                <%--  student.getStudentId()  --%>
            <td>${student.studentId}</td>
            <td>${student.studentName}</td>
            <td>${student.status?"Active":"Inactive"}</td>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="views/newStudent.jsp">Create new Student...</a>
</body>
</html>
