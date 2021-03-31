package InternExercise.day17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class InternationalizationDemoIO {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader
				(new FileInputStream("abcd.properties"),Charset.forName("UTF-8")));
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter
				(new FileOutputStream("copy-abcd.properties"),Charset.forName("UTF-8")));
		
		char[] c = new char[8];
		int i=0;
		while((i=reader.read(c))!=-1) {
			writer.write((char)i);
		}
		reader.close();
		writer.close();
	}
}
