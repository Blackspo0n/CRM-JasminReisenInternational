package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import crm.JasminReisen.Config;
import crm.JasminReisen.Functions.DateLabelFormatter;
import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.Functions.ServiceFunctions;
import crm.JasminReisen.Listener.BirthdayMessageListener;
import crm.JasminReisen.Listener.CreateCustomerContactListener;
import crm.JasminReisen.models.Kunde;

public class CreateCustomerContactFrame extends JFrame {

	private JTextField customerIdField;
	private Kunde[] customers;
	private JComboBox<Kunde> customerBox;
	private ArrayList<String> actionList;
	private SqlDateModel model;
	private JDatePickerImpl datePicker;
	private JDatePanelImpl datePanel;
	private JComboBox<String> actionBox;
	private JTextField kindOfReshowField;
	private JLabel kindOfReshowLabel;
	private JComboBox<String> actionBoxReshow;
	private JTextArea themeTextArea;
	private JScrollPane themeScrollPaneEast;
	private JTextArea themeTextAreaEast;
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
	private JLabel customerLabel;
	private ArrayList<Kunde> customersList;
	private JLabel customerIdLabel;
	private Kunde kunde;
	private JPanel westCenterPanel;
	private JPanel eastCenterPanel;
	private JScrollPane scrollArea;
	private JScrollPane scrollAreaEast;
	private JLabel reshowLabel;
	private ArrayList<String> actionListReshow;
	private String[] actionsReshows;
	private JButton saveButton;
	private JLabel emptyLabel13;
	private JLabel emptyLabel14;
	private JButton saveReviewButton;

	public CreateCustomerContactFrame() {
		this.setSize(1200, 550);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setTitle("Kontakt erfassen");

		northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 4, 10, 10));
		northPanel.setBackground(Config.getBACKGROUND());
		northPanel.setBorder(new EmptyBorder(10, 10, 10, 15));
		this.add(northPanel, BorderLayout.NORTH);

		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1, 2, 10, 10));
		centerPanel.setBackground(Config.getBACKGROUND());
		centerPanel.setBorder(new EmptyBorder(10, 10, 15, 10));
		this.add(centerPanel, BorderLayout.CENTER);

		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(3, 4, 10, 10));
		southPanel.setBackground(Config.getBACKGROUND());
		southPanel.setBorder(new EmptyBorder(10, 10, 10, 15));
		this.add(southPanel, BorderLayout.SOUTH);

		customerLabel = new JLabel("Kundenname");
		customerLabel.setFont(Config.getFONT());
		customerLabel.setBackground(Config.getBACKGROUND());
		northPanel.add(customerLabel);

		customersList = DbFunctions.getKunde();
		customers = new Kunde[customersList.size()];
		customersList.toArray(customers);
		customerBox = new JComboBox<Kunde>(customers);
		customerBox.setFont(Config.getFONT());
		customerBox.setBackground(Config.getBACKGROUND());
		customerBox.setActionCommand("Combo");
		customerBox.addActionListener(new CreateCustomerContactListener(this));
		northPanel.add(customerBox);

		customerIdLabel = new JLabel("Kundennummer");
		customerIdLabel.setFont(Config.getFONT());
		northPanel.add(customerIdLabel);

		customerIdField = new JTextField(10);
		customerIdField.setFont(Config.getFONT());
		customerIdField.setActionCommand("Field");
		customerIdField.addActionListener(new CreateCustomerContactListener(this));
		customerIdField.setBackground(Config.getBACKGROUND());
		northPanel.add(customerIdField);

		kunde = new Kunde();
		kunde = (Kunde) getCustomerBox().getSelectedItem();
		getCustomerIdField().setText("" + kunde.getKundennummer() + "");

		westCenterPanel = new JPanel();
		westCenterPanel.setLayout(new BorderLayout());
		eastCenterPanel = new JPanel();
		eastCenterPanel.setLayout(new BorderLayout());
		centerPanel.add(westCenterPanel);
		centerPanel.add(eastCenterPanel);

		scrollArea = new JScrollPane();
		westCenterPanel.add(scrollArea, BorderLayout.CENTER);

		themeTextArea = new JTextArea();
		themeTextArea.setFont(Config.getFONT_TEXTFIELD());
		themeTextArea.setBorder(new EmptyBorder(10, 10, 10, 10));
		themeTextArea.setText("Thema:\n\nBeschreibung:");
		scrollArea.setViewportView(themeTextArea);

		scrollAreaEast = new JScrollPane();
		eastCenterPanel.add(scrollAreaEast, BorderLayout.CENTER);

		themeTextAreaEast = new JTextArea();
		themeTextAreaEast.setFont(Config.getFONT_TEXTFIELD());
		themeTextAreaEast.setSize(600, 250);
		themeTextAreaEast.setBorder(new EmptyBorder(10, 10, 10, 10));
		themeTextAreaEast.setText("Thema:\n\nBeschreibung:");
		scrollAreaEast.setViewportView(themeTextAreaEast);

		// SÜDEN
		JLabel kindOfContactLabel = new JLabel("Kontaktart");
		kindOfContactLabel.setFont(Config.getFONT());
		southPanel.add(kindOfContactLabel);

		actionList = new ArrayList<String>(DbFunctions.getActionList());
		String[] actions = actionList.toArray(new String[actionList.size()]);
		actionBox = new JComboBox<String>(actions);
		actionBox.setFont(Config.getFONT());
		actionBox.setBackground(Config.getBACKGROUND());
		southPanel.add(actionBox);

		reshowLabel = new JLabel("Wiedervorlagedatum");
		reshowLabel.setFont(Config.getFONT());
		reshowLabel.setBackground(Config.getBACKGROUND());
		southPanel.add(reshowLabel);

		model = new SqlDateModel();
		Properties p = new Properties();
		p.put("text.today", "Heute");
		p.put("text.month", "Monat");
		p.put("text.year", "Jahr");
		datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setFont(Config.getFONT());
		southPanel.add(datePicker);

		JLabel emptyLabel11 = new JLabel();
		southPanel.add(emptyLabel11);

		JLabel emptyLabel12 = new JLabel();
		southPanel.add(emptyLabel12);

		kindOfReshowLabel = new JLabel("Wiedervorlageart");
		kindOfReshowLabel.setFont(Config.getFONT());
		kindOfReshowLabel.setBackground(Config.getBACKGROUND());
		southPanel.add(kindOfReshowLabel);

		actionListReshow = new ArrayList<String>(DbFunctions.getActionList());
		actionsReshows = actionList.toArray(new String[actionListReshow.size()]);
		actionBoxReshow = new JComboBox<String>(actionsReshows);
		actionBoxReshow.setFont(Config.getFONT());
		actionBoxReshow.setBackground(Config.getBACKGROUND());
		southPanel.add(actionBoxReshow);

		saveButton = new JButton("In Kontakthistorie Speichern");
		saveButton.setFont(Config.getFONT());
		saveButton.addActionListener(new CreateCustomerContactListener(this));
		southPanel.add(saveButton);

		emptyLabel13 = new JLabel();
		southPanel.add(emptyLabel13);

		emptyLabel14 = new JLabel();
		southPanel.add(emptyLabel14);

		saveReviewButton = new JButton("In Wiedervorlage Speichern");
		saveReviewButton.setFont(Config.getFONT());
		saveReviewButton.addActionListener(new CreateCustomerContactListener(this));
		southPanel.add(saveReviewButton);

		this.setVisible(true);

	}

	public JTextField getCustomerIdField() {
		return customerIdField;
	}

	public void setCustomerIdField(JTextField customerIdField) {
		this.customerIdField = customerIdField;
	}

	public Kunde[] getCustomers() {
		return customers;
	}

	public void setCustomers(Kunde[] customers) {
		this.customers = customers;
	}

	public JComboBox<Kunde> getCustomerBox() {
		return customerBox;
	}

	public void setCustomerBox(JComboBox<Kunde> customerBox) {
		this.customerBox = customerBox;
	}

	public ArrayList<String> getActionList() {
		return actionList;
	}

	public void setActionList(ArrayList<String> actionList) {
		this.actionList = actionList;
	}

	public SqlDateModel getModel() {
		return model;
	}

	public void setModel(SqlDateModel model) {
		this.model = model;
	}

	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(JDatePickerImpl datePicker) {
		this.datePicker = datePicker;
	}

	public JDatePanelImpl getDatePanel() {
		return datePanel;
	}

	public void setDatePanel(JDatePanelImpl datePanel) {
		this.datePanel = datePanel;
	}

	public JComboBox<String> getActionBox() {
		return actionBox;
	}

	public void setActionBox(JComboBox<String> actionBox) {
		this.actionBox = actionBox;
	}

	public JTextField getKindOfReshowField() {
		return kindOfReshowField;
	}

	public void setKindOfReshowField(JTextField kindOfReshowField) {
		this.kindOfReshowField = kindOfReshowField;
	}

	public JLabel getKindOfReshowLabel() {
		return kindOfReshowLabel;
	}

	public void setKindOfReshowLabel(JLabel kindOfReshowLabel) {
		this.kindOfReshowLabel = kindOfReshowLabel;
	}

	public JComboBox<String> getActionBoxReshow() {
		return actionBoxReshow;
	}

	public void setActionBoxReshow(JComboBox<String> actionBoxReshow) {
		this.actionBoxReshow = actionBoxReshow;
	}

	public JTextArea getThemeTextArea() {
		return themeTextArea;
	}

	public void setThemeTextArea(JTextArea themeTextArea) {
		this.themeTextArea = themeTextArea;
	}

	public JScrollPane getThemeScrollPaneEast() {
		return themeScrollPaneEast;
	}

	public void setThemeScrollPaneEast(JScrollPane themeScrollPaneEast) {
		this.themeScrollPaneEast = themeScrollPaneEast;
	}

	public JTextArea getThemeTextAreaEast() {
		return themeTextAreaEast;
	}

	public void setThemeTextAreaEast(JTextArea themeTextAreaEast) {
		this.themeTextAreaEast = themeTextAreaEast;
	}

	public JPanel getNorthPanel() {
		return northPanel;
	}

	public void setNorthPanel(JPanel northPanel) {
		this.northPanel = northPanel;
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	public JPanel getSouthPanel() {
		return southPanel;
	}

	public void setSouthPanel(JPanel southPanel) {
		this.southPanel = southPanel;
	}

	public JLabel getCustomerLabel() {
		return customerLabel;
	}

	public void setCustomerLabel(JLabel customerLabel) {
		this.customerLabel = customerLabel;
	}

	public ArrayList<Kunde> getCustomersList() {
		return customersList;
	}

	public void setCustomersList(ArrayList<Kunde> customersList) {
		this.customersList = customersList;
	}

	public JLabel getCustomerIdLabel() {
		return customerIdLabel;
	}

	public void setCustomerIdLabel(JLabel customerIdLabel) {
		this.customerIdLabel = customerIdLabel;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public JPanel getWestCenterPanel() {
		return westCenterPanel;
	}

	public void setWestCenterPanel(JPanel westCenterPanel) {
		this.westCenterPanel = westCenterPanel;
	}

	public JPanel getEastCenterPanel() {
		return eastCenterPanel;
	}

	public void setEastCenterPanel(JPanel eastCenterPanel) {
		this.eastCenterPanel = eastCenterPanel;
	}

	public JScrollPane getScrollArea() {
		return scrollArea;
	}

	public void setScrollArea(JScrollPane scrollArea) {
		this.scrollArea = scrollArea;
	}

	public JScrollPane getScrollAreaEast() {
		return scrollAreaEast;
	}

	public void setScrollAreaEast(JScrollPane scrollAreaEast) {
		this.scrollAreaEast = scrollAreaEast;
	}

	public JLabel getReshowLabel() {
		return reshowLabel;
	}

	public void setReshowLabel(JLabel reshowLabel) {
		this.reshowLabel = reshowLabel;
	}

	public ArrayList<String> getActionListReshow() {
		return actionListReshow;
	}

	public void setActionListReshow(ArrayList<String> actionListReshow) {
		this.actionListReshow = actionListReshow;
	}

	public String[] getActionsReshows() {
		return actionsReshows;
	}

	public void setActionsReshows(String[] actionsReshows) {
		this.actionsReshows = actionsReshows;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}

	public JLabel getEmptyLabel13() {
		return emptyLabel13;
	}

	public void setEmptyLabel13(JLabel emptyLabel13) {
		this.emptyLabel13 = emptyLabel13;
	}

	public JLabel getEmptyLabel14() {
		return emptyLabel14;
	}

	public void setEmptyLabel14(JLabel emptyLabel14) {
		this.emptyLabel14 = emptyLabel14;
	}

	public JButton getSaveReviewButton() {
		return saveReviewButton;
	}

	public void setSaveReviewButton(JButton saveReviewButton) {
		this.saveReviewButton = saveReviewButton;
	}

}
