package user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import customer.Customer;
import customer.DaoCust;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		RequestDispatcher dis=getServletContext().getRequestDispatcher("/user/NewUser.jsp");
		 dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = new User();
		ArrayList<User> newuser = new ArrayList<User>();
				
		user.setUserName(request.getParameter("userName"));
		user.setUserIdentificationNo(request.getParameter("userIDNo"));
		user.setUserContactNo(request.getParameter("userContactNo"));
		user.setUserDateOfBirth(request.getParameter("userDOB"));
		user.setUserEmail(request.getParameter("userEmail"));
		user.setUserPassword(request.getParameter("userPassword"));
		user.setUserRoles(request.getParameter("roles"));
		newuser.add(user);
		
		try {
			DaoUser DBIns = new DaoUser();
			String message = DBIns.CreateUser(newuser);
			if(message=="success") {
				String alert = "alert-success";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/index.jsp");
				 dis.forward(request, response);
			
			}
			else
			{
				String alert = "alert-danger";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/index.jsp");
				 dis.forward(request, response);
				
			}
			
		}
		catch(Exception e) {
			 //e.printStackTrace();
			String alert1 = "alert-danger" + e;
			response.setContentType("text/html");
			request.setAttribute("message_error",alert1);
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/index.jsp");
			 dis.forward(request, response);
		}
		
	}

}
