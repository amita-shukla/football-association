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
 * Servlet implementation class Add_team
 */
@WebServlet("/add_team.do")
public class Add_team extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String name,captain,members;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_team() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
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
			String result = dao.addTeam();
			request.setAttribute("add_res", result);
			RequestDispatcher rd = request.getRequestDispatcher("Add_result.jsp");
			rd.forward(request, response);
		}
	}

}
