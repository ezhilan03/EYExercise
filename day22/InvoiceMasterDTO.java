package EYExercise.day22;

import java.io.Serializable;
import java.sql.Date;


public class InvoiceMasterDTO implements Serializable{
	private int invNo;
	private Date invDate;
	private int customerNo;
	
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
	
	
}
