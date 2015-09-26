<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Output</title>
</head>
<body>
<% 
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	else
	{ String result=null;
	result=(String)request.getAttribute("output");
	if(result != null)
	{
		out.print(result);
	}

%>
		<a href="uploadResult.jsp">Upload Another Result</a>
		<a href="adminHome.jsp">Return to Admin Home</a>
		<form action="logout.do" method="post">
			<input type="submit" value="Logout"/> 
		</form>
	 <%} 
	 %>
	 <br>

</body>
</html>