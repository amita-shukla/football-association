<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Team Details</title>
</head>
<body>

		<p>Team Name: <% out.print(request.getAttribute("name")); %></p>
		<p>Team Captain: <%out.print(request.getAttribute("captain")); %></p>
		<p>Team Players:<br>  <%out.print(request.getAttribute("players")); %></p>
			
</body>
</html>