package htwg.in.gib.anam.control;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import htwg.in.gib.anam.model.Bogen;
import htwg.in.gib.anam.model.PDF_Generierung;

/**
 * Servlet implementation class AbrufenServlet
 */
@WebServlet("/GIB-Anamnese/AbrufenServlet")
public class AbrufenServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String bewegID = request.getParameter("parameter");
		DatenbankAnbindung dba = new DatenbankAnbindung();
		Bogen bogen = new Bogen();
		bogen.setId(bewegID);

		resp.setContentType("application/pdf");
		String htmlResp = "";

		List<String> fragen = dba.selectFragen();
		List<String> antworten = dba.selectInhalteinesBogens(bewegID);

		for (int i = 0; i < fragen.size(); i++) {
			htmlResp += fragen.get(i) + ":\n" + antworten.get(i) + "\n\n";
		}

		OutputStream os = resp.getOutputStream();
		PDF_Generierung.pdfGenerieren(htmlResp, os, bogen);
	}
}
