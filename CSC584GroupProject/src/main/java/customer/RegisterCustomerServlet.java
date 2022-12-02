package customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import appointment.DaoAppointment;
import car.DaoCar;

/**
 * Servlet implementation class CustomerServlet
 */
//@WebServlet("/CustomerServlet")
public class RegisterCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Customer cust = new Customer();
		ArrayList<Customer> newcustomer = new ArrayList<Customer>();
				
		cust.setCusName(request.getParameter("custName"));
		cust.setCusMyKad(request.getParameter("custMyKad"));
		cust.setCusPhoneNo(request.getParameter("custPhoneNo"));
		cust.setCusEmail(request.getParameter("custEmail"));
		cust.setCusCarType(Integer.parseInt(request.getParameter("car")));
		cust.setCusCarNo(request.getParameter("custCarPlate"));
		cust.setCusCurrMileage(Integer.parseInt(request.getParameter("custCarMileage")));
		cust.setCusPasswd(request.getParameter("custPasswd"));
		newcustomer.add(cust);
		
		
		try {
			DaoCust DBIns = new DaoCust();
			String message = DBIns.CreateCustomer(newcustomer);
			if(message=="success") {
				String alert = "alert-success";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/index.jsp");
				 dis.forward(request, response);
				// next try
//				response.setContentType("text/html");
//				PrintWriter pw=response.getWriter();
//				pw.println("<script type=\"text/javascript\">");
//				pw.println("alert('Customer Data Addedd Successfully');");
//				pw.println("</script>");
//				RequestDispatcher dis=getServletContext().getRequestDispatcher("/index.jsp");
//				 dis.forward(request, response);
			}
			else
			{
				String alert = "alert-danger";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/index.jsp");
				 dis.forward(request, response);
				// next try
//				response.setContentType("text/html");
//				PrintWriter pw=response.getWriter();
//				pw.println("<script type=\"text/javascript\">");
//				pw.println("alert('Insert Data Error. Please try again.');");
//				pw.println("</script>");
//				RequestDispatcher dis=getServletContext().getRequestDispatcher("/index.jsp");
//				 dis.forward(request, response);
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
