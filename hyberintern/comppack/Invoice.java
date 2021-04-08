package comppack;

public class Invoice {
	private CompKey compkey;
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
