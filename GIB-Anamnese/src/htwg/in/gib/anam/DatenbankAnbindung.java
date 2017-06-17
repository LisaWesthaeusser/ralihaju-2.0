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
					// C:/Users/Lisa/git/ralihaju2/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db
					"jdbc:sqlite:C:/Users/Jülide/git/ralihaju-2.0/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db");
			st = con.createStatement();
			result = st.executeQuery("SELECT * FROM BoBogen WHERE BoID = " + bogen.getId());

			if (result.next()) {
				bogen = SQLSelectBogen(id, result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bogen;
	}

	private Bogen SQLSelectBogen(String id, ResultSet result) throws SQLException {

		Bogen bog = new Bogen();
		bog.setFrage1(result.getString("BoFrage1"));
		bog.setId(result.getString("BoID"));
		return bog;
	}

	public void addArzt(String vorname, String nachname, String titel, String username, String passwort) {
		try {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(
					// C:/Users/Lisa/git/ralihaju2/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db
					"jdbc:sqlite:C:/Users/Jülide/git/ralihaju-2.0/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db");
			st = con.createStatement();
			result = st.executeQuery(
					"INSERT INTO ArArzt (ArNachname, ArVorname, ArTitel, ArLogin, ArPasswort) VALUES (" + "'" + nachname
							+ "', '" + vorname + "', '" + titel + "', '" + username + "', '" + passwort + "');");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String sucheBenutzer(String username) {
		String passwort2 = null;

		try {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(
					// C:/Users/Lisa/git/ralihaju2/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db
					"jdbc:sqlite:C:/Users/Jülide/git/ralihaju-2.0/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db");
			st = con.createStatement();
			result = st.executeQuery("SELECT * FROM ArArzt WHERE ArLogin = '" + username + "';");

			if (result.next()) {
				passwort2 = SQLSelectPasswort(username, result);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passwort2;
	}

	private String SQLSelectPasswort(String username, ResultSet result) throws SQLException {
		String passwort2 = "";
		passwort2 = result.getString("ArPasswort");

		return passwort2;
	}

	/*
	 * TODO insert into BewegBO, timestamp inserten evtl. datum feld ! (besser)
	 * und Status bei erfolgreichem Hinzufügen auf OK
	 */
	public void insertBogenIntoStamm(String vorname, String nachname, String antwortGeschlecht, String gebDat) {

		try {
			con = DriverManager.getConnection(
					// C:/Users/Lisa/git/ralihaju2/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db
					"jdbc:sqlite:C:/Users/Jülide/git/ralihaju-2.0/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db");

			st = con.createStatement();

			result = st.executeQuery(
					"INSERT INTO StammBogen (StammNachname, StammVorname, StammGeburtstag, StammGeschlecht) VALUES ('"
							+ nachname + "', '" + vorname + "', '" + antwortGeschlecht + "', '" + gebDat + "');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String readBogenId() {
		String inhalt = null;
		try

		{
			con = DriverManager.getConnection(
					// C:/Users/Lisa/git/ralihaju2/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db
					"jdbc:sqlite:C:/Users/Jülide/git/ralihaju-2.0/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db");

			st = con.createStatement();

			result = st.executeQuery(
					/*
					 * TODO Ausführung stimmt noch nicht so ganz !
					 */
					"SELECT MAX (BewegBoID) FROM BewegBogen;");
			if (result.next()) {
				inhalt = SQLSelect(result);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inhalt;
	}

	private String SQLSelect(ResultSet result) throws SQLException {

		Bogen bog = new Bogen();
		bog.setId(result.getString("BewegBoID"));
		String inhalt = bog.getId();

		return inhalt;
	}

	// public Bogen[] sucheBogenFuerArzt(int ArID) {
	//
	// try {
	// Class.forName("org.sqlite.JDBC");
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// con = DriverManager
	// .getConnection("jdbc:sqlite:C:/Users/Lisa/git/ralihaju2/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db");
	// st = con.createStatement();
	// result = st.executeQuery("INSERT INTO ArArzt (ArNachname, ArVorname,
	// ArTitel, ArLogin, ArPasswort) + VALUES ('"
	// + nachname + "', '" + vorname + "', '" + titel + "', '" + username + "',
	// '" + passwort + "');");
	//
	// }

}

// public static void main(String[] args) {
// DatenbankAnbindung dba = new DatenbankAnbindung();
// System.out.println(dba.sucheBenutzer("Dr.Huber"));
// }
