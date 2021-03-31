package InternExercise.assignment.multiThreadCommunicator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket ss;Socket s;PrintWriter out;BufferedReader br,in;
	public Server() {
		try {//threads here each thread has its own socket.
			//keep the socket and id for socket using hashmap;keep all socket in a hashmap.
			ss = new ServerSocket(2005); 
			System.out.println("Server is ready");
			while(true) {
				s=ss.accept();
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
