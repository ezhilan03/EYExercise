package EYExercise.day11;
import EYExercise.day11.vehicle.FourWheeler;

public class Day3Question7 {
	public static void main(String[] args) throws Exception{
		Car car = (Car)Class.forName("EYExercise.day11.Car").getConstructor().newInstance();
		car.met();
	}
}
	

class Car extends FourWheeler{
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public void met() {
		System.out.println("this is inherited class");
	}
}