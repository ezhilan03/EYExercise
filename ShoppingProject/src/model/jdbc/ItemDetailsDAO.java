package model.jdbc;

import java.util.Set;


public interface ItemDetailsDAO {
	public int insertItemDetails(ItemDetailsDTO itemDetailsDTO);
	public int deleteItemDetails(ItemDetailsDTO itemDetailsDTO);
	public int updateItemDetails(ItemDetailsDTO itemDetailsDTO);
	public ItemDetailsDTO getItemDetails(int itemNo);
	public Set<ItemDetailsDTO> getItemDetailsByCategory(int categoryID);
	public Set<ItemDetailsDTO> getItemDetailsAll();
}
