<!-- 
		From this page you can Add the teams
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Team</title>
</head>
<body>
<%
if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	else
	{%>
		<form method="post" action="UpdateFinal.team">
		Team Name:<input type="text" name="team_name" value="<%=request.getAttribute("teamname") %>" ><br><br>
		Captain: <input type="text" name="captain" value="<%=request.getAttribute("captain")%>"><br><br>
		Team Members(Seperated by Comma ","):<input type="text" name="members" value="<%=request.getAttribute("players")%>"><br><br>
		<input type="submit" name="submit" value="Update Team!"><br><br>
		</form>
	 <% } 
	 %>

</body>
</html>