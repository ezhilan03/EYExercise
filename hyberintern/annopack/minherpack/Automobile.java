package annopack.minherpack;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name="auto")
@Table(name="myauto")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="disc")
//@DiscriminatorValue(value="auto")
@Inheritance( strategy = InheritanceType.JOINED )
public class Automobile implements Serializable{
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	public int sid;
	
	@Column(name="featureofauto")
	public String autofeature;
		
	public Automobile()
	{
		
		sid=(int)System.nanoTime();
	}
	public String getAutofeature() {
		return autofeature;
	}
	public void setAutofeature(String autofeature) {
		this.autofeature = autofeature;
	}
	public int getSno() {
		return sid;
	}
	public void setSno(int sno) {
		this.sid = sno;
	}
	@Override
	public String toString() {
		return "Auto:"+autofeature+".."+super.toString();
	}
	public void handle() {
		new VisitorImpl().process(this);
	}
}
