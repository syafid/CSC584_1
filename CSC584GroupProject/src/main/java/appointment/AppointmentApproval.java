package appointment;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import login.DaoLogin;
import login.Login;
import service.DaoService;
import service.Service;
import user.DaoUser;
import user.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import car.Car;
import car.DaoCar;
import customer.Customer;
import customer.DaoCust;

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
		//doPost(request, response);
		HttpSession session = request.getSession();
		int statusButton = Integer.parseInt(request.getParameter("status"));
		String email = request.getParameter("email");
		Appointment newAppt = new Appointment();
		DaoAppointment updateAppt = new DaoAppointment();
		ArrayList<Appointment> updList = new ArrayList<Appointment>();
		String status = "null";
		
		if(statusButton == 1) {// if approve need to assign technician
			int AssignTo = Integer.parseInt(request.getParameter("AssignTo"));
			status = "Approve";
			int appID = Integer.parseInt(request.getParameter("appID"));
			
			
			newAppt.setAppStatus(status);
			newAppt.setEmpID(AssignTo);
			newAppt.setAppID(appID);
			updList.add(newAppt);
			
			try {
				String message = updateAppt.UpdAppoint(updList);
				if (message == "success") {
					response.setContentType("text/html");
					session.setAttribute("email",email);
					session.setAttribute("message",message);
					RequestDispatcher suc=getServletContext().getRequestDispatcher("/user/dashboard.jsp");
					suc.forward( request, response);
					
				}
				else if (message == "error") {
					response.setContentType("text/html");
					session.setAttribute("email",email);
					session.setAttribute("message",message);
					RequestDispatcher err=getServletContext().getRequestDispatcher("/user/dashboard.jsp");
					err.forward( request, response);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(statusButton == 9 ) { //reject no need to assign technician
			status = "Reject";
			int appID = Integer.parseInt(request.getParameter("appID"));
			newAppt.setAppStatus(status);
			newAppt.setEmpID(0);
			newAppt.setAppID(appID);
			updList.add(newAppt);
			
			try {
				String message = updateAppt.UpdAppoint(updList);
				if (message == "success") {
					response.setContentType("text/html");
					session.setAttribute("email",email);
					session.setAttribute("message",message);
					RequestDispatcher suc=getServletContext().getRequestDispatcher("/user/dashboard.jsp");
					suc.forward( request, response);
					
				}
				else if (message == "error") {
					response.setContentType("text/html");
					session.setAttribute("email",email);
					session.setAttribute("message",message);
					RequestDispatcher err=getServletContext().getRequestDispatcher("/user/dashboard.jsp");
					err.forward( request, response);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = null;
		pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html lang=en>");
		pw.println("<head>");
		pw.println("<meta charset=UTF-8/>");
		pw.println("<title>Proton 3s Service Center| By Group 5</title>");
		pw.println("<link rel=stylesheet href=https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css/>");
		pw.println("<link rel=stylesheet href=style2.css />");
		pw.println("<script src=https://code.jquery.com/jquery-3.5.0.min.js></script>");
		pw.println("</head>");
		pw.println("<body>");
		DaoLogin loginDetail = new DaoLogin();
		String logins = request.getParameter("email");
		ArrayList<Login> datalogin = loginDetail.getResultSet(logins);
		  for (int z = 0; z < datalogin.size(); z ++ )  { 
		pw.println("<div class=container>");
		pw.println("<nav>");
		pw.println("<ul>");
		pw.println("<li><a href=# class=logo>");
		pw.println("<img src=./image/logoProton.jfif>");
		pw.println("<span class=nav-item>"+datalogin.get(0).getUserName()+"<br></span>");
		pw.println("<span class=nav-item></span>");
		pw.println("</a></li>");
		pw.println("<li><a href=#>");
		pw.println("<i class=fas fa-menorah></i>");
		pw.println("<span class=nav-item>Dashboard</span>");
		pw.println("</a></li>");
	    pw.println("<li><a href=#>");
		pw.println("<i class=fas fa-database></i>");
		pw.println("<span class=nav-item>Report</span>");
		pw.println("</a></li>");
		pw.println("<li><a href=#>");
		pw.println("<i class=fas fa-chart-bar></i>");
		pw.println("<span class=nav-item>Attendance</span>");
		pw.println("</a></li>");
		pw.println("<li><a href=#>");
		pw.println("<i class=fas fa-cog></i>");
		pw.println("<span class=nav-item>Setting</span>");
		pw.println("</a></li>");
		pw.println("<li><a href=LogoutServlet >");
		pw.println("<i class=fas fa-sign-out-alt></i>");
		pw.println("<span class=nav-item>Log out</span>");
		pw.println("</a></li>");
	    pw.println("</ul>");
		pw.println("</nav>");
		pw.println("<section class=main>");
		pw.println("<div class=main-top>");
		pw.println("<h1>"+datalogin.get(0).getUserAccessLevel()+" Dashboard</h1>");
		pw.println("</div>");
		pw.println("<section class=attendance>");
		pw.println("<div class=attendance-list>");
	         
		pw.println("<h1>Update Appointment Status</h1>");
		DaoAppointment updateApp = new DaoAppointment();
		DaoAppointment GetAppt = new DaoAppointment();
		ArrayList<Appointment> applist = new ArrayList<Appointment>();
		
		Appointment appt = new Appointment();
		String email = request.getParameter("login");  // "2021492334@student.uitm.edu.my";
		HttpSession session = request.getSession();
		String statusButton = request.getParameter("status");
		int AppID = Integer.parseInt(request.getParameter("AppID"));
		int cusID = Integer.parseInt(request.getParameter("cusID"));
		//appt.setAppID(AppID);
		//appt.setCusID(cusID);
		//applist.add(appt);
		
		pw.println("<table class=table>");
		pw.println("<thead>");
		pw.println("<tr>");
		pw.println("<th align=center>ID</th>");
		pw.println("<th align=center>Customer Name</th>");
        pw.println("<th align=center>Status</th>");
        pw.println("<th align=center>Date/Time</th>");
        pw.println("<th align=center>Service Type</th>");
        pw.println(" <th align=center>Car Detail</th>");
        pw.println(" <th align=center>Technician</th>");
        pw.println("<th align=center>Action</th>");
        
        pw.println("</tr>");
        pw.println(" </thead>");
		try {
			ArrayList<Appointment> ApptAll = GetAppt.GetAppt(AppID);
			pw.println("<form action='AppointmentApproval' method='get' target='_self'>");
			for (int a = 0; a < ApptAll.size(); a ++ )  { 
            
			
			pw.println("<tr><td>" +ApptAll.get(a).getAppID()+ "<input type='hidden' name='appID' value='"+ApptAll.get(a).getAppID()+"'><input type='hidden' name='email' value='"+datalogin.get(0).getUserEmail()+"'> </td>");
			
			DaoCust customer = new DaoCust();
            ArrayList<Customer> CustomerList = customer.getCustomer(ApptAll.get(a).getCusID());
	            for (int b = 0; b < CustomerList.size(); b ++ )  { 
	            	pw.println("<td>" +CustomerList.get(b).getCusName()+ "</td>");
            		
            		}
            		
			pw.println("<td><select name='status' required> <option disabled selected value> -- select status -- </option>");
			pw.println("<option  value='1'>Accept</option>");
			pw.println("<option  value='9'>Reject </option>");
			pw.println("</select></td>");
			pw.println("<td>"+ApptAll.get(a).getAppDate()+"</td>");
			
			DaoService serviceList = new DaoService();
            //int serve = ApptAll.get(a).getServiceID();
            ArrayList<Service> sList = serviceList.ServiceDetail(ApptAll.get(a).getServiceID());
            for (int d = 0; d < sList.size(); d ++ )  { 
            	pw.println("<td>"+sList.get(d).getServiceName()+"</td>");
           	}
			
        	DaoCar car = new DaoCar();
            ArrayList<Car> CarList = car.getCarType(ApptAll.get(a).getCarID());
            for (int e = 0; e < CarList.size(); e ++ )  {	
            	pw.println("<td>"+CarList.get(e).getCarModel()+" / "+CarList.get(e).getCarVariant() +" / "+CarList.get(e).getCarTransmission()+"</td>");
            	}
			
			
			DaoUser UserTech = new DaoUser();
            ArrayList<User> userArr = UserTech.getUserSet();
            pw.println("<td><select name='AssignTo' required> <option disabled selected value> -- select to assign -- </option>");
            for (int c=0; c < userArr.size(); c++) { 
           		
            	pw.println("<option  value="+userArr.get(c).getUserID()+" required>"+userArr.get(c).getUserName()+" </option>");
            
            }
            pw.println("</select></td>");
           
			pw.println("<td><button type='submit'>Save</button>  </td>");
			pw.println("</form>");
			pw.println("</tr>");
			
			}
			
			pw.println("<tr>");
			pw.println("<td><button onclick='history.back()'>Go Back</button> </td>");
			
			pw.println("</tr>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//hold
//		if(statusButton == "1") { //case approve appointment
//		
//		String AssignTo = request.getParameter("AssignTo");//technician
//				
//		appt.setAppID(Integer.parseInt(AppID));
//		appt.setEmpID(Integer.parseInt(AssignTo));
//		appt.setAppStatus("Approve");
//		
//		applist.add(appt);
//	}
//	else if(statusButton == "9"){ //case reject appointment
//		int newAssignID = 0;
//		//String AppID = request.getParameter("AppID");
//		appt.setAppID(Integer.parseInt(AppID));
//		appt.setEmpID(newAssignID);
//		appt.setAppStatus("Reject");
//		applist.add(appt);
//		
//	}
		
		
		pw.println("</table>");
		  }
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
		
//		DaoAppointment updateApp = new DaoAppointment();
//		ArrayList<Appointment> applist = new ArrayList<Appointment>();
//		Appointment appt = new Appointment();
//		String email = "2021492334@student.uitm.edu.my";//request.getParameter("email");
//		HttpSession session = request.getSession();
//		
//		String statusButton = request.getParameter("status");
//		if(statusButton == "1") { //case approve appointment
//			String AppID = request.getParameter("AppID");
//			String AssignTo = request.getParameter("AssignTo");//technician
//					
//			appt.setAppID(Integer.parseInt(AppID));
//			appt.setEmpID(Integer.parseInt(AssignTo));
//			appt.setAppStatus("Approve");
//			
//			applist.add(appt);
//		}
//		else if(statusButton == "9"){ //case reject appointment
//			int newAssignID = 0;
//			String AppID = request.getParameter("AppID");
//			appt.setAppID(Integer.parseInt(AppID));
//			appt.setEmpID(newAssignID);
//			appt.setAppStatus("Reject");
//			applist.add(appt);
//			
//		}
//		
//		try {
//			message = updateApp.UpdAppoint(applist);
//			if(message == "success") {  //String message
//				session.setAttribute("message", message);
//				session.setAttribute("email",email);
//				RequestDispatcher dis=getServletContext().getRequestDispatcher("/user/dashboard.jsp");
//				 dis.forward(request, response);
//			}else { //reject appointment
//				session.setAttribute("message", message);
//				session.setAttribute("email",email);
//				RequestDispatcher dis=getServletContext().getRequestDispatcher("/user/dashboard.jsp");
//				 dis.forward(request, response);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
