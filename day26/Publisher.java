package InternExercise.day26;

import javax.xml.ws.Endpoint;

public class Publisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:3000/cs/hello", new ComplexServiceImpl());
		System.out.println("Service published");
	}
}
