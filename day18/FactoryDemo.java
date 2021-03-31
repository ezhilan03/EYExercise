package InternExercise.day18;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class FactoryDemo {
	public static void main(String[] args) throws Exception{
		Customer customer = (Customer)Class.forName("EYExercise.day18.Customer").getConstructor().newInstance();
		ShoeSeller seller = StaticContainer.getSeller();
		customer.name="abc";
		Shoe shoe = seller.sellShoe(customer);
		System.out.println(shoe);
	}
}
@Retention(RetentionPolicy.RUNTIME)
@interface Injection{
	String factoryClassName();
}

class StaticContainer{
	public static ShoeSeller getSeller() throws Exception{
		ShoeShop seller = new RamuShoeShop();
		Class c = seller.getClass().getSuperclass();
		Field f = c.getDeclaredField("smf");
		f.setAccessible(true);
		Injection in = f.getAnnotation(Injection.class);
		if(in!=null) {
			String factoryClassName = in.factoryClassName();
			ShoeFactory sf = (ShoeFactory)Class.forName(factoryClassName).getConstructor().newInstance();
			seller.setSmf(sf);
		}
		return seller;
	}
}

abstract class Shoe{	
}
class LeatherShoe extends Shoe{}
class SportsShoe extends Shoe{}

class Customer{
	String name;
	public Customer() {}
}

interface Seller{
	
}

interface ShoeSeller extends Seller{
	public Shoe sellShoe(Customer customer);
}

abstract class ShoeShop implements ShoeSeller{
	@Injection(factoryClassName="EYExercise.day18.LakhaniShoeFactory")
	private ShoeManufacturer smf;

	public final ShoeManufacturer getSmf() {
		return smf;
	}

	public final void setSmf(ShoeManufacturer smf) {
		this.smf = smf;
	}
	
}

class RamuShoeShop extends ShoeShop{
	@Override
	public Shoe sellShoe(Customer customer) {
		System.out.println("the customer name is "+customer.name);
		return getSmf().makeShoe();
	}
}

interface Manufacturer{
	
}
interface ShoeManufacturer extends Manufacturer{
	public Shoe makeShoe();
}

class ShoeManufacturerImp implements ShoeManufacturer{
	@Override
	public Shoe makeShoe() {
		return new LeatherShoe();
	}
}

abstract class ShoeFactory implements ShoeManufacturer{
	public ShoeFactory() {
		// TODO Auto-generated constructor stub
	}
}
class BataShoeFactory extends ShoeFactory{
	public BataShoeFactory() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Shoe makeShoe() {
		return new LeatherShoe();
	}
}

class LakhaniShoeFactory extends ShoeFactory{
	public LakhaniShoeFactory() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Shoe makeShoe() {
		return new SportsShoe();
	}
}

interface Exporter{
	
}
interface ShoeExporter extends Exporter{
	public void exportShoe();
}