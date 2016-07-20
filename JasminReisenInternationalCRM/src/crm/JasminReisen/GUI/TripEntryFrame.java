package crm.JasminReisen.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import crm.JasminReisen.Config;
import crm.JasminReisen.Functions.DateLabelFormatter;
import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.Listener.TripEntryFrameListener;
import crm.JasminReisen.models.Reise;

public class TripEntryFrame extends JFrame
{
	private JPanel datapanel;
	private JPanel descpanel;
	private JPanel buttons;
	private JLabel tripName;
	private JTextField tripNameField;
	private JLabel reiseBeginn;
	private JLabel reiseEnde;
	private JLabel plaetze;
	private JTextField plaetzeField;
	private JLabel transportmittelId;
	private JComboBox transportmittelIdBox;
	private JLabel region;
	private JLabel zielort;
	private JTextField zielortField;
	private JComboBox regionBox;
	private JLabel thema;
	private JComboBox themaBox;
	private JLabel klimaId;
	private JComboBox klimaIdBox;
	private JLabel hotelId;
	private JComboBox hotelIdBox;
	private JLabel preis;
	private JTextField preisField;
	private JLabel verfuegbar;
	private JLabel beschreibung;
	private JTextArea beschreibungArea;
	private JButton reset;
	private JButton send;
	private JDatePickerImpl startDate;
	private JDatePickerImpl endDate;
	private JDatePickerImpl availableDate;
	
	public static void main (String [] args)
	{
		new TripEntryFrame();
	}
	
	TripEntryFrame ()
	{
		this(new Reise());
	}

	public TripEntryFrame(Reise reise) 
	{
		DbFunctions.connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		this.setSize(550,470);
		setLocationRelativeTo(null);
		setTitle("Anlegen einer neuen Reise");
		this.setBackground(Config.getBACKGROUND());
		this.setLayout(new BorderLayout());
		datapanel = new JPanel();
		datapanel.setBackground(Config.getBACKGROUND());
		descpanel = new JPanel(new GridLayout(1,2,2,2));
		descpanel.setBackground(Config.getBACKGROUND());
		datapanel.setLayout(new GridLayout (12,2,2,2));
		buttons = new JPanel(new GridLayout(1,2,2,2));
		buttons.setBackground(Config.getBACKGROUND());
		this.add(datapanel, BorderLayout.NORTH);
		this.add(descpanel, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.SOUTH);
		
		SqlDateModel model1 = new SqlDateModel();
		Properties p1 = new Properties();
		p1.put("text.today", "Today");
		p1.put("text.month", "Month");
		p1.put("text.year", "Year");
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p1);
		startDate = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		
		SqlDateModel model2 = new SqlDateModel();
		Properties p2 = new Properties();
		p2.put("text.today", "Today");
		p2.put("text.month", "Month");
		p2.put("text.year", "Year");
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);
		endDate = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		
		SqlDateModel model3 = new SqlDateModel();
		Properties p3 = new Properties();
		p3.put("text.today", "Today");
		p3.put("text.month", "Month");
		p3.put("text.year", "Year");
		JDatePanelImpl datePanel3 = new JDatePanelImpl(model3, p3);
		availableDate = new JDatePickerImpl(datePanel3, new DateLabelFormatter());
		

		
		
		
		
		ArrayList<String> vehicleList = new ArrayList<String>(DbFunctions.getVehicleList());
		ArrayList<String> themeList = new ArrayList<String>(DbFunctions.getThemeList());
		ArrayList<String> climateList = new ArrayList<String>(DbFunctions.getClimateList());
		ArrayList<String> hotelList = new ArrayList<String>(DbFunctions.getHotelList());
		ArrayList<String> regionList = new ArrayList<String>(DbFunctions.getRegionList());
		String [] vehicles = vehicleList.toArray(new String[vehicleList.size()]);
		String [] themes = themeList.toArray(new String[themeList.size()]);
		String [] climates = climateList.toArray(new String[climateList.size()]);
		String [] hotels = hotelList.toArray(new String[hotelList.size()]);
		String [] regions = regionList.toArray(new String[regionList.size()]);
		
		zielort = new JLabel("Zielort der Reise");
		zielort.setBackground(Config.getBACKGROUND());
		zielortField = new JTextField();		
		tripName = new JLabel("Name der Reise:");
		tripName.setBackground(Config.getBACKGROUND());
		tripNameField = new JTextField();
		
		startDate.setFont(Config.getFONT_TEXTFIELD());
		startDate.setBackground(Config.getBACKGROUND());
		reiseBeginn = new JLabel("Beginn der Reise:");
		reiseBeginn.setBackground(Config.getBACKGROUND());
		reiseEnde = new JLabel("Ende der Reise:");
		reiseEnde.setBackground(Config.getBACKGROUND());
		
		endDate.setFont(Config.getFONT_TEXTFIELD());
		endDate.setBackground(Config.getBACKGROUND());
		plaetze = new JLabel("Verfügbare Plätze:");
		plaetze.setBackground(Config.getBACKGROUND());
		plaetzeField = new JTextField();
		transportmittelId = new JLabel("Transportmittel:");
		transportmittelId.setBackground(Config.getBACKGROUND());
		transportmittelIdBox = new JComboBox(vehicles);
		region = new JLabel("Region der Reise:");
		region.setBackground(Config.getBACKGROUND());
		regionBox = new JComboBox(regions);
		thema = new JLabel("Thema der Reise:");
		thema.setBackground(Config.getBACKGROUND());
		verfuegbar = new JLabel("Verfügbar ab:");
		verfuegbar.setBackground(Config.getBACKGROUND());
		
		availableDate.setFont(Config.getFONT_TEXTFIELD());
		availableDate.setBackground(Config.getBACKGROUND());
		themaBox = new JComboBox(themes);
		hotelId = new JLabel("ID des Hotels:");
		hotelId.setBackground(Config.getBACKGROUND());
		klimaId = new JLabel("KlimaID des Zielorts:");
		klimaId.setBackground(Config.getBACKGROUND());
		klimaIdBox = new JComboBox(climates);
		hotelIdBox = new JComboBox(hotels);
		preis = new JLabel("Preis der Reise:");
		preis.setBackground(Config.getBACKGROUND());
		preisField = new JTextField();
		beschreibung = new JLabel("Beschreibung:");
		beschreibung.setBackground(Config.getBACKGROUND());
		beschreibungArea = new JTextArea();
		this.beschreibungArea.setBorder(new LineBorder(Config.getBORDER()));
		send = new JButton("Reise anlegen");
		reset = new JButton("Zurücksetzen");
		
		transportmittelIdBox.setFont(Config.getFONT_TEXTFIELD());
		transportmittelIdBox.setBackground(Config.getBACKGROUND());
		regionBox.setFont(Config.getFONT_TEXTFIELD());
		regionBox.setBackground(Config.getBACKGROUND());
		themaBox.setFont(Config.getFONT_TEXTFIELD());
		themaBox.setBackground(Config.getBACKGROUND());
		klimaIdBox.setFont(Config.getFONT_TEXTFIELD());
		klimaIdBox.setBackground(Config.getBACKGROUND());
		hotelIdBox.setFont(Config.getFONT_TEXTFIELD());
		hotelIdBox.setBackground(Config.getBACKGROUND());
		
		datapanel.add(tripName);
		datapanel.add(tripNameField);
		datapanel.add(zielort);
		datapanel.add(zielortField);
		datapanel.add(reiseBeginn);
		datapanel.add(startDate);
		datapanel.add(reiseEnde);
		datapanel.add(endDate);
		datapanel.add(plaetze);
		datapanel.add(plaetzeField);
		datapanel.add(transportmittelId);
		datapanel.add(transportmittelIdBox);
		datapanel.add(region);
		datapanel.add(regionBox);
		datapanel.add(thema);
		datapanel.add(themaBox);
		datapanel.add(klimaId);
		datapanel.add(klimaIdBox);
		datapanel.add(hotelId);
		datapanel.add(hotelIdBox);
		datapanel.add(preis);
		datapanel.add(preisField);
		datapanel.add(verfuegbar);
		datapanel.add(availableDate);
		descpanel.add(beschreibung);
		descpanel.add(beschreibungArea);
		buttons.add(reset);
		buttons.add(send);
		
		TripEntryFrameListener tefl = new TripEntryFrameListener(this);
		reset.addActionListener(tefl);
		send.addActionListener(tefl);
		
		this.setVisible(true);
	}

	public JPanel getDatapanel() {
		return datapanel;
	}

	public void setDatapanel(JPanel datapanel) {
		this.datapanel = datapanel;
	}

	public JPanel getDescpanel() {
		return descpanel;
	}

	public void setDescpanel(JPanel descpanel) {
		this.descpanel = descpanel;
	}

	public JPanel getButtons() {
		return buttons;
	}

	public void setButtons(JPanel buttons) {
		this.buttons = buttons;
	}

	public JLabel getTripName() {
		return tripName;
	}

	public void setName(JLabel name) {
		this.tripName = name;
	}

	public JTextField getTripNameField() {
		return tripNameField;
	}

	public void setTripNameField(JTextField nameField) {
		this.tripNameField = nameField;
	}

	public JLabel getReisebeginn() {
		return reiseBeginn;
	}

	public void setReisebeginn(JLabel reisebeginn) {
		this.reiseBeginn = reisebeginn;
	}

	public JLabel getReiseEnde() {
		return reiseEnde;
	}

	public void setReiseEnde(JLabel reiseEnde) {
		this.reiseEnde = reiseEnde;
	}

	public JLabel getPlaetze() {
		return plaetze;
	}

	public void setPlaetze(JLabel plaetze) {
		this.plaetze = plaetze;
	}

	public JTextField getPlaetzeField() {
		return plaetzeField;
	}

	public void setPlaetzeField(JTextField plaetzeField) {
		this.plaetzeField = plaetzeField;
	}

	public JLabel getTransportmittelId() {
		return transportmittelId;
	}

	public void setTransportmittelId(JLabel transportmittelId) {
		this.transportmittelId = transportmittelId;
	}

	public JLabel getRegion() {
		return region;
	}

	public void setRegion(JLabel region) {
		this.region = region;
	}

	public JLabel getThema() {
		return thema;
	}

	public void setThema(JLabel thema) {
		this.thema = thema;
	}

	public JLabel getHotelId() {
		return hotelId;
	}

	public void setHotelId(JLabel hotelId) {
		this.hotelId = hotelId;
	}

	public JLabel getPreis() {
		return preis;
	}

	public void setPreis(JLabel preis) {
		this.preis = preis;
	}

	public JTextField getPreisField() {
		return preisField;
	}

	public void setPreisField(JTextField preisField) {
		this.preisField = preisField;
	}

	public JLabel getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(JLabel beschreibung) {
		this.beschreibung = beschreibung;
	}

	public JTextArea getBeschreibungArea() {
		return beschreibungArea;
	}

	public void setBeschreibungArea(JTextArea beschreibungArea) {
		this.beschreibungArea = beschreibungArea;
	}

	public JButton getReset() {
		return reset;
	}

	public void setReset(JButton reset) {
		this.reset = reset;
	}

	public JButton getSend() {
		return send;
	}

	public void setSend(JButton send) {
		this.send = send;
	}

	public JLabel getZielort() {
		return zielort;
	}

	public void setZielort(JLabel zielort) {
		this.zielort = zielort;
	}

	public JTextField getZielortField() {
		return zielortField;
	}

	public void setZielortField(JTextField zielortField) {
		this.zielortField = zielortField;
	}

	public void setTripName(JLabel tripName) {
		this.tripName = tripName;
	}

	public JLabel getVerfuegbar() {
		return verfuegbar;
	}

	public void setVerfuegbar(JLabel verfuegbar) {
		this.verfuegbar = verfuegbar;
	}

	public JLabel getKlima() {
		return klimaId;
	}

	public void setKlima(JLabel klima) {
		this.klimaId = klima;
	}

	public JComboBox getTransportmittelIdBox() {
		return transportmittelIdBox;
	}

	public JComboBox getRegionBox() {
		return regionBox;
	}

	public JComboBox getThemaBox() {
		return themaBox;
	}

	public JLabel getKlimaId() {
		return klimaId;
	}

	public JComboBox getKlimaIdBox() {
		return klimaIdBox;
	}

	public JComboBox getHotelIdBox() {
		return hotelIdBox;
	}

	public void setTransportmittelIdBox(JComboBox transportmittelIdBox) {
		this.transportmittelIdBox = transportmittelIdBox;
	}

	public void setRegionBox(JComboBox regionBox) {
		this.regionBox = regionBox;
	}

	public void setThemaBox(JComboBox themaBox) {
		this.themaBox = themaBox;
	}

	public void setKlimaId(JLabel klimaId) {
		this.klimaId = klimaId;
	}

	public void setKlimaIdBox(JComboBox klimaIdBox) {
		this.klimaIdBox = klimaIdBox;
	}

	public void setHotelIdBox(JComboBox hotelIdBox) {
		this.hotelIdBox = hotelIdBox;
	}

	public JDatePickerImpl getStartDate() {
		return startDate;
	}

	public JDatePickerImpl getEndDate() {
		return endDate;
	}

	public JDatePickerImpl getAvailableDate() {
		return availableDate;
	}

	public void setStartDate(JDatePickerImpl startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(JDatePickerImpl endDate) {
		this.endDate = endDate;
	}

	public void setAvailableDate(JDatePickerImpl availableDate) {
		this.availableDate = availableDate;
	}
	
	
}
