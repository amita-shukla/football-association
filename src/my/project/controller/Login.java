package my.project.controller;


import my.project.model.Verify;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
   		String username= request.getParameter("username");
   		String password = request.getParameter("pass");
   		
   		boolean value= Verify.verifyUser(username, password);
   		if(value==true)
   		{
   			
   			session.setAttribute("username",username );
   			response.sendRedirect("adminHome.jsp");
   			/*
   			RequestDispatcher rd  = request.getRequestDispatcher("adminHome.jsp");
			rd.forward(request, response);
			*/
   			/*
   			ResultSet rs = Dao.displayDetails(username);
   			try {
				while(rs.next())
				{
					
					String name= rs.getString(1);
					String codename =rs.getString(2);
					String designation=rs.getString(3);
					String dob=rs.getString(4);
					
					request.setAttribute("name", name);
					request.setAttribute("codename", codename);
					request.setAttribute("designation", designation);
					request.setAttribute("dob", dob);
					
					RequestDispatcher rd  = request.getRequestDispatcher("profile.jsp");
					rd.forward(request, response);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   			*/
   		}
   		else
   		{
   			request.setAttribute("output", "Your login failed!! Try Again");
   			//response.sendRedirect("index.jsp");
   			RequestDispatcher rd  = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
   			
   		}
   		
   		
	

	}

}
