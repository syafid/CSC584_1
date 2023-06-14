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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
//import java.util.Date;//comment
import java.sql.Date; //working
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import customerServlet.*;
import ordersServlet.*;
import tailorServlet.*;
/**
 * Servlet implementation class UpdateOrderController
 */
public class UpdateOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Date date;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderController() {
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
		
		
		Orders updOrder = new Orders();
		ArrayList<Orders> ArrOrd = new ArrayList<Orders>();
		ordersDao Oda = new ordersDao();
		
		int orda = Integer.parseInt(request.getParameter("orderID"));
		//LocalDate dat = java.time.LocalDate.now();
		
		
			
		
		    
		java.sql.Date tempDate = new Date(System.currentTimeMillis());
		java.sql.Date timeStamp = new Date(System.currentTimeMillis());
		
		//String date1 = request.getParameter("datecollect1");
		//String time1 = "00:00:00.000";
		//String newDate = timeStamp;//+' '+time1;
		//Date daComp = Date.valueOf(timeStamp); //date1
		//Timestamp dt = Timestamp.valueOf(date1);
			
		/*float amount1 = Float.parseFloat(request.getParameter("amount1"));
		float sleeve1 = Float.parseFloat(request.getParameter("sleeve1"));
		float shoulder1 = Float.parseFloat(request.getParameter("shoulder1"));
		float chest1 = Float.parseFloat(request.getParameter("chest1"));
		float topLength1 = Float.parseFloat(request.getParameter("toplength1"));
		float waist1 = Float.parseFloat(request.getParameter("waist1"));
		float hip1 = Float.parseFloat(request.getParameter("hip1"));
		float bottomLength1 = Float.parseFloat(request.getParameter("bottomlength1"));*/
		
		
		int orders_status = Integer.parseInt(request.getParameter("ordersStatus"));
		int matID = Integer.parseInt(request.getParameter("matID"));
		int designID = Integer.parseInt(request.getParameter("designID"));
		int colorID = Integer.parseInt(request.getParameter("coloID"));
		
		if(orders_status ==1)
			//no tailor assign, status = no tailor assigned
			updOrder.setDateCompleted(tempDate);
		else
			updOrder.setDateCompleted(timeStamp);
			
		
		
		//tailor_id is from staff specialization by fashion_id
		tailorDao getTailor = new tailorDao();
		ArrayList<tailor> tailorList;
		try {
			tailorList = getTailor.getTailorByDesign(designID);
			
			for(int a=0;a<tailorList.size();a++) {
				updOrder.setTailor_id(tailorList.get(a).getTailor_id());
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//System.out.println(tailor_id);
		//System.out.println(orders_status);
		
		/*updOrder.setSleeve(sleeve1);
		updOrder.setShoulder(shoulder1);
		updOrder.setChest(chest1);
		updOrder.setTopLength(topLength1);
		updOrder.setWaist(waist1);
		updOrder.setHip(hip1);
		updOrder.setBottomLength(bottomLength1);*/
		updOrder.setOrderId(orda);
		
		updOrder.setOrders_status(orders_status);
		updOrder.setMaterial_id(matID);
		updOrder.setDesign_id(designID);
		updOrder.setColour_id(colorID);
		
		
				
		ArrOrd.add(updOrder);
		
		try {
			String status = Oda.updateOrder(ArrOrd);
			if(status=="success") {
				HttpSession session = request.getSession();
				String alert = "update_success";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/order/listOrder.jsp");// request.getContextPath()+
				dis.forward( request, response);
				
			}
			else {
				HttpSession session = request.getSession();
				String alert = "update_error";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				//HttpSession session = request.getSession();
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/order/listOrder.jsp"); //request.getContextPath()+
				dis.forward( request, response);
				
		} 
			
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


		

		
}
	
}


