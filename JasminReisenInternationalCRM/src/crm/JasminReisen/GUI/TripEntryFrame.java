package crm.JasminReisen.GUI;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import crm.JasminReisen.Config;
import crm.JasminReisen.Functions.DateLabelFormatter;
import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.Listener.TripEntryFrameListener;
import crm.JasminReisen.models.Kunde;
import crm.JasminReisen.models.Reise;

public class TripEntryFrame extends JFrame
{
	private JPanel southPanel;
	private JPanel centerPanel;
	private JPanel northPanel;
	private JLabel header;
	
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
	

	private Reise tripContext;
	private JLabel gruppenGroesse;
	private JTextField gruppenGroesseField;
	private JLabel kontingent;
	private JTextField kontigentField;
	private static TripEntryFrame instance;
	
	public static TripEntryFrame getInstance ()
	{
		if (instance == null)
		{			
			instance=new TripEntryFrame();			
		}		
		return instance;
	}
	
	public static TripEntryFrame getInstanceWithTrip (Reise trip)
	{
		if (instance == null)
		{			
			instance=new TripEntryFrame(trip);			
		}		
		return instance;
	}
	
	TripEntryFrame ()
	{
		this(new Reise());
	}

	public TripEntryFrame(Reise reise) 
	{
		tripContext = reise;
		
		setLayout(new BorderLayout());
		setSize(700, 450);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		
		centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		//centerPanel.setLayout(new GridLayout(0,4,8,6));
		centerPanel.setBorder(new EmptyBorder(0,10,0,10));
		centerPanel.setLayout(new BorderLayout());
		
		JPanel centerPanelNorth = new JPanel();
		centerPanelNorth.setLayout(new GridLayout(0,4,8,6));

		centerPanelNorth.setPreferredSize(new Dimension(700,60));
		centerPanel.add(centerPanelNorth, BorderLayout.CENTER);
		JPanel centerPanelSouth = new JPanel();
		centerPanel.add(centerPanelSouth, BorderLayout.SOUTH);

		centerPanelSouth.setPreferredSize(new Dimension(700,60));
		centerPanelSouth.setLayout(new GridLayout(0,3,-165,2));
		
		southPanel = new JPanel();
		add(southPanel, BorderLayout.SOUTH);
		
		northPanel = new JPanel();
		
		add(northPanel, BorderLayout.NORTH);
		northPanel.setAlignmentX(LEFT_ALIGNMENT);
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		header = new JLabel();
		header.setHorizontalAlignment(SwingConstants.LEFT);
		header.setFont(new Font("Calibri Light", Font.BOLD, 24));
		northPanel.add(header);
		
		SqlDateModel model1 = new SqlDateModel();
		Properties p1 = new Properties();
		p1.put("text.today", "Today");
		p1.put("text.month", "Month");
		p1.put("text.year", "Year");
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p1);
		startDate = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		
		SqlDateModel model2 = new SqlDateModel();
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p1);
		endDate = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		
		SqlDateModel model3 = new SqlDateModel();
		JDatePanelImpl datePanel3 = new JDatePanelImpl(model3, p1);
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
		zielortField = new JTextField();		
		
		gruppenGroesse = new JLabel("Gruppen Größe:");
		gruppenGroesseField = new JTextField();	
		
		kontingent = new JLabel("Kontingent:");
		kontigentField = new JTextField();	
		
		tripName = new JLabel("Name der Reise:");
		tripNameField = new JTextField();
		
		reiseBeginn = new JLabel("Beginn der Reise:");
		reiseEnde = new JLabel("Ende der Reise:");
		
		plaetze = new JLabel("Verfügbare Plätze:");
		plaetzeField = new JTextField();
		transportmittelId = new JLabel("Transportmittel:");
		transportmittelIdBox = new JComboBox(vehicles);
		region = new JLabel("Region der Reise:");
		regionBox = new JComboBox(regions);
		thema = new JLabel("Thema der Reise:");
		verfuegbar = new JLabel("Verfügbar ab:");
		
		availableDate.setFont(Config.getFONT_TEXTFIELD());
		themaBox = new JComboBox(themes);
		hotelId = new JLabel("ID des Hotels:");
		klimaId = new JLabel("KlimaID des Zielorts:");
		klimaIdBox = new JComboBox(climates);
		hotelIdBox = new JComboBox(hotels);
		preis = new JLabel("Preis der Reise:");
		preisField = new JTextField();
		beschreibung = new JLabel("Beschreibung:");
		beschreibung.setVerticalAlignment(SwingConstants.TOP);
		beschreibung.setPreferredSize(new Dimension(60,60));
		JScrollPane scrollPane = new JScrollPane();
		
		beschreibungArea = new JTextArea();
		scrollPane.setViewportView(beschreibungArea);
		
		send = new JButton("Reise anlegen");
		reset = new JButton("Abbrechen");
		
		
		centerPanelNorth.add(tripName);
		centerPanelNorth.add(tripNameField);
		centerPanelNorth.add(zielort);
		centerPanelNorth.add(zielortField);
		centerPanelNorth.add(gruppenGroesse);
		centerPanelNorth.add(gruppenGroesseField);
		centerPanelNorth.add(kontingent);
		centerPanelNorth.add(kontigentField);
		centerPanelNorth.add(reiseBeginn);
		centerPanelNorth.add(startDate);
		centerPanelNorth.add(reiseEnde);
		centerPanelNorth.add(endDate);
		centerPanelNorth.add(plaetze);
		centerPanelNorth.add(plaetzeField);
		centerPanelNorth.add(transportmittelId);
		centerPanelNorth.add(transportmittelIdBox);
		centerPanelNorth.add(region);
		centerPanelNorth.add(regionBox);
		centerPanelNorth.add(thema);
		centerPanelNorth.add(themaBox);
		centerPanelNorth.add(klimaId);
		centerPanelNorth.add(klimaIdBox);
		centerPanelNorth.add(hotelId);
		centerPanelNorth.add(hotelIdBox);
		centerPanelNorth.add(preis);
		centerPanelNorth.add(preisField);
		centerPanelNorth.add(verfuegbar);
		centerPanelNorth.add(availableDate);
		centerPanelSouth.add(beschreibung, BorderLayout.WEST);
		centerPanelSouth.add(scrollPane, BorderLayout.CENTER);
		
		southPanel.add(reset);
		southPanel.add(send);
		
		TripEntryFrameListener tefl = new TripEntryFrameListener(this);
		reset.addActionListener(tefl);
		send.addActionListener(tefl);
		
		if(tripContext.getReiseID() == 0) {
			send.setText("Anlegen");
			header.setText("Neuen Kunden anlegen:");
		}
		else {
			send.setText("Speichern");
			header.setText("Reise " + tripContext.getName() + " bearbeiten:");
			setTitle("Reise " + tripContext.getName() + " bearbeiten:");
			
			getTripNameField().setText(tripContext.getName());
			getZielortField().setText(tripContext.getZielOrt());
			getStartDate().getJFormattedTextField().setText((tripContext.getReiseBeginn() != null) ? new SimpleDateFormat("yyyy-MM-dd").format(tripContext.getReiseBeginn()): "");
			getEndDate().getJFormattedTextField().setText((tripContext.getReiseEnde() != null) ? new SimpleDateFormat("yyyy-MM-dd").format(tripContext.getReiseEnde()): "");
			getPlaetzeField().setText(tripContext.getVerfuegbarePlaetze() + "");
			getKontigentField().setText(tripContext.getKontingent() + "");
			getGruppenGroesseField().setText(tripContext.getGruppengroesse() + "");
			
			getTransportmittelIdBox().setSelectedIndex(tripContext.getTransportmittelID());
			getRegionBox().setSelectedIndex(tripContext.getRegionID());
			getThemaBox().setSelectedIndex(tripContext.getThemaID());
			getKlimaIdBox().setSelectedIndex(tripContext.getKlimaID());
			getHotelIdBox().setSelectedIndex(tripContext.getHotelID());
			getPreisField().setText(tripContext.getPreis() + "");
			getAvailableDate().getJFormattedTextField().setText((tripContext.getVerfuegbarAb() != null) ? new SimpleDateFormat("yyyy-MM-dd").format(tripContext.getVerfuegbarAb()): "");
			getBeschreibungArea().setText(tripContext.getBeschreibung());
			
		}
		
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

	public static void setInstance(TripEntryFrame object) {
		TripEntryFrame.instance = object;
		
	}

	public JPanel getSouthPanel() {
		return southPanel;
	}

	public void setSouthPanel(JPanel southPanel) {
		this.southPanel = southPanel;
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	public JPanel getNorthPanel() {
		return northPanel;
	}

	public void setNorthPanel(JPanel northPanel) {
		this.northPanel = northPanel;
	}

	public JLabel getHeader() {
		return header;
	}

	public void setHeader(JLabel header) {
		this.header = header;
	}

	public JLabel getReiseBeginn() {
		return reiseBeginn;
	}

	public void setReiseBeginn(JLabel reiseBeginn) {
		this.reiseBeginn = reiseBeginn;
	}

	public Reise getTripContext() {
		return tripContext;
	}

	public void setTripContext(Reise tripContext) {
		this.tripContext = tripContext;
	}

	public JLabel getGruppenGroesse() {
		return gruppenGroesse;
	}

	public void setGruppenGroesse(JLabel gruppenGroesse) {
		this.gruppenGroesse = gruppenGroesse;
	}

	public JTextField getGruppenGroesseField() {
		return gruppenGroesseField;
	}

	public void setGruppenGroesseField(JTextField gruppenGroesseField) {
		this.gruppenGroesseField = gruppenGroesseField;
	}

	public JLabel getKontingent() {
		return kontingent;
	}

	public void setKontingent(JLabel kontingent) {
		this.kontingent = kontingent;
	}

	public JTextField getKontigentField() {
		return kontigentField;
	}

	public void setKontigentField(JTextField kontigentField) {
		this.kontigentField = kontigentField;
	}
	
	
}
