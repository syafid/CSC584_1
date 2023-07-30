/**
 * MOHD SYAFID ABDULLAH
 * 2021492334 CS240
 * ASSIGNMENT 2 CSC 584
 * Date:10 JAN 2023
 */
package connection;

import java.sql.*;
import java.util.Collection;
//import java.util.Collection;

public class ConnectionManager {

	public static Collection conn2;
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";//"com.mysql.jdbc.Driver"; //"com.mysql.cj.jdbc.Driver"
    public static final String DB_CONNECTION = "jdbc:mysql:/mybajudb";//"jdbc:mysql://localhost/myproject";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "p@ssw0rd1234";
    
    public static Connection getConnection() {

        try {
        	//1. load the driver
            Class.forName(DB_DRIVER);

            try {
            	//2. create connection
                conn2 = (Collection) DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
                System.out.println("connected");

            }

            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return (Connection) conn2;
    }
}
