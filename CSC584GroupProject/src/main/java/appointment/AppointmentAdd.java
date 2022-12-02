package appointment;

import java.io.IOException;
//import java.util.Date;
import java.sql.Date;
//import java.sql.Timestamp;
import java.util.Locale;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.sql.Timestamp;

import customer.DaoCustomerLogin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AppointmentAdd
 */

public class AppointmentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public java.sql.Timestamp dateHour;
	Date sqlDate;
	public String newDate;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentAdd() {
        super();
    }

	/**
	 * @return 
	 * @see Servlet#init(ServletConfig)
	 */
//	@Override

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("service", new DaoAppointment().getResultSet());
		request.setAttribute("customer_detail", new DaoCustomerLogin().getSessionSet(request.getParameter("cusID")));
		RequestDispatcher dis=getServletContext().getRequestDispatcher("/appointment/NewAppointment.jsp");
		 dis.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//retrieve value from NewAppointment.jsp and store in table appointment
		DaoAppointment newdata = new DaoAppointment();
		ArrayList<Appointment> newappoint = new ArrayList<Appointment>();
		Appointment appoint = new Appointment();
		String appStatus = "NEW";
		int empID = 0;
		
//		
//		DateTimeFormatter f = DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm" ) ;
		SimpleDateFormat f;// = new SimpleDateFormat("yyyy-MM-dd");
		 
		
		int cusID = Integer.parseInt(request.getParameter("cusID"));
		String cusEmail = request.getParameter("cusEmail");
		String serviceType = request.getParameter("service");
		String carID = request.getParameter("carID");
		String temp = request.getParameter("date");//temp[0] getParameterValues
		String time = request.getParameter("time");
		System.out.println("Date > " +temp);
		System.out.println("Time > " +time);
		Date date = null;
//		
//		f = new SimpleDateFormat("yyyy-mm-dd hh:mm");
//		formatterTime = new SimpleDateFormat("hh:mm",Locale.ENGLISH);
		
		//newDate = f.format(temp);
//        try {
//			date = (Date) f.parse(newDate);
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
		//String startingDate = new SimpleDateFormat("YYYY-MM-DD").format(temp);
		String newDate = temp+' '+time;
		Timestamp dt = Timestamp.valueOf(newDate);//.of(startingDate, startingTime);
		
        System.out.println("Time > " +newDate);
        System.out.println("DateTime > " +dt);
		
		appoint.setCusID(cusID);
		appoint.setServiceID(Integer.parseInt(serviceType));
		appoint.setCarID(Integer.parseInt(carID));
		appoint.setAppDate(dt);
		appoint.setAppStatus(appStatus);
		appoint.setEmpID(empID);
		
		newappoint.add(appoint);
		
		
		
		try {
			String status = newdata.AddAppoint(newappoint);
			if(status=="success") {
				String alert = "success";
				response.setContentType("text/html");
//				HttpSession session = request.getSession();
//	            session.setAttribute("email", cusEmail);
//				request.setAttribute("message",alert);
				request.getSession().setAttribute("email",cusEmail);
				request.getSession().setAttribute("message",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/user/dashboardCustomer.jsp");
				 dis.forward(request, response);
				 
			}
			else {
				
					String alert = "error";
					response.setContentType("text/html");
//					HttpSession session = request.getSession();
//		            session.setAttribute("email", cusEmail);
//					request.setAttribute("message",alert);
					request.getSession().setAttribute("email",cusEmail);
					request.getSession().setAttribute("message",alert);
					RequestDispatcher dis=getServletContext().getRequestDispatcher("/user/dashboardCustomer.jsp");
					 dis.forward(request, response);
					 
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
		
		
		
		
	}
	
//	private String modifyDateLayout(String inputDate) throws ParseException{
//	    Date date = (Date)new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").parse(inputDate);
//	    return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(date);
//	}

}

