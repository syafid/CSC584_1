package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManagerOracle {
	public static Connection conn;
	
	
	
	public static Connection getConnectionOracle() throws SQLException {
		
	        String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	        String USER = "baju";
	        String PASS = "baju@12345";


	        try {
	              Class.forName("oracle.jdbc.driver.OracleDriver");
	              conn = DriverManager.getConnection(URL, USER, PASS);
	              
	            }
	        catch(ClassNotFoundException ex) 
	        {
	              System.out.println("Error: unable to load driver class!");
	               System.exit(1);
	        }
	        return conn;  
		
//	try { 
//		
//        String dbURL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=localdb)))";
//        String strUserID = "baju";
//        String strPassword = "baju@12345";
//        Connection myConnection=DriverManager.getConnection(dbURL,strUserID,strPassword);
//
//        Statement sqlStatement = myConnection.createStatement();
//        String readRecordSQL = "select * from customer";  
//        ResultSet myResultSet = sqlStatement.executeQuery(readRecordSQL);
//        while (myResultSet.next()) {
//            System.out.println("Record values: " + myResultSet.getString("NAME"));
//        }
//        myResultSet.close();
//        myConnection.close();
//
//    } catch (Exception e) {
//        System.out.println(e);
//    }
	     
}
}
