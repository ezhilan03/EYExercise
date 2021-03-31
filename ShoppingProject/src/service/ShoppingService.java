package service;

import java.util.List;
import java.util.Set;

import model.jdbc.ItemDetailsDTO;

public interface ShoppingService {
	public Set<ItemDetailsDTO> getItems(int categoryID);
	public String getItemName(int itemNo);
	public Double getItemPrice(int itemNo); 
	public Double getTotal(List<Integer> itemList);
}
