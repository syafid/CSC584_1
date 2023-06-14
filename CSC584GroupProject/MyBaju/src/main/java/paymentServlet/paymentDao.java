package paymentServlet;

import paymentServlet.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Date;
import java.sql.Date;

import connection.ConnectionManagerOracle;
import customerServlet.Customer;
import fashionServlet.*;
import ordersServlet.*;

public class paymentDao {
	public String message;
	Connection conn=null;
	
	public String insertNewPayment(ArrayList<payment> newPayment) {
		for(int i=0;i<newPayment.size();i++)
		{
		
			
		
			try {
				 ConnectionManagerOracle conn3 = new ConnectionManagerOracle();
				 conn = conn3.getConnectionOracle();
				 
				 String query = " insert into payment (payment_id, payment_date, orders_id, customer_id, verify_by, payment_status)"
					        + " values (orderid.nextval, ?, ?, ?, ?, ?)";
				 
				 PreparedStatement preparedStmt;
				 
				 
			        
				 preparedStmt = conn.prepareStatement(query);
				 			        
				  preparedStmt.setDate(1, (java.sql.Date) newPayment.get(i).getPayment_date());//11
				  preparedStmt.setFloat (2, newPayment.get(i).getOrder_id());
			      preparedStmt.setFloat (3, newPayment.get(i).getCustomer_id());
			      preparedStmt.setFloat (4, newPayment.get(i).getVerify_by());
			      preparedStmt.setFloat (5, newPayment.get(i).getPayment_status());
			      
				
				
			     
			      
			      boolean rowInserted = preparedStmt.executeUpdate() > 0;
			      
				     
			        if (rowInserted) {
			            message = "success";
			            String query2 = "SELECT * FROM payment where orders_id='"+newPayment.get(i).getOrder_id()+"'";
			            Statement statement2 = conn.createStatement();
					     ResultSet result2 = statement2.executeQuery(query2);
					     ArrayList<payment> payment = new ArrayList<payment>();
					     			while (result2.next()) {
								        	 payment pymnt2 = new payment();
								        	 pymnt2.setOrder_id(Integer.parseInt(result2.getString("orders_id")));
								        	 pymnt2.setPayment_id(Integer.parseInt(result2.getString("payment_id")));
								        	 //pymnt2.setCustomer_id(Integer.parseInt(result2.getString("customer_id")));
//								        	 pymnt2.setPayment_date(result2.getDate("payment_date"));
//								        	 pymnt2.setVerify_by(Integer.parseInt(result2.getString("verify_by")));
//								        	 pymnt2.setPayment_status(Integer.parseInt(result2.getString("payment_status")));
								        	
								        	 payment.add(pymnt2); 
								        	 
								        	 for(int e=0; e<payment.size();e++) {
								        		 String query3 = "UPDATE orders SET payment_id=? WHERE orderid=?";
								        		 PreparedStatement preparedStmt3 = conn.prepareStatement(query3);
								       	      
									       	      preparedStmt3.setInt(1, payment.get(e).getPayment_id());
									       	      preparedStmt3.setInt (2, payment.get(e).getOrder_id());
									       	      
										       	   boolean rowInserted2 = preparedStmt3.executeUpdate() > 0;
										 	      
										  	     
											        if (rowInserted2) {
											            message = "success";
											        } else {
											            message = "error";
											        }
										     
											     
								        	 }
				         			}
			            
			        } else {
			            message = "error";
			        }
			        
			       
			        
			        
			      conn.commit();			      
			      preparedStmt.close();
			      conn.close();
			      
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		}
		
		
		return message;
		
		
	}
	
	
	
	//get order by orderID
		public ArrayList<payment> getPayment(int orders_id) throws SQLException{
			ArrayList<payment> payment = new ArrayList<payment>();
			
			 try {
				 conn = ConnectionManagerOracle.getConnectionOracle();
				 String query = "SELECT * FROM payment where orders_id='"+orders_id+"'";
				 Statement statement = conn.createStatement();
			     ResultSet result = statement.executeQuery(query);
			     
			     			while (result.next()) {
						        	 payment pymnt = new payment();
						        	 pymnt.setOrder_id(Integer.parseInt(result.getString("orders_id")));
						        	 pymnt.setPayment_id(Integer.parseInt(result.getString("payment_id")));
						        	 pymnt.setCustomer_id(Integer.parseInt(result.getString("customer_id")));
						        	 pymnt.setPayment_date(result.getDate("payment_date"));
						        	 pymnt.setVerify_by(Integer.parseInt(result.getString("verify_by")));
						        	 pymnt.setPayment_status(Integer.parseInt(result.getString("payment_status")));
						        	
						        	 payment.add(pymnt); 	
		         			}
			     
			     
			      conn.close();
			     
				 }
				 catch(SQLException e){
					 e.printStackTrace();
				 }
			
			 //System.out.print("order array size: "+order.size());
			return payment;
			
			
		}
		
		
		

}
