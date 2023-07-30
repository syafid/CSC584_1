/**
 * MOHD SYAFID ABDULLAH
 * 2021492334 CS240
 * ASSIGNMENT 2 CSC 584
 * Date:10 JAN 2023
 */
package ordersServlet;

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

public class ordersDao {
	public String message;
	Connection conn=null;
	
	
	public String insertNewOrder(ArrayList<Orders> newOrder) {
		for(int i=0;i<newOrder.size();i++)
		{
		
			
		
			try {
				 ConnectionManagerOracle conn3 = new ConnectionManagerOracle();
				 conn = conn3.getConnectionOracle();
				 
				 String query = " insert into orders1 (orderid, dateCreated, sleeve, shoulder, chest, topLength, waist, hip, bottomLength, customerId, material_id, orders_status,  staff_id, design_id, colour_id)"
					        + " values (orderid.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				 
				 PreparedStatement preparedStmt;
				 preparedStmt = conn.prepareStatement(query);
				  preparedStmt.setDate(1, (java.sql.Date) newOrder.get(i).getDateCreated());//11
				  preparedStmt.setFloat (2, newOrder.get(i).getSleeve());
			      preparedStmt.setFloat (3, newOrder.get(i).getShoulder());
			      preparedStmt.setFloat (4, newOrder.get(i).getChest());
			      preparedStmt.setFloat (5, newOrder.get(i).getTopLength());
			      preparedStmt.setFloat (6, newOrder.get(i).getWaist());
			      preparedStmt.setFloat (7, newOrder.get(i).getHip());
			      preparedStmt.setFloat (8, newOrder.get(i).getBottomLength());
			      preparedStmt.setInt (9, newOrder.get(i).getCustomerId());
			      preparedStmt.setInt (10, newOrder.get(i).getMaterial_id());
			      preparedStmt.setInt (11, newOrder.get(i).getOrders_status());
			      preparedStmt.setInt (12, newOrder.get(i).getTailor_id());
			      preparedStmt.setInt (13, newOrder.get(i).getDesign_id());
			      preparedStmt.setInt (14, newOrder.get(i).getColour_id());
			      
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
	
	
	public ArrayList<Orders> getCustomerList(){
		
		ArrayList ListOrder = new ArrayList<Orders>();
		try {
			 conn = ConnectionManagerOracle.getConnectionOracle();
			 String sql = "SELECT orderId,dateCreated,sleeve,shoulder,chest,topLength,waist,hip,bottomLength,customerId,staff_id,orders_status FROM orders1 order by customerId asc";
	         Statement statement = conn.createStatement();
	         ResultSet result = statement.executeQuery(sql);
	         
	         
	         while (result.next()) {
	        	 Orders OrderList = new Orders();
	        	 OrderList.setOrderId(Integer.parseInt(result.getString("orderId")));
	        	 OrderList.setDateCreated(result.getDate("dateCreated"));
//	        	 OrderList.setDateCollect(result.getDate("dateCollect"));
//	        	 OrderList.setAmount(result.getFloat("amount"));
	        	 OrderList.setSleeve(result.getFloat("sleeve"));
	        	 OrderList.setShoulder(result.getFloat("shoulder"));
	        	 OrderList.setChest(result.getFloat("chest"));
	        	 OrderList.setTopLength(result.getFloat("topLength"));
	        	 OrderList.setWaist(result.getFloat("waist"));
	        	 OrderList.setHip(result.getFloat("hip"));
	        	 OrderList.setBottomLength(result.getFloat("bottomLength"));
	        	 OrderList.setCustomerId(Integer.parseInt(result.getString("customerId")));
	        	 OrderList.setTailor_id(Integer.parseInt(result.getString("staff_id")));
	        	 OrderList.setOrders_status(Integer.parseInt(result.getString("orders_status")));
	        	 
	        	 
	        	 ListOrder.add(OrderList);
	        	 
	        	 
	         }
	         
	         conn.close();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		
		 System.out.print(ListOrder.size());
		
		return ListOrder;
		
		
	}
	
	//get order by orderID
	public ArrayList<Orders> getOrder(int orderId) throws SQLException{
		ArrayList<Orders> order = new ArrayList<Orders>();
		
		 try {
			 conn = ConnectionManagerOracle.getConnectionOracle();
			 String query = "SELECT * FROM orders1 where orderId='"+orderId+"'";
			 Statement statement = conn.createStatement();
		     ResultSet result = statement.executeQuery(query);
		     
		     			while (result.next()) {
					        	 Orders oda = new Orders();
					        	 oda.setOrderId(Integer.parseInt(result.getString("orderId")));
					        	 oda.setDateCreated(result.getDate("dateCreated"));
//					        	 oda.setDateCollect(result.getDate("dateCollect"));
//					        	 oda.setAmount(result.getFloat("amount"));
					        	 oda.setSleeve(result.getFloat("sleeve"));
					        	 oda.setShoulder(result.getFloat("shoulder"));
					        	 oda.setChest(result.getFloat("chest"));
					        	 oda.setTopLength(result.getFloat("topLength"));
					        	 oda.setWaist(result.getFloat("waist"));
					        	 oda.setHip(result.getFloat("hip"));
					        	 oda.setBottomLength(result.getFloat("bottomLength"));
					        	 oda.setCustomerId(Integer.parseInt(result.getString("customerId")));
					        	 oda.setOrders_status(Integer.parseInt(result.getString("orders_status")));
					        	 oda.setColour_id(Integer.parseInt(result.getString("colour_id")));
					        	 oda.setTailor_id(Integer.parseInt(result.getString("staff_id")));
					        	 oda.setMaterial_id(Integer.parseInt(result.getString("material_id")));
					        	 oda.setDesign_id(Integer.parseInt(result.getString("design_id")));
					        	 oda.setDateCompleted(result.getDate("datecompleted"));
					        	
					        	 order.add(oda); 	
	         			}
		     
		     
		      conn.close();
		     
			 }
			 catch(SQLException e){
				 e.printStackTrace();
			 }
		
		 //System.out.print("order array size: "+order.size());
		return order;
		
		
	}
	
	
	
	public String updateOrder(ArrayList<Orders> UpdOda) throws SQLException{
		
		for(int i=0;i<UpdOda.size();i++)
		{

			 conn = ConnectionManagerOracle.getConnectionOracle();
			 String query = "UPDATE orders1 SET datecompleted=?, orders_status=?, staff_id=?, material_id=?, design_id=?, colour_id=? WHERE orderId=?";
			
			
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
	
		      preparedStmt.setDate(1, UpdOda.get(i).getDateCompleted());
		      preparedStmt.setInt(2, UpdOda.get(i).getOrders_status());
		      preparedStmt.setInt(3, UpdOda.get(i).getTailor_id());
		      preparedStmt.setInt(4, UpdOda.get(i).getMaterial_id());
		      preparedStmt.setInt(5, UpdOda.get(i).getDesign_id());
		      preparedStmt.setInt(6, UpdOda.get(i).getColour_id());
		      preparedStmt.setInt(7, UpdOda.get(i).getOrderId());
		      

		      boolean rowInserted = preparedStmt.executeUpdate() > 0;
		      
		     
		        if (rowInserted) {
		            message = "success";
		        } else {
		            message = "error";
		        }
		      //System.out.println(query);
		      //System.out.println(message);
		      
		      preparedStmt.close();
		      conn.close();
		      
		
		
	
		
			}
		
		return message;
		
		
		
	}
	
	
	
	public String deleteOrder(int orderId) throws SQLException{
		
		conn = ConnectionManagerOracle.getConnectionOracle();
		String query = "DELETE FROM orders1 where orderid='"+orderId+"'";
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
	
	//get orders by customer id
	public ArrayList<Orders> getCustomerOrder(int customerId) throws SQLException{
		ArrayList<Orders> order = new ArrayList<Orders>();
		
		 try {
			 conn = ConnectionManagerOracle.getConnectionOracle();
			 String query = "SELECT * FROM orders1 where customerId='"+customerId+"'";
			 Statement statement = conn.createStatement();
		     ResultSet result = statement.executeQuery(query);
		     
		     			while (result.next()) {
					        	 Orders oda = new Orders();
					        	 oda.setOrderId(Integer.parseInt(result.getString("orderId")));
					        	 oda.setDateCreated(result.getDate("dateCreated"));
//					        	 oda.setDateCollect(result.getDate("dateCollect"));
//					        	 oda.setAmount(result.getFloat("amount"));
					        	 oda.setSleeve(result.getFloat("sleeve"));
					        	 oda.setShoulder(result.getFloat("shoulder"));
					        	 oda.setChest(result.getFloat("chest"));
					        	 oda.setTopLength(result.getFloat("topLength"));
					        	 oda.setWaist(result.getFloat("waist"));
					        	 oda.setHip(result.getFloat("hip"));
					        	 oda.setBottomLength(result.getFloat("bottomLength"));
					        	 oda.setCustomerId(Integer.parseInt(result.getString("customerId")));
					        	 oda.setOrders_status(Integer.parseInt(result.getString("orders_status")));
					        	 oda.setColour_id(Integer.parseInt(result.getString("colour_id")));
					        	 oda.setMaterial_id(Integer.parseInt(result.getString("material_id")));
					        	 oda.setDesign_id(Integer.parseInt(result.getString("design_id")));
					        	 
					        	
					        	 order.add(oda); 	
	         			}
		     
		     
		      conn.close();
		     
			 }
			 catch(SQLException e){
				 e.printStackTrace();
			 }
		
		 //System.out.print("customer order array size: "+order.size());
		return order;
		
		
	}
	
	
	public int ordersCount(int tailor_id) throws SQLException{
		int jobCount=0;
		
		try {
			 conn = ConnectionManagerOracle.getConnectionOracle();
			 String query = "select count(orderid) from orders1 where staff_id='"+tailor_id+"'";
			 Statement statement = conn.createStatement();
		     ResultSet result = statement.executeQuery(query);
		     while (result.next()) {
		         jobCount = result.getInt(1);
		       }
		     conn.close();
		     
		 }
		 catch(SQLException e){
			 e.printStackTrace();
		 }
		return jobCount;
	}
	
	//get count order by design
	public int designCount(int design_id) throws SQLException{
		int designCount=0;
		
		try {
			 conn = ConnectionManagerOracle.getConnectionOracle();
			 String query = "select count(orderid) from orders1 where design_id='"+design_id+"'";
			 Statement statement = conn.createStatement();
		     ResultSet result = statement.executeQuery(query);
		     while (result.next()) {
		         designCount = result.getInt(1);
		       }
		     conn.close();
		     
		 }
		 catch(SQLException e){
			 e.printStackTrace();
		 }
		return designCount;
	}
	
	//get orders by tailor id
	public ArrayList<Orders> getTailorOrder(int tailorId) throws SQLException{
		ArrayList<Orders> tailorder = new ArrayList<Orders>();
		
		 try {
			 conn = ConnectionManagerOracle.getConnectionOracle();
			 String query = "SELECT * FROM orders1 where staff_id='"+tailorId+"'";
			 Statement statement = conn.createStatement();
		     ResultSet result = statement.executeQuery(query);
		     
		     			while (result.next()) {
					        	 Orders oda = new Orders();
					        	 oda.setOrderId(Integer.parseInt(result.getString("orderId")));
					        	 oda.setDateCreated(result.getDate("dateCreated"));

					        	 oda.setCustomerId(Integer.parseInt(result.getString("customerId")));
					        	 oda.setOrders_status(Integer.parseInt(result.getString("orders_status")));
					        	 oda.setColour_id(Integer.parseInt(result.getString("colour_id")));
					        	 oda.setMaterial_id(Integer.parseInt(result.getString("material_id")));
					        	 oda.setDesign_id(Integer.parseInt(result.getString("design_id")));
					        	 oda.setDateCreated(result.getDate("datecompleted"));
					        	 
					        	
					        	 tailorder.add(oda); 	
	         			}
		     
		     
		      conn.close();
		     
			 }
			 catch(SQLException e){
				 e.printStackTrace();
			 }
		
		 //System.out.print("customer order array size: "+order.size());
		return tailorder;
		
		
	}
	
	
	//get orders by design id
		public ArrayList<Orders> getFashionOrder(int fashionId) throws SQLException{
			ArrayList<Orders> fashorder = new ArrayList<Orders>();
			 try {
				 conn = ConnectionManagerOracle.getConnectionOracle();
				 String query = "SELECT * FROM orders1 where design_id='"+fashionId+"'";
				 Statement statement = conn.createStatement();
			     ResultSet result = statement.executeQuery(query);
			     
			     while (result.next()) {
			      	 Orders order = new Orders();
			      	 order.setOrderId(Integer.parseInt(result.getString("orderid")));
			      	 order.setDateCreated(result.getDate("dateCreated"));
			      	 order.setCustomerId(Integer.parseInt(result.getString("customerID")));
			      	 order.setMaterial_id(Integer.parseInt(result.getString("material_id")));
			      	 order.setTailor_id(Integer.parseInt(result.getString("staff_id")));
			      	 order.setColour_id(Integer.parseInt(result.getString("colour_id")));
			      	 order.setOrders_status(Integer.parseInt(result.getString("orders_status")));
			      	 order.setDateCompleted((result.getDate("dateCreated")));
			      	 fashorder.add(order);
			     }   	 
			     conn.close();
					
		      } catch (SQLException e) {
		          // TODO Auto-generated catch block
		          e.printStackTrace();
		      }
			
			 //System.out.print(fashorder.size());
			     
			
			return fashorder;
			
		}
		
		//get count order by material
		public int materialCount(int material_id) throws SQLException{
			int materialCount=0;
			
			try {
				 conn = ConnectionManagerOracle.getConnectionOracle();
				 String query = "select count(orderid) from orders1 where material_id='"+material_id+"'";
				 Statement statement = conn.createStatement();
			     ResultSet result = statement.executeQuery(query);
			     while (result.next()) {
			         materialCount = result.getInt(1);
			       }
			     conn.close();
			     
			 }
			 catch(SQLException e){
				 e.printStackTrace();
			 }
			return materialCount;
		}
		
		//get count order by colour
				public int colourCount(int colour_id) throws SQLException{
					int colourCount=0;
					
					try {
						 conn = ConnectionManagerOracle.getConnectionOracle();
						 String query = "select count(orderid) from orders1 where colour_id='"+colour_id+"'";
						 Statement statement = conn.createStatement();
					     ResultSet result = statement.executeQuery(query);
					     while (result.next()) {
					         colourCount = result.getInt(1);
					       }
					     conn.close();
					     
					 }
					 catch(SQLException e){
						 e.printStackTrace();
					 }
					return colourCount;
				}
				
				
		//get orders by design id
				public ArrayList<Orders> getMaterialOrder(int materialId) throws SQLException{
					ArrayList<Orders> mateorder = new ArrayList<Orders>();
					 try {
						 conn = ConnectionManagerOracle.getConnectionOracle();
						 String query = "SELECT * FROM orders1 where material_id='"+materialId+"'";
						 Statement statement = conn.createStatement();
					     ResultSet result = statement.executeQuery(query);
					     
					     while (result.next()) {
					      	 Orders order = new Orders();
					      	 order.setOrderId(Integer.parseInt(result.getString("orderid")));
					      	 order.setDateCreated(result.getDate("dateCreated"));
					      	 order.setCustomerId(Integer.parseInt(result.getString("customerID")));
					      	 order.setMaterial_id(Integer.parseInt(result.getString("material_id")));
					      	 order.setTailor_id(Integer.parseInt(result.getString("staff_id")));
					      	 order.setColour_id(Integer.parseInt(result.getString("colour_id")));
					      	 order.setOrders_status(Integer.parseInt(result.getString("orders_status")));
					      	 order.setDateCompleted((result.getDate("dateCreated")));
					      	 mateorder.add(order);
					     }   	 
					     conn.close();
							
				      } catch (SQLException e) {
				          // TODO Auto-generated catch block
				          e.printStackTrace();
				      }
					
					 //System.out.print(fashorder.size());
					     
					
					return mateorder;
					
				}
				
				//get orders by colour id
				public ArrayList<Orders> getColourOrder(int colour_id) throws SQLException{
					ArrayList<Orders> colororder = new ArrayList<Orders>();
					 try {
						 conn = ConnectionManagerOracle.getConnectionOracle();
						 String query = "SELECT * FROM orders1 where colour_id='"+colour_id+"'";
						 Statement statement = conn.createStatement();
					     ResultSet result = statement.executeQuery(query);
					     
					     while (result.next()) {
					      	 Orders order = new Orders();
					      	 order.setOrderId(Integer.parseInt(result.getString("orderid")));
					      	 order.setDateCreated(result.getDate("dateCreated"));
					      	 order.setCustomerId(Integer.parseInt(result.getString("customerID")));
					      	 order.setMaterial_id(Integer.parseInt(result.getString("material_id")));
					      	 order.setTailor_id(Integer.parseInt(result.getString("staff_id")));
					      	 order.setColour_id(Integer.parseInt(result.getString("colour_id")));
					      	 order.setOrders_status(Integer.parseInt(result.getString("orders_status")));
					      	 order.setDateCompleted((result.getDate("dateCreated")));
					      	 colororder.add(order);
					     }   	 
					     conn.close();
							
				      } catch (SQLException e) {
				          // TODO Auto-generated catch block
				          e.printStackTrace();
				      }
					
					 //System.out.print(fashorder.size());
					     
					
					return colororder;
					
				}
				
				
				
				public String updateCustomerOrder(ArrayList<Orders> UpdOdaCustomer) throws SQLException{
					
					for(int i=0;i<UpdOdaCustomer.size();i++)
					{

						 conn = ConnectionManagerOracle.getConnectionOracle();
						 String query = "UPDATE orders1 SET datecompleted=?, orders_status=? WHERE orderId=?";
						
						
					      PreparedStatement preparedStmt = conn.prepareStatement(query);
				
					      preparedStmt.setDate(1, UpdOdaCustomer.get(i).getDateCompleted());
					      preparedStmt.setInt(2, UpdOdaCustomer.get(i).getOrders_status());
					     /* preparedStmt.setInt(3, UpdOda.get(i).getTailor_id());
					      preparedStmt.setInt(4, UpdOda.get(i).getMaterial_id());
					      preparedStmt.setInt(5, UpdOda.get(i).getDesign_id());
					      preparedStmt.setInt(6, UpdOda.get(i).getColour_id());*/
					      preparedStmt.setInt(3, UpdOdaCustomer.get(i).getOrderId());
					      

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
				
				
	//update payment table			
				
				public String updatePayment(ArrayList<Orders> UpdPayment) throws SQLException{
					
					for(int i=0;i<UpdPayment.size();i++)
					{

						 conn = ConnectionManagerOracle.getConnectionOracle();
						 String query = "UPDATE orders1 SET payment_id=? WHERE orderId=?";
						
						
					      PreparedStatement preparedStmt = conn.prepareStatement(query);
					      preparedStmt.setInt(1, UpdPayment.get(i).getOrders_status());
					     

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
} 
