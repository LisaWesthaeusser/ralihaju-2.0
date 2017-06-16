package htwg.in.gib.anam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/GIB-Anamnese/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String passwortVergleich = "";
		
		String username = request.getParameter("Klinik");
		String passwort = request.getParameter("Passwort");
		
		DatenbankAnbindung dba = new DatenbankAnbindung();
		passwortVergleich = dba.sucheBenutzer(username);

		if(passwort.equals(passwortVergleich)){
					
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String htmlResponse = "<html>";
		htmlResponse += "<head>";
		htmlResponse += "<body>";
	    htmlResponse +=  "<h2>Ihr Benutzername lautet: " + username + "</h2>";
		htmlResponse += "<h2>Ihr Passwort lautet: " + passwort + "</h2>";
	    htmlResponse +=  "<h2>Ihr Benutzername lautet: " + username + "</h2>";
		htmlResponse += "</body>";
		htmlResponse += "</html>";		
		writer.println(htmlResponse);
	
	} else {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String htmlResponse = "<html>";
		htmlResponse += "<head>";
		htmlResponse += "<body>";
	    htmlResponse +=  "<h2> Falsches Passwort! </h2>";
		htmlResponse += "</body>";
		htmlResponse += "</html>";		
		writer.println(htmlResponse);
	}
	}
}
