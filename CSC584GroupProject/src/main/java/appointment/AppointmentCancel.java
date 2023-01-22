package appointment;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Servlet implementation class AppointmentCancel
 */
public class AppointmentCancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentCancel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		
//		
//	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		ArrayList<Appointment> newappoint = new ArrayList<Appointment>();
		Appointment appoint = new Appointment();
		DaoAppointment updApptStat = new DaoAppointment();
		int empID = 0;
		String value1 = "";String alert="";
		int appid = Integer.parseInt(request.getParameter("AppID"));
		String cusEmail = request.getParameter("email");
		
		appoint.setAppID(appid);
		newappoint.add(appoint);
		
		try {
			alert = updApptStat.DelAppoint(newappoint);
			if(alert == "success") {
			
			session.setAttribute("email",cusEmail);
			session.setAttribute("messageDeleteSuccess",alert);
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/customer/dashboardCustomer.jsp");
			dis.forward( request, response);
			
			}
			else {
				
				
				session.setAttribute("email",cusEmail);
				session.setAttribute("messageDeleteError",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/customer/dashboardCustomer.jsp");
				dis.forward( request, response);
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}
}
