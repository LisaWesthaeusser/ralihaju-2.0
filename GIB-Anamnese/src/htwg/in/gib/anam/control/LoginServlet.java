package htwg.in.gib.anam.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@SuppressWarnings("serial")
@WebServlet("/GIB-Anamnese/login")
public class LoginServlet extends AbstractServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String passwortVergleich = "";
		
		String username = request.getParameter("Klinik");
		String passwort = request.getParameter("Passwort");
		
		DatenbankAnbindung dba = new DatenbankAnbindung();
		passwortVergleich = dba.sucheBenutzer(username);

		if(passwort.equals(passwortVergleich)){
					
		response.setContentType("text/html");
		RequestDispatcher view = request.getRequestDispatcher("html/Arzt.jsp");
		view.forward(request, response);
	
	} else {
		response.setContentType("text/html");
		RequestDispatcher view = request.getRequestDispatcher("html/Login.jsp");
		view.forward(request, response);
	}
	}
}
