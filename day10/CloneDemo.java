package EYExercise.day10;

public class CloneDemo {
	public static void main(String[] args) throws Exception{
		Sheep sheep1 = new Sheep();
		sheep1.name="Sheep 1";
		Sheep sheep2=sheep1.getSheepClone();
		sheep2.name="Sheep 2";
		
		System.out.println("Name of first sheep is "+sheep1.name);
		System.out.println("Name of second sheep is "+sheep2.name);
	}
}

class Sheep implements Cloneable{
	String name;
	public Sheep() {
		System.out.println("Sheep object is created");
	}
	
	public Sheep getSheepClone() throws Exception{
		return (Sheep)super.clone();
	}
}