package InternExercise.day17;

public class EnumDemo {
	public static void main(String[] args) {
		Cars car = Cars.duster;
		Cars cars[] = Cars.values();
		met(car);
		met2(cars);
		car.setPrice(500);
		met2(cars);
	}
	
	public static void met(Cars car) {
//		if(car==Cars.duster)
//			System.out.println("It's a duster");
//		else if(car==Cars.maruthi)
//			System.out.println("It's a maruthi");
		
		switch(car) {
		case duster:{
				System.out.println("It's a duster");
				break;
		}
		case maruthi:{
			System.out.println("It's a maruthi");
			break;
		}
		case sumo:{
			System.out.println("It's a sumo");
			break;
		}
		default:{
			System.out.println("I don't know this car");
			break;
		}
		}
	}
	
	public static void met2(Cars cars[]) {
		for(Cars cc:cars) {
			System.out.println("Price of the car "+cc.name()+" is "+cc.price);
		}
	}
}

enum Cars{
	maruthi(1000),sumo(2000),duster(3000);
	int price;
	private Cars(int price) {
		this.price=price;
	}
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price=price;
	}
}