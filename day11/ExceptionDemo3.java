package EYExercise.day11;

import java.util.Scanner;

public class ExceptionDemo3 {
	public static void main(String[] args) throws Exception{
		Dog tiger = new Dog();
		Child2 child = new Child2();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the item you want to perform action with the dog");
		String itemClass = scan.next();
		Item item = (Item)Class.forName(itemClass).getConstructor().newInstance();
		
		child.playWithDog(tiger, item);
	}
}

//asdasd
class Child2 {
	public void playWithDog(Dog dog,Item item) {
		try {
			dog.play(item);
		}
//		catch(DogBarkException dbae) {
//			new HandlerIndia().handle(dbae);
//		}
//		catch(DogBiteException dbie) {
//			new HandlerIndia().handle(dbie);
//		}
		catch(DogExceptions de) {
			//change this
			de.visit();
			System.out.println(de);
		}
	}
}

class Dog{
	public void play(Item item)throws DogExceptions{
		item.action();
	}
}

abstract class Item{
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public abstract void action()throws DogExceptions;
}

class StickItem extends Item{
	public StickItem() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void action() throws DogExceptions{
		throw new DogBiteException("You throw I Bite");
	}
}

class StoneItem extends Item{
	public StoneItem() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void action() throws DogExceptions{
		throw new DogBarkException("you throw I Bark and run");
	}
}

//can change this
//Exceptions
abstract class DogExceptions extends Exception{
	//visitor pattern
	public abstract void visit();
}

class DogBiteException extends DogExceptions{
	String msg;
	public DogBiteException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return "Exception.. :"+this.msg;
	}
	@Override
	public void visit() {
		new HandlerIndia().handle(this);
		
	}
}

class DogBarkException extends DogExceptions{
	String msg;
	public DogBarkException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return "Exception.. :"+this.msg;
	}
	@Override 
	public void visit() {
		new HandlerIndia().handle(this);
	}
}

//should change this as interface
//Handler
abstract class Handler{
	public abstract void handle(DogBarkException dbae);
	public abstract void handle(DogBiteException dbie);
}

class HandlerIndia extends Handler{
	@Override
	public void handle(DogBarkException dbae) {
		System.out.println("Barking dogs seldom bite");
	}
	@Override
	public void handle(DogBiteException dbie) {
		System.out.println("Child was bitten");
	}
}