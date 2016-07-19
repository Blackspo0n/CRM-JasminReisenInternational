package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.models.Kunde;

public class CustomerEntryFrame extends JFrame {
	private Kunde customerContext;
	private boolean isNew = false;
	
	public static void main(String[] args) {
		new CustomerEntryFrame(new Kunde(21,"Name", "Vorname", "", "", "", "", "", "", null));
	}
	
	public CustomerEntryFrame() {
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
		
		
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(0,2,6,6));
		centerPanel.setBorder(new EmptyBorder(0,10,0,10));
		
		JPanel southPanel = new JPanel();
		add(southPanel, BorderLayout.SOUTH);
		
		JPanel northPanel = new JPanel();
		add(northPanel, BorderLayout.NORTH);
		northPanel.setAlignmentX(LEFT_ALIGNMENT);
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel header = new JLabel();
		header.setHorizontalAlignment(SwingConstants.LEFT);
		header.setFont(new Font("Calibri Light", Font.BOLD, 24));
		northPanel.add(header);
		
		JLabel customerVorname = new JLabel("Vorname:");
		centerPanel.add(customerVorname);
		
		JTextField txtCustomerVorName = new JTextField();
		centerPanel.add(txtCustomerVorName);

		JLabel customerName = new JLabel("Nachname:");
		centerPanel.add(customerName);
		
		JTextField txtCustomerName = new JTextField();
		centerPanel.add(txtCustomerName);
		

		JLabel customerStreet = new JLabel("Straﬂe:");
		centerPanel.add(customerStreet);
		
		JTextField txtStreet = new JTextField();
		centerPanel.add(txtStreet);
		
		JLabel customerPLZ = new JLabel("Postleitzahl:");
		centerPanel.add(customerPLZ);
		
		JTextField txtPLZ = new JTextField();
		centerPanel.add(txtPLZ);

		JLabel customerTown = new JLabel("Ort:");
		centerPanel.add(customerTown);
		
		JTextField txtOrt = new JTextField();
		centerPanel.add(txtOrt);

		JLabel customerCountry = new JLabel("Land");
		centerPanel.add(customerCountry);
		
		JTextField txtCountry = new JTextField();
		centerPanel.add(txtCountry);
		
		JLabel customerTelephone = new JLabel("Telefon");
		centerPanel.add(customerTelephone);

		JTextField txtTelephone = new JTextField();
		centerPanel.add(txtTelephone);
		
		JLabel customerAdress = new JLabel("E-Mail Adresse");
		centerPanel.add(customerAdress);

		JTextField txtAdress = new JTextField();
		centerPanel.add(txtAdress);
		
		JLabel customerDate = new JLabel("Geburtsdatum");
		centerPanel.add(customerDate);

		JTextField txtDate = new JTextField();
		centerPanel.add(txtDate);	
		
		
		
		
		
		JButton cancleButton = new JButton("Abbrechen");
		southPanel.add(cancleButton);
		
		JButton saveButton = new JButton("");
		if(customerContext.getKundennummer() == 0) {
			saveButton.setText("Anlegen");
			header.setText("Neuen Benutzer anlegen:");
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
			
			if(customer.getGebDat() != null) txtDate.setText(customer.getGebDat().toString());
		}
		
		southPanel.add(saveButton);
		setVisible(true);
	}
}
