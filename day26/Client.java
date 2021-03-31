package InternExercise.day26;

import java.net.URL;
import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://localhost:3000/cs/hello?wsdl");
		QName qName = new QName("http://day26.InternExercise/","ComplexServiceImplService"); //(targetNameSpace,serviceName)
		Service service = Service.create(url,qName);
		
		ComplexService cService = service.getPort(ComplexService.class);
		
		List<Employee> list = cService.getAllEmployees();
		System.out.println("result is : "+list);
	}
}

/*
*
* SOAPREQUEST
* <soap:envelope>
	 * <soap:body>
		 * <sayHello>
		 * 	<arg0>ramu</arg0>
		 * </sayHello>
	 * </soap:body>
* </soap:envelope>
*
* SOAPRESPONSE
* <soap:envelope>
	 * <soap:body>
		 * <sayHelloResponse>
		 * 	<return>
		 * 			Welcome to Webservices...ramu.
		 *  </return>
		 * </sayHelloResponse>
	 * </soap:body>
* </soap:envelope>
*/
