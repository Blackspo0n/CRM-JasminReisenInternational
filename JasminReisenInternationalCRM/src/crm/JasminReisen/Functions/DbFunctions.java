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
		System.out.println("ASAFLKJASF");
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

	public static DefaultTableModel getFilteredTrips(String sql) {

		String col[] = { "Name", "Zielort", "Thema", "Region", "Hotel", "Preis", "Gruppengröße", "Kontingent",
				"Verfügbar Ab", "Reisebeginn", "Reiseende", "Beschreibung" };
		DefaultTableModel dtm = new DefaultTableModel(col, 0);

		try {
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object[] objs = new Object[12];
				objs[0] = rs.getString("Name");
				objs[1] = rs.getString("Zielort");
				objs[2] = rs.getString("Thema");
				objs[3] = rs.getString("Region");
				//objs[4] = rs.getString("Hotel");
				objs[5] = rs.getString("Preis");
				objs[6] = rs.getString("Gruppengroesse");
				objs[7] = rs.getString("Kontingent");
				objs[8] = rs.getString("VerfuegbarAb");
				objs[9] = rs.getString("Reisebeginn");
				objs[10] = rs.getString("Reiseende");
				objs[11] = rs.getString("Beschreibung");
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
				userList.add(new User(rs.getInt("BenutzerId"), rs.getString("BenutzerName"), rs.getString("Passwort")));
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
				vehicleList.add(rs.getString("TransportName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vehicleList;
	}
	
	public static List<String> getHotelsList() {
		List<String> hotelList = new ArrayList<String>();

		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM Hotel");
			hotelList.add("");
			while (rs.next()) {
				hotelList.add(rs.getString("HotelName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hotelList;
	}
	
	public static List<String> getRegionList() {
		List<String> regionList = new ArrayList<String>();

		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM Region");
			regionList.add("");
			while (rs.next()) {
				regionList.add(rs.getString("RegionName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return regionList;
	}
	
	public static List<String> getThemenList() {
		List<String> themenList = new ArrayList<String>();

		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM Themen");
			themenList.add("");
			while (rs.next()) {
				themenList.add(rs.getString("ThemenName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return themenList;
	}
	
	public static List<String> getKlimaList() {
		List<String> klimaList = new ArrayList<String>();

		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM Klima");
			klimaList.add("");
			while (rs.next()) {
				klimaList.add(rs.getString("KlimaBeschreibung"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return klimaList;
	}
	

	public static void createTrip(TripEntryFrame frame) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = sdf.format(frame.getVerfuegbarField().getText());
		String date2 = sdf.format(frame.getReiseEndeField().getText());
		String date3 = sdf.format(frame.getReisebeginnField().getText());

		sql = "INSERT INTO Reisen (`Reiseende`, `Reisebeginn`, `Zielort`, `Transportmittelid`,"
				+ "`Kontingent`, `VerfuegbarAb`, `Name`, `Beschreibung`, `Region`, `Thema`,"
				+ "`KlimaID`, `Preis`, `HotelID`) " + "VALUES (" + date2 + ", " + date3 + ", "
				+ frame.getZielortField().getText() + ", " + frame.getTransportmittelIdField().getText() + ", "
				+ frame.getPlaetzeField().getText() + ", " + date1 + ", " + frame.getTripNameField().getText() + ", "
				+ frame.getBeschreibungArea().getText() + ", " + frame.getRegionField().getText() + ", "
				+ frame.getThemaField().getText() + ", " + frame.getKlimaId().getText() + ", "
				+ frame.getPreisField().getText() + ", " + frame.getHotelIdField() + ");";

		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean createCostumer(Kunde customer) throws SQLException {

		if (customer == null)
			throw new SQLException("Customer cannot be null");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String sql = "INSERT INTO Kunden (Name, Vorname, Strasse, PLZ, Ort, Land, Telefon, EMail, GebDat)" + "VALUES ('"
				+ customer.getName() + "','" + customer.getVorname() + "','" + customer.getStrasse() + "','"
				+ customer.getPLZ() + "','" + customer.getOrt() + "','" + customer.getLand() + "','"
				+ customer.getTelefon() + "','" + customer.getEMail() + "','"
				+ ((customer.getGebDat() != null) ? sdf.format(customer.getGebDat()) : "\\N") + "')";

		if (statement.executeUpdate(sql) != 0) {
			return true;
		}
		return false;

	}
	
	public static Kunde getKundenDaten (int id) {
		Kunde kunde = new Kunde();
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM Kunden WHERE Kundennummer = '" + id + "'");
			while (rs.next()) {
				kunde.setEMail(rs.getString("EMail"));
				kunde.setName(rs.getString("Name"));
				kunde.setVorname(rs.getString("Vorname"));
				kunde.setPLZ(rs.getString("PLZ"));
				kunde.setOrt(rs.getString("Ort"));
				kunde.setLand(rs.getString("Land"));
				kunde.setTelefon(rs.getString("Telefon"));
				kunde.setStrasse(rs.getString("Strasse"));
				kunde.setGebDat(rs.getDate("GebDat"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return kunde;
	}

	public static boolean saveCostumer(Kunde customer) throws SQLException {
		if (customer == null)
			throw new SQLException("Customer cannot be null");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String sql = "UPDATE Kunden SET " + "Name = '" + customer.getName() + "'," + "Vorname = '"
				+ customer.getVorname() + "'," + "Strasse = '" + customer.getStrasse() + "'," + "PLZ = '"
				+ customer.getPLZ() + "'," + "Ort = '" + customer.getOrt() + "'," + "Land = '" + customer.getLand()
				+ "'," + "Telefon = '" + customer.getTelefon() + "'," + "EMail = '" + customer.getEMail() + "',"
				+ "GebDat = '" + ((customer.getGebDat() != null) ? sdf.format(customer.getGebDat()) : "\\N")
				+ "' WHERE Kundennummer = " + customer.getKundennummer();

		System.out.println(sql);
		if (statement.executeUpdate(sql) != 0) {
			return true;
		}
		return false;
	}
	


}
