package annopack.comppack;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice {
	
	@EmbeddedId
	private CompKey compkey;
	
	@Column(name="Deetails")
	private String details;
	
	public final CompKey getCompkey() {
		return compkey;
	}
	public final void setCompkey(CompKey compkey) {
		this.compkey = compkey;
	}
	public final String getDetails() {
		return details;
	}
	public final void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "Invoice [compkey=" + compkey + ", details=" + details + "]";
	}
	
}
