package model.jdbc;

import java.util.Set;

public interface ItemTransactionDAO {
	public int insertItemTransaction(ItemTransactionDTO itemTransactionDTO);
	public int deleteItemTransaction(int invNo,int itemNo);
	public int updateItemTransaction(ItemTransactionDTO itemTransactionDTO,int itemQuantity);
	public ItemTransactionDTO getItemTransaction(int invNo,int itemNo);
	public Set<ItemTransactionDTO> getItemTransactionAll();
	public Set<ItemTransactionDTO> getItemTransactionForParticularInvoice(int invNo);
}
