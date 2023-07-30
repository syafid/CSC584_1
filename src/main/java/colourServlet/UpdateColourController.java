package colourServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import customerServlet.*;

/**
 * Servlet implementation class UpdateColourController
 */
public class UpdateColourController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateColourController() {
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
		
		int colour_id = Integer.parseInt(request.getParameter("colourID"));
		String colour_name = request.getParameter("colour_name");
		String colour_desc = request.getParameter("colour_desc");
		
		colourDao colorArray = new colourDao();
		colour color = new colour();
		ArrayList<colour> colourArr = new ArrayList<colour>();
		color.setColour_id(colour_id);
		color.setColour_name(colour_name);
		color.setColour_desc(colour_desc);
		colourArr.add(color);
		
		try {
			String status = colorArray.updateColour(colourArr);
			if(status=="success") {
				String alert = "update_success";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/colour/listColour.jsp");// request.getContextPath()+
				dis.forward( request, response);
				
			}
			else {
				String alert = "update_error";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				//HttpSession session = request.getSession();
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/colour/listColour.jsp"); //request.getContextPath()+
				dis.forward( request, response);
				
		} 
			
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
	}

}
