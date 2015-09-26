<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Iterator" %>
<%@page import="my.project.bean.Matches" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<style>
#mylinkcolor
{
	color:red;
}
</style>
</head>
<body>
<div>Teams:<br>
<ul>
<%
		
		ArrayList<String> team = (ArrayList<String>)request.getAttribute("team");
					
		for(int i=0;i<team.size();i++)
		{
			String teamName=team.get(i);
%>
	<li>	<%	out.println(teamName);%> </li>
<%
		}
	
%>
</ul>
</div>

<div >
<form method= "post" action="teamDetails.do">
<p>Find More about: <input type="text" name="teamName" value="Enter team name">
<input type="submit" value="GO!">
</p>
</form>
</div>

<div>
Upcoming Matches:
<table>
	<tr>
	<th>First Team</th><th>Second Team </th><th>Date Of Match</th>
	</tr>
<% 
		ArrayList<Matches> match = (ArrayList<Matches>)request.getAttribute("match");
		for(int i=0;i<match.size();i++)
		{
			Matches m=match.get(i);
			String teamA=m.getTeamA();
			String teamB=m.getTeamB();
			String date=m.getDate();
%>
<tr>
<td>		<%	out.println(teamA);  %> </td>
<td>		<% 	out.println(teamB); %></td>
<td>		<%	out.println(date); %> </td>
</tr>		

<%
		}
%>
</table>	
</div>

<div>

<a href="login.jsp">Login!!</a>
</div>

</body>
</html>