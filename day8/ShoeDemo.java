package day8;

public class ShoeDemo {
	public static void main(String[] args) {
		ShoeShop ss = Container.getShoeShop();
		Customer customer = new ShoeCustomer("ramu");		
		Shoe shoe = ss.sellShoe(customer);
		System.out.println(shoe);
	}
}

class Container{
	public static ShoeShop getShoeShop() {
		return new GokulShoeShop();
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
//	Customer customer;
	String customerName;
	public LeatherShoe(Customer customer) {
		this.customerName=customer.getCustomerName();
	}
	@Override
	public String toString() {
		return "LeatherShoe [customer=" + customerName + "]";
	}
	
}

class SportsShoe extends Shoe{
	
}

//Seller
interface Seller{}

interface ShoeSeller extends Seller{
	public Shoe sellShoe(Customer customer);
}

abstract class ShoeShop implements ShoeSeller{
	
}

class GokulShoeShop extends ShoeShop{
	public Shoe sellShoe(Customer customer) {
		return new LeatherShoe(customer);
	}
}

//Manufacturer
interface Manufacturer{}

interface ShoeManufacturer extends Manufacturer{
	public void makeShoe();
}

abstract class ShoeFactory implements ShoeManufacturer{
	
}

class BataShoeFactory extends ShoeFactory{
	public void makeShoe(){
		
	}
}

class LakhaniShoeFactory extends ShoeFactory{
public void makeShoe(){
		
	}
}