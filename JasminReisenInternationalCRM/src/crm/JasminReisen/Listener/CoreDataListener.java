package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			sql = "SELECT * FROM Kunden WHERE Name LIKE '%" + cdf.getNameTextField().getText()
					+ "%' AND Vorname LIKE '%" + cdf.getVornameTextField().getText() + "%' AND Strasse LIKE '%"
					+ cdf.getStrasseTextField().getText() + "%' AND PLZ LIKE '" + cdf.getPlzTextField().getText()
					+ "%' AND Land LIKE '%" + cdf.getLandTextField().getText() + "%' AND Ort LIKE '%"
					+ cdf.getOrtTextField().getText() + "%' AND Telefon LIKE '%" + cdf.getTelefonTextField().getText()
					+ "%' AND EMail LIKE '%" + cdf.getMailTextField().getText() + "%'";
			cdf.getCustomerTable().setModel(DbFunctions.getFilteredCustomers(sql));
			cdf.getCustomerTable().repaint();
			break;
		case "Kunde Anlegen":
			CustomerEntryFrame.getInstance();
			break;
		case "Bearbeiten":
			Integer kundenNummer = (Integer) cdf.getCustomerTable().getValueAt(cdf.getCustomerTable().getSelectedRow(), 1);
			System.out.println(kundenNummer);
		}
	}

}
