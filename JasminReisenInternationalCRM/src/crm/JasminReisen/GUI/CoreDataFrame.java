package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
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
	private JScrollPane customerScrollPane;

	private JPanel northPanelTrip;
	
	
	public CoreDataFrame() {

		this.setSize(1200, 600);
		this.setResizable(false);
		this.setTitle("Stammdatenpflege");
		this.setBackground(Config.getBACKGROUND());
		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width / 2 - windowSize.width / 2, screenSize.height / 2 - windowSize.height / 2);
		this.setLayout(new BorderLayout());

		mainPanel = new JPanel();
		mainPanel.setBackground(Config.getBACKGROUND());
		this.add(mainPanel, BorderLayout.CENTER);

		coreDataTab = new JTabbedPane(JTabbedPane.TOP);
		coreDataTab.setFont(Config.getFONT());
		coreDataTab.setBackground(Config.getBACKGROUND());
		this.add(coreDataTab);

		tripPanel = new JPanel();
		tripPanel.setFont(Config.getFONT());
		tripPanel.setBackground(Config.getBACKGROUND());
		tripPanel.setLayout(new BorderLayout());
		coreDataTab.addTab("Reisen", null, tripPanel, null);

		customerPanel = new JPanel();
		customerPanel.setFont(Config.getFONT());
		customerPanel.setBackground(Config.getBACKGROUND());
		customerPanel.setLayout(new BorderLayout());
		coreDataTab.addTab("Kunden", null, customerPanel, null);
		
		northPanelTrip = new JPanel();
		northPanelTrip.setSize(1200, 400);
		northPanelTrip.setBackground(Config.getBACKGROUND());
		tripPanel.add(northPanelTrip, BorderLayout.NORTH);
		northPanelTrip.setLayout(new BorderLayout());
		
		JPanel northOfNorthPanelTrip = new JPanel();
		northOfNorthPanelTrip.setLayout(new GridLayout(1,1,0,0));
		northPanelTrip.add(northOfNorthPanelTrip, BorderLayout.NORTH);
		
		
		
		headLineTrip = new JLabel("Filter");
		headLineTrip.setFont(Config.getHEADLINE());
		headLineTrip.setBackground(Config.getBACKGROUND());
		headLineTrip.setHorizontalAlignment(JLabel.CENTER);
		northOfNorthPanelTrip.add(headLineTrip, BorderLayout.NORTH);
		
		JPanel gridNorthPanelTrip = new JPanel();
		gridNorthPanelTrip.setLayout(new GridLayout(6,4,5,5));
		northPanelTrip.add(gridNorthPanelTrip, BorderLayout.CENTER);
		
		JLabel tripNameLabel = new JLabel("Reisename");
		tripNameLabel.setFont(Config.getFONT());
		tripNameLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripNameLabel);
		
		JTextField tripNameField = new JTextField();
		tripNameField.setFont(Config.getFONT());
		tripNameField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripNameField);
		
		JLabel tripDestinationLabel = new JLabel("Zielort");
		tripDestinationLabel.setFont(Config.getFONT());
		tripDestinationLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripDestinationLabel);
		
		JTextField tripDestinatonField = new JTextField();
		tripDestinatonField.setFont(Config.getFONT());
		tripDestinatonField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripDestinatonField);
		
		
		JLabel tripFromLabel = new JLabel("Reise Anfang");
		tripFromLabel.setFont(Config.getFONT());
		tripFromLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripFromLabel);
		
		JTextField tripFromField = new JTextField();
		tripFromField.setFont(Config.getFONT());
		tripFromField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripFromField);
		
		JLabel tripTillLabel = new JLabel("Reise Ende");
		tripTillLabel.setFont(Config.getFONT());
		tripTillLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripTillLabel);
		
		JTextField tripTillField = new JTextField();
		tripTillField.setFont(Config.getFONT());
		tripTillField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripTillField);
		
		JLabel tripTransportationLabel = new JLabel("Transportmittel");
		tripTransportationLabel.setFont(Config.getFONT());
		tripTransportationLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripTransportationLabel);
		
		List<String> vehicleList = new ArrayList<String>(DbFunctions.getVehicleList());
		String[] vehicles = vehicleList.toArray(new String[vehicleList.size()]);
		JComboBox vehicleBox = new JComboBox(vehicles);
		vehicleBox.setFont(Config.getFONT());
		vehicleBox.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(vehicleBox);
		
		JLabel tripClimateLabel = new JLabel("Klima");
		tripClimateLabel.setFont(Config.getFONT());
		tripClimateLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripClimateLabel);
		
		String[] climates = {"polar", "subpolar", "gemäßigt", "subtropisch", "passat", "wüst", "tropisch"};
		JComboBox climatesBox = new JComboBox(climates);
		climatesBox.setFont(Config.getFONT());
		climatesBox.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(climatesBox);
		
		JLabel tripRegionLabel = new JLabel("Region");
		tripRegionLabel.setFont(Config.getFONT());
		tripRegionLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripRegionLabel);
		
		JTextField tripRegionField = new JTextField();
		tripRegionField.setFont(Config.getFONT());
		tripRegionField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripRegionField);
		
		JLabel tripHotelLabel = new JLabel("Hotelname");
		tripHotelLabel.setFont(Config.getFONT());
		tripHotelLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripHotelLabel);
		
		JTextField tripHotelField = new JTextField();
		tripHotelField.setFont(Config.getFONT());
		tripHotelField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripHotelField);
		
		JLabel tripPriceFromLabel = new JLabel("Preise von");
		tripPriceFromLabel.setFont(Config.getFONT());
		tripPriceFromLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripPriceFromLabel);
		
		JTextField tripPriceFromField = new JTextField();
		tripPriceFromField.setFont(Config.getFONT());
		tripPriceFromField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripPriceFromField);
		
		JLabel tripPriceToLabel = new JLabel("Preise bis");
		tripPriceToLabel.setFont(Config.getFONT());
		tripPriceToLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripPriceToLabel);
		
		JTextField tripPriceToField = new JTextField();
		tripPriceToField.setFont(Config.getFONT());
		tripPriceToField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripPriceToField);
		
		JLabel tripQuotaToLabel = new JLabel("Kontingent über");
		tripQuotaToLabel.setFont(Config.getFONT());
		tripQuotaToLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripQuotaToLabel);
		
		JTextField tripQuotaField = new JTextField();
		tripQuotaField.setFont(Config.getFONT());
		tripQuotaField.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripQuotaField);
		
		JLabel tripAvailableLabel = new JLabel("Verfügbar ab");
		tripAvailableLabel.setFont(Config.getFONT());
		tripAvailableLabel.setBackground(Config.getBACKGROUND());
		gridNorthPanelTrip.add(tripAvailableLabel);
		
		// Date Picker
		SqlDateModel model = new SqlDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		gridNorthPanelTrip.add(datePicker);
		
		//JTextField tripAvailableField = new JTextField("");
		//tripAvailableField.setFont(Config.getFONT());
		//tripAvailableField.setBackground(Config.getBACKGROUND());

		
		
		
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
		searchButton.setFont(Config.getFONT());
		searchButton.setBackground(Config.getBACKGROUND());
		centerOfNorthOfCustomerPanel.add(searchButton);

		emptyLabel = new JLabel("");
		emptyLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(emptyLabel);

		resetButton = new JButton("Zurücksetzen");
		resetButton.setFont(Config.getFONT());
		resetButton.setBackground(Config.getBACKGROUND());
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

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, 2, 5, 5));
		customerPanel.add(southPanel, BorderLayout.SOUTH);

		JButton bearbeitenButton = new JButton("Bearbeiten");
		bearbeitenButton.setBackground(Config.getBACKGROUND());
		bearbeitenButton.setFont(Config.getFONT());
		southPanel.add(bearbeitenButton);

		JButton anlegenButton = new JButton("Kunde Anlegen");
		anlegenButton.setBackground(Config.getBACKGROUND());
		anlegenButton.setFont(Config.getFONT());
		southPanel.add(anlegenButton);

		customerTable = new JTable();
		customerScrollPane = new JScrollPane();
		customerPanel.add(customerScrollPane, BorderLayout.CENTER);

		customerTable.setShowGrid(false);
		customerTable.setFont(Config.getFONT());
		customerTable.setBackground(Config.getBACKGROUND());
		customerTable.setModel(DbFunctions.getFilteredCustomers(""));
		customerTable.setAutoCreateRowSorter(true);
		customerTable.setPreferredScrollableViewportSize(customerTable.getPreferredSize());
		customerTable.setFillsViewportHeight(true);
		customerTable.setRowHeight(21);
		customerTable.getTableHeader().setFont(Config.getFONT());
		customerScrollPane.setViewportView(customerTable);
		
		
		
		
		
		
		
		
		
		
		
		
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
}
