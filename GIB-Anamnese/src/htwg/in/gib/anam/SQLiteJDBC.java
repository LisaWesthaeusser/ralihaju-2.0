package htwg.in.gib.anam;

import java.sql.*;

public class SQLiteJDBC {
	public static void main(String args[]) {
		Connection c = null;
		try {
			Class.forName("com.example.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:sqlite:WebContent/WEB-INF/Datenbank.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}
}
