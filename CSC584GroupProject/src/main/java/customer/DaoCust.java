package customer;


import java.security.MessageDigest;
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

	public ArrayList<Customer> getResultSet(String email) {

		ArrayList<Customer> service = new ArrayList<Customer>();

			try /*(Connection con = DriverManager.getConnection(url, user, password))*/{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				Connection conn = (Connection) DriverManager.getConnection(url, user, password);
				 String sql = "SELECT cusID,cusName,cusEmail FROM customer where cusEmail = '"+email+"'";
		         Statement statement = conn.createStatement();
		         ResultSet result = statement.executeQuery(sql);

		         while (result.next()) {
		        	 //int i = 0;
		//        	 serviceID = result.getInt("serviceID");
		//        	 serviceName = result.getString("serviceName");
		//        	 AppointmentAdd appAdd = new AppointmentAdd(result.getInt("serviceID"),result.getString("serviceName"));
		        	 Customer cust = new Customer();
		        	 cust.setCusName(result.getString("cusName"));
		        	 cust.setCusID(Integer.parseInt(result.getString("cusID")));
		             service.add(cust);
		             System.out.println(sql);
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
		String encryptedpassword = null;
		
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
			
			String userpass = newcustomer.get(i).getCusPasswd();
			MessageDigest m = MessageDigest.getInstance("MD5"); 
			m.update(userpass.getBytes());  
			byte[] bytes = m.digest();  
			//StringBuilder s = new StringBuilder();  
			StringBuilder s = new StringBuilder(newcustomer.get(i).getCusMyKad());
            for(int x=0; x< bytes.length ;x++)  
            {  
                s.append(Integer.toString((bytes[x] & 0xff) + 0x100, 16).substring(1));  
            }  
            encryptedpassword = s.toString();
            
		 String query = " insert into customer (cusName, cusMyKad, cusPhoneNo, cusEmail, cusCarType, cusCarPlate, cusCurrMileage, cusPasswd)"
		        + " values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		 // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, newcustomer.get(i).getCusName());
	      preparedStmt.setString (2, newcustomer.get(i).getCusMyKad());
	      preparedStmt.setString (3, newcustomer.get(i).getCusPhoneNo());
	      preparedStmt.setString (4, newcustomer.get(i).getCusEmail());
	      preparedStmt.setInt    (5, newcustomer.get(i).getCusCarType());
	      preparedStmt.setString (6, newcustomer.get(i).getCusCarPlate());
	      preparedStmt.setInt    (7, newcustomer.get(i).getCusCurrMileage());
	      preparedStmt.setString (8, encryptedpassword);
	      
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
	
	
	
	public ArrayList<Customer> getCustomer(int cusID) {

		ArrayList<Customer> CustList = new ArrayList<Customer>();

			try {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				Connection conn = (Connection) DriverManager.getConnection(url, user, password);
				 String sql = "SELECT cusID, cusName, cusEmail FROM customer where cusID = '"+cusID+"'";
		         Statement statement = conn.createStatement();
		         ResultSet result = statement.executeQuery(sql);
		         Customer cust = new Customer();
		         while (result.next()) {
		        	
		        	
		        	 cust.setCusName(result.getString("cusName"));
		        	 cust.setCusID(Integer.parseInt(result.getString("cusID")));
		             CustList.add(cust);
		             System.out.println(sql);
		             //System.out.println(result.getString(2));
		             //i++;
		             }
			}
			catch (SQLException e) {
		        e.printStackTrace();
		    }
			return CustList;
	}


}