package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.GUI.CreateCustomerContactFrame;
import crm.JasminReisen.models.Kunde;

public class CreateCustomerContactListener implements ActionListener {

	CreateCustomerContactFrame cccf;

	public CreateCustomerContactListener(CreateCustomerContactFrame cccf) {
		this.cccf = cccf;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		switch (event.getActionCommand()) {

		case "Combo":

			Kunde kunde = new Kunde();
			kunde = (Kunde) cccf.getCustomerBox().getSelectedItem();
			cccf.getCustomerIdField().setText("" + kunde.getKundennummer() + "");
			break;

		case "Field":

			cccf.getCustomerBox().setActionCommand("temp");
			int i = -1;
			boolean notFound = false;
			Integer custId = Integer.parseInt(cccf.getCustomerIdField().getText());

			do {
				i++;
				try {
					cccf.getCustomerBox().setSelectedIndex(i);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Die ID konnte keinem Kunden zugewiesen werden.");
					notFound = true;
				}
			} while (((Kunde) cccf.getCustomerBox().getSelectedItem()).getKundennummer() != custId
					&& notFound == false);

			cccf.getCustomerBox().setActionCommand("Combo");
			break;

		case "Abbrechen":
			cccf.dispose();
			break;

		case "Speichern":
			String review;

			review = (cccf.getDatePicker().getJFormattedTextField().getText());
			Integer custId2 = Integer.parseInt(cccf.getCustomerIdField().getText());
			int actionId = cccf.getActionBox().getSelectedIndex() + 1;

			DbFunctions.saveContactData(custId2, actionId, review);

			cccf.dispose();
			break;

		}

	}
}
