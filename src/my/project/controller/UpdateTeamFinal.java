package my.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.project.bean.TeamBean;
import my.project.dao.Dao;

/**
 * Servlet implementation class UpdateTeamFinal
 */
@WebServlet("/UpdateFinal.team")
public class UpdateTeamFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String name,captain,members;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTeamFinal() {
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
		name=request.getParameter("team_name");
		captain=request.getParameter("captain");
		members=request.getParameter("members");
		
		if(name != null)
		{	TeamBean tb = new TeamBean(name, captain, members);
			Dao dao = new Dao(tb);
			String result = dao.updateTeam();
			request.setAttribute("add_res", result);
			RequestDispatcher rd = request.getRequestDispatcher("Teamupdate_result.jsp");
			rd.forward(request, response);
		}
	}

}
