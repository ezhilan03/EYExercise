package annopack;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	private int eid;
	
	@Column(name = "ename", nullable = false)
	private String ename;
	
	private int esal;
	
	@Column(name = "joiningDate", nullable = false)
	//@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate joiningDate;
	
	
	public final LocalDate getJoiningDate() {
		return joiningDate;
	}
	public final void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public final int getEid() {
		return eid;
	}
	public final void setEid(int eid) {
		this.eid = eid;
	}
	public final String getEname() {
		return ename;
	}
	public final void setEname(String ename) {
		this.ename = ename;
	}
	public final int getEsal() {
		return esal;
	}
	public final void setEsal(int esal) {
		this.esal = esal;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", joiningDate=" + joiningDate
				+ ", addresses="  + "]";
	}
	
	
}
