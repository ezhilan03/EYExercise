package day6;

public class TemplateMethodDemo {
	public static void main(String[] args) {
		
	}
}

abstract class DominoPizza{
	final public void makeAtta() {	
		System.out.println("Atta selected by Dominoes");
	}
	final public void makeIngredients() {
		System.out.println("Ingredients selected by dominoes");
	}
	final public void packing() {
		System.out.println("packing dabba is selected by Dominoes");
	}
	final public void selectItems() {
		makeAtta();
		makeIngredients();
	}
	public abstract void delivery();
	public abstract void makePizza();
}
class KovaiDominos extends DominoPizza{
	@Override
	public void delivery() {
		System.out.println("pizza delivered..");
	}
	@Override
	public void makePizza() {
		selectItems();
		System.out.println("cooking......");
		packing();
		delivery();
	}
}