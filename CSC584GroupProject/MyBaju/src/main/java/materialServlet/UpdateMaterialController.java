package materialServlet;

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

import fashionServlet.fashion;
import fashionServlet.fashionDao;
import materialServlet.*;

/**
 * Servlet implementation class UpdateMaterialController
 */
public class UpdateMaterialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMaterialController() {
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
		
		int matID = Integer.parseInt(request.getParameter("materialID"));
		String materialCode = request.getParameter("materialCode");
		String materialName = request.getParameter("materialName");
		
		material material = new material();
		ArrayList<material> matArray = new ArrayList<material>();
		MaterialDao MatDao = new MaterialDao();
		
		material.setMaterial_id(matID);
		material.setMaterial_code(materialCode);
		material.setMaterial_name(materialName);
		
		matArray.add(material);
		
		try {
			String status = MatDao.updateMaterial(matArray);
			if(status=="success") {
				HttpSession session = request.getSession();
				String alert = "update_success";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/material/listMaterial.jsp");// request.getContextPath()+
				dis.forward( request, response);
				
			}
			else {
				HttpSession session = request.getSession();
				String alert = "update_error";
				response.setContentType("text/html");
				request.setAttribute("message",alert);
				//HttpSession session = request.getSession();
				RequestDispatcher dis=getServletContext().getRequestDispatcher("/material/listMaterial.jsp"); //request.getContextPath()+
				dis.forward( request, response);
				
		} 
			
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
