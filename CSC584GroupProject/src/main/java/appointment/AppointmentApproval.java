package appointment;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import car.DaoCar;

/**
 * Servlet implementation class AppointmentApproval
 */
public class AppointmentApproval extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String paramName;
	private String paramValue;
	public String message;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentApproval() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String AppID = request.getParameter("AppID");
		String AssignTo = request.getParameter("AssignTo");//technician
		String statusButton = request.getParameter("status");
		String email = "2021492334@student.uitm.edu.my";//request.getParameter("email");
		System.out.println(AppID);
		System.out.println(AssignTo);
		System.out.println(statusButton);
		
		//update appointment table with new technician ID and status
		DaoAppointment updateApp = new DaoAppointment();
		ArrayList<Appointment> applist = new ArrayList<Appointment>();
		Appointment appt = new Appointment();
		
		appt.setAppID(Integer.parseInt(AppID));
		appt.setEmpID(Integer.parseInt(AssignTo));
		
		if(statusButton.contentEquals("1"))
		{
			appt.setAppStatus("Approve");
		}
		
		else {
			appt.setAppStatus("Reject");
		}
		applist.add(appt);
		
		try {
			message = updateApp.UpdAppoint(applist);
			if(message == "success") {  //String message
				session.setAttribute("message", message);
				session.setAttribute("email",email);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/user/dashboard.jsp");
				 dis.forward(request, response);
			}else if(message == "error") { //reject appointment
				session.setAttribute("message", message);
				session.setAttribute("email",email);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/user/dashboard.jsp");
				 dis.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
