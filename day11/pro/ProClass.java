package EYExercise.day11.pro;

import EYExercise.day11.Day3Qeustion6;

public class ProClass extends Day3Qeustion6{
	public static void main(String[] args) {
		Day3Qeustion6.proMet();
		ChildClass.met();
	}
	
}

class ChildClass extends ProClass{
	public static void met(){
		Day3Qeustion6.proMet();
	}
}