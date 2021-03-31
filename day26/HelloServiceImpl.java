package InternExercise.day26;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "InternExercise.day26.HelloService")
public class HelloServiceImpl implements HelloService{
	@WebMethod
	@Override
	public String sayHello(String name) {
		return "Welcome to SOAP based standard webservices....:"+name;
	}
}
