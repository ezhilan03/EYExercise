package InternExercise.day8;

public class Question12 {
	public static void main(String[] args) {
		Harris arr[] = new Harris[3];
		for(int i=0;i<3;i++) {
			arr[i]= new DummyHarris();
		}
		arr[0]=new HarrisInfotech();
		arr[1] = new HarrisTechnologies();
		arr[2] = new HarrisPharma();
		for(int i=0;i<3;i++) {
			arr[i].eat();
			arr[i].speak();
		}
	}
}

abstract class Harris{
	abstract void eat();
	abstract void speak();
}

class DummyHarris extends Harris{
	@Override
	void eat() {}
	@Override
	void speak() {}
}

class HarrisInfotech extends Harris{
	@Override
	 void eat() {
		 System.out.println("HarrisInfotech Harris eats only in good restaurants");
	 }
	@Override
	 void speak() {
		 System.out.println("HarrisInfotech Harris speaks good english");
	 }
}

class HarrisTechnologies extends Harris{
	@Override
	void eat() {
		 System.out.println("HarrisTechnologies Harris doesn't have time to eat");
	}
	@Override
	void speak() {
		 System.out.println("HarrisTechnologies Harris speaks four languages");
	}
}

class HarrisPharma extends Harris{
	@Override
	void eat() {
		 System.out.println("HarrisPharma Harris eats in local restaurant");
	}
	@Override
	void speak() {
		 System.out.println("HarrisPharma Harris only Tamil");
	}
}