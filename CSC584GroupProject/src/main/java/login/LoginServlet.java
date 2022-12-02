package login;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
//		request.setAttribute("message",alert);
		RequestDispatcher dis=getServletContext().getRequestDispatcher("/login/login.jsp");
		 dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
		String passwd = request.getParameter("password");
		String choice = request.getParameter("radio");
		Boolean status = null;
		try {
			status = DaoLogin.verifyUserPassword(email, passwd);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(status);
		
		//if password verified forward userName, userRoles to user session
		if(status) {
			request.setAttribute("email",email);
			HttpSession session = request.getSession();
            session.setAttribute("email", email);
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/user/dashboard.jsp");
			 dis.forward(request, response);
			
		}
		else //notify an error
		{
			response.setContentType("text/html");
			String alert = "alert-danger";
			request.setAttribute("message",alert);
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/login/login.jsp");
			 dis.forward(request, response);
		}
		//if password wrong/user not available
	}

}
