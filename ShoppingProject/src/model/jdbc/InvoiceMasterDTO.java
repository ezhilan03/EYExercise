package model.jdbc;

import java.io.Serializable;
import java.sql.Date;


public class InvoiceMasterDTO implements Serializable,Cloneable{
	private int invNo;
	private Date invDate;
	private int customerNo;
	private static InvoiceMasterDTO invoiceMasterDTO;
	
	private InvoiceMasterDTO() {
		// TODO Auto-generated constructor stub
	}
	
	synchronized public static InvoiceMasterDTO getInvoiceMasterDTO() {
		if(invoiceMasterDTO==null) {
			invoiceMasterDTO=new InvoiceMasterDTO();
			return invoiceMasterDTO;
		}
		else {
			return invoiceMasterDTO.createClone();
		}
	}
	
	public InvoiceMasterDTO createClone(){
		try {
			return (InvoiceMasterDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public final int getInvno() {
		return invNo;
	}
	public final void setInvno(int invno) {
		this.invNo = invno;
	}
	public final Date getInvdate() {
		return invDate;
	}
	public final void setInvdate(Date invdate) {
		this.invDate = invdate;
	}
	public final int getCustomerno() {
		return customerNo;
	}
	public final void setCustomerno(int customerno) {
		this.customerNo = customerno;
	}
	
	@Override
	public String toString() {
		return "InvoiceMasterDTO [invno=" + invNo + ", invdate=" + invDate + ", customerno=" + customerNo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerNo;
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + invNo;
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
		InvoiceMasterDTO other = (InvoiceMasterDTO) obj;
		if (customerNo != other.customerNo)
			return false;
		if (invDate == null) {
			if (other.invDate != null)
				return false;
		} else if (!invDate.equals(other.invDate))
			return false;
		if (invNo != other.invNo)
			return false;
		return true;
	}

	public InvoiceMasterDTO(int invNo, Date invDate, int customerNo) {
		super();
		this.invNo = invNo;
		this.invDate = invDate;
		this.customerNo = customerNo;
	}
	
	
}
