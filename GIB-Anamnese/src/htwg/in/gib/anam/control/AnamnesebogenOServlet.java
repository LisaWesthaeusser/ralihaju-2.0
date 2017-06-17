package htwg.in.gib.anam.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnamnesebogenOServlet
 */
@SuppressWarnings("serial")
@WebServlet("/GIB-Anamnese/anamnesebogenOrthopaedie")
public class AnamnesebogenOServlet extends AbstractServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String vorname = req.getParameter("Vorname");
		String nachname = req.getParameter("Nachname");


		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		String htmlResponse = "<html>";
		htmlResponse += "<head>";
		htmlResponse += "<body>";
	    htmlResponse +=  "<h2>Ihr Vorname lautet: " + vorname + "</h2>";
		htmlResponse += "<h2>Ihr Nachname lautet: " + nachname + "</h2>";
		htmlResponse += "</body>";
		htmlResponse += "</html>";		
		writer.println(htmlResponse);
	}

}
