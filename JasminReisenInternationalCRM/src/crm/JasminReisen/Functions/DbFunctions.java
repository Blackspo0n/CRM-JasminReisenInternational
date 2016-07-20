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

import crm.JasminReisen.models.Kunde;
import crm.JasminReisen.GUI.SpecEntryFrame;
import crm.JasminReisen.GUI.TripEntryFrame;
import crm.JasminReisen.models.User;

public class DbFunctions {
	private static Statement statement = null;
	private static Connection connection = null;
	private static String sql = null;
	private static ResultSet rs = null;
	private static final String ipAdresse = ";_=.;][.;__.;=:";
	private static final String port = "==:\\";
	private static final String db = "PEZ";
	private static final String benutzerName = "juf";
	private static final String password = "juf<:;\\";

	public static Connection connect() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://" + ServiceFunctions.String(ipAdresse) + ":" + 
							ServiceFunctions.String(port) + "/" + 
							ServiceFunctions.String(db) + "?useSSL=false", 
							ServiceFunctions.String(benutzerName), 
							ServiceFunctions.String(password));
			statement = connection.createStatement();

			return connection;

		} catch (Exception e) {
			return null;
			// throw new IllegalStateException(e);
		}
	}
	public static void login(String username, String password) {
		sql = "Select * from Benutzer";

		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static DefaultTableModel getFilteredCustomers(String sql) {
		String col[] = { "ID", "Name", "Vorname", "Strasse", "Ort", "PLZ", "Land", "Telefon", "Email", "Geburtstag" };
		DefaultTableModel dtm = new DefaultTableModel(col, 0);

		try {
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object[] objs = new Object[10];
				objs[0] = rs.getInt("Kundennummer");
				objs[1] = rs.getString("Name");
				objs[2] = rs.getString("Vorname");
				objs[3] = rs.getString("Strasse");
				objs[4] = rs.getString("PLZ");
				objs[5] = rs.getString("Ort");
				objs[6] = rs.getString("Land");
				objs[7] = rs.getString("Telefon");
				objs[8] = rs.getString("EMail");
				Date geburtstag = rs.getDate("GebDat");
				if (geburtstag != null) {
					objs[9] = new SimpleDateFormat("dd.MM.yyyy").format(geburtstag);
				}
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
	public static List<String> getVehicleList() 
	{
		List<String> vehicleList = new ArrayList<String>();
		
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM Transportmittel");
			vehicleList.add("");
			while (rs.next()) {
				vehicleList.add(rs.getString("TransportName"));
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
	
		return vehicleList;
	}
	public static List<String> getClimateList() 
		{
			List<String> vehicleList = new ArrayList<String>();
			
			try {
				statement = connection.createStatement();
				rs = statement.executeQuery("SELECT * FROM Klima");
				vehicleList.add("");
				while (rs.next()) {
					vehicleList.add(rs.getString("Klimabeschreibung"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return vehicleList;
		}	
	public static List<String> getThemeList() 
	{
		List<String> vehicleList = new ArrayList<String>();
				
				try {
					statement = connection.createStatement();
					rs = statement.executeQuery("SELECT * FROM Themen");
					vehicleList.add("");
					while (rs.next()) {
						vehicleList.add(rs.getString("ThemenName"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return vehicleList;	
	}
	public static List<String> getHotelList() 
	{
		List<String> vehicleList = new ArrayList<String>();
				
				try {
					statement = connection.createStatement();
					rs = statement.executeQuery("SELECT * FROM Hotels");
					vehicleList.add("");
					while (rs.next()) {
						vehicleList.add(rs.getString("HotelName"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return vehicleList;	
	}
	public static List<String> getRegionList() 
	{
		List<String> vehicleList = new ArrayList<String>();
				
				try {
					statement = connection.createStatement();
					rs = statement.executeQuery("SELECT * FROM Regionen");
					vehicleList.add("");
					while (rs.next()) {
						vehicleList.add(rs.getString("RegionenName"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return vehicleList;	
	}
	
	
	public static void createTrip(TripEntryFrame frame)
	{
		
		
		String date1 = frame.getStartDate().getJFormattedTextField().getText();
		String date2 = frame.getEndDate().getJFormattedTextField().getText();
		String date3 = frame.getAvailableDate().getJFormattedTextField().getText();
		

		/*String newDateString1 = date1.substring(6, 10) + "-" + date1.substring(3,5) +  "-" + date1.substring(0,2);
		String newDateString2 = date2.substring(6, 10) + "-" + date2.substring(3,5) +  "-" + date2.substring(0,2);
		String newDateString3 = date3.substring(6, 10) + "-" + date3.substring(3,5) +  "-" + date3.substring(0,2);
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date3);*/
		sql = "INSERT INTO Reisen (Reisebeginn, Reiseende, Zielort, TransportmittelID, "
            + "Kontingent, VerfuegbarAb, Name, Beschreibung, Region, Thema, KlimaID, "
            + "Preis, HotelID) "
            + "VALUES ('" + date1 + "', '" + date2 + "', "
            + "'" + frame.getZielortField().getText() + "', "
            + "'" + frame.getTransportmittelIdBox().getSelectedIndex() + "', "
            + "'" + frame.getPlaetzeField().getText() + "', "
            + "'" + date3 + "', "
            + "'" + frame.getTripNameField().getText() + "', "
            + "'" + frame.getBeschreibungArea().getText() + "', "
            + "'" + frame.getRegionBox().getSelectedIndex() + "', "
            + "'" + frame.getThemaBox().getSelectedIndex() + "', "
            + "'" + frame.getKlimaIdBox().getSelectedIndex() + "', "
            + "'" + frame.getPreisField().getText() + "', "
            + "'" + frame.getHotelIdBox().getSelectedIndex() + "'"
            + ");";
			System.out.println(sql);
			try
		{
			connect();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
 	
	}

	public static boolean createCostumer(Kunde customer) throws SQLException {

		if(customer == null) throw new SQLException("Customer cannot be null");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String sql = "INSERT INTO Kunden (Name, Vorname, Strasse, PLZ, Ort, Land, Telefon, EMail, GebDat)"
				+ "VALUES ('"
				+ customer.getName() + "','" +  customer.getVorname() + "','" +  customer.getStrasse() + "','" + customer.getPLZ()
				+ "','" + customer.getOrt() + "','" + customer.getLand() + "','" + customer.getTelefon() + "','" + customer.getEMail()
				+ "','" + ((customer.getGebDat() != null) ? sdf.format(customer.getGebDat()) : "\\N")+ "')";
		
		if(statement.executeUpdate(sql) != 0) {
			return true;
		}
		return false;
		
	}
	public static boolean saveCostumer(Kunde customer) throws SQLException {
		if(customer == null) throw new SQLException("Customer cannot be null");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String sql = "UPDATE Kunden SET "
					+ "Name = '" + customer.getName() + "',"
					+ "Vorname = '" +  customer.getVorname() + "',"
					+ "Strasse = '" +  customer.getStrasse() + "',"
					+ "PLZ = '" + customer.getPLZ() + "',"
					+ "Ort = '" + customer.getOrt() + "',"
					+ "Land = '" + customer.getLand() + "',"
					+ "Telefon = '" + customer.getTelefon() + "',"
					+ "EMail = '" + customer.getEMail() + "',"
					+ "GebDat = '" + ((customer.getGebDat() != null) ? sdf.format(customer.getGebDat()) : "\\N")+ "' WHERE Kundennummer = " + customer.getKundennummer();
		
		System.out.println(sql);
		if(statement.executeUpdate(sql) != 0) {
			return true;
		}
		return false;
	}
	
	public static Kunde getKunde (int id) {
		Kunde kunde = new Kunde();
		
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM Kunden WHERE Kundennummer = '" + id + "'");
			
			while (rs.next()) {
				kunde.setName(rs.getString("Name"));
				kunde.setVorname(rs.getString("Vorname"));
				kunde.setStrasse(rs.getString("Strasse"));
				kunde.setPLZ(rs.getString("PLZ"));
				kunde.setOrt(rs.getString("Ort"));
				kunde.setLand(rs.getString("Land"));
				kunde.setTelefon(rs.getString("Telefon"));
				kunde.setEMail(rs.getString("EMail"));
				kunde.setGebDat(rs.getDate("GebDat"));
				kunde.setKundennummer(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return kunde;	
		
	}
	
	public static void createSpec(SpecEntryFrame frame, String spec)
	{
		connect();
		sql = "INSERT INTO " + spec + " VALUES ('" + frame.getEntry().getText() + "');";
		try 
		{
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
