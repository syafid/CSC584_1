package user;


import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;


public class DaoUser {

	//private Connection conn;
//	private String url;
//	private String user;
//	private String password;
	public String url = "jdbc:mysql:/csc584";
    public String user = "root";
    public String password = "p@ssw0rd1234";
    public String message = null;

	public ArrayList<User> getResultSet() {

//			String url = "jdbc:mysql:/csc584";
//		    String user = "root";
//		    String password = "p@ssw0rd1234";
			//Connection conn;// = null;
			ArrayList<User> service = new ArrayList<User>();

			try /*(Connection con = DriverManager.getConnection(url, user, password))*/{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				Connection conn = (Connection) DriverManager.getConnection(url, user, password);
				 String sql = "SELECT cusID,cusName FROM customer";
		         Statement statement = conn.createStatement();
		         ResultSet result = statement.executeQuery(sql);

		         while (result.next()) {
		        	 //int i = 0;
		//        	 serviceID = result.getInt("serviceID");
		//        	 serviceName = result.getString("serviceName");
		//        	 AppointmentAdd appAdd = new AppointmentAdd(result.getInt("serviceID"),result.getString("serviceName"));
		        	 User user = new User();
		        	 user.setUserName(result.getString("username"));
		        	 
		             service.add(user);
		            
		             }
			}
			catch (SQLException e) {
		        e.printStackTrace();
		    }
			return service;
	}
	
//	


	public String CreateUser(ArrayList<User> newuser) throws SQLException {
		Connection conn = null;
		String encryptedpassword = null;  
		for(int i=0;i<newuser.size();i++)
		{
			//System.out.println(newcustomer.get(i).getCusName());

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		try {	
			String userpass = newuser.get(i).getUserPassword();
			MessageDigest m = MessageDigest.getInstance("MD5"); 
			m.update(userpass.getBytes());  
			byte[] bytes = m.digest();  
			StringBuilder s = new StringBuilder();  
            for(int x=0; x< bytes.length ;x++)  
            {  
                s.append(Integer.toString((bytes[x] & 0xff) + 0x100, 16).substring(1));  
            }  
            encryptedpassword = s.toString();
			
			
			
		 String query = " insert into user (userName, userIdentificationNo, userContactNo, userDateOfBirth, userEmail, userPassword)"
		        + " values (?, ?, ?, ?, ?, ?)";
		
		 // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, newuser.get(i).getUserName());
	      preparedStmt.setString (2, newuser.get(i).getUserIdentificationNo());
	      preparedStmt.setString (3, newuser.get(i).getUserContactNo());
	      preparedStmt.setString (4, newuser.get(i).getUserDateOfBirth());
	      preparedStmt.setString (5, newuser.get(i).getUserEmail());
	      preparedStmt.setString (6, encryptedpassword);
	      
	      
	   // execute the preparedstatement
	      //preparedStmt.execute();
	      boolean rowInserted = preparedStmt.executeUpdate() > 0;
	      
	     
	        if (rowInserted) {
	            message = "success";
	        } else {
	            message = "error";
	        }
	      
	      conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}//for
		
		return message;
		
		// TODO Auto-generated method stub
		
		
		
	}


}