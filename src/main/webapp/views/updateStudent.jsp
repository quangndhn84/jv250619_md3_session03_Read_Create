<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/28/2025
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/StudentServlet?action=Update" method="post">
  <label for="studentId">Student Id</label>
  <input type="text" id="studentId" name="studentId" value="${student.studentId}" readonly/><br>
  <label for="studentName">Student Name</label>
  <input type="text" id="studentName" name="studentName" value="${student.studentName}"/><br>
  <label>Status</label>
  <input type="radio" id="active" name="status" value="true" ${student.status?'checked':''}/><label for="active">Active</label>
  <input type="radio" id="inActive" name="status" value="false" ${student.status?'':'checked'}/><label for="inActive">Inactive</label><br>
  <input type="submit" value="Update"/>
</form>
</body>
</html>
