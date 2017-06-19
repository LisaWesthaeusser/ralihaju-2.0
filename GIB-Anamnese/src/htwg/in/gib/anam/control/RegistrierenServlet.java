package htwg.in.gib.anam.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrierenServlet
 */
@SuppressWarnings("serial")
@WebServlet("/GIB-Anamnese/RegistrierenServlet")
public class RegistrierenServlet extends AbstractServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String vorname = request.getParameter("Vorname");
		String nachname = request.getParameter("Nachname");
		String titel = request.getParameter("Titel");
		String institution = request.getParameter("Institution");
		String strasse = request.getParameter("Strasse");
		String plz = request.getParameter("PLZ");
		String ort = request.getParameter("Ort");
		String hausnummer = request.getParameter("Hausnummer");
		String email = request.getParameter("E-Mail");
		String username = request.getParameter("Account");
		String passwort = request.getParameter("Passwort2");

		DatenbankAnbindung dba = new DatenbankAnbindung();
		dba.addArzt(vorname, nachname, titel, institution, strasse, hausnummer, plz, ort, email, username, passwort);

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		String htmlResponse = "<html>";
		htmlResponse += "<head>";
		htmlResponse += "<body>";
		htmlResponse += "<h2>Ihr Benutzername lautet: " + username + "</h2>";
		htmlResponse += "<h2>Ihr Passwort lautet: " + passwort + "</h2>";
		htmlResponse += "<h2>Ihr Benutzername lautet: " + username + "</h2>";
		htmlResponse += "</body>";
		htmlResponse += "</html>";
		writer.println(htmlResponse);
	}

}
