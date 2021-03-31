package InternExercise.day7;
public class DecoratorDemo {
	public static void main(String[] args) {
		IceCream FinalIceCream = new Vannila(new Chocolate(new Nuts(new Cherry())));
		System.out.println("The cost of the ice cream is.. "+FinalIceCream.cost());
	}
}
abstract class IceCream{
	public abstract int cost();
}
abstract class Cream extends IceCream{}
abstract class IceCreamIngredients extends IceCream{}

class Vannila extends Cream{
	IceCream iceCream;
	public Vannila() {
		// TODO Auto-generated constructor stub
	}
	public Vannila(IceCream iceCream) {
		this.iceCream=iceCream;
	}
	@Override
	public int cost() {
		if(this.iceCream==null)
			return 10;
		else
			return 10+this.iceCream.cost();
	}
}
class Chocolate extends Cream{
	IceCream iceCream;
	public Chocolate() {
		// TODO Auto-generated constructor stub
	}
	public Chocolate(IceCream iceCream) {
		this.iceCream=iceCream;
	}
	@Override
	public int cost() {
		if(this.iceCream==null)
			return 20;
		else
			return 20+this.iceCream.cost();
	}
}
class Cherry extends IceCreamIngredients{
	IceCream iceCream;
	public Cherry() {
		// TODO Auto-generated constructor stub
	}
	public Cherry(IceCream iceCream) {
		this.iceCream=iceCream;
	}
	@Override
	public int cost() {
		if(this.iceCream==null)
			return 5;
		else
			return 5+this.iceCream.cost();
	}
}
class Nuts extends IceCreamIngredients{
	IceCream iceCream;
	public Nuts() {
		// TODO Auto-generated constructor stub
	}
	public Nuts(IceCream iceCream) {
		this.iceCream=iceCream;
	}
	@Override
	public int cost() {
		if(this.iceCream==null)
			return 5;
		else
			return 5+this.iceCream.cost();
	}
}