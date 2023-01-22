package customer;
 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionManager;
import user.User;
import login.Login;
import connection.ConnectionManager;

public class DaoCustomerLogin {
//	public static String url = "jdbc:mysql:/csc584";
//    public static String user = "root";
//    public static String password = "p@ssw0rd1234";
    public String message = null;
     
    
    public static boolean verifyUserPassword(String email,
            String passwd) throws NoSuchAlgorithmException  
    {  
        boolean finalval = true;
        String encryptedpassword = null; 
              
        ArrayList<Customer> datalogin = getResultSet(email);  //get userpassword from db
        for(int i=0; i<datalogin.size();i++) {
        /* decode the userpassword*/
        MessageDigest m = MessageDigest.getInstance("MD5"); 
		m.update(passwd.getBytes());  
		byte[] bytes = m.digest();  
		//StringBuilder s = new StringBuilder();  
		StringBuilder s = new StringBuilder(datalogin.get(i).getCusMyKad());
        for(int x=0; x< bytes.length ;x++)  
        {  
            s.append(Integer.toString((bytes[x] & 0xff) + 0x100, 16).substring(1));  
        }  
        encryptedpassword = s.toString();
        System.out.println("encrypted password " +encryptedpassword);
        System.out.println("key in password " +passwd);
        
          
        /* Check if two passwords are equal */  
        finalval = encryptedpassword.equalsIgnoreCase(datalogin.get(i).getCusPasswd());  //.equalsIgnoreCase //equals
        System.out.println("status " +finalval);
        }
        return finalval;  
        
    }  

	public static ArrayList<Customer> getResultSet(String email) {
			

			ArrayList<Customer> arrlogin = new ArrayList<Customer>();

			try {
//				try {
//					Class.forName("com.mysql.cj.jdbc.Driver");
//				} catch (ClassNotFoundException e) {
//					
//					e.printStackTrace();
//					
//				}
//				Connection conn = (Connection) DriverManager.getConnection(url, user, password);
				 ConnectionManager cm = new ConnectionManager();
				 Connection conn = cm.getConnection();
				 
				 String sql = "SELECT cusID, cusName, cusMyKad, cusEmail, cusPasswd, cusCarType, cusCarPlate, cusCurrMileage FROM customer where cusEmail ='" +email+ "'";
		         Statement statement = conn.createStatement();
		         ResultSet result = statement.executeQuery(sql);

		         while (result.next()) {
		        	 Customer cusLogin = new Customer();
		        	 cusLogin.setCusID(result.getInt("cusID"));
		        	 cusLogin.setCusName(result.getString("cusName"));
		        	 cusLogin.setCusMyKad(result.getString("cusMyKad"));
		        	 cusLogin.setCusEmail(result.getString("cusEmail"));
		        	 cusLogin.setCusPasswd(result.getString("cusPasswd"));
		        	 cusLogin.setCusCarType(result.getInt("cusCarType"));
		        	 cusLogin.setCusCarNo(result.getString("cusCarPlate"));
		        	 cusLogin.setCusCurrMileage(result.getInt("cusCurrMileage"));
		        	 
		        	 arrlogin.add(cusLogin);
		        	 
		        	 
		        	 System.out.println(sql);
		             //System.out.println("original password " +result.getString("cusPasswd"));
		            
		             }
			}
			catch (SQLException e) {
		        e.printStackTrace();
		    }
			return arrlogin;
	}
	
	
	public static ArrayList<Customer> getSessionSet(String cusID) {
		ArrayList<Customer> cusSess = new ArrayList<Customer>();
		
		try {
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//			} catch (ClassNotFoundException e) {
//				
//				e.printStackTrace();
//				
//			}
//			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			 ConnectionManager cm = new ConnectionManager();
			 Connection conn = cm.getConnection();
			 
			 String sql = "SELECT cusID, cusName, cusMyKad, cusEmail, cusPasswd, cusCarType, cusCarPlate, cusCurrMileage FROM customer where cusID ='" +cusID+ "';";
	         Statement statement = conn.createStatement();
	         ResultSet result = statement.executeQuery(sql);

	         while (result.next()) {
	        	 Customer cusLogin = new Customer();
	        	 cusLogin.setCusID(result.getInt("cusID"));
	        	 cusLogin.setCusName(result.getString("cusName"));
	        	 cusLogin.setCusMyKad(result.getString("cusMyKad"));
	        	 cusLogin.setCusEmail(result.getString("cusEmail"));
	        	 cusLogin.setCusPasswd(result.getString("cusPasswd"));
	        	 cusLogin.setCusCarType(result.getInt("cusCarType"));
	        	 cusLogin.setCusCarNo(result.getString("cusCarPlate"));
	        	 cusLogin.setCusCurrMileage(result.getInt("cusCurrMileage"));
	        	 
	        	 cusSess.add(cusLogin);
	        	 
	        	 
	        	 System.out.println(sql);
	             //System.out.println("original password " +result.getString("cusPasswd"));
	            
	             }
		}
		catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return cusSess;
	}

}
