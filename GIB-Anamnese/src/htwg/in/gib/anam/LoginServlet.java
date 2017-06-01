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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("Klinik");
		String passwort = request.getParameter("Passwort");

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String htmlResponse = "<html>";
		htmlResponse += "<head>";
		htmlResponse += "<body>";
	    htmlResponse +=  "<h2>Ihr Benutzername lautet: " + username + "</h2>";
		htmlResponse += "<h2>Ihr Passwort lautet: " + passwort + "</h2>";
		htmlResponse += "</body>";
		htmlResponse += "</html>";		
		writer.println(htmlResponse);
	}

}
