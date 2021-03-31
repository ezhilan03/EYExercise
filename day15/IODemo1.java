package InternExercise.day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;


public class IODemo1 {
	public static void main(String[] args) {
		new CopyCommand().copy("abcd.properties");
	}
}

class CopyCommand{
	public void copy(String fileName) {
		FileInputStream fis = null; //Byte stream
		FileOutputStream fos = null;
		FileReader reader = null; //character stream
		//FileWriter writer = null;
		try(FileWriter writer = new FileWriter("copy-abcd.properties");){  //resource block
//			fis = new FileInputStream(fileName);
//			fos = new FileOutputStream("copy-abcd.properties");
			reader = new FileReader(fileName);
			//writer = new FileWriter("copy-abcd.properties");
			//System.out.println("No of bytes available "+fis.available());
			
			//int noOfBytesRead;
			//byte[] b = new byte[8];
			int noOfCharRead;
			char[] c = new char[8];
			while((noOfCharRead=reader.read(c))!=-1) {
				//System.out.println((char) valueOfChar);
				String s = new String(c, 0, noOfCharRead);
				System.out.println(s);
				System.out.println("Loop");
				writer.write(c, 0, noOfCharRead);
			}
			
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try{
//			fis.close();
//			fos.close();
//			reader.close();
//			writer.close();
			}catch(Exception ee) {ee.printStackTrace();}
		}
	}
}