package EYExercise.day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IODemo9 {
	public static void main(String[] args) throws Exception{
		Jangiri jangiri = new Jangiri();
		System.out.println("Original size of jangiri "+jangiri.size);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("jangiri.dat"));
		oos.writeObject(jangiri);
		
		jangiri.size=20;
		System.out.println("The changed jangiri size is "+jangiri.size);
		System.out.println("Getting the old jangiri");
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("jangiri.dat"));
		Jangiri originalJangiri = (Jangiri)ois.readObject();
		
		System.out.println("size of Original jangiri "+originalJangiri.size);
	}
}

class Jangiri implements Serializable{
	public int size=10;
	
}