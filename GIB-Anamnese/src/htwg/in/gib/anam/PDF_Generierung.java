package htwg.in.gib.anam;

import java.awt.Color;
import java.io.OutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.Barcode;
import com.lowagie.text.pdf.BarcodeEAN;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

public class PDF_Generierung {

	public static void pdfGenerieren(String inhaltText, OutputStream resp, String bogenBarcode) {
		

		Document document = new Document();
		PdfWriter writer = null;
		try {
			writer = PdfWriter.getInstance(document, resp);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.open();

		PdfContentByte content = writer.getDirectContent();
		BarcodeEAN barcode = new BarcodeEAN();
		/*TODO !!
		Tabelle Bewegungsbogen hat eine Spalte Barcode
		diese muss 13 stellig sein
		die wird aus der DB gelesen und hier gesettet*/
		barcode.setCode(bogenBarcode);
		barcode.setCodeType(Barcode.UPCA);

		try {
			document.add(new Paragraph("Anamnesebogen"));
			document.add(barcode.createImageWithBarcode(content, Color.BLACK, Color.BLACK));

		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// System.out.println(document);
		try {

			document.add(new Paragraph(inhaltText));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		document.close();
	}

}
