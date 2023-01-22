package service;

import java.sql.Connection;
import connection.ConnectionManager;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class DaoService {
	
//	public static String url = "jdbc:mysql:/csc584";
//    public static String user = "root";
//    public static String password = "p@ssw0rd1234";


	
	
	public static ArrayList<Service> list(){
        final ArrayList<Service> listCategory = new ArrayList<>();
        
         ConnectionManager cm = new ConnectionManager();
		 Connection conn = cm.getConnection();

         try /*(Connection connection = DriverManager.getConnection(url, user, password))*/ {
             String sql = "SELECT * FROM service ORDER BY serviceID";
             Statement statement = conn.createStatement();
             ResultSet result = statement.executeQuery(sql);
             
             while (result.next()) {
            	 Service service = new Service();
                 service.setServiceID(result.getInt("ServiceID"));
                 service.setServiceName(result.getString("serviceName"));
                

                 listCategory.add(service);
             }

         } catch (SQLException e) {
		        e.printStackTrace();
         }

         return listCategory;
     }
	
	public static ArrayList<Service> ServiceDetail(int serviceID){
        final ArrayList<Service> serviceList = new ArrayList<>();
        
         ConnectionManager cm = new ConnectionManager();
		 Connection conn = cm.getConnection();
		 
         try /*(Connection connection = DriverManager.getConnection(url, user, password))*/ {
             String sql = "SELECT serviceID, serviceName, serviceType, serviceFees FROM service where serviceID='" +serviceID+ "';";
             Statement statement = conn.createStatement();
             ResultSet result = statement.executeQuery(sql);
             
             while (result.next()) {
            	 Service service = new Service();
                 service.setServiceID(result.getInt("ServiceID"));
                 service.setServiceName(result.getString("serviceName"));
                 service.setServiceType(result.getString("serviceType"));
                 service.setServiceFees(result.getFloat("serviceFees"));

                 serviceList.add(service);
             }

         } catch (SQLException e) {
		        e.printStackTrace();
         }

         return serviceList;
     }

}
