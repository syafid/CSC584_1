package fashionServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ordersServlet.Orders;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import fashionServlet.*;

/**
 * Servlet implementation class UpdateDesignController
 */
public class UpdateDesignController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDesignController() {
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
		
		int fashID = Integer.parseInt(request.getParameter("fashionID"));
		String fash_desc = request.getParameter("fashionDesc");
		float fashionPrice = Float.parseFloat(request.getParameter("fashionPrice"));
		
		fashion fash = new fashion();
		ArrayList<fashion> fashion = new ArrayList<fashion>();
		fashionDao fashDao = new fashionDao();
		
		fash.setFashion_id(fashID);
		fash.setFashion_desc(fash_desc);
		fash.setPrice(fashionPrice);
		
		fashion.add(fash);
		try {
			String status = fashDao.updateFashion(fashion);
			if(status=="success") {
				HttpSession session = request.getSession();
				String alert = "update_success";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/fashion/listFashion.jsp");// request.getContextPath()+
				dis.forward( request, response);
				
			}
			else {
				HttpSession session = request.getSession();
				String alert = "update_error";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				//HttpSession session = request.getSession();
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/fashion/listFashion.jsp"); //request.getContextPath()+
				dis.forward( request, response);
				
		} 
			
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	
	
}


