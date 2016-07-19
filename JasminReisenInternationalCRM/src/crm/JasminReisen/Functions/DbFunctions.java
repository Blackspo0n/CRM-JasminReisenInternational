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
import crm.JasminReisen.GUI.TripEntryFrame;
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

		String col[] = { "Name", "Vorname", "Strasse", "Ort", "PLZ", "Land", "Telefon", "Email", "Geburtstag", "Kundennummer" };
		DefaultTableModel dtm = new DefaultTableModel(col, 0);

		try {
			rs = statement.executeQuery("SELECT * FROM Kunden WHERE Name LIKE '%" + name + "%'");
			while (rs.next()) {
				Object[] objs = new Object[10];
				objs[0] = rs.getString("Name");
				objs[1] = rs.getString("Vorname");
				objs[2] = rs.getString("Strasse");
				objs[3] = rs.getString("PLZ");
				objs[4] = rs.getString("Ort");
				objs[5] = rs.getString("Land");
				objs[6] = rs.getString("Telefon");
				objs[7] = rs.getString("EMail");
				Date geburtstag = rs.getDate("GebDat");
				if (geburtstag != null) {
					objs[8] = new SimpleDateFormat("dd.MM.yyyy").format(geburtstag);
				}
				objs[9] = rs.getString("Kundennummer");
				dtm.addRow(objs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtm;

	}
	
	public static DefaultTableModel getFilteredTrips(String name) {

		String col[] = { "Name", "Vorname", "Strasse", "Ort", "PLZ", "Land", "Telefon", "Email", "Geburtstag", "Kundennummer" };
		DefaultTableModel dtm = new DefaultTableModel(col, 0);

		try {
			rs = statement.executeQuery("SELECT * FROM Kunden WHERE Name LIKE '%" + name + "%'");
			while (rs.next()) {
				Object[] objs = new Object[10];
				objs[0] = rs.getString("Name");
				objs[1] = rs.getString("Vorname");
				objs[2] = rs.getString("Strasse");
				objs[3] = rs.getString("PLZ");
				objs[4] = rs.getString("Ort");
				objs[5] = rs.getString("Land");
				objs[6] = rs.getString("Telefon");
				objs[7] = rs.getString("EMail");
				Date geburtstag = rs.getDate("GebDat");
				if (geburtstag != null) {
					objs[8] = new SimpleDateFormat("dd.MM.yyyy").format(geburtstag);
				}
				objs[9] = rs.getString("Kundennummer");
				dtm.addRow(objs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtm;

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
	public static List<String> getVehicleList() {
		List<String> vehicleList = new ArrayList<String>();
		
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM Transportmittel");
			vehicleList.add("");
			while (rs.next()) {
				vehicleList.add(rs.getString("Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vehicleList;
	}
	public static void createTrip(TripEntryFrame frame)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = sdf.format(frame.getVerfuegbarField().getText());
		String date2 = sdf.format(frame.getReiseEndeField().getText());
		String date3 = sdf.format(frame.getReisebeginnField().getText());
		
		
		sql = "INSERT INTO Reisen (`Reiseende`, `Reisebeginn`, `Zielort`, `Transportmittelid`,"
		    + "`Kontingent`, `VerfuegbarAb`, `Name`, `Beschreibung`, `Region`, `Thema`,"
		    + "`KlimaID`, `Preis`, `HotelID`) "
		    + "VALUES (" + date2 + ", " + date3
		    + ", " + frame.getZielortField().getText() + ", " + frame.getTransportmittelIdField().getText()
		    + ", " + frame.getPlaetzeField().getText() + ", " + date1
			+ ", " + frame.getTripNameField().getText() + ", " + frame.getBeschreibungArea().getText()
			+ ", " + frame.getRegionField().getText() + ", " + frame.getThemaField().getText()
			+ ", " + frame.getKlimaId().getText() + ", " + frame.getPreisField().getText()
			+ ", " + frame.getHotelIdField() + ");";
		
			try 
				{
					statement.executeUpdate(sql);
				} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
 	}
}
