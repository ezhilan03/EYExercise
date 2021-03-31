package components;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import service.InvoiceServiceImpl;


public class SmsServiceImpl implements SmsService,Cloneable{
	
	private static Properties prop;
	private static SmsServiceImpl smsServiceImpl;
	
	private SmsServiceImpl(Properties prop) {
		this.prop=prop;
	}
	
	public static SmsServiceImpl getSmsServiceImpl(Properties prop) {
		if(smsServiceImpl==null) {
			smsServiceImpl=new SmsServiceImpl(prop);
		}
		return smsServiceImpl;
	}
	
	public SmsServiceImpl createClone() {
		try {
			return (SmsServiceImpl)super.clone();
		}catch(Exception e) {e.printStackTrace();return null;}
	}
	
	public void sendSMS(String fileName) {
		try {
			String recipient = "+441234567";
			String username = "admin";
			String password = "abc123";
			String originator = "+441234567";
			
			
			DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
			dbf.setIgnoringElementContentWhitespace(true);
			dbf.setValidating(true);
			
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(fileName);
			
			Element rootElement = doc.getDocumentElement();
			
			String customerName = rootElement.getChildNodes().item(0).getChildNodes().item(0).getNodeValue();
			String invNo = rootElement.getChildNodes().item(1).getChildNodes().item(0).getNodeValue();
			String invDate = rootElement.getChildNodes().item(2).getChildNodes().item(0).getNodeValue();
			String total = rootElement.getChildNodes().item(5).getChildNodes().item(0).getNodeValue();
			
			String message = " Hello. This is your Invoice details."+"Customer Name :"+customerName+"   Invoice No : "+invNo+"   Invoice Date : "+invDate + " Total : "+total;
			
			String requestUrl  = "http://127.0.0.1:9501/api?action=sendmessage&" +
					 "username=" + URLEncoder.encode(username, "UTF-8") +
					 "&password=" + URLEncoder.encode(password, "UTF-8") +
					 "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
					 "&messagetype=SMS:TEXT" +
					 "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
					 "&originator=" + URLEncoder.encode(originator, "UTF-8") +
					 "&serviceprovider=GSMModem1" +
					 "&responseformat=html";
			
			URL url = new URL(requestUrl);
			HttpURLConnection uc = (HttpURLConnection)url.openConnection();
	
			System.out.println(uc.getResponseMessage());
	
			uc.disconnect();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

