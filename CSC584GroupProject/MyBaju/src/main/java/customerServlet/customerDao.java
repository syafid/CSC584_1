/**
 * MOHD SYAFID ABDULLAH
 * 2021492334 CS240
 * ASSIGNMENT 2 CSC 584
 * Date:10 JAN 2023
 */
package customerServlet;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionManagerOracle;
import customerServlet.*;

public class customerDao {
	public String message;
	Connection conn=null;
	
	
	
	
	public String insertNewCust(ArrayList<Customer> newcust) {
		
		
		
		for(int i=0;i<newcust.size();i++)
		{
		
			
		
			try {
//				 ConnectionManager conn3 = new ConnectionManager();
				 //conn = conn3.getConnection();
//				 ConnectionManagerOracle conn3 = new ConnectionManagerOracle();
				 conn = ConnectionManagerOracle.getConnectionOracle();
				 
				 String query = " insert into customer (customerid, name, phoneNumber, address)"
					        + " values (customerid.nextval, ?, ?, ?)";
				 
				 PreparedStatement preparedStmt;
				 preparedStmt = conn.prepareStatement(query);
				  preparedStmt.setString(1, newcust.get(i).getName());//
			      preparedStmt.setString (2, newcust.get(i).getPhoneNumber());
			      preparedStmt.setString (3, newcust.get(i).getAddress());
			      
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
			      
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		}
		
		
		return message;
		
		
		
	}
	
	public ArrayList<Customer> getCustomerList(){
		 ArrayList<Customer> CustList = new ArrayList<Customer>();
		 

		 try {
			 conn = ConnectionManagerOracle.getConnectionOracle();
			 String sql = "SELECT customerId, name, phoneNumber, address FROM customer";
	         Statement statement = conn.createStatement();
	         ResultSet result = statement.executeQuery(sql);
	         
	         
	         while (result.next()) {
	        	 Customer custList = new Customer();
	        	 custList.setCustomerId(Integer.parseInt(result.getString("customerId")));
	        	 custList.setName(result.getString("name"));
	        	 custList.setPhoneNumber(result.getString("phoneNumber"));
	        	 custList.setAddress(result.getString("address"));
	        	 
	        	 CustList.add(custList);
	        	 
	        	 
	         }
	       
		      conn.close();
			
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		
		 System.out.print(CustList.size());
		 return CustList;
		
		
	}
	
	
	public ArrayList<Customer> getCustomer(int cusid) throws SQLException{
		ArrayList<Customer> cust = new ArrayList<Customer>();
		
		 try {
		 conn = ConnectionManagerOracle.getConnectionOracle();
		 String query = "SELECT * FROM customer where customerId='"+cusid+"'";
		 Statement statement = conn.createStatement();
	     ResultSet result = statement.executeQuery(query);
	     
	     while (result.next()) {
				        	 Customer customer = new Customer();
				        	 customer.setCustomerId(Integer.parseInt(result.getString("customerId")));
				        	 customer.setName(result.getString("name"));
				        	 customer.setPhoneNumber(result.getString("phoneNumber"));
				        	 customer.setAddress(result.getString("address"));
				        	
				        	 cust.add(customer);
        	 
        	 
         			}
	     
	     
	      conn.close();
	     
		 }
		 catch(SQLException e){
			 e.printStackTrace();
		 }
		
		
		
		return cust;
		
		
	}
	
	
	public String updateCustomer(ArrayList<Customer> UpdCust) throws SQLException{

		for(int i=0;i<UpdCust.size();i++)
		{

			 conn = ConnectionManagerOracle.getConnectionOracle();
			 String query = "UPDATE customer SET name=?, phoneNumber=?, address=? WHERE customerId=?";
			
			
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		     
		      preparedStmt.setString(1, UpdCust.get(i).getName());
		      preparedStmt.setString (2, UpdCust.get(i).getPhoneNumber());
		      preparedStmt.setString(3, UpdCust.get(i).getAddress());
		      preparedStmt.setInt(4, UpdCust.get(i).getCustomerId());

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
	
	
public String deleteCustomer(int custId) throws SQLException{
		
		conn = ConnectionManagerOracle.getConnectionOracle();
		String query = "DELETE FROM customer where customerId='"+custId+"'";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		
		boolean rowDeleted = preparedStmt.executeUpdate() > 0;
		if (rowDeleted) {
            message = "success";
        } else {
            message = "error";
        }
	      System.out.println(query);
	      System.out.println(message);
	      
	      preparedStmt.close();
	      conn.close();
		
		
		
		return message;
		
		
		
		
	}

public String getCustomerOrders(int orderID) throws SQLException{
	
	conn = ConnectionManagerOracle.getConnectionOracle();
	String query ="";
	
	
	
	return message;
}

}
