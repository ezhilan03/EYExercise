package InternExercise.day16;

import java.net.InetAddress;

public class InetDemo {
	public static void main(String[] args) throws Exception{
		InetAddress ineta = InetAddress.getByName("www.wikipedia.com");
		System.out.println(ineta.getHostAddress());
		
		InetAddress inetarr[] = InetAddress.getAllByName("www.irctc.co.in");
		for(InetAddress a: inetarr) {
			System.out.println(a.getHostAddress());
		}
		
//		InetAddress inetName = ineta.getByAddress(new byte[] {10,10,10,10});\
//		System.out.println(inetName.getHostName());
	}
}
