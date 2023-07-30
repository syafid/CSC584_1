package colourServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import fashionServlet.fashion;
import fashionServlet.fashionDao;

/**
 * Servlet implementation class AddColourController
 */
public class AddColourController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddColourController() {
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
		colour newColour = new colour();
		ArrayList<colour> newArray = new ArrayList<colour>(); 
		
		String colName = request.getParameter("colName");
		String colDesc = request.getParameter("colDesc");
		
		newColour.setColour_name(colName);
		newColour.setColour_desc(colDesc);
		newArray.add(newColour);
		
		colourDao calDao = new colourDao();
		String message = calDao.insertNewColour(newArray);
		
		if(message == "success") {
			String alert = "success";
			response.setContentType("text/html");
			request.setAttribute("message",alert);
			HttpSession session = request.getSession();
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/colour/listColour.jsp"); //request.getContextPath()+
			dis.forward( request, response);
			
		}
		else {
			String alert = "update_error";
			response.setContentType("text/html");
			request.setAttribute("message",alert);
			HttpSession session = request.getSession();
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/colour/listColour.jsp"); //request.getContextPath()+
			dis.forward( request, response);
			
	}
  }

}
