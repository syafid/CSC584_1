package appointment;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAO {

	//private Connection conn;
//	private String url;
//	private String user;
//	private String password;

	public ArrayList<Appointment> getResultSet() {

			String url = "jdbc:mysql:/csc584";
		    String user = "root";
		    String password = "p@ssw0rd1234";
			//Connection conn;// = null;
			ArrayList<Appointment> service = new ArrayList<Appointment>();

			try /*(Connection con = DriverManager.getConnection(url, user, password))*/{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				Connection conn = (Connection) DriverManager.getConnection(url, user, password);
				 String sql = "SELECT serviceID, serviceName FROM service";
		         Statement statement = conn.createStatement();
		         ResultSet result = statement.executeQuery(sql);

		         while (result.next()) {
		        	 //int i = 0;
		//        	 serviceID = result.getInt("serviceID");
		//        	 serviceName = result.getString("serviceName");
		//        	 AppointmentAdd appAdd = new AppointmentAdd(result.getInt("serviceID"),result.getString("serviceName"));
		        	 Appointment appAdd = new Appointment();
		        	 appAdd.setServiceID(result.getInt("serviceID"));
		        	 appAdd.setServiceName(result.getString("serviceName"));
		             service.add(appAdd);
		             //System.out.println();
		             //System.out.println(result.getString(2));
		             //i++;
		             }
			}
			catch (SQLException e) {
		        e.printStackTrace();
		    }
			return service;
	}


}