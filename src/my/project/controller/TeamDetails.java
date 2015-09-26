package my.project.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.project.dao.Dao;

/**
 * Servlet implementation class TeamDetails
 */
@WebServlet("/teamDetails.do")
public class TeamDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teamName=request.getParameter("teamName");
		ResultSet rs=Dao.teamDetails(teamName);
		try {
			while(rs.next())
			{
				String Name= rs.getString(1);
				String captain=rs.getString(2);
				String players=rs.getString(3);
				request.setAttribute("name", Name);
				request.setAttribute("captain", captain);
				request.setAttribute("players", players);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd  = request.getRequestDispatcher("teamDetails.jsp");
		rd.forward(request, response);
	}

}
