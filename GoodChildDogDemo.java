package day6;
import java.util.Scanner;
public class GoodChildDogDemo {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter an item");
		String itemS = sc.next();
		itemS = "day6."+itemS;
		GoodChild child = new GoodChild();
		GoodBulldog tiger = new GoodBulldog();
		child.playWithDog(tiger,itemS);
	}
}

class GoodBulldog{
	public void play(String i) throws Exception{
		System.out.println(i);
		
		Item item = (Item)Class.forName(i).newInstance();
		item.action();
	}
}
class GoodChild{
	public void playWithDog(GoodBulldog dog,String itemS) throws Exception{
		dog.play(itemS);
	}
}

abstract class Item{
	public abstract void action();
}

class Stick extends Item{
	@Override
	public void action() {
		System.out.println("you beat I bite");
	}
}
class Stone extends Item{
	@Override
	public void action() {
		System.out.println("you hit I bark");
	}
}