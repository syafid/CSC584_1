package fashionServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import materialServlet.MaterialDao;
import materialServlet.material;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class AddFashionController
 */
public class AddFashionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFashionController() {
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
		fashion newFashion = new fashion();
		ArrayList<fashion> newArray = new ArrayList<fashion>(); 
		
		String fashName = request.getParameter("fashName");
		String fashDesc = request.getParameter("fashDesc");
		float fashPrice = Float.parseFloat(request.getParameter("fashPrice"));
		
		
		newFashion.setFashion_name(fashName);
		newFashion.setFashion_desc(fashDesc);
		newFashion.setPrice(fashPrice);
		newArray.add(newFashion);
		
		fashionDao fashDao = new fashionDao();
		String message = fashDao.insertNewFashion(newArray);
		if(message == "success") {
			String alert = "success";
			response.setContentType("text/html");
			request.setAttribute("message",alert);
			HttpSession session = request.getSession();
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/fashion/listFashion.jsp"); //request.getContextPath()+
			dis.forward( request, response);
			
		}
		else {
			String alert = "update_error";
			response.setContentType("text/html");
			request.setAttribute("message",alert);
			HttpSession session = request.getSession();
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/fashion/listFashion.jsp"); //request.getContextPath()+
			dis.forward( request, response);
			
	}
	}

}
