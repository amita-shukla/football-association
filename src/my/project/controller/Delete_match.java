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
 * Servlet implementation class Delete_match
 */
@WebServlet("/delete.match")
public class Delete_match extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String teamA,teamB,date; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_match() {
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
		teamA=request.getParameter("teamA");
		teamB=request.getParameter("teamB");
		date=request.getParameter("date");
		
		if(teamA.isEmpty()||teamB.isEmpty()||date.isEmpty())
		{
			String result = "Enter the Field";
			request.setAttribute("del_res", result);
			RequestDispatcher rd = request.getRequestDispatcher("Del_match.jsp");
			rd.forward(request, response);
		}
		else
		{		
		RequestDispatcher rd;
		MatchBean m =new MatchBean(teamA, teamB, date, null);
			Dao_matches dao = new Dao_matches(m);
			String result = dao.delMatch();
			if(result.equals("Data Not Found"))
			{
				request.setAttribute("del_res", result);
				rd = request.getRequestDispatcher("Del_match.jsp");
				rd.forward(request, response);
			}
			else{
			
			request.setAttribute("del_res", result);
			rd = request.getRequestDispatcher("Del_result.jsp");
			rd.forward(request, response);
			}
		}
		
		}
	

}
