package InternExercise.day15;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

public class IODemo3 {
	public static void main(String[] args) throws Exception{
		String str = "India &copy won the &copy; Worldcup";
		
		ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
		BufferedInputStream bfs = new BufferedInputStream(bais);
		
		System.out.println(bfs.markSupported()); //to check whether the input stream supports the mark and reset method.
		
		int c=0;
		boolean mark=false;
		while((c=bfs.read())!=-1) {
			switch((char)c) {
			
			case '&':
				if(!mark) {
					bfs.mark(4);
					mark=true;
				}
				break;
			
			case ';':
				if(mark) {
					System.out.print((char)169);
					mark=false;
				}
				break;
			
			case ' ':
				if(mark) {
					bfs.reset();
					mark=false;
					System.out.print('&');
				}
				else
					System.out.print(" ");
				break;
				
			default:
				if(!mark) {
					System.out.print((char)c);
				}
				break;
			}
		}
	}
}
