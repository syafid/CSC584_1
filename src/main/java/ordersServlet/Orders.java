/**
 * MOHD SYAFID ABDULLAH
 * 2021492334 CS240
 * ASSIGNMENT 2 CSC 584
 * Date:10 JAN 2023
 */
package ordersServlet;

//import java.util.Date; //takboleh guna
import java.sql.Date;
//import java.time.LocalDate;
import java.sql.Timestamp;
import tailorServlet.tailor;

public class Orders {
	private int orderId;
	private int CustomerId;
	private Date dateCreated;
	//private Date dateCollect;
	private float amount;
	private float sleeve;
	private float shoulder;
	private float chest;
	private float topLength;
	private float waist;
	private float hip;
	private float bottomLength;
	private int tailor_id;
	private int orders_status;
	private int material_id;
	private int design_id;
	private int colour_id;
	private Date dateCompleted;
	private int payment_id;
	
	
	public Orders() {
		
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


//	public Date getDateCollect() {
//		return dateCollect;
//	}


//	public void setDateCollect(Date daCol) {
//		this.dateCollect = daCol;
//	}


//	public float getAmount() {
//		return amount;
//	}
//
//
//	public void setAmount(float amount) {
//		this.amount = amount;
//	}


	public float getSleeve() {
		return sleeve;
	}


	public void setSleeve(float sleeve) {
		this.sleeve = sleeve;
	}


	public float getShoulder() {
		return shoulder;
	}


	public void setShoulder(float shoulder) {
		this.shoulder = shoulder;
	}


	public float getChest() {
		return chest;
	}


	public void setChest(float chest) {
		this.chest = chest;
	}


	public float getTopLength() {
		return topLength;
	}


	public void setTopLength(float topLength) {
		this.topLength = topLength;
	}


	public float getWaist() {
		return waist;
	}


	public void setWaist(float waist) {
		this.waist = waist;
	}


	public float getHip() {
		return hip;
	}


	public void setHip(float hip) {
		this.hip = hip;
	}


	public float getBottomLength() {
		return bottomLength;
	}


	public void setBottomLength(float bottomLength) {
		this.bottomLength = bottomLength;
	}


	public int getCustomerId() {
		return CustomerId;
	}


	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}


	public int getTailor_id() {
		return tailor_id;
	}


	public void setTailor_id(int tailor_id) {
		this.tailor_id = tailor_id;
	}


	public int getOrders_status() {
		return orders_status;
	}


	public void setOrders_status(int orders_status) {
		this.orders_status = orders_status;
	}


	public int getMaterial_id() {
		return material_id;
	}


	public void setMaterial_id(int material_id) {
		this.material_id = material_id;
	}


	public int getDesign_id() {
		return design_id;
	}


	public void setDesign_id(int design_id) {
		this.design_id = design_id;
	}


	public int getColour_id() {
		return colour_id;
	}


	public void setColour_id(int colour_id) {
		this.colour_id = colour_id;
	}


	public Date getDateCompleted() {
		return dateCompleted;
	}


	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}


	public int getPayment_id() {
		return payment_id;
	}


	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}


	

}
