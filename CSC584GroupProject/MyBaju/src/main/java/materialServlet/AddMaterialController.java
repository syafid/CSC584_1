package materialServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ordersServlet.Orders;

import java.io.IOException;
//import java.util.Date;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Servlet implementation class AddMaterialController
 */
public class AddMaterialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMaterialController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		material newMat = new material();
		ArrayList<material> newArray = new ArrayList<material>(); 
		
		String matCode = request.getParameter("matCode");
		String matName = request.getParameter("matName");
		System.out.print(matCode);
		
		newMat.setMaterial_code(matCode);
		newMat.setMaterial_name(matName);
		newArray.add(newMat);
		
		MaterialDao matDao = new MaterialDao();
		String message = matDao.insertNewMaterial(newArray);
		if(message == "success") {
			String alert = "success";
			response.setContentType("text/html");
			request.setAttribute("message",alert);
			HttpSession session = request.getSession();
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/material/listMaterial.jsp"); //request.getContextPath()+
			dis.forward( request, response);
			
		}
		else {
			String alert = "update_error";
			response.setContentType("text/html");
			request.setAttribute("message",alert);
			HttpSession session = request.getSession();
			RequestDispatcher dis=getServletContext().getRequestDispatcher("/material/listMaterial.jsp"); //request.getContextPath()+
			dis.forward( request, response);
			
	}
		
	}

}
