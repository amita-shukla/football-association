<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Match</title>
</head>
<body>
<%
if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	else
	{%>
		<form action="delete.match" method="Post">
		Team A:<input type="text" name="teamA"><br><br>
		Team B: <input type="text" name="teamB"><br><br>
		Dates (yyyy-mm-dd):<input type="text" name="date"><br><br>
		<input type="submit" name="submit" value="Delete Team!"><br><br>
</form>

<% String result=null;
	result=(String)request.getAttribute("del_res");
	if(result != null)
	{
		out.print(result);
	}

%>
	 <% } 
	 %>

</body>
</html>