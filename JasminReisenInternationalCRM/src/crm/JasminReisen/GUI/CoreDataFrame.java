package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import org.jdatepicker.impl.UtilDateModel;

import crm.JasminReisen.Config;
import crm.JasminReisen.Functions.DateLabelFormatter;
import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.Listener.CoreDataListener;
import crm.JasminReisen.Listener.CoreDataTripListener;

public class CoreDataFrame extends JDialog {

	private JPanel mainPanel;
	private JTabbedPane coreDataTab;
	private JPanel tripPanel;
	private JPanel customerPanel;
	private JPanel northPanelCustomer;
	private JPanel centerOfNorthOfCustomerPanel;
	private JLabel headLineCustomer;
	private JLabel headLineTrip;
	private JButton searchButton;
	private JLabel emptyLabel;
	private JButton resetButton;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel vornameLabel;
	private JTextField vornameTextField;
	private JLabel strasseLabel;
	private JTextField strasseTextField;
	private JLabel ortLabel;
	private JTextField ortTextField;
	private JLabel plzLabel;
	private JTextField plzTextField;
	private JLabel landLabel;
	private JTextField landTextField;
	private JLabel telefonLabel;
	private JTextField telefonTextField;
	private JLabel mailLabel;
	private JTextField mailTextField;
	private JTable customerTable;
	private JTable tripTable;
	private JScrollPane tripScrollPane;
	private JScrollPane customerScrollPane;
	private JPanel northPanelTrip;
	private JPanel southPanel;
	private JButton bearbeitenButton;
	private JButton anlegenButton;
	private JLabel tripAvailableLabel;
	private JTextField tripQuotaField;
	private JLabel tripQuotaToLabel;
	private JTextField tripPriceToField;
	private JLabel tripPriceToLabel;
	private JDatePickerImpl datePicker;
	private SqlDateModel model;
	private JDatePanelImpl datePanel;
	private JTextField tripPriceFromField;
	private JLabel tripPriceFromLabel;
	private JTextField tripHotelField;
	private JLabel tripHotelLabel;
	private JTextField tripRegionField;
	private JLabel tripRegionLabel;
	private String[] climates;
	private JComboBox climatesBox;
	private JLabel tripClimateLabel;
	private JComboBox vehicleBox;
	private String[] vehicles;
	private List<String> vehicleList;
	private JLabel tripTransportationLabel;
	private JTextField tripTillField;
	private JLabel tripTillLabel;
	private JTextField tripFromField;
	private JLabel tripFromLabel;
	private JTextField tripDestinatonField;
	private JLabel tripDestinationLabel;
	private JTextField tripNameField;
	private JLabel tripNameLabel;
	private JPanel gridNorthPanelTrip;
	private JPanel northOfNorthPanelTrip;
	private JPanel southTripPanel;
	private JButton bearbeitenButton2;
	private JButton anlegenButton2;
	private JButton tripSearchButton;
	private JButton tripResetButton;
	private Properties p;
	private JCheckBox tripPastCheckbox;
	private JLabel tripPastLabel;
	private SqlDateModel modelTripStart;
	private Properties pTripStart;
	private JDatePanelImpl datePanelTripStart;
	private JDatePickerImpl datePickerTripStart;
	private SqlDateModel modelTripEnd;
	private Properties pTripEnd;
	private JDatePanelImpl datePanelTripEnd;
	private JDatePickerImpl datePickerTripEnd;

	@SuppressWarnings("unchecked")
	public CoreDataFrame() {

		this.setSize(1200, 800);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setTitle("Stammdatenpflege");
		this.setBackground(Config.getBACKGROUND());
		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width / 2 - windowSize.width / 2, screenSize.height / 2 - windowSize.height / 2);
		this.setLayout(new BorderLayout());

		mainPanel = new JPanel();
		mainPanel.setBackground(Config.getBACKGROUND());
		this.add(mainPanel, BorderLayout.CENTER);

		ImageIcon reisenIcon = new ImageIcon("images/reisen.png");
		ImageIcon kundenIcon = new ImageIcon("images/kunden.png");

		coreDataTab = new JTabbedPane(JTabbedPane.TOP);
		coreDataTab.setFont(Config.getFONT());
		coreDataTab.setBackground(Config.getBACKGROUND());
		this.add(coreDataTab);

		tripPanel = new JPanel();
		tripPanel.setFont(Config.getFONT());
		tripPanel.setBackground(Config.getBACKGROUND());
		tripPanel.setLayout(new BorderLayout());
		coreDataTab.addTab("Reisen", reisenIcon, tripPanel, null);

		customerPanel = new JPanel();
		customerPanel.setFont(Config.getFONT());
		customerPanel.setBackground(Config.getBACKGROUND());
		customerPanel.setLayout(new BorderLayout());
		coreDataTab.addTab("Kunden", kundenIcon, customerPanel, null);

		northPanelTrip = new JPanel();
		northPanelTrip.setSize(1200, 400);
		northPanelTrip.setBackground(Config.getBACKGROUND());
		tripPanel.add(northPanelTrip, BorderLayout.NORTH);
		northPanelTrip.setLayout(new BorderLayout());

		northOfNorthPanelTrip = new JPanel();
		northOfNorthPanelTrip.setLayout(new GridLayout(1, 1, 0, 0));
		northOfNorthPanelTrip.setBackground(Config.getBACKGROUND());
		northPanelTrip.add(northOfNorthPanelTrip, BorderLayout.NORTH);

		headLineTrip = new JLabel("Filter");
		headLineTrip.setFont(Config.getHEADLINE());
		headLineTrip.setBackground(Config.getBACKGROUND());
		headLineTrip.setHorizontalAlignment(JLabel.CENTER);
		northOfNorthPanelTrip.add(headLineTrip, BorderLayout.NORTH);

		gridNorthPanelTrip = new JPanel();
		gridNorthPanelTrip.setLayout(new GridLayout(9, 4, 5, 5));
		gridNorthPanelTrip.setBackground(Config.getBACKGROUND());
		northPanelTrip.add(gridNorthPanelTrip, BorderLayout.CENTER);

		JLabel tripEmptyLabel1 = new JLabel("");
		gridNorthPanelTrip.add(tripEmptyLabel1);

		tripSearchButton = new JButton("Suchen");
		tripSearchButton.setFont(Config.getFONT());
		tripSearchButton.addActionListener(new CoreDataTripListener(this));
		gridNorthPanelTrip.add(tripSearchButton);

		tripResetButton = new JButton("Zurücksetzen");
		tripResetButton.setFont(Config.getFONT());
		tripResetButton.addActionListener(new CoreDataTripListener(this));
		gridNorthPanelTrip.add(tripResetButton);

		JLabel tripEmptyLabel2 = new JLabel("");
		gridNorthPanelTrip.add(tripEmptyLabel2);

		JLabel tripEmptyLabel3 = new JLabel("");
		gridNorthPanelTrip.add(tripEmptyLabel3);

		tripPastLabel = new JLabel("Abgelaufene Reisen einbeziehen");
		tripPastLabel.setFont(Config.getFONT());
		tripPastLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripPastLabel);

		tripPastCheckbox = new JCheckBox("");
		tripPastCheckbox.setFont(Config.getFONT());
		tripPastCheckbox.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripPastCheckbox);

		JLabel tripEmptyLabel4 = new JLabel("");
		gridNorthPanelTrip.add(tripEmptyLabel4);

		tripNameLabel = new JLabel("Reisename");
		tripNameLabel.setFont(Config.getFONT());
		tripNameLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripNameLabel);

		tripNameField = new JTextField();
		tripNameField.setFont(Config.getFONT());
		tripNameField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripNameField);

		tripDestinationLabel = new JLabel("Zielort");
		tripDestinationLabel.setFont(Config.getFONT());
		tripDestinationLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripDestinationLabel);

		tripDestinatonField = new JTextField();
		tripDestinatonField.setFont(Config.getFONT());
		tripDestinatonField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripDestinatonField);

		tripFromLabel = new JLabel("Reise Anfang");
		tripFromLabel.setFont(Config.getFONT());
		tripFromLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripFromLabel);
		
		modelTripStart = new SqlDateModel();
		pTripStart = new Properties();
		pTripStart.put("text.today", "Today");
		pTripStart.put("text.month", "Month");
		pTripStart.put("text.year", "Year");
		datePanelTripStart = new JDatePanelImpl(modelTripStart, pTripStart);
		datePickerTripStart = new JDatePickerImpl(datePanelTripStart, new DateLabelFormatter());
		datePickerTripStart.setFont(Config.getFONT());
		gridNorthPanelTrip.add(datePickerTripStart);

		tripTillLabel = new JLabel("Reise Ende");
		tripTillLabel.setFont(Config.getFONT());
		tripTillLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripTillLabel);
		
		modelTripEnd = new SqlDateModel();
		pTripEnd = new Properties();
		pTripEnd.put("text.today", "Today");
		pTripEnd.put("text.month", "Month");
		pTripEnd.put("text.year", "Year");
		datePanelTripEnd = new JDatePanelImpl(modelTripEnd, pTripEnd);
		datePickerTripEnd = new JDatePickerImpl(datePanelTripEnd, new DateLabelFormatter());
		datePickerTripStart.setFont(Config.getFONT());
		gridNorthPanelTrip.add(datePickerTripEnd);

		tripTransportationLabel = new JLabel("Transportmittel");
		tripTransportationLabel.setFont(Config.getFONT());
		tripTransportationLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripTransportationLabel);

		vehicleList = new ArrayList<String>(DbFunctions.getVehicleList());
		vehicles = vehicleList.toArray(new String[vehicleList.size()]);
		vehicleBox = new JComboBox(vehicles);
		vehicleBox.setFont(Config.getFONT());
		vehicleBox.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(vehicleBox);

		tripClimateLabel = new JLabel("Klima");
		tripClimateLabel.setFont(Config.getFONT());
		tripClimateLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripClimateLabel);

		List<String> climaList = new ArrayList<String>(DbFunctions.getKlimaList());
		String[] climaArray = climaList.toArray(new String[climaList.size()]);
		climatesBox = new JComboBox(climaArray);
		climatesBox.setFont(Config.getFONT());
		climatesBox.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(climatesBox);

		tripRegionLabel = new JLabel("Region");
		tripRegionLabel.setFont(Config.getFONT());
		tripRegionLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripRegionLabel);

		tripRegionField = new JTextField();
		tripRegionField.setFont(Config.getFONT());
		tripRegionField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripRegionField);

		tripHotelLabel = new JLabel("Hotelname");
		tripHotelLabel.setFont(Config.getFONT());
		tripHotelLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripHotelLabel);

		tripHotelField = new JTextField();
		tripHotelField.setFont(Config.getFONT());
		tripHotelField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripHotelField);

		tripPriceFromLabel = new JLabel("Preise von");
		tripPriceFromLabel.setFont(Config.getFONT());
		tripPriceFromLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripPriceFromLabel);

		tripPriceFromField = new JTextField();
		tripPriceFromField.setFont(Config.getFONT());
		tripPriceFromField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripPriceFromField);

		tripPriceToLabel = new JLabel("Preise bis");
		tripPriceToLabel.setFont(Config.getFONT());
		tripPriceToLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripPriceToLabel);

		tripPriceToField = new JTextField();
		tripPriceToField.setFont(Config.getFONT());
		tripPriceToField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripPriceToField);

		tripQuotaToLabel = new JLabel("Kontingent über");
		tripQuotaToLabel.setFont(Config.getFONT());
		tripQuotaToLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripQuotaToLabel);

		tripQuotaField = new JTextField();
		tripQuotaField.setFont(Config.getFONT());
		tripQuotaField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripQuotaField);

		tripAvailableLabel = new JLabel("Verfügbar ab");
		tripAvailableLabel.setFont(Config.getFONT());
		tripAvailableLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripAvailableLabel);

		model = new SqlDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);

		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setFont(Config.getFONT());
		gridNorthPanelTrip.add(datePicker);
		
		JLabel tripEmptyLabel5 = new JLabel("");
		gridNorthPanelTrip.add(tripEmptyLabel5);
		
		JLabel tripThemaLabel = new JLabel("Thema");
		tripThemaLabel.setFont(Config.getFONT());
		tripThemaLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripThemaLabel);
		
		
		List<String> themaList = new ArrayList<String>(DbFunctions.getThemenList());
		String[] themaListArray = themaList.toArray(new String[themaList.size()]);
		JComboBox themeBox = new JComboBox(themaListArray);
		themeBox.setFont(Config.getFONT());
		themeBox.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(themeBox);

		
		
		
		
		
		
		
		JLabel tripEmptyLabel6 = new JLabel("");
		gridNorthPanelTrip.add(tripEmptyLabel6);

		northPanelCustomer = new JPanel();
		northPanelCustomer.setSize(1200, 400);
		customerPanel.add(northPanelCustomer, BorderLayout.NORTH);
		northPanelCustomer.setLayout(new BorderLayout());

		centerOfNorthOfCustomerPanel = new JPanel();
		centerOfNorthOfCustomerPanel.setLayout(new GridLayout(5, 4, 5, 5));
		centerOfNorthOfCustomerPanel.setBackground(Config.getBACKGROUND());
		northPanelCustomer.add(centerOfNorthOfCustomerPanel);

		headLineCustomer = new JLabel("Filter");
		headLineCustomer.setFont(Config.getHEADLINE());
		headLineCustomer.setBackground(Config.getBACKGROUND());
		centerOfNorthOfCustomerPanel.add(headLineCustomer);

		searchButton = new JButton("Suchen");
		searchButton.addActionListener(new CoreDataListener(this));
		searchButton.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(searchButton);

		emptyLabel = new JLabel("");
		emptyLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(emptyLabel);

		resetButton = new JButton("Zurücksetzen");
		resetButton.setFont(Config.getFONT());
		resetButton.addActionListener(new CoreDataListener(this));
		centerOfNorthOfCustomerPanel.add(resetButton);

		nameLabel = new JLabel("Name");
		nameLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(nameLabel);

		nameTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(nameTextField);

		vornameLabel = new JLabel("Vorname");
		vornameLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(vornameLabel);

		vornameTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(vornameTextField);

		strasseLabel = new JLabel("Strasse");
		strasseLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(strasseLabel);

		strasseTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(strasseTextField);

		ortLabel = new JLabel("Ort");
		ortLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(ortLabel);

		ortTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(ortTextField);

		plzLabel = new JLabel("PLZ");
		plzLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(plzLabel);

		plzTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(plzTextField);

		landLabel = new JLabel("Land");
		landLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(landLabel);

		landTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(landTextField);

		telefonLabel = new JLabel("Telefon");
		telefonLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(telefonLabel);

		telefonTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(telefonTextField);

		mailLabel = new JLabel("E-Mail");
		mailLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(mailLabel);

		mailTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(mailTextField);

		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, 2, 5, 5));
		customerPanel.add(southPanel, BorderLayout.SOUTH);

		bearbeitenButton = new JButton("Bearbeiten");
		bearbeitenButton.setFont(Config.getFONT());
		southPanel.add(bearbeitenButton);

		anlegenButton = new JButton("Kunde Anlegen");
		anlegenButton.setFont(Config.getFONT());
		southPanel.add(anlegenButton);

		customerTable = new JTable();
		customerScrollPane = new JScrollPane();
		customerPanel.add(customerScrollPane, BorderLayout.CENTER);

		customerTable.setShowGrid(false);
		customerTable.setFont(Config.getFONT());
		customerTable.setBackground(Config.getBACKGROUND());
		customerTable.getTableHeader().setReorderingAllowed(false);
		customerTable.setAutoCreateRowSorter(true);
		customerTable.setPreferredScrollableViewportSize(customerTable.getPreferredSize());
		customerTable.setFillsViewportHeight(true);
		customerTable.setRowHeight(21);
		customerTable.setModel(DbFunctions.getFilteredCustomers("SELECT * FROM Kunden"));
		customerTable.getTableHeader().setFont(Config.getFONT());
		customerScrollPane.setViewportView(customerTable);

		tripTable = new JTable();
		tripScrollPane = new JScrollPane();
		tripPanel.add(tripScrollPane, BorderLayout.CENTER);

		tripTable.setShowGrid(false);
		tripTable.setFont(Config.getFONT());
		tripTable.setBackground(Config.getBACKGROUND());
		tripTable.getTableHeader().setReorderingAllowed(false);
		tripTable.setModel(DbFunctions.getFilteredTrips("SELECT * FROM Reisen"));
		tripTable.setAutoCreateRowSorter(true);
		tripTable.setPreferredScrollableViewportSize(tripTable.getPreferredSize());
		tripTable.setFillsViewportHeight(true);
		tripTable.setRowHeight(21);
		tripTable.getTableHeader().setFont(Config.getFONT());
		tripScrollPane.setViewportView(tripTable);

		southTripPanel = new JPanel();
		southTripPanel.setLayout(new GridLayout(1, 2, 5, 5));
		tripPanel.add(southTripPanel, BorderLayout.SOUTH);

		bearbeitenButton2 = new JButton("Bearbeiten");
		bearbeitenButton2.setFont(Config.getFONT());
		southTripPanel.add(bearbeitenButton2);

		anlegenButton2 = new JButton("Reise Anlegen");
		anlegenButton2.setFont(Config.getFONT());
		southTripPanel.add(anlegenButton2);

		this.setVisible(true);
	}

	public JTabbedPane getCoreDataTab() {
		return coreDataTab;
	}

	public void setCoreDataTab(JTabbedPane coreDataTab) {
		this.coreDataTab = coreDataTab;
	}

	public JPanel getTripPanel() {
		return tripPanel;
	}

	public void setTripPanel(JPanel tripPanel) {
		this.tripPanel = tripPanel;
	}

	public JPanel getCustomerPanel() {
		return customerPanel;
	}

	public void setCustomerPanel(JPanel customerPanel) {
		this.customerPanel = customerPanel;
	}

	public JPanel getNorthPanelCustomer() {
		return northPanelCustomer;
	}

	public void setNorthPanelCustomer(JPanel northPanelCustomer) {
		this.northPanelCustomer = northPanelCustomer;
	}

	public JPanel getCenterOfNorthOfCustomerPanel() {
		return centerOfNorthOfCustomerPanel;
	}

	public void setCenterOfNorthOfCustomerPanel(JPanel centerOfNorthOfCustomerPanel) {
		this.centerOfNorthOfCustomerPanel = centerOfNorthOfCustomerPanel;
	}

	public JLabel getHeadLineCustomer() {
		return headLineCustomer;
	}

	public void setHeadLineCustomer(JLabel headLineCustomer) {
		this.headLineCustomer = headLineCustomer;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}

	public JLabel getEmptyLabel() {
		return emptyLabel;
	}

	public void setEmptyLabel(JLabel emptyLabel) {
		this.emptyLabel = emptyLabel;
	}

	public JButton getResetButton() {
		return resetButton;
	}

	public void setResetButton(JButton resetButton) {
		this.resetButton = resetButton;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public void setNameTextField(JTextField nameTextField) {
		this.nameTextField = nameTextField;
	}

	public JLabel getVornameLabel() {
		return vornameLabel;
	}

	public void setVornameLabel(JLabel vornameLabel) {
		this.vornameLabel = vornameLabel;
	}

	public JTextField getVornameTextField() {
		return vornameTextField;
	}

	public void setVornameTextField(JTextField vornameTextField) {
		this.vornameTextField = vornameTextField;
	}

	public JLabel getStrasseLabel() {
		return strasseLabel;
	}

	public void setStrasseLabel(JLabel strasseLabel) {
		this.strasseLabel = strasseLabel;
	}

	public JTextField getStrasseTextField() {
		return strasseTextField;
	}

	public void setStrasseTextField(JTextField strasseTextField) {
		this.strasseTextField = strasseTextField;
	}

	public JLabel getOrtLabel() {
		return ortLabel;
	}

	public void setOrtLabel(JLabel ortLabel) {
		this.ortLabel = ortLabel;
	}

	public JTextField getOrtTextField() {
		return ortTextField;
	}

	public void setOrtTextField(JTextField ortTextField) {
		this.ortTextField = ortTextField;
	}

	public JLabel getPlzLabel() {
		return plzLabel;
	}

	public void setPlzLabel(JLabel plzLabel) {
		this.plzLabel = plzLabel;
	}

	public JTextField getPlzTextField() {
		return plzTextField;
	}

	public void setPlzTextField(JTextField plzTextField) {
		this.plzTextField = plzTextField;
	}

	public JLabel getLandLabel() {
		return landLabel;
	}

	public void setLandLabel(JLabel landLabel) {
		this.landLabel = landLabel;
	}

	public JTextField getLandTextField() {
		return landTextField;
	}

	public void setLandTextField(JTextField landTextField) {
		this.landTextField = landTextField;
	}

	public JLabel getTelefonLabel() {
		return telefonLabel;
	}

	public void setTelefonLabel(JLabel telefonLabel) {
		this.telefonLabel = telefonLabel;
	}

	public JTextField getTelefonTextField() {
		return telefonTextField;
	}

	public void setTelefonTextField(JTextField telefonTextField) {
		this.telefonTextField = telefonTextField;
	}

	public JLabel getMailLabel() {
		return mailLabel;
	}

	public void setMailLabel(JLabel mailLabel) {
		this.mailLabel = mailLabel;
	}

	public JTextField getMailTextField() {
		return mailTextField;
	}

	public void setMailTextField(JTextField mailTextField) {
		this.mailTextField = mailTextField;
	}

	public JTable getCustomerTable() {
		return customerTable;
	}

	public void setCustomerTable(JTable customerTable) {
		this.customerTable = customerTable;
	}

	public JScrollPane getCustomerScrollPane() {
		return customerScrollPane;
	}

	public void setCustomerScrollPane(JScrollPane customerScrollPane) {
		this.customerScrollPane = customerScrollPane;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JLabel getHeadLineTrip() {
		return headLineTrip;
	}

	public void setHeadLineTrip(JLabel headLineTrip) {
		this.headLineTrip = headLineTrip;
	}

	public JTable getTripTable() {
		return tripTable;
	}

	public void setTripTable(JTable tripTable) {
		this.tripTable = tripTable;
	}

	public JScrollPane getTripScrollPane() {
		return tripScrollPane;
	}

	public void setTripScrollPane(JScrollPane tripScrollPane) {
		this.tripScrollPane = tripScrollPane;
	}

	public JPanel getNorthPanelTrip() {
		return northPanelTrip;
	}

	public void setNorthPanelTrip(JPanel northPanelTrip) {
		this.northPanelTrip = northPanelTrip;
	}

	public JPanel getSouthPanel() {
		return southPanel;
	}

	public void setSouthPanel(JPanel southPanel) {
		this.southPanel = southPanel;
	}

	public JButton getBearbeitenButton() {
		return bearbeitenButton;
	}

	public void setBearbeitenButton(JButton bearbeitenButton) {
		this.bearbeitenButton = bearbeitenButton;
	}

	public JButton getAnlegenButton() {
		return anlegenButton;
	}

	public void setAnlegenButton(JButton anlegenButton) {
		this.anlegenButton = anlegenButton;
	}

	public JLabel getTripAvailableLabel() {
		return tripAvailableLabel;
	}

	public void setTripAvailableLabel(JLabel tripAvailableLabel) {
		this.tripAvailableLabel = tripAvailableLabel;
	}

	public JTextField getTripQuotaField() {
		return tripQuotaField;
	}

	public void setTripQuotaField(JTextField tripQuotaField) {
		this.tripQuotaField = tripQuotaField;
	}

	public JLabel getTripQuotaToLabel() {
		return tripQuotaToLabel;
	}

	public void setTripQuotaToLabel(JLabel tripQuotaToLabel) {
		this.tripQuotaToLabel = tripQuotaToLabel;
	}

	public JTextField getTripPriceToField() {
		return tripPriceToField;
	}

	public void setTripPriceToField(JTextField tripPriceToField) {
		this.tripPriceToField = tripPriceToField;
	}

	public JLabel getTripPriceToLabel() {
		return tripPriceToLabel;
	}

	public void setTripPriceToLabel(JLabel tripPriceToLabel) {
		this.tripPriceToLabel = tripPriceToLabel;
	}

	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(JDatePickerImpl datePicker) {
		this.datePicker = datePicker;
	}

	public SqlDateModel getModel() {
		return model;
	}

	public void setModel(SqlDateModel model) {
		this.model = model;
	}

	public JDatePanelImpl getDatePanel() {
		return datePanel;
	}

	public void setDatePanel(JDatePanelImpl datePanel) {
		this.datePanel = datePanel;
	}

	public JTextField getTripPriceFromField() {
		return tripPriceFromField;
	}

	public void setTripPriceFromField(JTextField tripPriceFromField) {
		this.tripPriceFromField = tripPriceFromField;
	}

	public JLabel getTripPriceFromLabel() {
		return tripPriceFromLabel;
	}

	public void setTripPriceFromLabel(JLabel tripPriceFromLabel) {
		this.tripPriceFromLabel = tripPriceFromLabel;
	}

	public JTextField getTripHotelField() {
		return tripHotelField;
	}

	public void setTripHotelField(JTextField tripHotelField) {
		this.tripHotelField = tripHotelField;
	}

	public JLabel getTripHotelLabel() {
		return tripHotelLabel;
	}

	public void setTripHotelLabel(JLabel tripHotelLabel) {
		this.tripHotelLabel = tripHotelLabel;
	}

	public JTextField getTripRegionField() {
		return tripRegionField;
	}

	public void setTripRegionField(JTextField tripRegionField) {
		this.tripRegionField = tripRegionField;
	}

	public JLabel getTripRegionLabel() {
		return tripRegionLabel;
	}

	public void setTripRegionLabel(JLabel tripRegionLabel) {
		this.tripRegionLabel = tripRegionLabel;
	}

	public String[] getClimates() {
		return climates;
	}

	public void setClimates(String[] climates) {
		this.climates = climates;
	}

	public JComboBox getClimatesBox() {
		return climatesBox;
	}

	public void setClimatesBox(JComboBox climatesBox) {
		this.climatesBox = climatesBox;
	}

	public JLabel getTripClimateLabel() {
		return tripClimateLabel;
	}

	public void setTripClimateLabel(JLabel tripClimateLabel) {
		this.tripClimateLabel = tripClimateLabel;
	}

	public JComboBox getVehicleBox() {
		return vehicleBox;
	}

	public void setVehicleBox(JComboBox vehicleBox) {
		this.vehicleBox = vehicleBox;
	}

	public String[] getVehicles() {
		return vehicles;
	}

	public void setVehicles(String[] vehicles) {
		this.vehicles = vehicles;
	}

	public List<String> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<String> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public JLabel getTripTransportationLabel() {
		return tripTransportationLabel;
	}

	public void setTripTransportationLabel(JLabel tripTransportationLabel) {
		this.tripTransportationLabel = tripTransportationLabel;
	}

	public JTextField getTripTillField() {
		return tripTillField;
	}

	public void setTripTillField(JTextField tripTillField) {
		this.tripTillField = tripTillField;
	}

	public JLabel getTripTillLabel() {
		return tripTillLabel;
	}

	public void setTripTillLabel(JLabel tripTillLabel) {
		this.tripTillLabel = tripTillLabel;
	}

	public JTextField getTripFromField() {
		return tripFromField;
	}

	public void setTripFromField(JTextField tripFromField) {
		this.tripFromField = tripFromField;
	}

	public JLabel getTripFromLabel() {
		return tripFromLabel;
	}

	public void setTripFromLabel(JLabel tripFromLabel) {
		this.tripFromLabel = tripFromLabel;
	}

	public JTextField getTripDestinatonField() {
		return tripDestinatonField;
	}

	public void setTripDestinatonField(JTextField tripDestinatonField) {
		this.tripDestinatonField = tripDestinatonField;
	}

	public JLabel getTripDestinationLabel() {
		return tripDestinationLabel;
	}

	public void setTripDestinationLabel(JLabel tripDestinationLabel) {
		this.tripDestinationLabel = tripDestinationLabel;
	}

	public JTextField getTripNameField() {
		return tripNameField;
	}

	public void setTripNameField(JTextField tripNameField) {
		this.tripNameField = tripNameField;
	}

	public JLabel getTripNameLabel() {
		return tripNameLabel;
	}

	public void setTripNameLabel(JLabel tripNameLabel) {
		this.tripNameLabel = tripNameLabel;
	}

	public JPanel getGridNorthPanelTrip() {
		return gridNorthPanelTrip;
	}

	public void setGridNorthPanelTrip(JPanel gridNorthPanelTrip) {
		this.gridNorthPanelTrip = gridNorthPanelTrip;
	}

	public JPanel getNorthOfNorthPanelTrip() {
		return northOfNorthPanelTrip;
	}

	public void setNorthOfNorthPanelTrip(JPanel northOfNorthPanelTrip) {
		this.northOfNorthPanelTrip = northOfNorthPanelTrip;
	}

	public JPanel getSouthTripPanel() {
		return southTripPanel;
	}

	public void setSouthTripPanel(JPanel southTripPanel) {
		this.southTripPanel = southTripPanel;
	}

	public JButton getBearbeitenButton2() {
		return bearbeitenButton2;
	}

	public void setBearbeitenButton2(JButton bearbeitenButton2) {
		this.bearbeitenButton2 = bearbeitenButton2;
	}

	public JButton getAnlegenButton2() {
		return anlegenButton2;
	}

	public void setAnlegenButton2(JButton anlegenButton2) {
		this.anlegenButton2 = anlegenButton2;
	}

	public JButton getTripSearchButton() {
		return tripSearchButton;
	}

	public void setTripSearchButton(JButton tripSearchButton) {
		this.tripSearchButton = tripSearchButton;
	}

	public JButton getTripResetButton() {
		return tripResetButton;
	}

	public void setTripResetButton(JButton tripResetButton) {
		this.tripResetButton = tripResetButton;
	}

	public Properties getP() {
		return p;
	}

	public void setP(Properties p) {
		this.p = p;
	}

	public JCheckBox getTripPastCheckbox() {
		return tripPastCheckbox;
	}

	public void setTripPastCheckbox(JCheckBox tripPastCheckbox) {
		this.tripPastCheckbox = tripPastCheckbox;
	}

	public JLabel getTripPastLabel() {
		return tripPastLabel;
	}

	public void setTripPastLabel(JLabel tripPastLabel) {
		this.tripPastLabel = tripPastLabel;
	}

	public SqlDateModel getModelTripStart() {
		return modelTripStart;
	}

	public void setModelTripStart(SqlDateModel modelTripStart) {
		this.modelTripStart = modelTripStart;
	}

	public Properties getpTripStart() {
		return pTripStart;
	}

	public void setpTripStart(Properties pTripStart) {
		this.pTripStart = pTripStart;
	}

	public JDatePanelImpl getDatePanelTripStart() {
		return datePanelTripStart;
	}

	public void setDatePanelTripStart(JDatePanelImpl datePanelTripStart) {
		this.datePanelTripStart = datePanelTripStart;
	}

	public JDatePickerImpl getDatePickerTripStart() {
		return datePickerTripStart;
	}

	public void setDatePickerTripStart(JDatePickerImpl datePickerTripStart) {
		this.datePickerTripStart = datePickerTripStart;
	}

	public SqlDateModel getModelTripEnd() {
		return modelTripEnd;
	}

	public void setModelTripEnd(SqlDateModel modelTripEnd) {
		this.modelTripEnd = modelTripEnd;
	}

	public Properties getpTripEnd() {
		return pTripEnd;
	}

	public void setpTripEnd(Properties pTripEnd) {
		this.pTripEnd = pTripEnd;
	}

	public JDatePanelImpl getDatePanelTripEnd() {
		return datePanelTripEnd;
	}

	public void setDatePanelTripEnd(JDatePanelImpl datePanelTripEnd) {
		this.datePanelTripEnd = datePanelTripEnd;
	}

	public JDatePickerImpl getDatePickerTripEnd() {
		return datePickerTripEnd;
	}

	public void setDatePickerTripEnd(JDatePickerImpl datePickerTripEnd) {
		this.datePickerTripEnd = datePickerTripEnd;
	}
}
