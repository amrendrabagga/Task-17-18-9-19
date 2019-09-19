<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>ENTER EMP DETAILS</h2><hr>
<form action="SaveEmp">
	<table align="center"  cellspacing="0" cellpadding="6px">
		<tr>
		<td>Enter Eno</td><td><input type="text" name="eno"></td>
		</tr>
		<tr>
		<td>Enter Name</td><td><input type="text" name="ename"></td>
		</tr>
		<tr>
		<td>Enter Salary</td><td><input type="text" name="salary"></td>
		</tr>
		<tr>
		<td>Enter Designation</td><td><input type="text" name="designation"></td>
		</tr>
		<tr>
		<td>Enter Department</td><td><input type="text" name="dept"></td>
		</tr>
		<tr colspan="2" align="center">
		<td ><input type="submit" value="SUBMIT"></td>
		</tr>
	</table>
	
</form>
<hr>
<a href="index.jsp">Home</a>
</body>
</html>