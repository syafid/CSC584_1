package customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import car.DaoCar;
import customer.Customer;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
//@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int cusID = Integer.parseInt(request.getParameter("cusID"));
		HttpSession session = request.getSession();
		session.setAttribute("cusID",cusID);
		RequestDispatcher dis=getServletContext().getRequestDispatcher("/registration/UpdateCustomer.jsp");
		 dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		Customer cust = new Customer();
		ArrayList<Customer> newcustomer = new ArrayList<Customer>();
		
		String email = request.getParameter("custEmail");
			
		cust.setCusID(Integer.parseInt(request.getParameter("cusID")));
		cust.setCusName(request.getParameter("custName"));
		cust.setCusAdd(request.getParameter("custAddress"));
		cust.setCusMyKad(request.getParameter("custMyKad"));
		cust.setCusPhoneNo(request.getParameter("custPhoneNo"));
		cust.setCusCarType(Integer.parseInt(request.getParameter("car")));
		cust.setCusCurrMileage(Integer.parseInt(request.getParameter("custCarMileage")));
		cust.setCusCarNo(request.getParameter("custCarPlate"));
		
		
		newcustomer.add(cust);
		
		try {
			DaoCust updateCus = new DaoCust();
			String message = updateCus.UpdateCustomer(newcustomer);
			
			if(message=="success") {
				String alert = "success";
				//response.setContentType("text/html");
				session.setAttribute("message",alert);
				session.setAttribute("email",email);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/customer/dashboardCustomer.jsp");
				 dis.forward(request, response);
				
			}
			else
			{
				String alert = "error";
				//response.setContentType("text/html");
				request.setAttribute("message",alert);
				session.setAttribute("email",email);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/customer/dashboardCustomer.jsp");
				 dis.forward(request, response);
				
			}
			
		}
		catch(Exception e) {
			 e.printStackTrace();
			
		}
	}
}

