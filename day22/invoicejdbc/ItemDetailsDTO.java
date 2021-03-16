package EYExercise.day22.invoicejdbc;

import java.io.Serializable;

public class ItemDetailsDTO implements Serializable{
	private int itemNo;
	private String itemDesc;
	private double itemPrice;
	private String itemUnit;
	
	public final int getItemNo() {
		return itemNo;
	}
	public final void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public final String getItemDesc() {
		return itemDesc;
	}
	public final void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public final double getItemPrice() {
		return itemPrice;
	}
	public final void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public final String getItemUnit() {
		return itemUnit;
	}
	public final void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}
	@Override
	public String toString() {
		return "ItemDetailsDTO [itemNo=" + itemNo + ", itemDesc=" + itemDesc + ", itemPrice=" + itemPrice
				+ ", itemUnit=" + itemUnit + "]";
	}
	
}
