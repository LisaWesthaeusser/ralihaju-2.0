package htwg.in.gib.anam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatenbankAnbindung {

	ResultSet result = null;
	Statement st = null;
	Connection con = null;
	String kette = null;

	public Bogen readBogen(String id) {
		Bogen bogen = new Bogen();
		bogen.setId(id);

		try {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(
					"jdbc:sqlite:C:/Users/Lisa/git/ralihaju2/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db");
			st = con.createStatement();
			result = st.executeQuery("SELECT * FROM BoBogen WHERE BoID = " + id);

			if (result.next()) {
				bogen = SQLSelect(id, result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bogen;
	}

	private Bogen SQLSelect(String id, ResultSet result) throws SQLException {

		Bogen bog = new Bogen();
		bog.setFrage1(result.getString("BoFrage1"));
		bog.setId(result.getString("BoID"));
		return bog;
	}
	
	public void addArzt(String vorname, String nachname, String titel, String username, String passwort){
		try {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(
					"jdbc:sqlite:C:/Users/Lisa/git/ralihaju2/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db");
			st = con.createStatement();
			result = st.executeQuery("INSERT INTO ArArzt (ArNachname, ArVorname, ArTitel, ArLogin, ArPasswort) VALUES (" 
					+ "'" + nachname + "', '"
					+ vorname + "', '"
					+ titel + "', '"
					+ username + "', '"
					+ passwort + "');");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	// public static void main(String[] args) {
	// Bogen bogen = new Bogen();
	// DatenbankAnbindung dba = new DatenbankAnbindung();
	// bogen = dba.readBogen("1");
	// System.out.println(bogen.getFrage1());
	// }

}
