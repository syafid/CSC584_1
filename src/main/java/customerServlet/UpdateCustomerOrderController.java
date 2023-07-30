package customerServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ordersServlet.Orders;
import ordersServlet.ordersDao;
import paymentServlet.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class UpdateCustomerOrderController
 */
public class UpdateCustomerOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
    	
    	String action = request.getParameter("action");

    	if ("save".equals(action)) {
    	    // Invoke FirstServlet's job here.
    		Orders updCoOrder = new Orders();
    		ArrayList<Orders> ArrOrd = new ArrayList<Orders>();
    		ordersDao Oda = new ordersDao();
    		//paymentDao
    		
    		int orderID = Integer.parseInt(request.getParameter("orderid"));
    		java.sql.Date timeStamp = new Date(System.currentTimeMillis());
    		int orderStatus = Integer.parseInt(request.getParameter("orderSta"));
    		
    		updCoOrder.setOrderId(orderID);
    		updCoOrder.setDateCompleted(timeStamp);
    		updCoOrder.setOrders_status(orderStatus);
    		
    		ArrOrd.add(updCoOrder);
    		
    		try {
    			String status = Oda.updateCustomerOrder(ArrOrd);
    			//String status2 = 
    			if(status=="success") {
    				HttpSession session = request.getSession();
    				String alert = "update_success";
    				response.setContentType("text/html");
    				request.setAttribute("message",alert);
    				RequestDispatcher dis=getServletContext().getRequestDispatcher("/customer/listCustomer.jsp");// request.getContextPath()+
    				dis.forward( request, response);
    				
    			}
    			else {
    				HttpSession session = request.getSession();
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
    		
    	} else if ("pay".equals(action)) {
    	    // Invoke SecondServlet's job here.
    		Orders updCoOrder = new Orders();
    		ArrayList<Orders> ArrOrd = new ArrayList<Orders>();
    		ordersDao Oda = new ordersDao();
    		//paymentDao
    		payment pay = new payment();
    		ArrayList<payment> payList = new ArrayList<payment>();
    		paymentDao payDao = new paymentDao();
    		
    		
    		
    		int orderID = Integer.parseInt(request.getParameter("orderid"));
    		java.sql.Date timeStamp = new Date(System.currentTimeMillis());
    		int customer_id = Integer.parseInt(request.getParameter("customerid"));
    		int payment_status = 1;
    		int verify_by = 0;
    		
    		pay.setOrder_id(orderID);
    		pay.setCustomer_id(customer_id);
    		pay.setPayment_date(timeStamp);
    		pay.setPayment_status(payment_status);
    		pay.setVerify_by(verify_by);
    		
    		payList.add(pay);
    		
//    		updCoOrder.setOrderId(orderID);
//    		updCoOrder.setDateCompleted(timeStamp);
//    		updCoOrder.s
//    		
//    		ArrOrd.add(updCoOrder);
    		
    		String status = payDao.insertNewPayment(payList);
			
			//String status2 = 
			if(status=="success") {
				HttpSession session = request.getSession();
				String alert = "update_success";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/customer/listCustomer.jsp");// request.getContextPath()+
				dis.forward( request, response);
				
			}
			else {
				HttpSession session = request.getSession();
				String alert = "update_error";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				//HttpSession session = request.getSession();
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/customer/listCustomer.jsp"); //request.getContextPath()+
				dis.forward( request, response);
				
 		}
    		
    		
    	}
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
//	}

}
