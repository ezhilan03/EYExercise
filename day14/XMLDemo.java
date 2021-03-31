package InternExercise.day14;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLDemo {
	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true); //XML considers the indendation and whitespaces as it's elements and counts them.
		dbf.setValidating(true); //We can validate if the XML doc follows the DTD doc correctly.
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse("invoice.xml");
		
//		System.out.println("The name of root element is "+doc.getDocumentElement().getNodeName()); //this gets the root element
//		System.out.println("The number of child nodes is "+doc.getDocumentElement().getChildNodes().getLength());
		
		Element rootElement = doc.getDocumentElement();
		
		
		
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Invoice");
		int rowCount=0;
		Row header = sheet.createRow(rowCount++);
		header.createCell(0).setCellValue("Customer Name:");
		header.createCell(1).setCellValue(rootElement.getChildNodes().item(0).getChildNodes().item(0).getNodeValue());
		header.createCell(2).setCellValue("Bill no:");
		header.createCell(3).setCellValue(Integer.parseInt(rootElement.getChildNodes().item(1).getChildNodes().item(0).getNodeValue()));
		header.createCell(4).setCellValue("Bill date:");
		header.createCell(5).setCellValue(rootElement.getChildNodes().item(2).getChildNodes().item(0).getNodeValue());
		
		Row top = sheet.createRow(rowCount++);
		top.createCell(0).setCellValue("S.no");
		top.createCell(1).setCellValue("Item name");
		top.createCell(2).setCellValue("Price");
		top.createCell(3).setCellValue("Quantity");
		top.createCell(4).setCellValue("Amount");
		
		List<List> arr = new ArrayList<>();
		
		NodeList list = rootElement.getElementsByTagName("item");
		int length = list.getLength();
		for(int i=0;i<length;i++) {
			List l = new ArrayList<>();
			Node n = list.item(i);
			if(n.getNodeType() == Node.ELEMENT_NODE) {
				int sno = Integer.parseInt(n.getChildNodes().item(0).getChildNodes().item(0).getNodeValue());
				l.add(sno);
				String customerName = n.getChildNodes().item(1).getChildNodes().item(0).getNodeValue();
				l.add(customerName);
				int price = Integer.parseInt(n.getChildNodes().item(2).getChildNodes().item(0).getNodeValue());
				l.add(price);
				int quantity = Integer.parseInt(n.getChildNodes().item(3).getChildNodes().item(0).getNodeValue());
				l.add(quantity);
				double amount = Double.parseDouble(n.getChildNodes().item(4).getChildNodes().item(0).getNodeValue());
				l.add(amount);
				
				arr.add(l);
			}
		}
		for(List l:arr) {
			int listLength = l.size();
			Row row = sheet.createRow(rowCount++);
			Iterator iter = l.iterator();
			int count=0;
			while(iter.hasNext()) {
				Object obj = iter.next();
				if(obj instanceof String) {
					row.createCell(count++).setCellValue((String)obj);
				}
				else if(obj instanceof Integer) {
					row.createCell(count++).setCellValue((Integer)obj);
				}
				else if(obj instanceof Double) {
					row.createCell(count++).setCellValue((Double)obj);
				}
			}
		}
	
		
		try(FileOutputStream fos = new FileOutputStream("invoice.xlsx")) {
			workbook.write(fos);
			System.out.println("file writtend successfully");
		}
		
		
		
//		rowCount+=1;
//		int numOfChild = rootElement.getChildNodes().getLength();
//		
//		for(int i=0;i<numOfChild;i++)
//			for(int j=0;j<rootElement.getChildNodes().item(i).getChildNodes().getLength()-1;j++) {
//				Node node = rootElement.getChildNodes().item(i).getChildNodes().item(j);
//				System.out.println(node.getNodeName()+" = "+node.getFirstChild().getNodeValue());
//			}
//		System.out.println(rootElement.getFirstChild().getNodeName());
//		System.out.println(rootElement.getFirstChild().getFirstChild().getFirstChild().getNodeValue());
		
	}
}	
