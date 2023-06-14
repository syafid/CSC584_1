package colourServlet;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionManagerOracle;
import materialServlet.material;


public class colourDao {
	public String message;
	Connection conn = null;
	
public String insertNewColour(ArrayList<colour> newColour) {
		
		
		
		for(int i=0;i<newColour.size();i++)
		{
		
			
		
			try {

				 conn = ConnectionManagerOracle.getConnectionOracle();
				 
				 String query = " insert into colour ( colour_id, colour_name, colour_desc)"
					        + " values (colour_id.nextval, ?, ?)";//
				 
				 PreparedStatement preparedStmt;
				 preparedStmt = conn.prepareStatement(query);
				  
			      preparedStmt.setString (1, newColour.get(i).getColour_name());
			      preparedStmt.setString (2, newColour.get(i).getColour_desc());
			      
			      boolean rowInserted = preparedStmt.executeUpdate() > 0;
			      
				     
			        if (rowInserted) {
			            message = "success";
			        } else {
			            message = "error";
			        }
			      //System.out.println(query);
			     // System.out.println(message);
			      
			      preparedStmt.close();
			      conn.close();
			      
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		}
		
		
		return message;
		
		
		
	}


public ArrayList<colour> getColourList(){
	 ArrayList<colour> ColourList = new ArrayList<colour>();
	 

	 try {
		 conn = ConnectionManagerOracle.getConnectionOracle();
		 String sql = "SELECT colour_id, colour_name, colour_desc FROM colour";
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery(sql);
      
      
      while (result.next()) {
     	 colour colourList = new colour();
     	 colourList.setColour_id(Integer.parseInt(result.getString("colour_id")));
     	 colourList.setColour_name(result.getString("colour_name"));
     	 colourList.setColour_desc(result.getString("colour_desc"));
     	 
     	 
     	ColourList.add(colourList);
     	 
     	 
      }
    
	      conn.close();
		
     } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
	
	 System.out.print(ColourList.size());
	 return ColourList;
	
	
}
	
public ArrayList<colour> getColourName(int colour_id){
	 ArrayList<colour> ColourList = new ArrayList<colour>();
	 

	 try {
		 conn = ConnectionManagerOracle.getConnectionOracle();
		 String sql = "SELECT colour_id, colour_name, colour_desc FROM colour where colour_id="+colour_id+"";
     Statement statement = conn.createStatement();
     ResultSet result = statement.executeQuery(sql);
     
     
     while (result.next()) {
    	 colour colourName = new colour();
    	 colourName.setColour_id(Integer.parseInt(result.getString("colour_id")));
    	 colourName.setColour_name(result.getString("colour_name"));
    	 colourName.setColour_desc(result.getString("colour_desc"));
    	 
    	 
    	ColourList.add(colourName);
    	
    	if(ColourList.isEmpty())
    	     System.out.printf("ColourList is empty >>",ColourList.toString());
    	else
    		System.out.printf("ColourList have value >>",ColourList.toString());
     }
   
	      conn.close();
		
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
	
	 
	 return ColourList;
	
	
}


//update colour

public String updateColour(ArrayList<colour> UpdColour) throws SQLException{

	for(int i=0;i<UpdColour.size();i++)
	{

		 conn = ConnectionManagerOracle.getConnectionOracle();
		 String query = "UPDATE colour SET colour_name=?, colour_desc=? WHERE colour_id=?";
		
		
		  PreparedStatement preparedStmt = conn.prepareStatement(query);
	     
	      preparedStmt.setString(1, UpdColour.get(i).getColour_name());
	      preparedStmt.setString (2, UpdColour.get(i).getColour_desc());
	      preparedStmt.setInt (3, UpdColour.get(i).getColour_id());
	     

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
public String deleteColour(int colourId) throws SQLException{
	
	conn = ConnectionManagerOracle.getConnectionOracle();
	String query = "DELETE FROM colour where colour_id='"+colourId+"'";
	PreparedStatement preparedStmt = conn.prepareStatement(query);
	//conn.setAutoCommit(true);
	preparedStmt.executeUpdate();
	conn.commit();
	boolean rowDeleted = preparedStmt.executeUpdate() > 0;
	if (rowDeleted) {
        message = "success";
    } else {
        message = "error";
    }
      //System.out.println(query);
      //System.out.println(message);
      //conn.commit();
      preparedStmt.close();
      conn.close();
	
	
	
	return message;
	
	
	
	
}
	
	
	

}
