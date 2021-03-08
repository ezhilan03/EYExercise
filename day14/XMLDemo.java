package EYExercise.day14;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLDemo {
	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true); //XML considers the indendation and whitespaces as it's elements and counts them.
		dbf.setValidating(true); //We can validate if the XML doc follows the DTD doc correctly.
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse("books.xml");
		
		System.out.println("The name of root element is "+doc.getDocumentElement().getNodeName()); //this gets the root element
		System.out.println("The number of child nodes is "+doc.getDocumentElement().getChildNodes().getLength());
		
		Element rootElement = doc.getDocumentElement();
		int numOfChild = rootElement.getChildNodes().getLength();
		
		for(int i=0;i<numOfChild;i++)
			for(int j=0;j<rootElement.getChildNodes().item(i).getChildNodes().getLength()-1;j++) {
				Node node = rootElement.getChildNodes().item(i).getChildNodes().item(j);
				System.out.println(node.getNodeName()+" = "+node.getFirstChild().getNodeValue());
			}
		System.out.println(rootElement.getFirstChild().getNodeName());
		System.out.println(rootElement.getFirstChild().getFirstChild().getFirstChild().getNodeValue());
		
	}
}	
