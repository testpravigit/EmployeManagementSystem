<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="editEmploye_projectcss.css">
</head>
<body>
<%@ include file="index_project.jsp" %>


<div class="container">
<form action="Home1">
		
	<label>Name</label>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name="name"></br>
	<label>Salary</label>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name="salary"></br>
	<label>Dept</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name="dept"></br>
	<input type="submit" value="add">

</form>
</div>

</body>
</html>