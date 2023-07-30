package tailorServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ordersServlet.ordersDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class DeleteTailorController
 */
public class DeleteTailorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTailorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		tailorDao delDao = new tailorDao();
		int tailorId = Integer.parseInt(request.getParameter("tailorId"));
		//System.out.println(request.getRequestURI);
		try {
			String status = delDao.deleteTailor(tailorId);
			if(status=="delete_success") {
				HttpSession session = request.getSession();
				String alert = "delete_success";
				//String path =  "http://localhost:8080/MyBaju/order/listOrder.jsp";//request.getRequestURI ()+"/order/listOrder.jsp";
				//System.out.println(path);
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/tailor/listTailor.jsp");// request.getContextPath()+ "/order/listOrder.jsp"
				dis.forward( request, response);
				
			}
			else {
				HttpSession session = request.getSession();
				String alert = "delete_error";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/tailor/listTailor.jsp"); //request.getContextPath()+
				dis.forward( request, response);
				
		}
			
		} catch (SQLException e) {
			
			//e.printStackTrace();
			final StringWriter sw = new StringWriter();
		    final PrintWriter pw = new PrintWriter(sw);
		    e.printStackTrace(pw);
			
			
		}
	}

}
