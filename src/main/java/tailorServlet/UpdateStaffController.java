package tailorServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.util.ArrayList;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import tailorServlet.*;


/**
 * Servlet implementation class UpdateStaffController
 */
public class UpdateStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStaffController() {
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
		
		tailor NewStaff = new tailor();
		ArrayList<tailor> tailorList = new ArrayList<tailor>();
		tailorDao tailD = new tailorDao();
		
		int tailor_ID = Integer.parseInt(request.getParameter("tailorID"));
		String staff_name = request.getParameter("staff_name");
		String staff_phone = request.getParameter("staff_phone");
		
		NewStaff.setTailor_id(tailor_ID);
		NewStaff.setTailor_name(staff_name);
		NewStaff.setTailor_phone(staff_phone);
		
		
		tailorList.add(NewStaff);
		
		try {
			String status = tailD.updateStaff(tailorList);
			if(status=="success") {
				HttpSession session = request.getSession();
				String alert = "update_success";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/tailor/listTailor.jsp");// request.getContextPath()+
				dis.forward( request, response);
				
			}
			else {
				HttpSession session = request.getSession();
				String alert = "update_error";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				//HttpSession session = request.getSession();
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/tailor/listTailor.jsp"); //request.getContextPath()+
				dis.forward( request, response);
				
		} 
			
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}

}
