package appointment;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import car.DaoCar;

/**
 * Servlet implementation class AppointmentApproval
 */
public class AppointmentApproval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		String AppID = request.getParameter("AppID");
		String AssignTo = request.getParameter("AssignTo");
		//update appointment table with new technician ID and status
		
//		if(ButID1 == "apprv") {
//			request.setAttribute("AppID", AppID);
//			RequestDispatcher dis=getServletContext().getRequestDispatcher("/appointment/AppointmentApproveReject.jsp");
//			 dis.forward(request, response);
//		}else { //reject appointment
//			AppID = "00";
//			request.setAttribute("AppID", AppID);
//			RequestDispatcher dis=getServletContext().getRequestDispatcher("/appointment/AppointmentApproveReject.jsp");
//			 dis.forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
