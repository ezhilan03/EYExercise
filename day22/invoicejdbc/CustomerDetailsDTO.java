package InternExercise.day22.invoicejdbc;

import java.io.Serializable;

public class CustomerDetailsDTO implements Serializable{
	private int customerNo;
	private String customerName;
	private String customerAddress;
	private String customerEmail;
	private long customerPhone;
	
	public final String getCustomerName() {
		return customerName;
	}
	public final void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public final int getCustomerNo() {
		return customerNo;
	}
	public final void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	public final String getCustomerAddress() {
		return customerAddress;
	}
	public final void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public final String getCustomerEmail() {
		return customerEmail;
	}
	public final void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public final long getCustomerPhone() {
		return customerPhone;
	}
	public final void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}
	@Override
	public String toString() {
		return "CustomerDetailsDTO [customerNo=" + customerNo + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerEmail=" + customerEmail + ", customerPhone=" + customerPhone + "]";
	}
	

	
	
}
