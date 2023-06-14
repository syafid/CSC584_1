package tailorServlet;

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
 * Servlet implementation class AddTailorController
 */
public class AddTailorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTailorController() {
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
		String job_typ ="";
		tailor newTailor = new tailor();
		ArrayList<tailor> newArray = new ArrayList<tailor>(); 
		
		String tailName = request.getParameter("tailName");
		String tailPhone = request.getParameter("tailPhone");
		String job_id = request.getParameter("job_id");
		String tailor_spec = request.getParameter("job_spec");
		
		if(job_id.equals("Admin")) {
			tailor_spec = "0";
			//job_typ = "Admin";
		}	
		else if(job_id.equals("Tailor"))
			job_typ = "Tailor";
		
		
		newTailor.setTailor_name(tailName);
		newTailor.setTailor_phone(tailPhone);
		newTailor.setJob_id(job_id);
		newTailor.setJob_spec(tailor_spec);
		
		
		newArray.add(newTailor);
		
		tailorDao tailDao = new tailorDao();
		String message = tailDao.insertNewTailor(newArray);
		if(message == "success") {
			String alert = "success";
			response.setContentType("text/html");
			request.setAttribute("message",alert);
			HttpSession session = request.getSession();
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/tailor/listTailor.jsp"); //request.getContextPath()+
			dis.forward( request, response);
			
		}
		else {
			String alert = "update_error";
			response.setContentType("text/html");
			request.setAttribute("message",alert);
			HttpSession session = request.getSession();
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/tailor/listTailor.jsp"); //request.getContextPath()+
			dis.forward( request, response);
			
	}
	}

}
