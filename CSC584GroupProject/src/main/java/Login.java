import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns={"/Login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
	     PrintWriter pwriter=response.getWriter();
	     String uname=request.getParameter("val1");
	     String pw=request.getParameter("val2");
	     pwriter.println("User Details Page:");
	     pwriter.println("Hello "+uname);
	     pwriter.println("Your Password is **"+pw+"**");
	     pwriter.close();


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
        try {

            String user = request.getParameter("txtName");
            out.println("<h2> Welcome "+user+"</h2>");
        } finally {
            out.close();
        }
	}

}
