package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
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

	public CreateCustomerContactFrame() {
		this.setSize(800, 450);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setTitle("Kontakt erfassen");

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 6, 10, 10));
		northPanel.setBackground(Config.getBACKGROUND());
		northPanel.setBorder(new EmptyBorder(10, 10, 20, 10));
		this.add(northPanel, BorderLayout.NORTH);

		JLabel customerLabel = new JLabel("Kunde");
		customerLabel.setFont(Config.getFONT());
		northPanel.add(customerLabel);

		ArrayList<Kunde> customersList = DbFunctions.getKunde();
		customers = new Kunde[customersList.size()];
		customersList.toArray(customers);
		customerBox = new JComboBox<Kunde>(customers);
		customerBox.setFont(Config.getFONT());
		customerBox.setBackground(Config.getBACKGROUND());
		customerBox.setActionCommand("Combo");
		customerBox.addActionListener(new CreateCustomerContactListener(this));
		northPanel.add(customerBox);

		JLabel customerIdLabel = new JLabel("Kundennummer");
		customerIdLabel.setFont(Config.getFONT());
		northPanel.add(customerIdLabel);

		customerIdField = new JTextField(10);
		customerIdField.setFont(Config.getFONT());
		customerIdField.setActionCommand("Field");
		customerIdField.addActionListener(new CreateCustomerContactListener(this));
		customerIdField.setBackground(Config.getBACKGROUND());
		northPanel.add(customerIdField);

		Kunde kunde = new Kunde();
		kunde = (Kunde) getCustomerBox().getSelectedItem();
		getCustomerIdField().setText("" + kunde.getKundennummer() + "");

		JLabel kindOfContactLabel = new JLabel("Kontaktart");
		kindOfContactLabel.setFont(Config.getFONT());
		northPanel.add(kindOfContactLabel);

		actionList = new ArrayList<String>(DbFunctions.getActionList());
		String[] actions = actionList.toArray(new String[actionList.size()]);
		JComboBox<String> actionBox = new JComboBox<String>(actions);
		actionBox.setFont(Config.getFONT());
		actionBox.setBackground(Config.getBACKGROUND());
		northPanel.add(actionBox);

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Config.getBACKGROUND());
		centerPanel.setBorder(new LineBorder(Config.getBORDER()));
		centerPanel.setLayout(new BorderLayout());
		this.add(centerPanel, BorderLayout.CENTER);

		JScrollPane themeScrollPane = new JScrollPane();
		centerPanel.add(themeScrollPane, BorderLayout.CENTER);

		JTextArea themeTextArea = new JTextArea();
		themeTextArea.setFont(Config.getFONT_TEXTFIELD());
		themeTextArea.setBorder(new EmptyBorder(10, 10, 10, 10));
		themeTextArea.setText("Thema:\n\nBeschreibung:");
		themeScrollPane.setViewportView(themeTextArea);

		JPanel southPanel = new JPanel();
		southPanel.setBackground(Config.getBACKGROUND());
		southPanel.setBorder(new EmptyBorder(20, 10, 10, 10));
		southPanel.setLayout(new GridLayout(2, 2, 10, 10));
		this.add(southPanel, BorderLayout.SOUTH);

		JLabel reshowLabel = new JLabel("Wiedervorlage");
		reshowLabel.setFont(Config.getFONT());
		reshowLabel.setBackground(Config.getBACKGROUND());
		southPanel.add(reshowLabel);

		model = new SqlDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setFont(Config.getFONT());
		southPanel.add(datePicker);

		JButton abortButton = new JButton("Abbrechen");
		abortButton.addActionListener(new CreateCustomerContactListener(this));
		southPanel.add(abortButton);

		JButton saveButton = new JButton("Speichern");
		southPanel.add(saveButton);

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

}
