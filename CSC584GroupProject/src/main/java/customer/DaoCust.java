package customer;


import java.security.MessageDigest;
import connection.ConnectionManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;


public class DaoCust {

    public String message = null;

	public ArrayList<Customer> getResultSet(String email) {

		ArrayList<Customer> service = new ArrayList<Customer>();

			try {

				 ConnectionManager cm = new ConnectionManager();
				 Connection conn = cm.getConnection();
				 String sql = "SELECT cusID,cusName,cusEmail FROM customer where cusEmail = '"+email+"'";
		         Statement statement = conn.createStatement();
		         ResultSet result = statement.executeQuery(sql);

		         while (result.next()) {
		
		        	 Customer cust = new Customer();
		        	 cust.setCusName(result.getString("cusName"));
		        	 cust.setCusID(Integer.parseInt(result.getString("cusID")));
		             service.add(cust);
		             System.out.println(sql);
		            
		             }
			}
			catch (SQLException e) {
		        e.printStackTrace();
		    }
			return service;
	}
	
//	


	public String CreateCustomer(ArrayList<Customer> newcustomer) throws SQLException {
	
		String encryptedpassword = null;
		
		for(int i=0;i<newcustomer.size();i++)
		{
			
			ConnectionManager cm = new ConnectionManager();
			Connection conn = cm.getConnection();
		
		
		
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
            
		 String query = " insert into customer (cusName, cusAddress, cusMyKad, cusPhoneNo, cusEmail, cusCarType, cusCarPlate, cusCurrMileage, cusPasswd)"
		        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		 // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, newcustomer.get(i).getCusName());
	      preparedStmt.setString (2, newcustomer.get(i).getCusAdd());
	      preparedStmt.setString (3, newcustomer.get(i).getCusMyKad());
	      preparedStmt.setString (4, newcustomer.get(i).getCusPhoneNo());
	      preparedStmt.setString (5, newcustomer.get(i).getCusEmail());
	      preparedStmt.setInt    (6, newcustomer.get(i).getCusCarType());
	      preparedStmt.setString (7, newcustomer.get(i).getCusCarPlate());
	      preparedStmt.setInt    (8, newcustomer.get(i).getCusCurrMileage());
	      preparedStmt.setString (9, encryptedpassword);
	      
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
	
	public String UpdateCustomer(ArrayList<Customer> updcustomer) throws SQLException {
		for(int i=0;i<updcustomer.size();i++)
		{


			 ConnectionManager cm = new ConnectionManager();
			 Connection conn = cm.getConnection();
			 String query = "UPDATE customer SET cusName=?, cusAddress=?, cusMyKad=?, cusPhoneNo=?, cusCarType=?, cusCarPlate=?, cusCurrMileage=?  WHERE cusID=?";
			
			
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      
		      preparedStmt.setString(1, updcustomer.get(i).getCusName());
		      preparedStmt.setString (2, updcustomer.get(i).getCusAdd());
		      preparedStmt.setString(3, updcustomer.get(i).getCusMyKad());
		      preparedStmt.setString(4, updcustomer.get(i).getCusPhoneNo());
		      preparedStmt.setInt(5, updcustomer.get(i).getCusCarType());
		      preparedStmt.setString(6, updcustomer.get(i).getCusCarPlate());
		      preparedStmt.setInt(7, updcustomer.get(i).getCusCurrMileage());
		      preparedStmt.setInt(8, updcustomer.get(i).getCusID());
		      
		      boolean rowInserted = preparedStmt.executeUpdate() > 0;
		      
		     
		        if (rowInserted) {
		            message = "success";
		        } else {
		            message = "error";
		        }
		      System.out.println(query);
		      System.out.println(message);
		      
		      preparedStmt.close();
		      conn.close();
		      
		
		
	
		
			}
		
		return message;
		
		
		
	}
	
	
	public ArrayList<Customer> getCustomer(int cusID) {

		ArrayList<Customer> CustList = new ArrayList<Customer>();

			try {

				 ConnectionManager cm = new ConnectionManager();
				 Connection conn = cm.getConnection();
				 
				 String sql = "SELECT cusID, cusName, cusAddress, cusMyKad, cusPhoneNo, cusEmail, cusCarType, cusCarPlate, cusCurrMileage FROM customer where cusID = '"+cusID+"'";
		         Statement statement = conn.createStatement();
		         ResultSet result = statement.executeQuery(sql);
		         Customer cust = new Customer();
		         while (result.next()) {
		        	
		        	
		        	 cust.setCusName(result.getString("cusName"));
		        	 cust.setCusID(Integer.parseInt(result.getString("cusID")));
		        	 cust.setCusAdd(result.getString("cusAddress"));
		        	 cust.setCusMyKad(result.getString("cusMyKad"));
		        	 cust.setCusPhoneNo(result.getString("cusPhoneNo"));
		        	 cust.setCusEmail(result.getString("cusEmail"));
		        	 cust.setCusCarType(result.getInt("cusCarType"));
		        	 cust.setCusCarNo(result.getString("cusCarPlate"));
		        	 cust.setCusCurrMileage(result.getInt("cusCurrMileage"));
		        	 
		             CustList.add(cust);
		             System.out.println(sql);
		             
		             }
			}
			catch (SQLException e) {
		        e.printStackTrace();
		    }
			return CustList;
	}


}