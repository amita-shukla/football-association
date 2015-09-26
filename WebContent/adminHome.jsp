<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
<% 
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	else
	{%><br><br>
		<a href="modify_team.jsp">Modify Team</a><br><br>
		<a href="matches.jsp">Set Matches</a><br><br>
		<!-- <a href="match_result.jsp">Upload Match Result</a><br><br> -->
		<a href="uploadResult.jsp"> Upload Match Result </a> <br><br>
		<form action="logout.do" method="post">
		<input type="submit" value="Logout"/> 
		</form>
	 <%} 
	 %>
	
</body>
</html>