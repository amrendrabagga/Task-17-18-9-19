<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.wp.entity.Emp" %>
<!DOCTYPE html>
<% List<Emp> list = (List<Emp>)request.getAttribute("empList");%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">EMP DETAILS</h2><hr>
<table align="center" cellspacing="0" cellpadding="5px" border="1">
<tr><th>Eno</th><th>Ename</th><th>Salary</th><th>Designation</th><th>Dept</th></tr>
<%for(Emp emp : list){ %>
<tr>
<td><%=emp.getEno() %></td>
<td><%=emp.getEname() %></td>
<td><%=emp.getSalary() %></td>
<td><%=emp.getDesignation() %></td>
<td><%=emp.getDept() %></td>
<td><a href="update?eno=<%=emp.getEno()%>">Update</a></td>
<td><a href="delete?eno=<%=emp.getEno()%>">Delete</a></td>
</tr>
<%} %>
</table>
<hr>
<a href="index.jsp">Home</a>
</body>
</html>