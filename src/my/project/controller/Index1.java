package my.project.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.project.bean.Matches;
import my.project.dao.Dao;

/**
 * Servlet implementation class Index1
 */
@WebServlet("/index1.do")
public class Index1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResultSet rs = Dao.teamNames();
		
		ArrayList<String> team = new ArrayList<String>();
		try {
			while(rs.next())
			{
				
				//Iterator itr = team.iterator();
				String teamName= rs.getString(1);
				team.add(teamName);
				request.setAttribute("team", team);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ResultSet rs2= Dao.upcomingMatches();
	
		try {
			ArrayList<Matches> match = new ArrayList<Matches>();
			
			while(rs2.next())
			{
				Matches m1= new Matches(rs2.getString(1),rs2.getString(2),rs2.getString(3));
				match.add(m1);
				request.setAttribute("match", match);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd  = request.getRequestDispatcher("index1.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
