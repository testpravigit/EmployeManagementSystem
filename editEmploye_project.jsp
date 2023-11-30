<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dao.DaoemployeImpl"%>
    <%@page import="dto.Employe" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="editEmploye_projectcss.css">
</head>
<body>
<%@ include file="index_project.jsp" %>

<%
String id=request.getParameter("id");
DaoemployeImpl de=new DaoemployeImpl();
Employe e=de.geteachEmploye(id);

%>
<div class="container">
<form action="Edit1">
		
	<label>Name</label>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name="name" value="<%=e.getName() %>"></br>
	<label>Salary</label>&nbsp;&nbsp;&nbsp;
	<input type="text" name="salary"value="<%=e.getSalary() %>"></br>
	<label>Dept</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name="dept"value="<%=e.getDept() %>"></br>
	
	<input type="hidden" name="id"value="<%=e.getId() %>"></br>
	
	<input type="submit" value="Edit">

</form>
</div>



</body>
</html>