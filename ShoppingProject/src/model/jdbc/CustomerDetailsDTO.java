package model.jdbc;

import java.io.Serializable;

public class CustomerDetailsDTO implements Serializable,Cloneable{
	private int customerNo;
	private String customerName;
	private String customerAddress;
	private String customerEmail;
	private long customerPhone;
	private static CustomerDetailsDTO customerDetailsDTO;
	
	private CustomerDetailsDTO() {
		// TODO Auto-generated constructor stub
	}
	
	synchronized public static CustomerDetailsDTO getCustomerDetailsDTO() {
		if(customerDetailsDTO==null) {
			customerDetailsDTO=new CustomerDetailsDTO();
			return customerDetailsDTO;
		}
		else {
			return customerDetailsDTO.createClone();
		}
	}
	
	public CustomerDetailsDTO createClone(){
		try {
			return (CustomerDetailsDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result + ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + customerNo;
		result = prime * result + (int) (customerPhone ^ (customerPhone >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDetailsDTO other = (CustomerDetailsDTO) obj;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerEmail == null) {
			if (other.customerEmail != null)
				return false;
		} else if (!customerEmail.equals(other.customerEmail))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerNo != other.customerNo)
			return false;
		if (customerPhone != other.customerPhone)
			return false;
		return true;
	}

	public CustomerDetailsDTO(int customerNo, String customerName, String customerAddress, String customerEmail,
			long customerPhone) {
		super();
		this.customerNo = customerNo;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
	}
	

	
	
}
