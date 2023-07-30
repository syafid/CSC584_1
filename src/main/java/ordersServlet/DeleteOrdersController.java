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
import java.sql.SQLException;

import ordersServlet.*;
import customerServlet.*;

/**
 * Servlet implementation class DeleteOrdersController
 */
public class DeleteOrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOrdersController() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		ordersDao delDao = new ordersDao();
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		//System.out.println(request.getRequestURI);
		try {
			String status = delDao.deleteOrder(orderId);
			if(status=="success") {
				HttpSession session = request.getSession();
				String alert = "delete_success";
				//String path =  "http://localhost:8080/MyBaju/order/listOrder.jsp";//request.getRequestURI ()+"/order/listOrder.jsp";
				//System.out.println(path);
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/order/listOrder.jsp");// request.getContextPath()+ "/order/listOrder.jsp"
				dis.forward( request, response);
				
			}
			else {
				HttpSession session = request.getSession();
				String alert = "delete_error";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				//String path =  "http://localhost:8080/MyBaju/order/listOrder.jsp";//request.getRequestURI ()+"/order/listOrder.jsp";
				//System.out.println(path);
				//HttpSession session = request.getSession();
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/order/listOrder.jsp"); //request.getContextPath()+
				dis.forward( request, response);
				
		}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}

}
