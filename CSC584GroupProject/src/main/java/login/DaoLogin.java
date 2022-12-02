package login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import user.User;
import login.Login;

public class DaoLogin {
	public static String url = "jdbc:mysql:/csc584";
    public static String user = "root";
    public static String password = "p@ssw0rd1234";
    public String message = null;
     
    
    public static boolean verifyUserPassword(String email,
            String passwd) throws NoSuchAlgorithmException  
    {  
        boolean finalval = true;
        String encryptedpassword = null; 
              
        ArrayList<Login> datalogin = getResultSet(email);  //get userpassword from db
        
        /* decode the userpassword*/
        MessageDigest m = MessageDigest.getInstance("MD5"); 
		m.update(passwd.getBytes());  
		byte[] bytes = m.digest();  
		//StringBuilder s = new StringBuilder();  
		StringBuilder s = new StringBuilder(datalogin.get(0).getUserIdentificationNo());
        for(int x=0; x< bytes.length ;x++)  
        {  
            s.append(Integer.toString((bytes[x] & 0xff) + 0x100, 16).substring(1));  
        }  
        encryptedpassword = s.toString();
        System.out.println("encrypted password " +encryptedpassword);
        System.out.println("key in password " +passwd);
        
          
        /* Check if two passwords are equal */  
        finalval = encryptedpassword.replace("\ufeff","").equalsIgnoreCase(datalogin.get(0).getUserPassword().replace("\ufeff",""));  //.equalsIgnoreCase //equals
        System.out.println("status " +finalval);
        
        return finalval;  
    }  

	public static ArrayList<Login> getResultSet(String email) {
			

			ArrayList<Login> arrlogin = new ArrayList<Login>();
			
			try {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
					
				}
				Connection conn = (Connection) DriverManager.getConnection(url, user, password);
				 String sql = "SELECT userID, userName, userIdentificationNo, userContactNo, userDateOfBirth, userEmail, userPassword, userAccessLevel FROM user where userEmail ='" +email+ "';";
		         Statement statement = conn.createStatement();
		         ResultSet result = statement.executeQuery(sql);
		         Login newlogin = new Login();
		         
		         while (result.next()) {
		        
		        	 newlogin.setUserID(result.getInt("userID"));
		        	 newlogin.setUserName(result.getString("userName"));
		        	 newlogin.setUserIdentificationNo(result.getString("userIdentificationNo"));
		        	 newlogin.setUserContactNo(result.getString("userContactNo"));
		        	 newlogin.setUserEmail(result.getString("userEmail"));
		        	 newlogin.setUserPassword(result.getString("userPassword"));
		        	 newlogin.setUserAccessLevel(result.getString("userAccessLevel"));
		        	 
		        	 arrlogin.add(newlogin);
		        	 
		        	 
		        	 System.out.println(sql);
		             System.out.println("original password " +result.getString("userPassword"));
		            
		             }
			}
			catch (SQLException e) {
		        e.printStackTrace();
		    }
			return arrlogin;
	}

}