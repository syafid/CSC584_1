/**
 * MOHD SYAFID ABDULLAH
 * 2021492334 CS240
 * ASSIGNMENT 2 CSC 584
 * Date:10 JAN 2023
 */
package customerServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import customerServlet.*;

/**
 * Servlet implementation class CustomerController
 */
//@WebServlet("/CustomerController")
public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Customer cust = new Customer();
		ArrayList<Customer> newcust = new ArrayList<Customer>();
		customerDao cdao = new customerDao();
		
		String cusName = request.getParameter("name");
		String cusPhone = request.getParameter("phoneNo");
		String cusAddress = request.getParameter("address");
		
		cust.setName(cusName);
		cust.setPhoneNumber(cusPhone);
		cust.setAddress(cusAddress);
		
		newcust.add(cust); 
		
		String status = cdao.insertNewCust(newcust);
		
		if(status=="success") {
			String alert = "success_add";
			response.setContentType("text/html");
			request.setAttribute("message",alert);
			HttpSession session = request.getSession();
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/customer/listCustomer.jsp");
			dis.forward( request, response);
			
		}
		else {
			String alert = "error_add";
			response.setContentType("text/html");
			request.setAttribute("message",alert);
			HttpSession session = request.getSession();
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/customer/listCustomer.jsp");
			dis.forward( request, response);
			
		}
		
	}

}
