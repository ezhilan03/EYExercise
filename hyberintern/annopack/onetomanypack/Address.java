package annopack.onetomanypack;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="address")
@Table(name="address")
public class Address {
	@Id //@GeneratedValue(strategy=GenerationType.AUTO)
	private int aid;
	
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	private String street;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name="employee_eid" )
	public Employee employee;
	
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


}
