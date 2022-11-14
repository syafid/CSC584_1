package customer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;


public class DaoCust {

	
	public String url = "jdbc:mysql:/csc584";
    public String user = "root";
    public String password = "p@ssw0rd1234";
    public String message = null;

	public ArrayList<Customer> getResultSet() {

		ArrayList<Customer> service = new ArrayList<Customer>();

			try /*(Connection con = DriverManager.getConnection(url, user, password))*/{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				Connection conn = (Connection) DriverManager.getConnection(url, user, password);
				 String sql = "SELECT cusID,cusName FROM customer";
		         Statement statement = conn.createStatement();
		         ResultSet result = statement.executeQuery(sql);

		         while (result.next()) {
		        	 //int i = 0;
		//        	 serviceID = result.getInt("serviceID");
		//        	 serviceName = result.getString("serviceName");
		//        	 AppointmentAdd appAdd = new AppointmentAdd(result.getInt("serviceID"),result.getString("serviceName"));
		        	 Customer cust = new Customer();
		        	 cust.setCusName(result.getString("cusName"));
		        	 
		             service.add(cust);
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
	
//	


	public String CreateCustomer(ArrayList<Customer> newcustomer) throws SQLException {
		Connection conn = null;
		for(int i=0;i<newcustomer.size();i++)
		{
			//System.out.println(newcustomer.get(i).getCusName());

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		try {	
		 String query = " insert into customer (cusName, cusMyKad, cusPhoneNo, cusEmail, cusCarType, cusCarPlate, cusCurrMileage)"
		        + " values (?, ?, ?, ?, ?, ?, ?)";
		
		 // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, newcustomer.get(i).getCusName());
	      preparedStmt.setString (2, newcustomer.get(i).getCusMyKad());
	      preparedStmt.setString (3, newcustomer.get(i).getCusPhoneNo());
	      preparedStmt.setString (4, newcustomer.get(i).getCusEmail());
	      preparedStmt.setInt    (5, newcustomer.get(i).getCusCarType());
	      preparedStmt.setString (6, newcustomer.get(i).getCusCarPlate());
	      preparedStmt.setInt    (7, newcustomer.get(i).getCusCurrMileage());
	      
	   // execute the preparedstatement
	      //preparedStmt.execute();
	      boolean rowInserted = preparedStmt.executeUpdate() > 0;
	      
	     
	        if (rowInserted) {
	            message = "success";
	        } else {
	            message = "error";
	        }
	      
	      conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}//for
		
		return message;
		
		// TODO Auto-generated method stub
		
		
		
	}


}