/**
 * MOHD SYAFID ABDULLAH
 * 2021492334 CS240
 * ASSIGNMENT 2 CSC 584
 * Date:10 JAN 2023
 */
package ordersServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
//import java.util.Date;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;


import ordersServlet.*;

/**
 * Servlet implementation class OrdersController
 */
//@WebServlet("/AddOrdersController")
public class AddOrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrdersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Orders newOrder = new Orders();
		ArrayList<Orders> newArray = new ArrayList<Orders>(); 
		SimpleDateFormat f;
		Date date1,date2;
		
		int tailor_id = 0; //no tailor define yet
		int orders_status = 0; // new orders
		int id1 = Integer.parseInt(request.getParameter("id1"));
		int material = Integer.parseInt(request.getParameter("material"));
		int fashion = Integer.parseInt(request.getParameter("fashion"));
		int colour = Integer.parseInt(request.getParameter("colour"));
		//Date daCol = Date.valueOf(request.getParameter("dateCollect"));//working
		
		
		java.sql.Date ddate = new java.sql.Date (Calendar.getInstance ().getTime ().getTime ());//new java.sql.Date(date1.getTime());
		String time = "00:00:00";
		
		
		//float amount = Float.parseFloat(request.getParameter("amount"));
		float sleeve = Float.parseFloat(request.getParameter("sleeve"));
		float shoulder = Float.parseFloat(request.getParameter("shoulder"));
		float chest = Float.parseFloat(request.getParameter("chest"));
		float topLength = Float.parseFloat(request.getParameter("toplength"));
		float waist = Float.parseFloat(request.getParameter("waist"));
		float hip = Float.parseFloat(request.getParameter("hip"));
		float bottomLength = Float.parseFloat(request.getParameter("bottomlength"));
		
		newOrder.setCustomerId(id1);
		newOrder.setDateCreated(ddate);
		//newOrder.setDateCollect(daCol);
		//newOrder.setAmount(amount);
		newOrder.setSleeve(sleeve);
		newOrder.setShoulder(shoulder);
		newOrder.setChest(chest);
		newOrder.setTopLength(topLength);
		newOrder.setWaist(waist);
		newOrder.setHip(hip);
		newOrder.setBottomLength(bottomLength);
		newOrder.setDesign_id(fashion);	
		newOrder.setMaterial_id(material);
		newOrder.setColour_id(colour);
		newOrder.setTailor_id(tailor_id);
		newOrder.setOrders_status(orders_status);//orders_status
		
		newArray.add(newOrder);
		
		ordersDao order = new ordersDao();
		
		String message = order.insertNewOrder(newArray);
		if(message == "success") {
			String alert = "success";
			response.setContentType("text/html");
			request.setAttribute("message",alert);
			HttpSession session = request.getSession();
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/customer/listCustomer.jsp"); //request.getContextPath()+
			dis.forward( request, response);
			
		}
		else {
			String alert = "update_error";
			response.setContentType("text/html");
			request.setAttribute("message",alert);
			HttpSession session = request.getSession();
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/customer/listCustomer.jsp"); //request.getContextPath()+
			dis.forward( request, response);
			
	} 
		
		
		
		
		
		
		
	}

}
