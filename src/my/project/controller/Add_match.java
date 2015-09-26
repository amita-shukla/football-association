package my.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.project.bean.MatchBean;
import my.project.dao.Dao_matches;

/**
 * Servlet implementation class Add_match
 */
@WebServlet("/add.match")
public class Add_match extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String teamA,teamB, date,result;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_match() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			teamA=request.getParameter("Team_A");
			teamB=request.getParameter("Team_B");
			date=request.getParameter("Date");
			
			if(teamA.equalsIgnoreCase(teamB)|| (teamA.isEmpty()) ||(date.isEmpty()) ||(teamB.isEmpty()))
					{
					result ="Both Team-Names are Same or Some fields missing.";
					request.setAttribute("result", result);
					RequestDispatcher rd = request.getRequestDispatcher("Add_match.jsp");
					rd.forward(request, response);
					}
			else
			{	MatchBean mb = new MatchBean(teamA, teamB, date, null);
					Dao_matches dao = new Dao_matches(mb);
					result=dao.addMatch();
					if(result.equals("Error while fixing the match."))
					{
						request.setAttribute("result", result);
						RequestDispatcher rd = request.getRequestDispatcher("Add_match.jsp");
						rd.forward(request, response);
					}
					else
					{
						
					request.setAttribute("result", result);
					RequestDispatcher rd = request.getRequestDispatcher("Match_Add_result.jsp");
					rd.forward(request, response);
					
					}
			}
			
		
	}

}
