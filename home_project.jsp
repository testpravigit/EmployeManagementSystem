<%@page import="dao.DaoemployeImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List" %>
    <%@page import="dto.Employe" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="home_projectcss.css">
</head>
<body>
<%@ include file="index_project.jsp" %>
<div class="table">
<h3>Employe List</h3>
<table>
<tr>
<th>Name&nbsp;&nbsp;&nbsp;&nbsp;</th>
<th>Salary&nbsp;&nbsp;&nbsp;&nbsp;</th>
<th>Department&nbsp;&nbsp;&nbsp;&nbsp;</th>
<th>Action</th>
</tr>
<%
DaoemployeImpl de=new DaoemployeImpl();
   List<Employe> l=de.getEmploye();
   for(Employe e:l)
   {%>
   
   <tr>
<th><%= e.getName()%></th>
<th><%= e.getSalary()%></th>
<th><%= e.getDept()%></th>
<th><a class="edit" href="editEmploye_project.jsp?id=<%=e.getId() %>" >Edit</a>&nbsp;&nbsp;&nbsp;<a class="delete" href="Delete1?id=<%=e.getId() %>" >Delete</a></th>
</tr>
   
   
	   
   <%	   
   }
   %>




</table>
</div>


</body>
</html>