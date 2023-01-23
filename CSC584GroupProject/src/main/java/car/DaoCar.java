package car;


import java.sql.Connection;
import connection.ConnectionManager;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;


public class DaoCar {

	public static ArrayList<Car> getResultSet() {

			
	
			ArrayList<Car> service = new ArrayList<Car>();
			

			try {

				 ConnectionManager cm = new ConnectionManager();
				 Connection conn = cm.getConnection();
				
				 String sql = "SELECT distinct carID,carModel,carVariant,carTransmission FROM car";
		         Statement statement = conn.createStatement();
		         ResultSet result = statement.executeQuery(sql);

		         while (result.next()) {

		        	 Car cr = new Car();
		        	 cr.setCarID(result.getInt("carID"));
		        	 cr.setCarModel(result.getString("carModel"));
		        	 cr.setCarVariant(result.getString("carVariant"));
		        	 cr.setCarTransmission(result.getString("carTransmission"));
		             service.add(cr);
		          
		             }
			}
			catch (SQLException e) {
		        e.printStackTrace();
		    }
			return service;
	}
	
	public ArrayList<Car> getCarType(int carType) {
		
		ArrayList<Car> carName = new ArrayList<Car>();
		try {

			 ConnectionManager cm = new ConnectionManager();
			 Connection conn = cm.getConnection();
			 String sql = "SELECT carID, carModel, carVariant, carTransmission FROM car where carID ='" +carType+ "';";
	         Statement statement = conn.createStatement();
	         ResultSet result = statement.executeQuery(sql);

	         while (result.next()) {

	        	 Car cr = new Car();
	        	 cr.setCarID(result.getInt("carID"));
	        	 cr.setCarModel(result.getString("carModel"));
	        	 cr.setCarVariant(result.getString("carVariant"));
	        	 cr.setCarTransmission(result.getString("carTransmission"));
	             carName.add(cr);
	           
	             }
	         System.out.println(sql);
		}
		catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		
	   return carName;
	}


}