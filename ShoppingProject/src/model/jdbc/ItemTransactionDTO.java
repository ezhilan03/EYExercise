package model.jdbc;

import java.io.Serializable;

public class ItemTransactionDTO implements Serializable,Cloneable{
	private int itemNo;
	private int invNo;
	private int itemQuantity;
	private static ItemTransactionDTO itemTransactionDTO;
	
	private ItemTransactionDTO() {
		// TODO Auto-generated constructor stub
	}
	
	synchronized public static ItemTransactionDTO getItemTransactionDTO() {
		if(itemTransactionDTO==null) {
			itemTransactionDTO=new ItemTransactionDTO();
			return itemTransactionDTO;
		}
		else {
			return itemTransactionDTO.createClone();
		}
	}
	
	public ItemTransactionDTO createClone(){
		try {
			return (ItemTransactionDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + invNo;
		result = prime * result + itemNo;
		result = prime * result + itemQuantity;
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
		ItemTransactionDTO other = (ItemTransactionDTO) obj;
		if (invNo != other.invNo)
			return false;
		if (itemNo != other.itemNo)
			return false;
		if (itemQuantity != other.itemQuantity)
			return false;
		return true;
	}

	public ItemTransactionDTO(int itemNo, int invNo, int itemQuantity) {
		super();
		this.itemNo = itemNo;
		this.invNo = invNo;
		this.itemQuantity = itemQuantity;
	}
	
	
}
