package test;
import java.io.Serializable;

public class StudentBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String serviceName;
	private String serviceID;

	public StudentBean(String name, String id){
		this.serviceName = name;
		this.serviceID = id;

	}


	    public String getName(String name) {
	        return serviceName;
	    }

//	    public void setName(String name) {
//	        this.serviceName = name;
//	    }

	    public String getId(String id) {
	        return serviceID;
	    }

//	    public void setId(String id) {
//	        this.serviceID = id;
//	    }
	}
