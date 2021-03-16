package EYExercise.day22.invoicejdbc;

import java.io.Serializable;

public class ItemTransactionDTO implements Serializable{
	private int itemNo;
	private int invNo;
	private int itemQuantity;
	
	public final int getItemNo() {
		return itemNo;
	}
	public final void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public final int getInvNo() {
		return invNo;
	}
	public final void setInvNo(int invNo) {
		this.invNo = invNo;
	}
	public final int getItemQuantity() {
		return itemQuantity;
	}
	public final void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	@Override
	public String toString() {
		return "ItemTransactionDTO [itemNo=" + itemNo + ", invNo=" + invNo + ", itemQuantity=" + itemQuantity + "]";
	}
	
	
}
