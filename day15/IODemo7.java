package EYExercise.day15;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class IODemo7 {
	public static void main(String[] args) throws Exception{
		Document doc = new Document();
		PdfWriter.getInstance(doc, new FileOutputStream("bill.pdf"));
		
		doc.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
		Chunk chunk1 = new Chunk("Customer name : Ezhilan", font);
		Chunk chunk2 = new Chunk(" bill no : 102", font);
		Chunk chunk3 = new Chunk(" bill date : 08/03/2021", font);
		
		doc.add(chunk1);
		doc.add(chunk2);
		doc.add(chunk3);
		
		PdfPTable table = new PdfPTable(6);
		table.addCell("S.no");
		table.addCell("item");
		table.addCell("unit");
		table.addCell("price");
		table.addCell("quantity");
		table.addCell("amount");
		
		table.addCell("1");
		table.addCell("Dall");
		table.addCell("100g");
		table.addCell("120");
		table.addCell("1");
		table.addCell("120");
		
		table.addCell("2");
		table.addCell("Rice");
		table.addCell("50g");
		table.addCell("60");
		table.addCell("2");
		table.addCell("120");
		
		doc.add(table);
		
		doc.close();
		System.out.println("pdf is created");
	}
}
