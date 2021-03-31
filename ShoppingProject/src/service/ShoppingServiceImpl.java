package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import model.jdbc.ItemDetailsDAO;
import model.jdbc.ItemDetailsDAOImpl;
import model.jdbc.ItemDetailsDTO;

public class ShoppingServiceImpl implements ShoppingService,Cloneable{
	private static Properties prop;
	private static ShoppingServiceImpl shoppingServiceImpl;
	
	private ShoppingServiceImpl(Properties prop) {
		this.prop=prop;
	}
	
	public static ShoppingServiceImpl getShoppingServiceImpl(Properties prop) {
		if(shoppingServiceImpl==null) {
			shoppingServiceImpl=new ShoppingServiceImpl(prop);
		}
		return shoppingServiceImpl;
	}
	
	public ShoppingServiceImpl createClone() {
		try {
			return (ShoppingServiceImpl)super.clone();
		}catch(Exception e) {e.printStackTrace();return null;}
	}
	
	@Override
	public Set<ItemDetailsDTO> getItems(int categoryID) {
		ItemDetailsDAO itemDetailsDAO = ItemDetailsDAOImpl.getItemDetailsDAOImpl(prop);
		return itemDetailsDAO.getItemDetailsByCategory(categoryID);
	}
	
	@Override
	public String getItemName(int itemNo) {
		ItemDetailsDAO itemDetailsDAO = ItemDetailsDAOImpl.getItemDetailsDAOImpl(prop);
		ItemDetailsDTO itemDetailsDTO = itemDetailsDAO.getItemDetails(itemNo);
		return itemDetailsDTO.getItemDesc();
	}
	
	@Override
	public Double getItemPrice(int itemNo) {
		ItemDetailsDAO itemDetailsDAO = ItemDetailsDAOImpl.getItemDetailsDAOImpl(prop);
		ItemDetailsDTO itemDetailsDTO = itemDetailsDAO.getItemDetails(itemNo);
		return itemDetailsDTO.getItemPrice();
	}
	
	@Override
	public Double getTotal(List<Integer> itemList) {
		Double total = 0.0;
		for(int itemNo:itemList) {
			total= total + getItemPrice(itemNo);
		}
		return total;
	}
}
