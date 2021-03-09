package EYExercise.day15;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IODemo8 {
	public static void main(String[] args) throws Exception{
		PipedReader pr = new PipedReader();
		PipedWriter pw = new PipedWriter(pr);
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(()->{
			try{
				int data = pr.read();
				while(data!=-1) {
					System.out.print((char)data);
					data=pr.read();
				}
				
			}catch(Exception e) {e.printStackTrace();}
		});
		
		es.execute(()->{
			try {
				while(true) {
					pw.write("Hello World.Hi there".toCharArray());
					try {Thread.sleep(1000);}catch(Exception ex) {}
					System.out.println();
				}
				
			}catch(Exception ee) {ee.printStackTrace();}
		});
	}
}
