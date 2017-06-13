package htwg.in.gib.anam;

import java.io.OutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PDF_Generierung {

	 public static void pdfGenerieren(String inhaltText, OutputStream resp) {
	
	 Document document = new Document();
	 PdfWriter writer = null;
	 try {
	 writer = PdfWriter.getInstance(document, resp);
	 } catch (DocumentException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	
	
	
	
	
	 document.open();
	
	 // System.out.println(document);
	 try {
	 document.add(new Paragraph(inhaltText));
	 } catch (DocumentException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	
	 document.close();
	 }

//	public void barcode() {
//
//		ByteArrayOutputStream bout = QRCode.from("www.amazon.de").withSize(250, 250).to(ImageType.PNG).stream();
//
//		try {
//			FileOutputStream out = new FileOutputStream("img/barcode.jpg");
//			out.write(bout.toByteArray());
//			out.flush();
//			out.close();
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void main(String[] args) {
//		PDF_Generierung p = new PDF_Generierung();
//		p.barcode();
//
//	}

}
