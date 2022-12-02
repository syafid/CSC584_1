package service;

public class Service {

	public int serviceID;
	public String serviceName;
	public String serviceType;
	public float serviceFees;

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
}
