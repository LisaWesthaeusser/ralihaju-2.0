package htwg.in.gib.anam;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.OutputStream;

public class PDF_Generierung {

	public static void pdfGenerieren(String inhaltText, OutputStream resp) {

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, resp);
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

		// Meldung : Wollen Sie es ansehen ?

		// public static void main(String[] args) {
		//
		// PDF_Generierung pdf = new PDF_Generierung("Hallo Aybars, was geht
		// broo");
		// pdf.pdfGenerieren("Hallo Aybars, was geht broo");
		//
	}

}
