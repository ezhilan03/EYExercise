package annopack.onetomanypack;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Training {
	@Id //@GeneratedValue(strategy=GenerationType.AUTO)
	public int tid;
	public String tname;
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public static final String name1="aaaa";
	
	@ManyToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinTable(name="Employee_has_training")
	public Set<Employee> employee;
	
	
	public void getEmployee()
	{
		
	}
}
