package crm.JasminReisen.GUI;

import java.awt.*;

import javax.swing.*;

import crm.JasminReisen.Listener.TripEntryFrameListener;
import crm.JasminReisen.models.Reise;

public class TripEntryFrame extends JFrame
{
	private JPanel datapanel;
	private JPanel descpanel;
	private JPanel buttons;
	private JLabel tripName;
	private JTextField tripNameField;
	private JLabel reisebeginn;
	private JTextField reisebeginnField;
	private JLabel reiseEnde;
	private JTextField reiseEndeField;
	private JLabel plaetze;
	private JTextField plaetzeField;
	private JLabel transportmittelId;
	private JTextField transportmittelIdField;
	private JLabel region;
	private JLabel zielort;
	private JTextField zielortField;
	private JTextField regionField;
	private JLabel thema;
	private JTextField themaField;
	private JLabel klima;
	private JTextField klimaId;
	private JLabel hotelId;
	private JTextField hotelIdField;
	private JLabel preis;
	private JTextField preisField;
	private JLabel verfuegbar;
	private JTextField verfuegbarField;
	private JLabel beschreibung;
	private JTextArea beschreibungArea;
	private JButton reset;
	private JButton send;
	
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		this.setSize(600,400);
		setTitle("Anlegen einer neuen Reise");
		this.setLayout(new BorderLayout());
		datapanel = new JPanel();
		descpanel = new JPanel(new GridLayout(1,2,2,2));
		datapanel.setLayout(new GridLayout (11,2,2,2));
		buttons = new JPanel(new GridLayout(1,2,2,2));
		this.add(datapanel, BorderLayout.NORTH);
		this.add(descpanel, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.SOUTH);
		
		zielort = new JLabel("Zielort der Reise");
		zielortField = new JTextField();		
		tripName = new JLabel("Name der Reise:");
		tripNameField = new JTextField();
		reisebeginn = new JLabel("Beginn der Reise:");
		reisebeginnField = new JTextField();
		reiseEnde = new JLabel("Ende der Reise:");
		reiseEndeField = new JTextField();
		plaetze = new JLabel("Verfügbare Plätze:");
		plaetzeField = new JTextField();
		transportmittelId = new JLabel("Transportmittel:");
		transportmittelIdField = new JTextField();
		region = new JLabel("Region der Reise:");
		regionField = new JTextField();
		thema = new JLabel("Thema der Reise:");
		verfuegbar = new JLabel("Verfügbar ab:");
		verfuegbarField = new JTextField();
		themaField = new JTextField();
		hotelId = new JLabel("ID des Hotels:");
		hotelIdField = new JTextField();
		preis = new JLabel("Preis der Reise:");
		preisField = new JTextField();
		beschreibung = new JLabel("Beschreibung:");
		beschreibungArea = new JTextArea();
		send = new JButton("Reise anlegen");
		reset = new JButton("Zurücksetzen");
		
		
		datapanel.add(tripName);
		datapanel.add(tripNameField);
		datapanel.add(zielort);
		datapanel.add(zielortField);
		datapanel.add(reisebeginn);
		datapanel.add(reisebeginnField);
		datapanel.add(reiseEnde);
		datapanel.add(reiseEndeField);
		datapanel.add(plaetze);
		datapanel.add(plaetzeField);
		datapanel.add(transportmittelId);
		datapanel.add(transportmittelIdField);
		datapanel.add(region);
		datapanel.add(regionField);
		datapanel.add(thema);
		datapanel.add(themaField);
		datapanel.add(hotelId);
		datapanel.add(hotelIdField);
		datapanel.add(preis);
		datapanel.add(preisField);
		datapanel.add(verfuegbar);
		datapanel.add(verfuegbarField);
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
		return reisebeginn;
	}

	public void setReisebeginn(JLabel reisebeginn) {
		this.reisebeginn = reisebeginn;
	}

	public JTextField getReisebeginnField() {
		return reisebeginnField;
	}

	public void setReisebeginnField(JTextField reisebeginnField) {
		this.reisebeginnField = reisebeginnField;
	}

	public JLabel getReiseEnde() {
		return reiseEnde;
	}

	public void setReiseEnde(JLabel reiseEnde) {
		this.reiseEnde = reiseEnde;
	}

	public JTextField getReiseEndeField() {
		return reiseEndeField;
	}

	public void setReiseEndeField(JTextField reiseEndeField) {
		this.reiseEndeField = reiseEndeField;
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

	public JTextField getTransportmittelIdField() {
		return transportmittelIdField;
	}

	public void setTransportmittelIdField(JTextField transportmittelIdField) {
		this.transportmittelIdField = transportmittelIdField;
	}

	public JLabel getRegion() {
		return region;
	}

	public void setRegion(JLabel region) {
		this.region = region;
	}

	public JTextField getRegionField() {
		return regionField;
	}

	public void setRegionField(JTextField regionField) {
		this.regionField = regionField;
	}

	public JLabel getThema() {
		return thema;
	}

	public void setThema(JLabel thema) {
		this.thema = thema;
	}

	public JTextField getThemaField() {
		return themaField;
	}

	public void setThemaField(JTextField themaField) {
		this.themaField = themaField;
	}

	public JLabel getHotelId() {
		return hotelId;
	}

	public void setHotelId(JLabel hotelId) {
		this.hotelId = hotelId;
	}

	public JTextField getHotelIdField() {
		return hotelIdField;
	}

	public void setHotelIdField(JTextField hotelIdField) {
		this.hotelIdField = hotelIdField;
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

	public JTextField getVerfuegbarField() {
		return verfuegbarField;
	}

	public void setVerfuegbar(JLabel verfuegbar) {
		this.verfuegbar = verfuegbar;
	}

	public void setVerfuegbarField(JTextField verfuegbarField) {
		this.verfuegbarField = verfuegbarField;
	}

	public JLabel getKlima() {
		return klima;
	}

	public JTextField getKlimaId() {
		return klimaId;
	}

	public void setKlima(JLabel klima) {
		this.klima = klima;
	}

	public void setKlimaId(JTextField klimaId) {
		this.klimaId = klimaId;
	}
	
	
}
