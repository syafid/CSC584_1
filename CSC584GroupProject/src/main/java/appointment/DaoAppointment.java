package appointment;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;


import customer.Customer;
import connection.ConnectionManager;


public class DaoAppointment {
	
    public String message = null;

    
//GET SERVICE LIST FROM SERVICE TABLE//
	public ArrayList<Appointment> getResultSet() {

		
			//Connection conn;// = null;
			ArrayList<Appointment> service = new ArrayList<Appointment>();

			try {
				 ConnectionManager cm = new ConnectionManager();
				 Connection conn = cm.getConnection();
				 String sql = "SELECT serviceID, serviceName FROM service";
		         Statement statement = conn.createStatement();
		         ResultSet result = statement.executeQuery(sql);

		         while (result.next()) {
		        	
		        	 Appointment appAdd = new Appointment();
		        	 appAdd.setServiceID(result.getInt("serviceID"));
		        	 appAdd.setServiceName(result.getString("serviceName"));
		             service.add(appAdd);
		            
		             }
			}
			catch (SQLException e) {
		        e.printStackTrace();
		    }
			return service;
	}
	
//ADD NEW APPOINTMENT BY CUSTOMER//
	public String AddAppoint(ArrayList<Appointment> newappointment) throws SQLException {
		
		//Connection conn = null;
		String appStatus = "NEW";
		
		for(int i=0;i<newappointment.size();i++)
		{


			
			 ConnectionManager cm = new ConnectionManager();
			 Connection conn = cm.getConnection();
			
			String query = " insert into appointment (appDateTime, appStatus, empID, serviceID, carID, cusID)"
			        + " values (?, ?, ?, ?, ?, ?)";
			
			 // create the mysql insert preparedstatement
			  System.out.println(newappointment.size());
			  System.out.println(newappointment.get(i).getAppDate());
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setObject(1, newappointment.get(i).getAppDate());//
		      preparedStmt.setString (2, newappointment.get(i).getAppStatus());
		      preparedStmt.setInt (3, newappointment.get(i).getEmpID());
		      preparedStmt.setInt (4, newappointment.get(i).getServiceID());//
		      preparedStmt.setInt (5, newappointment.get(i).getCarID());//
		      preparedStmt.setInt (6, newappointment.get(i).getCusID());//
		      
		      
		   
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

//GET APPOINTMENT LIST BY CUSTOMER //
	public ArrayList<Appointment> AppointList(int cusID) throws SQLException {
		ArrayList<Appointment> appointment = new ArrayList<Appointment>();
		try {
//			
			 ConnectionManager cm = new ConnectionManager();
			 Connection conn = cm.getConnection();
			 
			 String sql = "SELECT appID, appDateTime, appStatus, empID, serviceID, carID, cusID FROM appointment where cusID="+cusID+"";
	         Statement statement = conn.createStatement();
	         ResultSet result = statement.executeQuery(sql);

	         while (result.next()) {
	        	
	        	 Appointment appAdd = new Appointment();
	        	 
	        	 appAdd.setAppID(result.getInt("appID"));
	        	 appAdd.setAppDate(result.getTimestamp("appDateTime"));
	        	 appAdd.setAppStatus(result.getString("appStatus"));
	        	 appAdd.setEmpID(result.getInt("empID"));
	        	 appAdd.setServiceID(result.getInt("serviceID"));
	        	 appAdd.setCarID(result.getInt("carID"));
	        	 appAdd.setCusID(result.getInt("cusID"));
	        	
	             appointment.add(appAdd);
	            
	             }
		}
		catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return appointment;
		
	}
	
//GET APPOINTMENT LIST BY SUPERVISOR//
	public ArrayList<Appointment> getAppointment() throws SQLException {
		ArrayList<Appointment> appointment = new ArrayList<Appointment>();
		try {

			 ConnectionManager cm = new ConnectionManager();
			 Connection conn = cm.getConnection();
			 String sql = "SELECT appID, appDateTime, appStatus, empID, serviceID, carID, cusID FROM appointment where appStatus='NEW' or appStatus='Approve' ORDER BY appStatus";
	         Statement statement = conn.createStatement();
	         ResultSet result = statement.executeQuery(sql);

	         while (result.next()) {
	        	
	        	 Appointment appAdd = new Appointment();
	        	 
	        	 appAdd.setAppID(result.getInt("appID"));
	        	 appAdd.setAppDate(result.getTimestamp("appDateTime"));
	        	 appAdd.setAppStatus(result.getString("appStatus"));
	        	 appAdd.setEmpID(result.getInt("empID"));
	        	 appAdd.setServiceID(result.getInt("serviceID"));
	        	 appAdd.setCarID(result.getInt("carID"));
	        	 appAdd.setCusID(result.getInt("cusID"));
	        	
	             appointment.add(appAdd);
	            
	             }
		}
		catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return appointment;
		
	}
		
	
	
//UPDATE APPOINTMENT BY SUPERVISOR//	
public String UpdAppoint(ArrayList<Appointment> newappointment) throws SQLException {
		

		
		
		for(int i=0;i<newappointment.size();i++)
		{


			 ConnectionManager cm = new ConnectionManager();
			 Connection conn = cm.getConnection();
			 String query = "UPDATE appointment SET appStatus=?, empID=? WHERE AppID=?";
			
			
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString(1, newappointment.get(i).getAppStatus());
		      preparedStmt.setInt (2, newappointment.get(i).getEmpID());
		      preparedStmt.setInt(3, newappointment.get(i).getAppID());

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
//GET APPOINTMENT BY ID//
public ArrayList<Appointment> GetAppt(int AppID) throws SQLException { 
	ArrayList<Appointment> appointment = new ArrayList<Appointment>();

		try {

			ConnectionManager cm = new ConnectionManager();
			Connection conn = cm.getConnection();
			 
			String query = "SELECT appID, appDateTime, appStatus, empID, serviceID, carID, cusID from appointment WHERE appID="+AppID+"";
			
			Statement statement = conn.createStatement();
	        ResultSet result = statement.executeQuery(query);
	
		        while (result.next()) {
		       	
		       	 Appointment appAdd = new Appointment();
		       	 
		       	 appAdd.setAppID(result.getInt("appID"));
		       	 appAdd.setAppDate(result.getTimestamp("appDateTime"));
		       	 appAdd.setAppStatus(result.getString("appStatus"));
		       	 appAdd.setEmpID(result.getInt("empID"));
		       	 appAdd.setServiceID(result.getInt("serviceID"));
		       	 appAdd.setCarID(result.getInt("carID"));
		       	 appAdd.setCusID(result.getInt("cusID"));
		       	
		       	
		            appointment.add(appAdd);
		           
		            }
		        
		}
		
		catch (SQLException e) {
	       e.printStackTrace();
		}
		
		
		
	
	return appointment;
	
	
		
	
	
	
}




//DELETE APPOINTMENT BY CUSTOMER//
public String DelAppoint(ArrayList<Appointment> newappointment) throws SQLException { 

	for(int i=0;i<newappointment.size();i++)
	{


		 ConnectionManager cm = new ConnectionManager();
		 Connection conn = cm.getConnection();
		 
		String query = "DELETE from appointment WHERE AppID=?";
		
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	    
	      preparedStmt.setInt(1, newappointment.get(i).getAppID());


	      boolean rowInserted = preparedStmt.executeUpdate() > 0;
	      
	     
	        if (rowInserted) {
	            message = "success";
	        } else {
	            message = "error";
	        }
	      System.out.println(query);
	      System.out.println(message);
	      System.out.println(newappointment.get(i).getAppID());
	      preparedStmt.close();
	      conn.close();
	      
	
	

	
		}
	return message;

	
	}

//GET APPOINTMENT LIST BY TECHNICIAN//
public ArrayList<Appointment> AppointListByTech(int empID) throws SQLException {
	ArrayList<Appointment> appointment = new ArrayList<Appointment>();
	try {

		 ConnectionManager cm = new ConnectionManager();
		 Connection conn = cm.getConnection();
		 String sql = "SELECT appID, appDateTime, appStatus, empID, serviceID, carID, cusID FROM appointment where appStatus='Approve' and empID="+empID+"";
         Statement statement = conn.createStatement();
         ResultSet result = statement.executeQuery(sql);

         while (result.next()) {
        	
        	 Appointment appAdd = new Appointment();
        	 
        	 appAdd.setAppID(result.getInt("appID"));
        	 appAdd.setAppDate(result.getTimestamp("appDateTime"));
        	 appAdd.setAppStatus(result.getString("appStatus"));
        	 appAdd.setEmpID(result.getInt("empID"));
        	 appAdd.setServiceID(result.getInt("serviceID"));
        	 appAdd.setCarID(result.getInt("carID"));
        	 appAdd.setCusID(result.getInt("cusID"));
        	
             appointment.add(appAdd);
            
             }
	}
	catch (SQLException e) {
        e.printStackTrace();
    }
	
	return appointment;
	
}


	}