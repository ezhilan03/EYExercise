package EYExercise.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket ss;Socket s;PrintWriter out;BufferedReader br,in;
	public Server() {
		try {
			ss = new ServerSocket(2000); //this is the port number where the request will land.
			System.out.println("Server is ready");
			while(true) {
				s=ss.accept();
				System.out.println(s);
				in = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter message to send to client");
				String msg = in.readLine();
				
				out = new PrintWriter(s.getOutputStream(),true);
				out.println(msg);
				
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String msgFromClient = br.readLine();
				System.out.println(msgFromClient);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}
}
