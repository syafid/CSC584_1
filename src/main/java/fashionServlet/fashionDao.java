package fashionServlet;

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
import materialServlet.material;

public class fashionDao {
	public String message;
	Connection conn=null;
	
	
public String insertNewFashion(ArrayList<fashion> newFash) {
		
		
		
		for(int i=0;i<newFash.size();i++)
		{
		
			
		
			try {

				 conn = ConnectionManagerOracle.getConnectionOracle();
				 
				 String query = " insert into design1 ( design_id, design_name, design_desc, price)"
					        + " values (design_id.nextval, ?, ?, ?)";//
				 
				 PreparedStatement preparedStmt;
				 preparedStmt = conn.prepareStatement(query);
				  //preparedStmt.setInt(1, newMat.get(i).getMaterial_id());//
			      preparedStmt.setString (1, newFash.get(i).getFashion_name());
			      preparedStmt.setString (2, newFash.get(i).getFashion_desc());
			      preparedStmt.setFloat(3, newFash.get(i).getPrice());
			      
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


public ArrayList<fashion> getFashionList(){
	 ArrayList<fashion> FashList = new ArrayList<fashion>();
	 

	 try {
		 conn = ConnectionManagerOracle.getConnectionOracle();
		 String sql = "SELECT design_id, design_name, design_desc, price FROM design1";
       Statement statement = conn.createStatement();
       ResultSet result = statement.executeQuery(sql);
       
       
       while (result.next()) {
      	 fashion fashList = new fashion();
      	 fashList.setFashion_id(Integer.parseInt(result.getString("design_id")));
      	 fashList.setFashion_name(result.getString("design_name"));
      	 fashList.setFashion_desc(result.getString("design_desc"));
      	 fashList.setPrice(Float.parseFloat(result.getString("price")));
      	 
      	 
      	 FashList.add(fashList);
      	 
      	 
       }
     
	      conn.close();
		
      } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
	
	 System.out.print(FashList.size());
	 return FashList;
	
	
}

public ArrayList<fashion> getFashion(int fashId) throws SQLException{
	ArrayList<fashion> fashion = new ArrayList<fashion>();
	
	 try {
		 conn = ConnectionManagerOracle.getConnectionOracle();
		 String query = "SELECT design_id, design_name, price, design_desc FROM design1 where design_id='"+fashId+"'";
		 Statement statement = conn.createStatement();
	     ResultSet result = statement.executeQuery(query);
	     
	     			while (result.next()) {
				        	 fashion fash = new fashion();
				        	 fash.setFashion_id(Integer.parseInt(result.getString("design_id")));
				        	 fash.setFashion_name(result.getString("design_name"));
				        	 fash.setPrice(Float.parseFloat(result.getString("price")));
				        	 fash.setFashion_desc(result.getString("design_desc"));
				        	 
				        	
				        	
				        	 fashion.add(fash); 	
         			}
	     
	     
	      conn.close();
	     
		 }
		 catch(SQLException e){
			 e.printStackTrace();
		 }
	
	 //System.out.print("material array size: "+material.toString());
	return fashion;
	
	
}

public String updateFashion(ArrayList<fashion> UpdFashion) throws SQLException{

	for(int i=0;i<UpdFashion.size();i++)
	{

		 conn = ConnectionManagerOracle.getConnectionOracle();
		 String query = "UPDATE design1 SET design_desc=?, price=? WHERE design_id=?";
		
		
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	     
	      preparedStmt.setString(1, UpdFashion.get(i).getFashion_desc());
	      preparedStmt.setFloat(2, UpdFashion.get(i).getPrice());
	      preparedStmt.setInt (3, UpdFashion.get(i).getFashion_id());
	     

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
public String deleteFashion(int designId) throws SQLException{
	
	conn = ConnectionManagerOracle.getConnectionOracle();
	String query = "DELETE FROM design1 where design_id='"+designId+"'";
	PreparedStatement preparedStmt = conn.prepareStatement(query);
	
	boolean rowDeleted = preparedStmt.executeUpdate() > 0;
	if (rowDeleted) {
        message = "success";
    } else {
        message = "error";
    }
           
      preparedStmt.close();
      conn.close();
	
	
	
	return message;
	
	
	
	
}

}
