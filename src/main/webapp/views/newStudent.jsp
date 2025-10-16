<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/16/2025
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Student</title>
</head>
<body>
<h2>Create new Student</h2>
<%--<%=request.getContextPath()%>: lấy lại đường dẫn gốc localhost:8080--%>
<form action="<%=request.getContextPath()%>/StudentServlet?action=Create" method="post">
    <%-- id: định danh phía client tương tác html,css,js   --%>
    <%-- name: định danh phía server   --%>
    <label for="studentId">Student Id</label>
    <input type="text" id="studentId" name="studentId"/><br>
    <label for="studentName">Student Name</label>
    <input type="text" id="studentName" name="studentName"/><br>
    <label>Status</label>
    <input type="radio" id="active" name="status" value="true" checked/><label for="active">Active</label>
    <input type="radio" id="inActive" name="status" value="false"/><label for="inActive">Inactive</label><br>
    <input type="submit" value="Create"/>
</form>
</body>
</html>
