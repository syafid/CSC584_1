package paymentServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ordersServlet.Orders;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class PaymentController
 */
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		payment pay = new payment();
		ArrayList<payment> payArr = new ArrayList<payment>();
		paymentDao payDao = new paymentDao();
		
		int order_id = Integer.parseInt(request.getParameter("orderID"));
		int customer_id = Integer.parseInt(request.getParameter("customer_id"));
		
		java.sql.Date payDate = new Date(System.currentTimeMillis());
		int verify_by = 0;
		int payment_status = 1;//paid
		
		pay.setOrder_id(order_id);
		pay.setCustomer_id(customer_id);
		pay.setPayment_date(payDate);
		pay.setVerify_by(verify_by);
		pay.setPayment_status(payment_status);
		
		payArr.add(pay);
		
		String status = payDao.insertNewPayment(payArr);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
	//}

}
