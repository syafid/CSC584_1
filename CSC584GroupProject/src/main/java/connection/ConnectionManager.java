package connection;

import java.sql.*;

public class ConnectionManager {

    private static Connection con;
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql:/csc584";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "p@ssw0rd1234";
    
    public static Connection getConnection() {

        try {
        	//1. load the driver
            Class.forName(DB_DRIVER);

            try {
            	//2. create connection
                con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
                System.out.println("connected");

            }

            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return con;
    }
}
