package EYExercise.day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IODemo10 {
	public static void main(String[] args) throws Exception{
		WriteToString wts = new WriteToString();
		wts.write("Hello World".getBytes());
		System.out.println(wts.read());
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mydata.dat"));
		oos.writeObject(wts);
		
		wts.write("Hi there".getBytes());
		System.out.println(wts.read());
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mydata.dat"));
		wts = (WriteToString)ois.readObject();
		System.out.println(wts.read());
	}
}

class WriteToString implements Serializable{
	//transient - not saved
	transient String str;
	public void write(byte[] b) throws Exception{
		str = new String(b);
	}
	public String read() {
		return str;
	}
}

