<!-- 
		From this page you can Add the teams
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Team</title>
</head>
<body>
<%
if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	else
	{%>
		<form method="post" action="add_team.do">
		Team Name:<input type="text" name="team_name"><br><br>
		Captain: <input type="text" name="captain"><br><br>
		Team Members(Separated by Comma ","):<input type="text" name="members"><br><br>
		<input type="submit" name="submit" value="Add Team!"><br><br>
</form>
	 <% } 
	 %>

</body>
</html>