<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="login.do" method="post">
	Username: <input type="text" name="username"><br>
	Password: <input type="password" name="pass"><br>
	<input type="submit" name="loginButton" value="Login!!"/>
</form>
<a href="index1.do">Back to Home Page </a>
<% String result=null;
	result=(String)request.getAttribute("output");
	if(result != null)
	{
		out.print(result);
	}

%>

</body>
</html>