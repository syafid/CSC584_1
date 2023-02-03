package reporting;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionManager;
import customer.Customer;
import user.User;
import login.Login;
import connection.ConnectionManager;

public class reportDao {

	//get customer count
	public static int getCustomerCount() {
		int cust_count = 0;
		
		try {

			 ConnectionManager cm = new ConnectionManager();
			 Connection conn = cm.getConnection();
			 
			 String sql = "SELECT COUNT(*) as total FROM customer";
	         Statement statement = conn.createStatement();
	         ResultSet result = statement.executeQuery(sql);

	         while (result.next()) {
	        	 cust_count = result.getInt("total");
	        	 
	        	 
	        	 System.out.println(cust_count);
	            
	            
	             }
	         conn.close();
		}
		catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return cust_count;
		
		
	}
	
	
	//get appointment count
	public static int getAppointmentCount() {
		int app_count = 0;
		try {

			 ConnectionManager cm = new ConnectionManager();
			 Connection conn = cm.getConnection();
			 
			 String sql = "SELECT COUNT(*) as total FROM appointment";
	         Statement statement = conn.createStatement();
	         ResultSet result = statement.executeQuery(sql);

	         while (result.next()) {
	        	 app_count = result.getInt("total");
	        	 
	        	 
	        	 System.out.println(app_count);
	            
	            
	             }
	         conn.close();
		}
		catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return app_count;
		
	}
	
	
	
	//get staff count
	public static int getStaffCount() {
		int staff_count = 0;
		try {

			 ConnectionManager cm = new ConnectionManager();
			 Connection conn = cm.getConnection();
			 
			 String sql = "SELECT COUNT(*) as total FROM user";
	         Statement statement = conn.createStatement();
	         ResultSet result = statement.executeQuery(sql);

	         while (result.next()) {
	        	 staff_count = result.getInt("total");
	        	 
	        	 
	        	 System.out.println(staff_count);
	            
	            
	             }
	         conn.close();
		}
		catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return staff_count;
		
	}
}
