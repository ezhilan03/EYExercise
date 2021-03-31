package InternExercise.day8;

public class Question15 {
	public static void main(String[] args) {
		House smallHouse = new House();
		System.out.println("Cost of constructing smallHouse is "+smallHouse.calculatingCost()+" Rupees");
	}
	
}

class House{
	
	Door door;
	Window window;
	int doorSquareFeet = 13;
	int windowSquareFeet = 6;
	
	
	public House() {
		door = new Door();
		window = new Window();
	}

	public int calculatingCost() {
		return door.calculatingCost(doorSquareFeet)+window.calculatingCost(windowSquareFeet);
	}
}

class Door{	
	public int calculatingCost(int doorSquareFeet) {
		return doorSquareFeet*400;
	}	
}

class Window{	
	public int calculatingCost(int windowSquareFeet) {
		return windowSquareFeet*500;
	}	
}