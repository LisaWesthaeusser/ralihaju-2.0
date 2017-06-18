package htwg.in.gib.anam;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import htwg.in.gib.anam.Bogen;
import htwg.in.gib.anam.DatenbankAnbindung;

/**
 * Servlet implementation class AnamnesebogenAServlet
 */
@WebServlet("/GIB-Anamnese/anamnesebogenAnaesthesie")
public class AnamnesebogenAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnamnesebogenAServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String vorname = req.getParameter("Vorname");
		String nachname = req.getParameter("Nachname");
		String geschlecht = req.getParameter("Geschlecht");
		String gebDat = req.getParameter("gebDat");
		String strasse = req.getParameter("Str");
		String plz = req.getParameter("PLZ");
		String ort = req.getParameter("Ort");
		String beruf = req.getParameter("Beruf");
		String datenschutz = req.getParameter("Datenschutz");
		String antwort000 = req.getParameter("Antwort000");
		String antwort001 = req.getParameter("Antwort001");
		String antwort002 = req.getParameter("Antwort002");
		String antwort003 = req.getParameter("Antwort003");
		String antwort004 = req.getParameter("Antwort004");
		
		String frage000 = req.getParameter("Frage000");
		String frage001 = req.getParameter("Frage001");
		String frage002 = req.getParameter("Frage002");
		String frage003 = req.getParameter("Frage003");
	
		String nachricht000 = req.getParameter("Nachricht00");
		String nachricht001 = req.getParameter("Nachricht01");
		String nachricht002 = req.getParameter("Nachricht02");
		String nachricht003 = req.getParameter("Nachricht03");
		
		DatenbankAnbindung dba = new DatenbankAnbindung();
		dba.addAnaesthesiebogen(vorname, nachname, geschlecht, gebDat, strasse, plz, ort, antwort002);
		

		resp.setContentType("application/pdf");
		String htmlResp = "";
		htmlResp += "Vorname: " + vorname;
		htmlResp += "\nNachname: " + nachname;
		htmlResp += "\nGeschlecht: " + geschlecht;
		htmlResp += "\nGeburtsdatum: " + gebDat;
		htmlResp += "\nFrage 01: " + antwort002;

		OutputStream os = resp.getOutputStream();
		PDF_Generierung.pdfGenerieren(htmlResp, os);
	}

}
