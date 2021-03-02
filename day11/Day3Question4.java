package EYExercise.day11;

public class Day3Question4 {
	public static void main(String[] args) {
		Child child=new Child();
		child.met1();
		child.met2();
		child.met3();
		child.met4();
		child.met5();
		child.met6();
		child.newMet();
		child.childMet1(child);
		child.childMet2(child);
		child.childMet3(child);
		child.childMet4(child);
	}
}

interface Interface1{
	public void met1();
	public void met2();
}

interface Interface2{
	public void met3();
	public void met4();
}

interface Interface3{
	public void met5();
	public void met6();
}

interface mainInterface extends Interface1,Interface2,Interface3{
	public void newMet();
}

class Parent{
	
}

class Child extends Parent implements mainInterface{
	@Override
	public void met1() {
		System.out.println("This is Interface 1 method 1");
		
	}
	@Override
	public void met2() {
		System.out.println("This is Interface 1 method 2 ");
		
	}
	@Override
	public void met3() {
		System.out.println("This is Interface 2 method 3");
		
	}
	@Override
	public void met4() {
		System.out.println("This is Interface 2 method 4");
		
	}
	@Override
	public void met5() {
		System.out.println("This is Interface 3 method 5");
	}
	@Override
	public void met6() {
		System.out.println("This is Interface 3 method 6");
	}
	@Override
	public void newMet() {
		System.out.println("This is main Interface's method");
	}
	
	public void childMet1(Interface1 i1)
	{
		System.out.println("Interface 1 object: "+i1);
	}
	public void childMet2(Interface1 i2)
	{
		System.out.println("Interface 2 object: "+i2);
	}
	public void childMet3(Interface1 i3)
	{
		System.out.println("Interface 3 object: "+i3);
	}
	public void childMet4(Interface1 i4)
	{
		System.out.println("Interface 4 object: "+i4);
	}
}