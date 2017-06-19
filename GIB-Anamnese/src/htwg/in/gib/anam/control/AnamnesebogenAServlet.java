package htwg.in.gib.anam.control;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import htwg.in.gib.anam.model.Bogen;
import htwg.in.gib.anam.model.PDF_Generierung;

/**
 * Servlet implementation class AnamnesebogenAServlet
 */

@SuppressWarnings("serial")
@WebServlet("/GIB-Anamnese/anamnesebogenAnaesthesie")
public class AnamnesebogenAServlet extends AbstractServlet {
	
	public String nurArztID(String arztText){
		String arztID = "";
		char[] chars = new char[arztText.length()];
		boolean test = false;
		arztText.getChars(0, arztText.length(), chars, 0);
		for(int i = 0; i < chars.length; i++){
			if(chars[i] == ')'){
				test = false;				
			} 
			if(test == true){
				arztID += chars[i];
			}
			if(chars[i] == '('){
				test = true;
			}		
		}
		return arztID;
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<String> antworten = new ArrayList<String>();
		antworten.add(req.getParameter("Vorname"));
		antworten.add(req.getParameter("Nachname"));
		antworten.add(req.getParameter("Geschlecht"));
		antworten.add(req.getParameter("gebDat"));
		antworten.add(req.getParameter("Str"));
		antworten.add(req.getParameter("PLZ"));
		antworten.add(req.getParameter("Ort"));
		antworten.add(req.getParameter("Beruf"));
		antworten.add(req.getParameter("Antwort002"));
		antworten.add(req.getParameter("Antwort003"));
		antworten.add(req.getParameter("Antwort004"));
		antworten.add(req.getParameter("Antwort005"));
		antworten.add(req.getParameter("Frage001"));
		antworten.add(req.getParameter("Frage002"));
		antworten.add(req.getParameter("Frage003"));
		antworten.add(req.getParameter("Frage003"));

		String arzt = req.getParameter("anWelchenArzt");

		Bogen bogen = new Bogen();
		DatenbankAnbindung dba = new DatenbankAnbindung();
//		int arztID = Integer.parseInt(nurArztID(arzt));
		dba.addAnaesthesieBogenBewegBogen(1);
		
		for(int i = 0; i < antworten.size(); i++){
			dba.addAnaesthesieBogenBewegDatenAntworten(antworten.get(i), "" + i);
		}

//		bogen.setId(dba.sucheNachMaxIDinDB("BewegID", "BewegBogen"));

		resp.setContentType("text/html");
		
		PrintWriter w = resp.getWriter();
		String htmlResp = "<html>";
		htmlResp += "<head>";
		htmlResp += "<body>";


		List<String> fragen = dba.selectFragen();
		
		for(int i = 0; i < fragen.size(); i++){
			htmlResp += "<h2>" + fragen.get(i) + ":<br>" + (antworten.get(i)+1) + "<br><br> </h2>";
		}
		
		w.println(htmlResp);
		
//		OutputStream os = resp.getOutputStream();
//		PDF_Generierung.pdfGenerieren(htmlResp, os, bogen);
	}
	
	public static void main(String[] args) {
		AnamnesebogenAServlet a = new AnamnesebogenAServlet();
	System.out.println(a.nurArztID("Hallo(123)"));
	}
}
