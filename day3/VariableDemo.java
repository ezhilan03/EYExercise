package InternExercise.day3;

public class VariableDemo {
	public static void main(String[] args) {
		TrainingRoom trainingroomObj1 = new TrainingRoom();
		TrainingRoom trainingroomObj2 = new TrainingRoom();
	}
}

class Canteen {
	Canteen() {
		System.out.println("Canteen contructor is initiated");
	}
}

class Projector {
	Projector() {
		System.out.println("Projector contructor is initiated");
	}
}

class TrainingRoom {
	TrainingRoom() {
		System.out.println("Training room contructor is initiated");
	}

	static Canteen canteenobj = new Canteen();
	Projector projectObj = new Projector();
}