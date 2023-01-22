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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.setContentType("text/html");
//		if(request.getParameter("email") == null) {
//			RequestDispatcher dis=getServletContext().getRequestDispatcher("/user/dashboardCustomer.jsp");
//			 dis.forward(request, response);
//		} else 
//		{
		RequestDispatcher dis=getServletContext().getRequestDispatcher("/user/loginCustomer.jsp");
		 dis.forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//response.setContentType("text/html");
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
		
		//if password verified forward userName, userRoles to user session
		if(status) {
			//request.setAttribute("email",emailC);
			//HttpSession session = request.getSession();
            //session.setAttribute("email", emailC);
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
				
//		cust.setCusName(request.getParameter("custName"));
//		cust.setCusMyKad(request.getParameter("custMyKad"));
//		cust.setCusPhoneNo(request.getParameter("custPhoneNo"));
//		cust.setCusEmail(request.getParameter("custEmail"));
//		cust.setCusCarType(Integer.parseInt(request.getParameter("car")));
//		cust.setCusCarNo(request.getParameter("custCarPlate"));
//		cust.setCusCurrMileage(Integer.parseInt(request.getParameter("custCarMileage")));
//		cust.setCusPasswd(request.getParameter("custPasswd"));
//		newcustomer.add(cust);
		
		
//		try {
//			DaoCust DBIns = new DaoCust();
//			String message = DBIns.CreateCustomer(newcustomer);
//			if(message=="success") {
//				String alert = "alert-success";
//				response.setContentType("text/html");
//				request.setAttribute("message",alert);
//				RequestDispatcher dis=getServletContext().getRequestDispatcher("/index.jsp");
//				 dis.forward(request, response);
				// next try
//				response.setContentType("text/html");
//				PrintWriter pw=response.getWriter();
//				pw.println("<script type=\"text/javascript\">");
//				pw.println("alert('Customer Data Addedd Successfully');");
//				pw.println("</script>");
//				RequestDispatcher dis=getServletContext().getRequestDispatcher("/index.jsp");
//				 dis.forward(request, response);
//			}
//			else
//			{
//				String alert = "alert-danger";
//				response.setContentType("text/html");
//				request.setAttribute("message",alert);
//				RequestDispatcher dis=getServletContext().getRequestDispatcher("/index.jsp");
//				 dis.forward(request, response);
//				// next try
////				response.setContentType("text/html");
////				PrintWriter pw=response.getWriter();
////				pw.println("<script type=\"text/javascript\">");
////				pw.println("alert('Insert Data Error. Please try again.');");
////				pw.println("</script>");
////				RequestDispatcher dis=getServletContext().getRequestDispatcher("/index.jsp");
////				 dis.forward(request, response);
//			}
			
//		}
//		catch(Exception e) {
//			 //e.printStackTrace();
//			String alert1 = "alert-danger" + e;
//			response.setContentType("text/html");
//			request.setAttribute("message_error",alert1);
//			RequestDispatcher dis=getServletContext().getRequestDispatcher("/index.jsp");
//			 dis.forward(request, response);
//		}
	}
	
	protected void doCustomerLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		response.setContentType("text/html");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("car", new DaoCar().getResultSet());
		RequestDispatcher dis=getServletContext().getRequestDispatcher("/registration/NewCustomer.jsp");
		 dis.forward(request, response);

}

}
