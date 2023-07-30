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
import java.sql.SQLException;
import java.util.ArrayList;
import customerServlet.*;

/**
 * Servlet implementation class UpdateCustomerController2
 */
//@WebServlet("/UpdateCustomerController2")
public class UpdateCustomerController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		doGet(request, response);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Customer cust = new Customer();
		ArrayList<Customer> newcust = new ArrayList<Customer>();
		customerDao cdao = new customerDao();
		String url2 = request.getContextPath();
		int cusId = Integer.parseInt(request.getParameter("id1"));
		String cusName = request.getParameter("name1");
		String cusPhone = request.getParameter("phoneNo1");
		String cusAddress = request.getParameter("address1");
		
		
		cust.setName(cusName);
		cust.setPhoneNumber(cusPhone);
		cust.setAddress(cusAddress);
		cust.setCustomerId(cusId);
		
		newcust.add(cust); 
		
		try {
			String status = cdao.updateCustomer(newcust);
			if(status=="success") {
				String alert = "update_success";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/customer/listCustomer.jsp");// request.getContextPath()+
				dis.forward( request, response);
				
			}
			else {
				String alert = "update_error";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				//HttpSession session = request.getSession();
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/customer/listCustomer.jsp"); //request.getContextPath()+
				dis.forward( request, response);
				
		} 
			
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	
}
