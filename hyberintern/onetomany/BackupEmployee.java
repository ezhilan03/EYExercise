package onetomany;

public class BackupEmployee {
	private int eid;
	private String ename;
	private int esal;
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
		return "BackupEmployee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + "]";
	}
	
}
