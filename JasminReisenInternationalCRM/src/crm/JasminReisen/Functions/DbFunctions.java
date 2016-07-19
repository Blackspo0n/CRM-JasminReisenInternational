package crm.JasminReisen.Functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import crm.JasminReisen.Main;
import crm.JasminReisen.models.User;

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

	
	public static void login (String username, String password)
	{
		sql = "Select * from Benutzer";
		
		
		try 
		{
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	


	public static DefaultTableModel getFilteredCustomers(String name) {

		String col[] = { "Name", "Vorname", "Strasse", "Ort", "PLZ", "Land", "Telefon", "Email", "Geburtstag" };
		DefaultTableModel dtm = new DefaultTableModel(col, 0);

		try {
			rs = statement.executeQuery("SELECT * FROM Kunden WHERE Name = '" + name + "'");
			while (rs.next()) {
				Object[] objs = new Object[9];
				objs[0] = rs.getString("Name");
				objs[1] = rs.getString("Vorname");
				objs[2] = rs.getString("Strasse");
				objs[3] = rs.getString("PLZ");
				objs[4] = rs.getString("Ort");
//				objs[5] = rs.getString("Land");
				objs[6] = rs.getString("Telefon");
				objs[7] = rs.getString("EMail");
				Date geburtstag = rs.getDate("GebDat");
				if (geburtstag != null) {
					objs[8] = new SimpleDateFormat("dd.MM.yyyy").format(geburtstag);
				}
				dtm.addRow(objs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtm;

	}
	}
	
	public static List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM Benutzer");
			
			while (rs.next()) {
				userList.add(new User( rs.getInt("BenutzerId"), rs.getString("BenutzerName"), rs.getString("Passwort")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
		
	}
}
