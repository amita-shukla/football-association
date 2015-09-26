<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Team</title>
</head>
<body>
<%
if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	else
	{%>
		Enter the Team name to be Updated:
		<form action="update.team" method="post">
		<input type="text" name="team">
		<input type="submit" value="Update">
		</form>
	 <% } 
	 %>

</body>
</html>