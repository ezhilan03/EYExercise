package EYExercise.day13;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class CollectionsDemo6 {
	public static void main(String[] args) throws Exception{
		Properties prop = new Properties();
		//prop.put("a1", "prop1");
		prop.load(new FileInputStream("abc.properties"));
		
		Enumeration enu = prop.elements();
		while(enu.hasMoreElements()) {
			String val1 = (String)enu.nextElement();
			String val2 = prop.getProperty(val1);
			System.out.println(val1 +" = "+val2);
		}
	}
}
