<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Team</title>
</head>
<body>
<%
if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	else
	{%>
		<a href="add_team.jsp">Add Team</a>
		<br>
		<br>
		<a href="update_team.jsp">Update Team</a>
		<br>
		<br>
		<a href="delete_team.jsp">Delete Team</a>
		<form method="post" action="logout.do">
		<input type="submit" name="logout" value="Logout">
		</form>
	 <% } 
	 %>

</body>
</html>