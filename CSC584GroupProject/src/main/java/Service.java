import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import java.util.Locale.Category;

public class Service{
	 final String url = "jdbc:mysql:/csc584";
     final String user = "root";
     final String password = "p@ssw0rd1234";

    public int serviceID;
	public String serviceName;
	public String serviceType;
	public float serviceFees;

	 public Service(int id, String name) {
	        super();
	        this.serviceID = id;
	        this.serviceName = name;
	    }

	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceType() {

		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public float getServiceFees() {
		return serviceFees;
	}
	public void setServiceFees(float serviceFees) {
		this.serviceFees = serviceFees;
	}

	public int getServiceID() {
		return serviceID;
	}
	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}

	 public List<Service> list() throws SQLException {
         List<Service> listCategory = new ArrayList<>();

         try (Connection connection = DriverManager.getConnection(url, user, password)) {
             String sql = "SELECT * FROM service ORDER BY serviceID";
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql);

             while (result.next()) {
                 serviceID = result.getInt("ServiceID");
                 serviceName = result.getString("serviceName");
                 Service servis = new Service(serviceID, serviceName);

                 listCategory.add(servis);
             }

         } catch (SQLException ex) {
             ex.printStackTrace();
             throw ex;
         }

         return listCategory;
     }



}
