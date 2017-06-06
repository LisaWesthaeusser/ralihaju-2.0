package htwg.in.gib.anam;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.OutputStream;

import com.aspose.barcode.BarCodeBuilder;
import com.aspose.barcode.Symbology;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.Barcode;
import com.lowagie.text.pdf.BarcodeEAN;
import com.lowagie.text.pdf.PdfContentByte;
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

		PdfContentByte CB = writer.getDirectContent();
		BarcodeEAN codeEan = new BarcodeEAN();
		codeEan.setCode("3929543259056");

		Paragraph para = new Paragraph();
		try {
			document.add(new Paragraph("Anamnesebogen"));

			 codeEan.setCodeType(Barcode.UPCA);
			 codeEan.setCode("1098765432112");

//			document.add(codeEan.createImageWithBarcode(CB, Color.BLACK, Color.BLACK));
			String name = "barcode.jpg";
			String codeText = "123";
			BarCodeBuilder builder = new BarCodeBuilder(codeText, Symbology.Pdf417);
			Image img = Toolkit.getDefaultToolkit().getImage(name);
			
//			Paragraph p = new Paragraph();
			para.add(img);
//			document.add(p);
			

			document.add(para);
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
