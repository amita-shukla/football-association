package my.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.project.dao.Dao;
import my.project.model.Verify;

/**
 * Servlet implementation class UploadResult
 */
@WebServlet("/uploadResult.do")
public class UploadResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teamA = request.getParameter("teamA");
		String teamB = request.getParameter("teamB");
		String date=request.getParameter("date");
		String winningTeam=  request.getParameter("result");
		if(teamA.equals(teamB))
		{
			request.setAttribute("errorMsg", "Please enter different teams ");
			RequestDispatcher rd  = request.getRequestDispatcher("uploadResult.jsp");
			rd.forward(request, response);
		}
		
		if(Verify.verifyMatch(teamA, teamB, date)==false)
		{
			request.setAttribute("errorMsg", "No match between the given teams on the given date. Enter team names correctly");
			RequestDispatcher rd  = request.getRequestDispatcher("uploadResult.jsp");
			rd.forward(request, response);
		}
		else
		{
			if(Dao.uploadResult(teamA, teamB, winningTeam)==false)
			{
				request.setAttribute("errorMsg", "Error while uploading Result, sorry");
				RequestDispatcher rd  = request.getRequestDispatcher("uploadResult.jsp");
				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("successfulUpload.jsp");
				
			}
		}
		
	}

}
