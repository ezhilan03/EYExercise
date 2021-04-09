package annopack.onetomanypack;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="employee")
@Table(name="employee")
public class Employee {
	@Id //@GeneratedValue(strategy=GenerationType.AUTO)
	private int eid;

	private int getEid() {
		return eid;
	}
	private String ename;

	private float esalary;
	
	@OneToMany(cascade={CascadeType.ALL},
			fetch=FetchType.LAZY,mappedBy = "employee")
	public Set<Address> addresses;
	
	@ManyToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="Employee_has_Training")
	private Set<Training> trainings=new HashSet<Training>(0);

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public float getEsalary() {
		return esalary;
	}

	public void setEsalary(float esalary) {
		this.esalary = esalary;
	}

	public final Set<Address> getAddresses() {
		return addresses;
	}

	public final void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public final Set<Training> getTrainings() {
		return trainings;
	}

	public final void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + ", addresses=" + addresses
				+ ", trainings="  + "]";
	}

	
	
}
