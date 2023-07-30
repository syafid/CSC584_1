package materialServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ordersServlet.ordersDao;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class DeleteMaterialController
 */
public class DeleteMaterialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMaterialController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		MaterialDao delDao = new MaterialDao();
		int materialId = Integer.parseInt(request.getParameter("materialId"));
		//System.out.println(request.getRequestURI);
		try {
			String status = delDao.deleteMaterial(materialId);
			if(status=="success") {
				HttpSession session = request.getSession();
				String alert = "delete_success";
				//String path =  "http://localhost:8080/MyBaju/order/listOrder.jsp";//request.getRequestURI ()+"/order/listOrder.jsp";
				//System.out.println(path);
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/material/listMaterial.jsp");// request.getContextPath()+ "/order/listOrder.jsp"
				dis.forward( request, response);
				
			}
			else {
				HttpSession session = request.getSession();
				String alert = "delete_error";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				//String path =  "http://localhost:8080/MyBaju/order/listOrder.jsp";//request.getRequestURI ()+"/order/listOrder.jsp";
				//System.out.println(path);
				//HttpSession session = request.getSession();
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/material/listMaterial.jsp"); //request.getContextPath()+
				dis.forward( request, response);
				
		}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

}
