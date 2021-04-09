package annopack.minherpack;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="maruti")
//@DiscriminatorValue(value="maruti")
@PrimaryKeyJoinColumn(referencedColumnName="sid")
public class Maruti extends Car implements Serializable{
public String marutifeatures;
	
	public String getMarutifeatures() {
		return marutifeatures;
	}
	public void setMarutifeatures(String marutifeatures) {
		this.marutifeatures = marutifeatures;
	}
	public String toString() {
		return "maruti:"+marutifeatures+".."+super.toString();
	}
	public void handle() {
		new VisitorImpl().process(this);
	}
}
