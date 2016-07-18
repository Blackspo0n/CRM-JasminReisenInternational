package crm.JasminReisen.Functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import crm.JasminReisen.Main;

public class DbFunctions {
	private static Statement statement = null;
	private static Connection connection = null;
	private static String sql = null;
	private static ResultSet rs = null;

	public static Connection connect(String ipAdresse, String db, String port, String benutzerName, String passwort) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://" + ipAdresse + ":" + port + "/" + db + "?useSSL=false", benutzerName, passwort);
			statement = connection.createStatement();

			return connection;

		} catch (Exception e) {
			return null;
			// throw new IllegalStateException(e);
		}

	}

	public static DefaultTableModel getFilteredCustomers(String name) {

		String col[] = { "Name", "Vorname", "Strasse", "Ort", "PLZ", "Land", "Telefon", "Email", "Geburtstag" };
		DefaultTableModel dtm = new DefaultTableModel(col, 0);

		try {
			Connection connection = connect("193.175.199.130", "CRM", "3306", "whs", "whs2016"); // ANZUPASSEN,
																									// CONNECTION!
			Statement statement = connection.createStatement(); // ANZUPASSEN,
																// CONNECTION!
			ResultSet rs = statement.executeQuery("SELECT * FROM Kunden WHERE Name =" + name);
			while (rs.next()) {
				Object[] objs = new Object[9];
				objs[0] = rs.getString("Name");
				objs[1] = rs.getString("Vorname");
				objs[2] = rs.getString("Strasse");
				objs[3] = rs.getString("PLZ");
				objs[4] = rs.getString("Ort");
				objs[5] = rs.getString("Land");
				objs[6] = rs.getString("Telefon");
				objs[7] = rs.getString("EMail");
				Date geburtstag = rs.getDate("GebDat");
				objs[8] = new SimpleDateFormat("dd.MM.yyyy").format(geburtstag);
				dtm.addRow(objs);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return dtm;

	}

}
