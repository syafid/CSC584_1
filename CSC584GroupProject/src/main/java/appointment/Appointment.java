package appointment;

import java.util.Date;
//import java.sql.Timestamp;

public class Appointment {
	public int appID;
	public int serviceID;
 	public String serviceName;
 	public String appStatus;
 	public int empID;
 	public int carID;
 	public Date appDate;
 	public int cusID;
 	
 	

 	public int getServiceID() {
		return serviceID;
	}
	public void setServiceID(int id) {
		this.serviceID = id;
	}
	public String getServiceName() { //String name
		return serviceName;
	}
	public void setServiceName(String name) {
		this.serviceName = name;
	}
	public String getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	
	public int getCusID() {
		return cusID;
	}
	public void setCusID(int cusID) {
		this.cusID = cusID;
	}
	public int getAppID() {
		return appID;
	}
	public void setAppID(int appID) {
		this.appID = appID;
	}
	
	public Date getAppDate() {
		return appDate;
	}
	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}



}
