package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.Functions.LoginFunctions;
import crm.JasminReisen.GUI.CoreDataFrame;
import crm.JasminReisen.GUI.CustomerEntryFrame;
import crm.JasminReisen.GUI.LoginFrame;
import crm.JasminReisen.GUI.MainFrame;
import crm.JasminReisen.models.Kunde;
import crm.JasminReisen.models.User;

public class CustomerEntryFrameListener implements ActionListener
{
	CustomerEntryFrame customerFrame;
	
	public CustomerEntryFrameListener(CustomerEntryFrame customerFrame)
	{
		this.customerFrame = customerFrame ;
	}
	
	public void actionPerformed (ActionEvent event)
	{
		switch (event.getActionCommand()) {
		case "Anlegen":

			updateCustomerContext();
			try {
				DbFunctions.createCostumer(this.customerFrame.getCustomerContext());
				this.customerFrame.dispose();
				new CustomerEntryFrame();
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Der Kunde konnte nicht angelegt werden.");
			}
			break;
		case "Speichern":

			updateCustomerContext();
			try {
				DbFunctions.saveCostumer(this.customerFrame.getCustomerContext());
				this.customerFrame.dispose();
				
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Der Kunde konnte nicht gespeichert werden.");
			}
			CustomerEntryFrame.setInstance(null);
			break;
		case "Abbrechen":
			this.customerFrame.dispose();
			CustomerEntryFrame.setInstance(null);
			break;
		}
	}
	
	private void updateCustomerContext() {
		this.customerFrame.getCustomerContext().setName(this.customerFrame.getTxtCustomerName().getText());
		this.customerFrame.getCustomerContext().setVorname(this.customerFrame.getTxtCustomerVorName().getText());

		this.customerFrame.getCustomerContext().setStrasse(this.customerFrame.getTxtStreet().getText());
		this.customerFrame.getCustomerContext().setPLZ(this.customerFrame.getTxtPLZ().getText());
		this.customerFrame.getCustomerContext().setOrt(this.customerFrame.getTxtOrt().getText());
		this.customerFrame.getCustomerContext().setLand(this.customerFrame.getTxtCountry().getText());
		this.customerFrame.getCustomerContext().setTelefon(this.customerFrame.getTxtTelephone().getText());
		this.customerFrame.getCustomerContext().setEMail(this.customerFrame.getTxtAdress().getText());		
		try {
			if (this.customerFrame.getDatePicker().getJFormattedTextField().getText().charAt(4) == '-')
				this.customerFrame.getCustomerContext().setGebDat(new SimpleDateFormat("yyyy-MM-dd").parse(this.customerFrame.getDatePicker().getJFormattedTextField().getText()));
			else
				this.customerFrame.getCustomerContext().setGebDat(new SimpleDateFormat("dd-MMM-yyyy").parse(this.customerFrame.getDatePicker().getJFormattedTextField().getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
