package materialServlet;

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
import materialServlet.material;
import ordersServlet.Orders;

public class MaterialDao {
	public String message;
	Connection conn=null;
	
public String insertNewMaterial(ArrayList<material> newMat) {
		
		
		
		for(int i=0;i<newMat.size();i++)
		{
		
			
		
			try {

				 conn = ConnectionManagerOracle.getConnectionOracle();
				 
				 String query = " insert into material ( material_id, material_code, material_name)"
					        + " values (material_id.nextval, ?, ?)";//
				 
				 PreparedStatement preparedStmt;
				 preparedStmt = conn.prepareStatement(query);
				  //preparedStmt.setInt(1, newMat.get(i).getMaterial_id());//
			      preparedStmt.setString (1, newMat.get(i).getMaterial_code());
			      preparedStmt.setString (2, newMat.get(i).getMaterial_name());
			      
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

public ArrayList<material> getMaterialList(){
	 ArrayList<material> MatList = new ArrayList<material>();
	 

	 try {
		 conn = ConnectionManagerOracle.getConnectionOracle();
		 String sql = "SELECT material_id, material_code, material_name FROM material";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        
        while (result.next()) {
       	 material matList = new material();
       	 matList.setMaterial_id(Integer.parseInt(result.getString("material_id")));
       	 matList.setMaterial_code(result.getString("material_code"));
       	 matList.setMaterial_name(result.getString("material_name"));
       	 
       	 
       	 MatList.add(matList);
       	 
       	 
        }
      
	      conn.close();
		
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
	
	 System.out.print(MatList.size());
	 return MatList;
	
	
}


public ArrayList<material> getMaterialName(int matId) throws SQLException{
	ArrayList<material> material = new ArrayList<material>();
	
	 try {
		 conn = ConnectionManagerOracle.getConnectionOracle();
		 String query = "SELECT * FROM material where material_id='"+matId+"'";
		 Statement statement = conn.createStatement();
	     ResultSet result = statement.executeQuery(query);
	     
	     			while (result.next()) {
				        	 material mtrl = new material();
				        	 mtrl.setMaterial_id(Integer.parseInt(result.getString("material_id")));
				        	 mtrl.setMaterial_code(result.getString("material_code"));
				        	 mtrl.setMaterial_name(result.getString("material_name"));
				        	 
				        	 System.out.print(result.getString("material_name"));
				        	
				        	 material.add(mtrl); 	
         			}
	     
	     
	      conn.close();
	     
		 }
		 catch(SQLException e){
			 e.printStackTrace();
		 }
	
	 System.out.print("material array size: "+material.toString());
	return material;
	
	
}

//update material
public String updateMaterial(ArrayList<material> UpdMaterial) throws SQLException{

	for(int i=0;i<UpdMaterial.size();i++)
	{

		 conn = ConnectionManagerOracle.getConnectionOracle();
		 String query = "UPDATE material SET material_code=?, material_name=? WHERE material_id=?";
		
		
		  PreparedStatement preparedStmt = conn.prepareStatement(query);
	     
	      preparedStmt.setString(1, UpdMaterial.get(i).getMaterial_code());
	      preparedStmt.setString (2, UpdMaterial.get(i).getMaterial_name());
	      preparedStmt.setInt (3, UpdMaterial.get(i).getMaterial_id());
	     

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

public String deleteMaterial(int materialId) throws SQLException{
	
	conn = ConnectionManagerOracle.getConnectionOracle();
	String query = "DELETE FROM material where material_id='"+materialId+"'";
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
