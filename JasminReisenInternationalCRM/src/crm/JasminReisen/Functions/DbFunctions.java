package crm.JasminReisen.Functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import crm.JasminReisen.models.HistoryReise;
import crm.JasminReisen.models.Kunde;
import crm.JasminReisen.models.Reise;
import crm.JasminReisen.GUI.ContactDescriptionFrame;
import crm.JasminReisen.GUI.EmailMessageFrame;
import crm.JasminReisen.GUI.NewsletterMessageFrame;
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
					"jdbc:mysql://" + ServiceFunctions.String(ipAdresse) + ":" + ServiceFunctions.String(port) + "/"
							+ ServiceFunctions.String(db) + "?useSSL=false",
					ServiceFunctions.String(benutzerName), ServiceFunctions.String(password));
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
		String col[] = { "ID", "Name", "Vorname", "Strasse", "PLZ", "Ort", "Land", "Telefon", "Email", "Geburtstag" };
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

		String col[] = { "ID", "Name", "Preis", "Reise Beginn", "Reise Ende", "Zielort", "Land", "Thema", "Hotel",
				"Transportmittel", "Kontingent" };
		DefaultTableModel dtm = new DefaultTableModel(col, 0);

		try {
			System.out.println(sql);
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object[] objs = new Object[11];
				objs[0] = rs.getInt("ReiseID");
				objs[1] = rs.getString("Name");
				objs[2] = rs.getString("Preis");
				Date Reisebeginn = rs.getDate("Reisebeginn");
				if (Reisebeginn != null) {
					objs[3] = new SimpleDateFormat("dd.MM.yyyy").format(Reisebeginn);
				}

				Date Reiseende = rs.getDate("Reiseende");
				if (Reiseende != null) {
					objs[4] = new SimpleDateFormat("dd.MM.yyyy").format(Reiseende);
				}

				objs[5] = rs.getString("Zielort");
				objs[6] = rs.getString("Land");
				objs[7] = rs.getString("ThemenName");
				objs[8] = rs.getString("HotelName");
				objs[9] = rs.getString("TransportName");
				objs[10] = rs.getString("Kontingent");
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

	public static List<String> getClimateList() {
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

	public static List<String> getThemeList() {
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

	public static List<String> getActionList() {
		List<String> actionList = new ArrayList<String>();

		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM Aktionen");
			while (rs.next()) {
				actionList.add(rs.getString("AktionsName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actionList;
	}

	public static List<String> getHotelList() {
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

	public static List<String> getRegionList() {
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

	public static boolean createTrip(Reise trip) throws SQLException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		sql = "INSERT INTO Reisen (Reisebeginn, Reiseende, Zielort, TransportmittelID, "
				+ "Kontingent, VerfuegbarAb, Name, Beschreibung, RegionID, ThemaID, KlimaID, "
				+ "Preis, HotelID, GruppenGroesse) " + "VALUES (" + "'" + sdf.format(trip.getReiseBeginn()) + "', "
				+ "'" + sdf.format(trip.getReiseEnde()) + "', " + "'" + trip.getZielOrt() + "', "
				+ trip.getTransportmittelID() + ", " + trip.getKontingent() + ", " + "'"
				+ sdf.format(trip.getVerfuegbarAb()) + "', " + "'" + trip.getName() + "', " + "'"
				+ trip.getBeschreibung() + "', " + trip.getRegionID() + ", " + trip.getThemaID() + ", "
				+ trip.getKlimaID() + ", " + "'" + trip.getPreis() + "', " + trip.getHotelID() + "," + "'"
				+ trip.getGruppengroesse() + "'" + ")";
		System.out.println(sql);

		if (statement.executeUpdate(sql) != 0) {
			return true;
		}
		return false;

	}

	public static boolean saveTrip(Reise trip) throws SQLException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		sql = "UPDATE Reisen SET " + "Reisebeginn = '" + sdf.format(trip.getReiseBeginn()) + "'," + "Reiseende = '"
				+ sdf.format(trip.getReiseEnde()) + "', " + "Zielort = '" + trip.getZielOrt() + "', "
				+ "TransportmittelID = " + trip.getTransportmittelID() + ", " + "Kontingent = " + trip.getKontingent()
				+ ", " + "VerfuegbarAb = '" + sdf.format(trip.getVerfuegbarAb()) + "', " + "Name = '" + trip.getName()
				+ "', " + "Beschreibung = '" + trip.getBeschreibung() + "', " + "RegionID = " + trip.getRegionID()
				+ ", " + "ThemaID = " + trip.getThemaID() + ", " + "KlimaID = " + trip.getThemaID() + ", " + "Preis = "
				+ trip.getPreis() + ", " + "HotelID = " + trip.getHotelID() + ", " + "GruppenGroesse = "
				+ trip.getGruppengroesse() + " WHERE ReiseID = " + trip.getReiseID();

		System.out.println(sql);

		if (statement.executeUpdate(sql) != 0) {
			return true;
		}
		return false;

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

	public static ArrayList<Kunde> getKunde() {
		ArrayList<Kunde> kundeList = new ArrayList<Kunde>();

		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM Kunden");

			while (rs.next()) {
				Kunde kunde = new Kunde();
				kunde.setName(rs.getString("Name"));
				kunde.setVorname(rs.getString("Vorname"));
				kunde.setStrasse(rs.getString("Strasse"));
				kunde.setPLZ(rs.getString("PLZ"));
				kunde.setOrt(rs.getString("Ort"));
				kunde.setLand(rs.getString("Land"));
				kunde.setTelefon(rs.getString("Telefon"));
				kunde.setEMail(rs.getString("EMail"));
				kunde.setGebDat(rs.getDate("GebDat"));
				kunde.setKundennummer(rs.getInt("Kundennummer"));
				kundeList.add(kunde);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return kundeList;

	}

	public static Kunde getKunde(int id) {
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

	public static void createSpec(SpecEntryFrame frame, String spec) {
		connect();
		sql = "INSERT INTO " + spec + " VALUES ('" + frame.getEntry().getText() + "');";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static DefaultTableModel getCustomersWithBirthdays(String sql) {
		String col[] = { "Kundennummer", "Name", "Vorname", "Alter", "E-Mail" };
		DefaultTableModel dtm = new DefaultTableModel(col, 0);

		try {
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object[] objs = new Object[5];
				objs[0] = rs.getInt("Kundennummer");
				objs[1] = rs.getString("Name");
				objs[2] = rs.getString("Vorname");
				objs[3] = rs.getInt("Age");
				objs[4] = rs.getString("EMail");
				dtm.addRow(objs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtm;

	}

	public static DefaultTableModel getCustomersWithUpcomingBirthdays(String sql) {
		String col[] = { "Kundennummer", "Name", "Vorname", "Geburtstag", "Alter", "E-Mail" };
		DefaultTableModel dtm = new DefaultTableModel(col, 0);

		try {
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object[] objs = new Object[6];
				objs[0] = rs.getInt("Kundennummer");
				objs[1] = rs.getString("Name");
				objs[2] = rs.getString("Vorname");
				objs[3] = rs.getString("GebDat");
				objs[4] = rs.getInt("Age");
				objs[5] = rs.getString("EMail");
				dtm.addRow(objs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtm;

	}

	public static void safeVoucherCode(int customerID, String voucherCode) {
		connect();
		sql = "INSERT INTO Gutscheincode (KundenID, Code) VALUES ('" + customerID + "','" + voucherCode + "');";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void saveContactHistory(int customerID, int actionID, String review, String theme) {
		connect();
		sql = "INSERT INTO Kontakthistorien (KundenID, AktionsID, Wiedervorlage, KontaktThema) VALUES ('" + customerID
				+ "','" + actionID + "','" + review + "','" + theme + "');";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void saveReminder(int customerID, int actionID, String review, String theme) {
		connect();
		sql = "INSERT INTO Wiedervorlagen (WiedervorlageTermin, AktionsID, KundenID, WiedervorlageThema) VALUES ('"
				+ review + "','" + actionID + "','" + customerID + "','" + theme + "');";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Reise getReise(int id) {
		Reise reise = new Reise();

		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM Reisen WHERE ReiseID = '" + id + "'");

			while (rs.next()) {
				reise.setName(rs.getString("Name"));
				reise.setHotelID(rs.getInt("HotelID"));
				reise.setRegionID(rs.getInt("RegionID"));
				reise.setThemaID(rs.getInt("ThemaID"));
				reise.setTransportmittelID(rs.getInt("TransportmittelID"));
				reise.setKlimaID(rs.getInt("KlimaID"));
				reise.setBeschreibung(rs.getString("Beschreibung"));
				reise.setPreis(rs.getDouble("Preis"));
				reise.setGruppengroesse(rs.getInt("GruppenGroesse"));
				reise.setKontingent(rs.getInt("Kontingent"));
				reise.setVerfuegbarAb(rs.getDate("VerfuegbarAb"));
				reise.setReiseBeginn(rs.getDate("ReiseBeginn"));
				reise.setReiseEnde(rs.getDate("ReiseEnde"));
				reise.setZielOrt(rs.getString("Zielort"));
				reise.setReiseID(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reise;

	}

public static void sendNewsletter(NewsletterMessageFrame nmf) 
	{
		try 
		{
			rs = statement.executeQuery("SELECT * FROM Kunden WHERE Newsletter = 1");
			Statement statement1 = connection.createStatement();

			while (rs.next())
			{
				EmailFunctions.sendMultiPartMail(rs.getString("EMail"), 
						"Unser Newsletter mit tollen Angeboten", nmf.getAreaMessage().getText(), false, true);
		
				statement1.execute("INSERT INTO Kontakthistorien (KundenID, AktionsID, KontaktThema)"
						+ " VALUES (" + rs.getInt("Kundennummer") + ", 5, 'Thema:" + " N" + nmf.getAreaMessage().getText() + "')");				
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public static TableModel getTodoList() {
		String col[] = {"Id", "Termin", "Wer", "Thema", "Aktion"};
		DefaultTableModel dtm = new DefaultTableModel(col, 0);

		try {
			rs = statement.executeQuery("SELECT * FROM Wiedervorlagen AS w "
					+ "JOIN Kunden AS k ON w.KundenID = k.Kundennummer "
					+ "JOIN Aktionen As a on w.AktionsID = a.AktionsID "
					+ "WHERE Erledigt = 0 AND WiedervorlageTermin < DATE_ADD(NOW(), INTERVAL 5 DAY) "
					+ "ORDER BY WiedervorlageTermin");
			while (rs.next()) {
				Object[] objs = new Object[5];
				objs[0] = rs.getInt("WiedervorlagenId");
				objs[1] = new SimpleDateFormat("dd.MM.yyyy hh:mm").format(rs.getDate("WiedervorlageTermin"));
				String tempstr = rs.getString("WiedervorlageThema");
				objs[2] = rs.getString("Vorname") + " " + rs.getString("Name");
				objs[3] = tempstr.substring(7, tempstr.indexOf("Beschreibung:"));
				objs[4] = rs.getString("AktionsName");
				
				dtm.addRow(objs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtm;
	}

	public static TableModel getMeistgebuchteReisen() {
		String col[] = { "Name", "Zielort", "Preis", "Buchungen", "Durchschnittliche Teilnehmerzahl" };
		DefaultTableModel dtm = new DefaultTableModel(col, 0);

		try {
			String sql = "SELECT r.*, count(*) AS buchungen, AVG(b.Teilnehmerzahl) AS avgteilnehmer FROM Reisen AS r JOIN Buchungen AS b ON (r.ReiseID = b.ReiseID) GROUP BY r.Name ORDER BY buchungen DESC LIMIT 10 ";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				Object[] objs = new Object[5];
				objs[0] = rs.getString("Name");
				objs[1] = rs.getString("Zielort");
				objs[2] = rs.getDouble("Preis");
				objs[3] = rs.getInt("buchungen");
				objs[4] = rs.getInt("avgteilnehmer");
				dtm.addRow(objs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtm;
	}
	
	
	public static void storeMail(EmailMessageFrame emf) {
		
		try {
			statement.execute("INSERT INTO Kontakthistorien (KundenID, AktionsID, KontaktThema)"
					+ " VALUES (" + emf.getKundennummer() + ", 3, 'Thema: " + emf.getSubject() + " Beschreibung: " + emf.getAreaMessage().getText() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
			
	}
	
	public static ResultSet getWiederVorlage(int ID) {
		try {
			rs = statement.executeQuery("SELECT * FROM Wiedervorlagen AS w "
					+ "JOIN Kunden AS k ON w.KundenID = k.Kundennummer "
					+ "JOIN Aktionen As a on w.AktionsID = a.AktionsID "
					+ "WHERE w.WiedervorlagenID = " + ID);
			rs.next();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean setWiederVorlageReaded(int ID) {
		sql = "UPDATE Wiedervorlagen SET Erledigt = 1 WHERE WiedervorlagenId = " + ID;
			
		try {
			System.out.println(sql);
			if(statement.executeUpdate(sql) != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	public static DefaultTableModel getContactHistory(String sql) {
		String col[] = { "Datum", "Art", "Thema" };
		DefaultTableModel dtm = new DefaultTableModel(col, 0);
		String temp;
		try {
			rs = connection.createStatement().executeQuery(sql);
			while (rs.next()) {
				Object[] objs = new Object[3];
				objs[0] = rs.getString("Datum");
				objs[1] = rs.getString("Aktion");
				temp = rs.getString("Thema");
				String result = temp.substring(temp.indexOf("Thema:"), temp.indexOf("Beschreibung:"));
				objs[2] = result;
				dtm.addRow(objs);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return dtm;

	}

	public static DefaultTableModel getTripHistory(ArrayList<HistoryReise> hr) {
		String col[] = { "Datum", "Zielort", "Hotel" };
		DefaultTableModel dtm = new DefaultTableModel(col, 0);
		try {
			for (HistoryReise reise : hr) {
				Object[] objs = new Object[3];
				objs[0] = reise.getReiseBeginn();
				objs[1] = reise.getZielOrt();
				objs[2] = reise.getHotel();

				dtm.addRow(objs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtm;

	}

	public static ArrayList<HistoryReise> getHistoryReise(int customerID) {
		ArrayList<HistoryReise> reiseList = new ArrayList<HistoryReise>();

		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("select b.KundenID as KundenID, r.Reisebeginn as Reisebeginn,"
					+ " r.Reiseende as Reiseende, r.Name as Reisename, r.Zielort as Zielort, HotelName as Hotelname, r.Preis "
					+ "from Buchungen as b, Reisen as r, Hotels as h where b.ReiseID = r.ReiseID and KundenID ="
					+ customerID);
			while (rs.next()) {
				HistoryReise historyReise = new HistoryReise();
				historyReise.setHotel(rs.getString("Hotelname"));
				historyReise.setPreis(rs.getDouble("Preis"));
				historyReise.setReiseBeginn(rs.getDate("Reisebeginn"));
				historyReise.setReiseEnde(rs.getDate("Reiseende"));
				historyReise.setReiseName(rs.getString("Reisename"));
				historyReise.setZielOrt(rs.getString("Zielort"));
				reiseList.add(historyReise);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reiseList;

	}

}
