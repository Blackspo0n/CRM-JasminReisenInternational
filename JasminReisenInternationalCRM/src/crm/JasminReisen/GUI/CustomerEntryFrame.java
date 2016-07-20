package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import crm.JasminReisen.Functions.DateLabelFormatter;
import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.Listener.CustomerEntryFrameListener;
import crm.JasminReisen.models.Kunde;

public class CustomerEntryFrame extends JFrame {
	private Kunde customerContext;
	private boolean isNew = false;
	private JPanel southPanel;
	private JPanel centerPanel;
	private JPanel northPanel;
	private JLabel header;
	private JLabel customerVorname;
	private JTextField txtCustomerVorName;
	private JLabel customerName;
	private JTextField txtCustomerName;
	private JLabel customerStreet;
	private JTextField txtStreet;
	private JLabel customerPLZ;
	private JTextField txtPLZ;
	private JLabel customerTown;
	private JTextField txtOrt;
	private JLabel customerCountry;
	private JTextField txtCountry;
	private JLabel customerTelephone;
	private JTextField txtTelephone;
	private JLabel customerAdress;
	private JTextField txtAdress;
	private JLabel customerDate;
	private SqlDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private JButton cancleButton;
	private JButton saveButton;
	
	private static CustomerEntryFrame instance;
	
	protected static CustomerEntryFrame getInstance ()
	{
		if (instance == null)
		{			
			instance=new CustomerEntryFrame();			
		}		
		return instance;
	}	
	
	public CustomerEntryFrame() 
	{
			this(new Kunde());
	}

	public CustomerEntryFrame(Kunde customer) {
		customerContext = customer;
		if(customerContext.getKundennummer() == 0) {
			isNew = true;
		}
		
		setLayout(new BorderLayout());
		setSize(500, 400);
		setLocationRelativeTo(null);
		setTitle("Kunden neu anlegen");
		setAlwaysOnTop(true);
		setUndecorated(true);
		
		centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(0,2,6,6));
		centerPanel.setBorder(new EmptyBorder(0,10,0,10));
		
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
		
		customerVorname = new JLabel("Vorname:");
		centerPanel.add(customerVorname);
		
		txtCustomerVorName = new JTextField();
		centerPanel.add(txtCustomerVorName);

		customerName = new JLabel("Nachname:");
		centerPanel.add(customerName);
		
		txtCustomerName = new JTextField();
		centerPanel.add(txtCustomerName);
		

		customerStreet = new JLabel("Straﬂe:");
		centerPanel.add(customerStreet);
		
		txtStreet = new JTextField();
		centerPanel.add(txtStreet);
		
		customerPLZ = new JLabel("Postleitzahl:");
		centerPanel.add(customerPLZ);
		
		txtPLZ = new JTextField();
		centerPanel.add(txtPLZ);

		customerTown = new JLabel("Ort:");
		centerPanel.add(customerTown);
		
		txtOrt = new JTextField();
		centerPanel.add(txtOrt);

		customerCountry = new JLabel("Land");
		centerPanel.add(customerCountry);
		
		txtCountry = new JTextField();
		centerPanel.add(txtCountry);
		
		customerTelephone = new JLabel("Telefon");
		centerPanel.add(customerTelephone);

		txtTelephone = new JTextField();
		centerPanel.add(txtTelephone);
		
		customerAdress = new JLabel("E-Mail Adresse");
		centerPanel.add(customerAdress);

		txtAdress = new JTextField();
		centerPanel.add(txtAdress);
		
		customerDate = new JLabel("Geburtsdatum");
		centerPanel.add(customerDate);

		model = new SqlDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);

		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		centerPanel.add(datePicker);
		
		cancleButton = new JButton("Abbrechen");
		southPanel.add(cancleButton);
		
		saveButton = new JButton("");
		if(customerContext.getKundennummer() == 0) {
			saveButton.setText("Anlegen");
			header.setText("Neuen Kunden anlegen:");
		}
		else {
			saveButton.setText("Speichern");
			header.setText("Kunden " + customerContext.getVorname() + " " + customerContext.getName() + " bearbeiten:");
			setTitle("Kunden " + customerContext.getVorname() + " " + customerContext.getName() + " bearbeiten");
			
			txtCustomerName.setText(customer.getName());
			txtCustomerVorName.setText(customer.getVorname());
			txtStreet.setText(customer.getStrasse());
			txtPLZ.setText(customer.getPLZ());;
			txtOrt.setText(customer.getOrt());;
			txtCountry.setText(customer.getLand());;
			txtTelephone.setText(customer.getTelefon());
			txtAdress.setText(customer.getTelefon());
			
			if(customer.getGebDat() != null) datePicker.getModel().setDate(customer.getGebDat().getYear(), customer.getGebDat().getMonth(), customer.getGebDat().getDay());
		}
		saveButton.addActionListener(new CustomerEntryFrameListener(this));
		cancleButton.addActionListener(new CustomerEntryFrameListener(this));
		
		southPanel.add(saveButton);
		setVisible(true);
	}

	public Kunde getCustomerContext() {
		return customerContext;
	}

	public void setCustomerContext(Kunde customerContext) {
		this.customerContext = customerContext;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
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

	public JLabel getCustomerVorname() {
		return customerVorname;
	}

	public void setCustomerVorname(JLabel customerVorname) {
		this.customerVorname = customerVorname;
	}

	public JTextField getTxtCustomerVorName() {
		return txtCustomerVorName;
	}

	public void setTxtCustomerVorName(JTextField txtCustomerVorName) {
		this.txtCustomerVorName = txtCustomerVorName;
	}

	public JLabel getCustomerName() {
		return customerName;
	}

	public void setCustomerName(JLabel customerName) {
		this.customerName = customerName;
	}

	public JTextField getTxtCustomerName() {
		return txtCustomerName;
	}

	public void setTxtCustomerName(JTextField txtCustomerName) {
		this.txtCustomerName = txtCustomerName;
	}

	public JLabel getCustomerStreet() {
		return customerStreet;
	}

	public void setCustomerStreet(JLabel customerStreet) {
		this.customerStreet = customerStreet;
	}

	public JTextField getTxtStreet() {
		return txtStreet;
	}

	public void setTxtStreet(JTextField txtStreet) {
		this.txtStreet = txtStreet;
	}

	public JLabel getCustomerPLZ() {
		return customerPLZ;
	}

	public void setCustomerPLZ(JLabel customerPLZ) {
		this.customerPLZ = customerPLZ;
	}

	public JTextField getTxtPLZ() {
		return txtPLZ;
	}

	public void setTxtPLZ(JTextField txtPLZ) {
		this.txtPLZ = txtPLZ;
	}

	public JLabel getCustomerTown() {
		return customerTown;
	}

	public void setCustomerTown(JLabel customerTown) {
		this.customerTown = customerTown;
	}

	public JTextField getTxtOrt() {
		return txtOrt;
	}

	public void setTxtOrt(JTextField txtOrt) {
		this.txtOrt = txtOrt;
	}

	public JLabel getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(JLabel customerCountry) {
		this.customerCountry = customerCountry;
	}

	public JTextField getTxtCountry() {
		return txtCountry;
	}

	public void setTxtCountry(JTextField txtCountry) {
		this.txtCountry = txtCountry;
	}

	public JLabel getCustomerTelephone() {
		return customerTelephone;
	}

	public void setCustomerTelephone(JLabel customerTelephone) {
		this.customerTelephone = customerTelephone;
	}

	public JTextField getTxtTelephone() {
		return txtTelephone;
	}

	public void setTxtTelephone(JTextField txtTelephone) {
		this.txtTelephone = txtTelephone;
	}

	public JLabel getCustomerAdress() {
		return customerAdress;
	}

	public void setCustomerAdress(JLabel customerAdress) {
		this.customerAdress = customerAdress;
	}

	public JTextField getTxtAdress() {
		return txtAdress;
	}

	public void setTxtAdress(JTextField txtAdress) {
		this.txtAdress = txtAdress;
	}

	public JLabel getCustomerDate() {
		return customerDate;
	}

	public void setCustomerDate(JLabel customerDate) {
		this.customerDate = customerDate;
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

	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(JDatePickerImpl datePicker) {
		this.datePicker = datePicker;
	}

	public JButton getCancleButton() {
		return cancleButton;
	}

	public void setCancleButton(JButton cancleButton) {
		this.cancleButton = cancleButton;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}
}
