<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Match</title>
</head>
<body>
<% String result=null;
	result=(String)request.getAttribute("result");
	if(result != null)
	{
		out.print(result);
	}

%>
<% 
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	else
	{%>
		<form method="Post" action="add.match">
		Team A:		<input type="text" name="Team_A"><br><br>
		Team B:		<input type="text" name="Team_B"><br><br>
		Date of Match:<input type="text" name="Date">
		(yyyy-mm-dd)<br><br>
		<input type="submit" name="submit" value="Add this Match">
</form>
	 <%} 
	 %>

<br>

</body>
</html>