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


public class DaoAppointment {
	String url = "jdbc:mysql:/csc584";
    String user = "root";
    String password = "p@ssw0rd1234";
    public String message = null;
    
	public ArrayList<Appointment> getResultSet() {

		
			//Connection conn;// = null;
			ArrayList<Appointment> service = new ArrayList<Appointment>();

			try /*(Connection con = DriverManager.getConnection(url, user, password))*/{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				Connection conn = (Connection) DriverManager.getConnection(url, user, password);
				 String sql = "SELECT serviceID, serviceName FROM service";
		         Statement statement = conn.createStatement();
		         ResultSet result = statement.executeQuery(sql);

		         while (result.next()) {
		        	 //int i = 0;
		//        	 serviceID = result.getInt("serviceID");
		//        	 serviceName = result.getString("serviceName");
		//        	 AppointmentAdd appAdd = new AppointmentAdd(result.getInt("serviceID"),result.getString("serviceName"));
		        	 Appointment appAdd = new Appointment();
		        	 appAdd.setServiceID(result.getInt("serviceID"));
		        	 appAdd.setServiceName(result.getString("serviceName"));
		             service.add(appAdd);
		             //System.out.println();
		             //System.out.println(result.getString(2));
		             //i++;
		             }
			}
			catch (SQLException e) {
		        e.printStackTrace();
		    }
			return service;
	}
	
	public String AddAppoint(ArrayList<Appointment> newappointment) throws SQLException {
		
		Connection conn = null;
		String appStatus = "NEW";
		
		for(int i=0;i<newappointment.size();i++)
		{

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = (Connection) DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
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
		      
		      
		   // execute the preparedstatement
		      //preparedStmt.execute();
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
	
	public ArrayList<Appointment> AppointList(int cusID) throws SQLException {
		ArrayList<Appointment> appointment = new ArrayList<Appointment>();
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
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
	
	
	public ArrayList<Appointment> getAppointment() throws SQLException {
		ArrayList<Appointment> appointment = new ArrayList<Appointment>();
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			 String sql = "SELECT appID, appDateTime, appStatus, empID, serviceID, carID, cusID FROM appointment where appStatus='NEW' or appStatus='Approve' ";
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
		
	
	
	
public String UpdAppoint(ArrayList<Appointment> newappointment) throws SQLException {
		
		Connection conn = null;
		
		
		for(int i=0;i<newappointment.size();i++)
		{

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = (Connection) DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
//			String query = " insert into appointment (appDateTime, appStatus, empID, serviceID, carID, cusID)"
//			        + " values (?, ?, ?, ?, ?, ?)";
			
			String query = "UPDATE appointment SET appStatus=?, empID=? WHERE AppID=?";
			
			 // create the mysql insert preparedstatement
			  
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString(1, newappointment.get(i).getAppStatus());
		      preparedStmt.setInt (2, newappointment.get(i).getEmpID());
		      preparedStmt.setInt(3, newappointment.get(i).getAppID());

//		      
		      
		   // execute the preparedstatement
		      //preparedStmt.execute();
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

public String DelAppoint(ArrayList<Appointment> newappointment) throws SQLException { //delete record
	
	Connection conn = null;
	
	
	for(int i=0;i<newappointment.size();i++)
	{

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
//		
		
		String query = "DELETE from appointment WHERE AppID=?";
		
		 // create the mysql insert preparedstatement
		  
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	     // preparedStmt.setString(1, newappointment.get(i).getAppStatus());
	      //preparedStmt.setInt (2, newappointment.get(i).getEmpID());
	      preparedStmt.setInt(1, newappointment.get(i).getAppID());

//	      
	      
	   // execute the preparedstatement
	      //preparedStmt.execute();
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


public ArrayList<Appointment> AppointListByTech(int empID) throws SQLException {
	ArrayList<Appointment> appointment = new ArrayList<Appointment>();
	try {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		Connection conn = (Connection) DriverManager.getConnection(url, user, password);
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

//public String CancelAppoint(ArrayList<Appointment> newappointment) throws SQLException {
//	
//	Connection conn = null;
//	String appStatus = "NEW";
//	
//	for(int i=0;i<newappointment.size();i++)
//	{
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = (Connection) DriverManager.getConnection(url, user, password);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}
//		
//		String query = " insert into appointment (appDateTime, appStatus, empID, serviceID, carID, cusID)"
//		        + " values (?, ?, ?, ?, ?, ?)";
//		
//		 // create the mysql insert preparedstatement
//		  System.out.println(newappointment.size());
//		  System.out.println(newappointment.get(i).getAppDate());
//	      PreparedStatement preparedStmt = conn.prepareStatement(query);
//	      preparedStmt.setObject(1, newappointment.get(i).getAppDate());//
//	      preparedStmt.setString (2, newappointment.get(i).getAppStatus());
//	      preparedStmt.setInt (3, newappointment.get(i).getEmpID());
//	      preparedStmt.setInt (4, newappointment.get(i).getServiceID());//
//	      preparedStmt.setInt (5, newappointment.get(i).getCarID());//
//	      preparedStmt.setInt (6, newappointment.get(i).getCusID());//
//	      
//	      
//	   // execute the preparedstatement
//	      //preparedStmt.execute();
//	      boolean rowInserted = preparedStmt.executeUpdate() > 0;
//	      
//	     
//	        if (rowInserted) {
//	            message = "success";
//	        } else {
//	            message = "error";
//	        }
//	      System.out.println(query);
//	      System.out.println(message);
//	      
//	      preparedStmt.close();
//	      conn.close();
//	      
//	
//	
//
//	
//		}
//	return message;
//
//	
//	}
	}