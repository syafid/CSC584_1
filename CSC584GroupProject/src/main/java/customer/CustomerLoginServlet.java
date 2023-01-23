package customer;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import login.DaoLogin;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import car.DaoCar;
import customer.Customer;
/**
 * Servlet implementation class CustomerLoginServlet
 */
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String emailC;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dis=getServletContext().getRequestDispatcher("/user/loginCustomer.jsp");
		 dis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Customer cust = new Customer();
		ArrayList<Customer> newcustomer = new ArrayList<Customer>();
		emailC = request.getParameter("emailCustomer");
		String passwdC = request.getParameter("passwordCustomer");
		Boolean status = null;
		try {
			status = DaoCustomerLogin.verifyUserPassword(emailC, passwdC);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(status);
		
		
		if(status) {
			
			request.getSession().setAttribute("email",emailC);
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/customer/dashboardCustomer.jsp");
			 dis.forward(request, response);
			
		}
		else //notify an error
		{
			response.setContentType("text/html");
			String alert = "alert-danger";
			request.setAttribute("message",alert);
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/user/loginCustomer.jsp");
			 dis.forward(request, response);
		}
		
		

	}
	
	protected void doCustomerLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		response.setContentType("text/html");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("car", new DaoCar().getResultSet());
		RequestDispatcher dis=getServletContext().getRequestDispatcher("/registration/NewCustomer.jsp");
		 dis.forward(request, response);

}

}
