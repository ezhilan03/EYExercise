package InternExercise.day15;

import java.io.ByteArrayInputStream;
import java.io.SequenceInputStream;
import java.io.StringBufferInputStream;

public class IODemo5 {
	public static void main(String[] args) throws Exception{
		ByteArrayInputStream bis = new ByteArrayInputStream("Hello World".getBytes());
		StringBufferInputStream sbis = new StringBufferInputStream("Hi there");
		
		SequenceInputStream sis = new SequenceInputStream(bis,sbis);
		
		int c=0;
		while((c=sis.read())!=-1) {
			System.out.print((char)c);
		}
	}
}
