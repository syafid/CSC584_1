package tailorServlet;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionManagerOracle;
import customerServlet.Customer;
import fashionServlet.fashion;
import tailorServlet.tailor;

public class tailorDao {
	public String message;
	Connection conn=null;
	
public String insertNewTailor(ArrayList<tailor> newTailor) {
		
		
		
		for(int i=0;i<newTailor.size();i++)
		{
		
			
		
			try {

				 conn = ConnectionManagerOracle.getConnectionOracle();
				 
				 String query = " insert into staff1 ( staff_id, staff_name, staff_phone, specialization, job_id)"
					        + " values (staff_id.nextval, ?, ?, ?, ?)";//
				 
				 PreparedStatement preparedStmt;
				 preparedStmt = conn.prepareStatement(query);
				  //preparedStmt.setInt(1, newTailor.get(i).getTailor_id());//
			      preparedStmt.setString (1, newTailor.get(i).getTailor_name());
			      preparedStmt.setString (2, newTailor.get(i).getTailor_phone());
			      preparedStmt.setString (3, newTailor.get(i).getJob_spec());
			      preparedStmt.setString (4, newTailor.get(i).getJob_id());
			      
			      
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


public ArrayList<tailor> getTailorList(){
	 ArrayList<tailor> TailorList = new ArrayList<tailor>();
	 

	 try {
		 conn = ConnectionManagerOracle.getConnectionOracle();
		 String sql = "SELECT staff_id, staff_name, staff_phone, job_id, specialization FROM staff1";
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery(sql);
      
      
      while (result.next()) {
     	 tailor tailList = new tailor();
     	 tailList.setTailor_id(Integer.parseInt(result.getString("staff_id")));
     	 tailList.setTailor_name(result.getString("staff_name"));
     	 tailList.setTailor_phone(result.getString("staff_phone"));
     	 tailList.setJob_id(result.getString("job_id"));
     	 tailList.setJob_spec(result.getString("specialization"));
     	 
     	 
     	 TailorList.add(tailList);
     	 
     	 
      }
    
	      conn.close();
		
     } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
	
	 System.out.print(TailorList.size());
	 return TailorList;
	
	
}

public ArrayList<tailor> getTailor(int staff_id) throws SQLException{
	ArrayList<tailor> tailor = new ArrayList<tailor>();
	
	 try {
	 conn = ConnectionManagerOracle.getConnectionOracle();
	 String query = "SELECT staff_id,staff_name,staff_phone,specialization,job_id FROM staff1 where staff_id='"+staff_id+"'";
	 Statement statement = conn.createStatement();
     ResultSet result = statement.executeQuery(query);
     
     while (result.next()) {
			        	 tailor newTailor = new tailor();
			        	 newTailor.setTailor_id(Integer.parseInt(result.getString("staff_id")));
			        	 newTailor.setTailor_name(result.getString("staff_name"));;
			        	 newTailor.setTailor_phone(result.getString("staff_phone"));
			        	 newTailor.setJob_id(result.getString("job_id"));
			        	 newTailor.setJob_spec(result.getString("specialization"));
			        	
			        	
			        	 tailor.add(newTailor);
    	 
    	 
     			}
     
     
      conn.close();
     
	 }
	 catch(SQLException e){
		 e.printStackTrace();
	 }
	
	
	
	return tailor;
	
	
}


public ArrayList<tailor> getTailorByDesign(int design_id) throws SQLException{
	ArrayList<tailor> tailor = new ArrayList<tailor>();
	
	 try {
	 conn = ConnectionManagerOracle.getConnectionOracle();
	 String query = "SELECT staff_id,staff_name FROM staff1 where specialization='"+design_id+"' and job_id='Tailor'";
	 Statement statement = conn.createStatement();
     ResultSet result = statement.executeQuery(query);
     
     while (result.next()) {
			        	 tailor newTailor = new tailor();
			        	 newTailor.setTailor_id(Integer.parseInt(result.getString("staff_id")));
			        	 newTailor.setTailor_name(result.getString("staff_name"));;
			        	 //newTailor.setTailor_phone(result.getString("tailor_phone"));
			        	
			        	
			        	 tailor.add(newTailor);
    	 
    	 
     			}
     
     
      conn.close();
     
	 }
	 catch(SQLException e){
		 e.printStackTrace();
	 }
	
	
	
	return tailor;
	
	
}


public String updateStaff(ArrayList<tailor> UpdStaff) throws SQLException{

	for(int i=0;i<UpdStaff.size();i++)
	{

		 conn = ConnectionManagerOracle.getConnectionOracle();
		 String query = "UPDATE staff1 SET staff_name=?, staff_phone=? WHERE staff_id=?";
		
		
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      
	      preparedStmt.setString(1, UpdStaff.get(i).getTailor_name());
	      preparedStmt.setString (2, UpdStaff.get(i).getTailor_phone());
	      preparedStmt.setInt(3, UpdStaff.get(i).getTailor_id());

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


//delete

public String deleteTailor(int staffId) throws SQLException{
	
	conn = ConnectionManagerOracle.getConnectionOracle();
	String query = "DELETE FROM staff1 where staff_id='"+staffId+"'";
	PreparedStatement preparedStmt = conn.prepareStatement(query);
	
	boolean rowDeleted = preparedStmt.executeUpdate() > 0;
	if (rowDeleted) {
        message = "delete_success";
    } else {
        message = "delete_error";
    }
      
      
      preparedStmt.close();
      conn.close();
	
	
	
	return message;
	
	
	
	
}
}
