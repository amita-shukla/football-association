<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Result</title>
</head>
<body>

<form method="post" action="uploadResult.do">
<% 
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	else
	{%>
		Team A:<input type="text" name="teamA"/><br>
		Team B:<input type="text" name="teamB"/><br>
		Date of Match:<input type="text" name="date" value="YYYY-MM-DD"/><br>
		Winning team: <input type="text" name="result"><br>
		<input type="submit" value="Upload Result">
	 <%} 
	 %>
	 <br>

</form>
<% String result=null;
	result=(String)request.getAttribute("errorMsg");
	if(result != null)
	{
		out.print(result);
	}

%>

</body>
</html>