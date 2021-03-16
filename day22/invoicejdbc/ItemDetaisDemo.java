package EYExercise.day22.invoicejdbc;

import java.util.HashSet;
import java.util.Set;

public class ItemDetaisDemo {
	public static void main(String[] args) {
		ItemDetailsDAOImpl itemImpl = new ItemDetailsDAOImpl();
		
		ItemDetailsDTO item1 = new ItemDetailsDTO();
		item1.setItemNo(2);
		item1.setItemDesc("good food");
		item1.setItemPrice(120.00);
		item1.setItemUnit("1kg");
		
//		//insert
//		System.out.println(itemImpl.insertItemDetails(item1));
		
//		//delete
//		System.out.println(itemImpl.deleteItemDetails(1));
		
//		//update
//		System.out.println(itemImpl.updateItemDetails(item1, 200.50));
		
		//get
		item1 = itemImpl.getItemDetails(2);
		System.out.println(item1);
		
		//get all
		Set<ItemDetailsDTO> set = new HashSet<>();
		set = itemImpl.getItemDetailsAll();
		System.out.println(set);
	}
}
