package EYExercise.day11;

import java.io.IOException;

public class Day4Question6 {
	public static void main(String[] args) throws IOException{
		Child3 child = new Child3(); 
	}
}

class Parent2{
	public Parent2() throws IOException{
		throw new IOException();
	}
}

class Child3 extends Parent2{
	public Child3() throws IOException{
		try {
			new Parent2();
		}catch(IOException e) { //Unreachable catch block for IOException. This exception is never thrown from the try statement body
			e.printStackTrace();
		}
	}
}