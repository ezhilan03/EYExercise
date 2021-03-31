package InternExercise.day19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepCopyDemo {
	public static void main(String[] args) throws Exception{
		MyClass obj = new MyClass(); //this will load the object in memory....
		obj.name="Ezhilan";
		obj.birthName="Ezhilan Chinnasamy";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.dat"));
		oos.writeObject(obj);//this will create a hard copy of the object in harddisk....
		
		obj.name="Ezzi";
		obj.birthName="Ezzilan";
		System.out.println(obj.name);
		System.out.println(obj.birthName);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.dat"));
		obj =(MyClass)ois.readObject();
		System.out.println(obj.name);
		System.out.println(obj.birthName);
	}
}

class MyClass implements Serializable{
	String name;
	transient String birthName; //if we don’t want to save value of a particular variable in a file during serialization
}