<!-- 
		This pasge will add/modify the match schedule 
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Fixture</title>
</head>
<body>
<%
if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	else
	{%>
		<a href="Add_match.jsp">Add Match</a>
		<a href="Del_match.jsp">Delete Match</a>
	 <% } 
	 %>

</body>
</html>