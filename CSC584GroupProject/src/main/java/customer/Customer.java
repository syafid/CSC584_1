package customer;

public class Customer {
	public int CusID;
	public String CusName;
	public String CusMyKad;
	public String CusPhoneNo;
	public String CusEmail;
	public String CusPasswd;
	public int CusCarType;
	public String CusCarPlate;
	public int CusCurrMileage;
	
	
	public int getCusID() {
		
		return CusID;
	}
	public void setCusID(int cusID) {
		CusID = cusID;
	}
	public String getCusName() {
		return CusName;
	}
	public void setCusName(String cusName) {
		CusName = cusName;
	}
	public String getCusMyKad() {
		return CusMyKad;
	}
	public void setCusMyKad(String cusMyKad) {
		CusMyKad = cusMyKad;
	}
	public String getCusPhoneNo() {
		return CusPhoneNo;
	}
	public void setCusPhoneNo(String cusPhoneNo) {
		CusPhoneNo = cusPhoneNo;
	}
	public String getCusEmail() {
		return CusEmail;
	}
	public void setCusEmail(String cusEmail) {
		CusEmail = cusEmail;
	}
	public int getCusCarType() {
		return CusCarType;
	}
	public void setCusCarType(int cusCarType) {
		CusCarType = cusCarType;
	}
	public String getCusCarPlate() {
		return CusCarPlate;
	}
	public void setCusCarNo(String cusCarPlate) {
		CusCarPlate = cusCarPlate;
	}
	public int getCusCurrMileage() {
		return CusCurrMileage;
	}
	public void setCusCurrMileage(int cusCurrMileage) {
		CusCurrMileage = cusCurrMileage;
	}
	
	 public String toString(){
	        return "[" + CusName + "," + CusMyKad + "]";
	       
	    }
	public String getCusPasswd() {
		return CusPasswd;
	}
	public void setCusPasswd(String cusPasswd) {
		CusPasswd = cusPasswd;
	}
	

}
