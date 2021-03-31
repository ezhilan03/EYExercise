package model.jdbc;

import java.io.Serializable;

public class ItemDetailsDTO implements Serializable,Cloneable{
	private int itemNo;
	private int categoryID;
	private String itemDesc;
	private double itemPrice;
	private String itemUnit;
	private String categoryName;
	
	private static ItemDetailsDTO itemDetailsDTO;
	
	private ItemDetailsDTO() {
		// TODO Auto-generated constructor stub
	}
	
	synchronized public static ItemDetailsDTO getItemDetailsDTO() {
		if(itemDetailsDTO==null) {
			itemDetailsDTO=new ItemDetailsDTO();
			return itemDetailsDTO;
		}
		else {
			return itemDetailsDTO.createClone();
		}
	}
	
	public ItemDetailsDTO createClone(){
		try {
			return (ItemDetailsDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ItemDetailsDTO(int itemNo, int categoryID, String itemDesc, double itemPrice, String itemUnit,
			String categoryName) {
		super();
		this.itemNo = itemNo;
		this.categoryID = categoryID;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
		this.itemUnit = itemUnit;
		this.categoryName = categoryName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryID;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((itemDesc == null) ? 0 : itemDesc.hashCode());
		result = prime * result + itemNo;
		long temp;
		temp = Double.doubleToLongBits(itemPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((itemUnit == null) ? 0 : itemUnit.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDetailsDTO other = (ItemDetailsDTO) obj;
		if (categoryID != other.categoryID)
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (itemDesc == null) {
			if (other.itemDesc != null)
				return false;
		} else if (!itemDesc.equals(other.itemDesc))
			return false;
		if (itemNo != other.itemNo)
			return false;
		if (Double.doubleToLongBits(itemPrice) != Double.doubleToLongBits(other.itemPrice))
			return false;
		if (itemUnit == null) {
			if (other.itemUnit != null)
				return false;
		} else if (!itemUnit.equals(other.itemUnit))
			return false;
		return true;
	}
	public final int getCategoryID() {
		return categoryID;
	}
	public final void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public final String getCategoryName() {
		return categoryName;
	}
	public final void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
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
		return "ItemDetailsDTO [itemNo=" + itemNo + ", categoryID=" + categoryID + ", itemDesc=" + itemDesc
				+ ", itemPrice=" + itemPrice + ", itemUnit=" + itemUnit + ", categoryName=" + categoryName + "]";
	}
	
}
