package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.GUI.CoreDataFrame;
import crm.JasminReisen.GUI.CustomerEntryFrame;

public class CoreDataListener implements ActionListener {

	CoreDataFrame cdf;
	String sql;

	public CoreDataListener(CoreDataFrame cdf) {
		this.cdf = cdf;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "Zurücksetzen":
			cdf.getMailTextField().setText("");
			cdf.getNameTextField().setText("");
			cdf.getVornameTextField().setText("");
			cdf.getStrasseTextField().setText("");
			cdf.getPlzTextField().setText("");
			cdf.getLandTextField().setText("");
			cdf.getOrtTextField().setText("");
			cdf.getTelefonTextField().setText("");
			sql = "SELECT * FROM Kunden";
			cdf.getCustomerTable().setModel(DbFunctions.getFilteredCustomers(sql));
			cdf.getCustomerTable().repaint();
			break;
		case "Suchen":
			Integer ageFromFieldInt = null;
			Integer ageToFieldInt = null;
			if (!cdf.getAgeFromField().getText().equals("")) {
				ageFromFieldInt = Integer.parseInt(cdf.getAgeFromField().getText());
			} else if (cdf.getAgeFromField().getText().equals("")){
				ageFromFieldInt = 0;
			}
			if (!cdf.getAgeToField().getText().equals("")) {
				ageToFieldInt = Integer.parseInt(cdf.getAgeToField().getText());
			} else if (cdf.getAgeToField().getText().equals("")){
				ageToFieldInt = 999;
			}
			if (!cdf.getAgeFromField().getText().equals("") && !cdf.getAgeToField().getText().equals("")) {
				if (ageFromFieldInt > ageToFieldInt) {
					JOptionPane.showMessageDialog(null, "Bitte korrigieren Sie den Altersfilter!");
				} else {
					sql = "SELECT * FROM Kunden WHERE Name LIKE '%" + cdf.getNameTextField().getText()
							+ "%' AND Vorname LIKE '%" + cdf.getVornameTextField().getText() + "%' AND Strasse LIKE '%"
							+ cdf.getStrasseTextField().getText() + "%' AND PLZ LIKE '"
							+ cdf.getPlzTextField().getText() + "%' AND Land LIKE '%" + cdf.getLandTextField().getText()
							+ "%' AND Ort LIKE '%" + cdf.getOrtTextField().getText() + "%' AND Telefon LIKE '%"
							+ cdf.getTelefonTextField().getText() + "%' AND EMail LIKE '%"
							+ cdf.getMailTextField().getText()
							+ "%' AND ((to_days(now()) - to_days(GebDat)) / 365) >='" + ageFromFieldInt
							+ "' AND ((to_days(now()) - to_days(GebDat)) / 365) <= '" + ageToFieldInt + "'";
				}
			} else if (!cdf.getAgeFromField().getText().equals("")) {
				sql = "SELECT * FROM Kunden WHERE Name LIKE '%" + cdf.getNameTextField().getText()
						+ "%' AND Vorname LIKE '%" + cdf.getVornameTextField().getText() + "%' AND Strasse LIKE '%"
						+ cdf.getStrasseTextField().getText() + "%' AND PLZ LIKE '" + cdf.getPlzTextField().getText()
						+ "%' AND Land LIKE '%" + cdf.getLandTextField().getText() + "%' AND Ort LIKE '%"
						+ cdf.getOrtTextField().getText() + "%' AND Telefon LIKE '%"
						+ cdf.getTelefonTextField().getText() + "%' AND EMail LIKE '%"
						+ cdf.getMailTextField().getText() + "%' AND ((to_days(now()) - to_days(GebDat)) / 365) >='"
						+ ageFromFieldInt + "'";

			} else if (!cdf.getAgeToField().getText().equals("")){
				sql = "SELECT * FROM Kunden WHERE Name LIKE '%" + cdf.getNameTextField().getText()
						+ "%' AND Vorname LIKE '%" + cdf.getVornameTextField().getText() + "%' AND Strasse LIKE '%"
						+ cdf.getStrasseTextField().getText() + "%' AND PLZ LIKE '" + cdf.getPlzTextField().getText()
						+ "%' AND Land LIKE '%" + cdf.getLandTextField().getText() + "%' AND Ort LIKE '%"
						+ cdf.getOrtTextField().getText() + "%' AND Telefon LIKE '%"
						+ cdf.getTelefonTextField().getText() + "%' AND EMail LIKE '%"
						+ cdf.getMailTextField().getText() + "%' AND ((to_days(now()) - to_days(GebDat)) / 365) <= '"
						+ ageToFieldInt + "'";

			} else {
				sql = "SELECT * FROM Kunden WHERE Name LIKE '%" + cdf.getNameTextField().getText()
						+ "%' AND Vorname LIKE '%" + cdf.getVornameTextField().getText() + "%' AND Strasse LIKE '%"
						+ cdf.getStrasseTextField().getText() + "%' AND PLZ LIKE '"
						+ cdf.getPlzTextField().getText() + "%' AND Land LIKE '%" + cdf.getLandTextField().getText()
						+ "%' AND Ort LIKE '%" + cdf.getOrtTextField().getText() + "%' AND Telefon LIKE '%"
						+ cdf.getTelefonTextField().getText() + "%' AND EMail LIKE '%"
						+ cdf.getMailTextField().getText()
						+ "%' AND ((to_days(now()) - to_days(GebDat)) / 365) >='" + ageFromFieldInt
						+ "' AND ((to_days(now()) - to_days(GebDat)) / 365) <= '" + ageToFieldInt + "'";
			}

			cdf.getCustomerTable().setModel(DbFunctions.getFilteredCustomers(sql));
			cdf.getCustomerTable().repaint();
			break;
		case "Kunde anlegen":
			CustomerEntryFrame.getInstance();
			break;
		case "Bearbeiten":
			if (cdf.getCustomerTable().getSelectedRow() != -1) {
				Integer kundenNummer = (Integer) cdf.getCustomerTable()
						.getValueAt(cdf.getCustomerTable().getSelectedRow(), 0);
				CustomerEntryFrame.getInstanceWithCustomer(DbFunctions.getKunde(kundenNummer));
			} else {
				JOptionPane.showMessageDialog(null, "Bitte wählen Sie zuerst einen Kunden aus!");
			}
			break;

		}
	}
}
