package InternExercise.day8;
import java.util.Scanner;

public class FactoryDemo {
	public static void main(String[] args)throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the factory class");
		String factoryClass = scan.next();
		System.out.println("Enter the Shop class");
		String shopClass = scan.next();
		System.out.println("Enter the type of shoe you want");
		String shoeClass = scan.next();
		ShoeShop ss = Container.getShoeShop(shopClass,factoryClass,shoeClass);
		Customer customer = new ShoeCustomer("ramu");		
		Shoe shoe = ss.sellShoe(customer);
		System.out.println(shoe);
	}
}

class Container{
	public static ShoeShop getShoeShop(String shopClass,String factoryClass,String shoeClass)throws Exception {
		ShoeFactory factory = (ShoeFactory)Class.forName(factoryClass).newInstance();
		ShoeShop shop = (ShoeShop)Class.forName(shopClass).newInstance();
		Shoe shoe = (Shoe)Class.forName(shoeClass).newInstance();
		factory.setShoe(shoe);
		shop.setFactory(factory);
		return shop;
	}
	
}

//Customer
abstract class Customer{

	abstract public String getCustomerName();
	
}

class ShoeCustomer extends Customer{
	String customerName;
	public ShoeCustomer(String customerName) {
		this.customerName=customerName;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
	
}

//Shoe
abstract class Shoe{}

class LeatherShoe extends Shoe{

	@Override
	public String toString() {
		return "This is a leather shoe";
	}
	
}

class SportsShoe extends Shoe{
	@Override
	public String toString() {
		return "This is a Sports shoe";
	}
}

//Seller
interface Seller{}

interface ShoeSeller extends Seller{
	public Shoe sellShoe(Customer customer);
}

abstract class ShoeShop implements ShoeSeller{
	private ShoeFactory factory;

	public final ShoeFactory getFactory() {
		return factory;
	}

	public final void setFactory(ShoeFactory factory) {
		this.factory = factory;
	}
	
}

class GokulShoeShop extends ShoeShop{
	@Override
	public Shoe sellShoe(Customer customer) {
		System.out.println("The customer of the soe is "+customer.getCustomerName());
		return getFactory().makeShoe();
	}
}

//Manufacturer
interface Manufacturer{}

interface ShoeManufacturer extends Manufacturer{
	public Shoe makeShoe();
}

abstract class ShoeFactory implements ShoeManufacturer{
	private Shoe shoe;

	public final Shoe getShoe() {
		return shoe;
	}

	public final void setShoe(Shoe shoe) {
		this.shoe = shoe;
	}
	
}

class BataShoeFactory extends ShoeFactory{
	@Override
	public Shoe makeShoe(){
		System.out.println("This shoe is made by Bata shoe factory");
		return getShoe();
	}
}

class LakhaniShoeFactory extends ShoeFactory{
	@Override
	public Shoe makeShoe(){
		System.out.println("This shoe is made by Lakhani shoe factory");
		return getShoe();
	}
}