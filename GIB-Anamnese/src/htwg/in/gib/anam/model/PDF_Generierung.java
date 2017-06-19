package htwg.in.gib.anam.model;

import java.awt.Color;
import java.io.OutputStream;

import com.aspose.barcode.BarCodeBuilder;
import com.aspose.barcode.Symbology;
import com.aspose.barcode.barcoderecognition.BarCodeReadType;
import com.aspose.barcode.barcoderecognition.BarCodeReader;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.Barcode;
import com.lowagie.text.pdf.BarcodeEAN;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

public class PDF_Generierung {

	public static void pdfGenerieren(String inhaltText, OutputStream resp, Bogen bogen) {

		Document document = new Document();
		PdfWriter writer = null;
		try {
			writer = PdfWriter.getInstance(document, resp);

			document.open();
			PdfContentByte content = writer.getDirectContent();
			BarcodeEAN barcode = new BarcodeEAN();
			String barcodeID = "" + bogen.getId();
			barcode.setCode(barcodeID);
			barcode.setCodeType(Barcode.UPCA);
//			BarCodeBuilder builder = new BarCodeBuilder(Symbology.Code39Standard + barcodeID);
//			builder.save("C:/Users/Jülide/Desktop/test.jpg");
//			BarCodeReader reader = new BarCodeReader("C:/Users/Jülide/Desktop/test.jpg", BarCodeReadType.Code39Standard);
//			while(reader.read()){
//				reader.getCodeText();
//			}
//			reader.close();
//			System.out.println(reader);

			document.add(new Paragraph("Anamnesebogen"));
			document.add(barcode.createImageWithBarcode(content, Color.BLACK, Color.BLACK));

			// System.out.println(document);

			document.add(new Paragraph(inhaltText));
			document.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
