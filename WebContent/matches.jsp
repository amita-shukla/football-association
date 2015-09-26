<!-- shows the match fixture and gives the option to add matches, set result, reschedule them. 

-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Set Matches</title>
</head>
<body>
<%
if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	else
	{%>
		<a href="modify_fixture.jsp">Modify Fixture</a>
	 <% } 
	 %>


<!-- <a href="reschedule_matches.jsp">Reschedule Matches</a>  -->
</body>
</html>