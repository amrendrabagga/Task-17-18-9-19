<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="com.wp.entity.Emp" isELIgnored="false"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Update Employee</h2>
<hr>
<form action="UpdateEmp" method="post">
<table align="center" cellspacing="0" cellpadding="9px">
<tr>
<td>Eno</td>
<td><input type="text" name="eno" value='<%=((Emp)request.getAttribute("emp")).getEno()%>' ></td>
</tr>
<tr>
<td>Ename</td>
<td><input type="text" name="ename" value='${emp.ename}'></td>
</tr>
<tr>
<td>Salary</td>
<td><input type="text" name="salary" value='${emp.salary}'></td>
</tr>

<tr>
<td>Designation</td>
<td><input type="text" name="designation" value='${emp.designation}'></td>
</tr>

<tr>
<td>Department</td>
<td><input type="text" name="dept" value='${emp.dept}'></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="SUBMIT"></td>
</tr>
</table>
</form>
<a href="index.jsp">Home</a>
</body>
</html>