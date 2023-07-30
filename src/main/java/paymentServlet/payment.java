package paymentServlet;

import java.sql.Date;

public class payment {
	private int payment_id;
	private Date payment_date;
	private int order_id;
	private int customer_id;
	private int verify_by;
	private int payment_status;
	
	public payment() {
		
		
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getVerify_by() {
		return verify_by;
	}

	public void setVerify_by(int verify_by) {
		this.verify_by = verify_by;
	}

	public int getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}
	
	
	

}
