package htwg.in.gib.anam.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import htwg.in.gib.anam.model.Bogen;

public class DatenbankAnbindung {

	ResultSet result = null;
	Statement st = null;
	Connection con = null;
	String kette = null;
	
	public int sucheNachMaxIDinDB(String spalteMitID, String tabelle) {

		int id = 0;

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
			result = st.executeQuery("SELECT MAX(" + spalteMitID + ")FROM '" + tabelle + "';");

			if (result.next()) {
				id = SQLSelectID(spalteMitID, result);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	private int SQLSelectID(String spalteMitID, ResultSet result) throws SQLException {
		int id = 0;
		id = result.getInt(spalteMitID);

		return id;
	}

	// public Bogen readBogen(String id) {
	// Bogen bogen = new Bogen();
	// bogen.setId(id);
	//
	// try {
	// try {
	// Class.forName("org.sqlite.JDBC");
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// con = DriverManager.getConnection(
	// "jdbc:sqlite:C:/Users/Jülide/git/ralihaju-2.0/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db");
	// st = con.createStatement();
	// result = st.executeQuery("SELECT * FROM BoBogen WHERE BoID = " + id);
	//
	// if (result.next()) {
	// bogen = SQLSelectBogen(id, result);
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return bogen;
	// }

//	private Bogen SQLSelectBogen(String id, ResultSet result) throws SQLException {
//
//		Bogen bog = new Bogen();
//		bog.setFrage1(result.getString("BoFrage1"));
//		bog.setId(result.getString("BoID"));
//		return bog;
//	}

	public void addArzt(String vorname, String nachname, String titel, String username, String passwort) {
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
					"jdbc:sqlite:C:/Users/Lisa/git/ralihaju2/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db");
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

	// public Bogen[] sucheBogenFuerArzt(int ArID) {
	// try {
	// try {
	// Class.forName("org.sqlite.JDBC");
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// con = DriverManager.getConnection(
	// "jdbc:sqlite:C:/Users/Lisa/git/ralihaju2/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db");
	// st = con.createStatement();
	// result = st.executeQuery(
	// "INSERT INTO ArArzt (ArNachname, ArVorname, ArTitel, ArLogin, ArPasswort)
	// VALUES (" + "'" + nachname
	// + "', '" + vorname + "', '" + titel + "', '" + username + "', '" +
	// passwort + "');");
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }

	// public static void main(String[] args) {
	// DatenbankAnbindung dba = new DatenbankAnbindung();
	// System.out.println(dba.sucheBenutzer("Dr.Huber"));
	// }

	public void insertIntoStamm(String vorname, String nachname, String antwortGeschlecht, String gebDat,
			String strasse, String plz, String ort) {
		try {

			Class.forName("org.sqlite.JDBC");

			con = DriverManager.getConnection(
					"jdbc:sqlite:C:/Users/Jülide/git/ralihaju-2.0/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db");
			st = con.createStatement();
			st.executeUpdate(
					"INSERT INTO StammBogen (StammNachname, StammVorname, StammGeschlecht, StammGeburtstag,StammStrasse,StammOrt) VALUES ('"
							+ nachname + "', '" + vorname + "', '" + antwortGeschlecht + "', '" + gebDat + "', '"
							+ strasse + "' , '" + ort + "');");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int readStammID() {
		int id = 0;
		try {
			
				Class.forName("org.sqlite.JDBC");
			 
			con = DriverManager.getConnection(
					"jdbc:sqlite:C:/Users/Jülide/git/ralihaju-2.0/GIB-Anamnese/WebContent/WEB-INF/Datenbank.db");
			st = con.createStatement();
			result = st.executeQuery("SELECT MAX (StammID) FROM StammBogen;");

			if (result.next()) {
				
				id += SQLSelectIDFromResultSet(result);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return id;
	}

	private int SQLSelectIDFromResultSet(ResultSet result2) throws SQLException {
		
		int id = result2.getInt("StammID");
		return id;
	}
	
	public void addAnaesthesieBogenStammDaten(String vorname, String nachname, String geschlecht, String gebDat,
			String strasse, String plz, String ort) {
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
			result = st.executeQuery(
					"INSERT INTO StammBogen (StammNachname, StammVorname, StammGeburtstag, StammGeschlecht, StammStrasse, StammPLZ, StammOrt)"
							+ "VALUES ('" + nachname + "', '" + vorname + "', '" + geschlecht + "', '" + gebDat + "', '"
							+ strasse + "', '" + plz + "', '" + ort + "');");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addAnaesthesieBogenBewegDaten() {
		Integer stammID = sucheNachMaxIDinDB("StammID", "StammBogen");

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
			result = st.executeQuery("INSERT INTO AnAntwort (StammAnID)" + "VALUES ('" + stammID + "');");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addAnaesthesieBogenBewegDatenAntworten(String antwort) {

		Integer bewegID = sucheNachMaxIDinDB("BewegBoID", "BewegBogen");

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
			result = st.executeQuery(
					"INSERT INTO AnAntwort (AnInhalt, BewegAnID)" + "VALUES ('" + antwort + "', '" + bewegID + "');");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addAnaesthesiebogen(String vorname, String nachname, String geschlecht, String gebDat, String strasse,
			String plz, String ort, String antwort) {
		addAnaesthesieBogenStammDaten(vorname, nachname, geschlecht, gebDat, strasse, plz, ort);
		addAnaesthesieBogenBewegDaten();
		addAnaesthesieBogenBewegDatenAntworten(antwort);
	}
	
	public static void main(String[] args) {
		DatenbankAnbindung dba = new DatenbankAnbindung();
		dba.addArzt("gh", "hj", "hj", "io", "hjk");		
		dba.addAnaesthesiebogen("vor", "gh", "ghj", "ghj", "ghj", "12345", "dfg", "dfg");
	}
}
