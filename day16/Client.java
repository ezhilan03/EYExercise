package EYExercise.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
	Socket s;BufferedReader br,in;PrintWriter out;
	public Client() {
		try {
			while(true) {
				s=new Socket("localhost",2000); //(location where the server is available, port number)
	
				br= new BufferedReader(new InputStreamReader(s.getInputStream()));
				String msgFromServer = br.readLine();
				System.out.println(msgFromServer);
				
				System.out.println("Enter a message to send to client");
				in = new BufferedReader(new InputStreamReader(System.in));
				String msg = in.readLine();
				out = new PrintWriter(s.getOutputStream(),true);
				out.println(msg);
			}
			
		}catch(Exception e) {e.printStackTrace();}
	}
	public static void main(String[] args) {
		new Client();
	}
}
