package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import crm.JasminReisen.Functions.EmailFunctions;
import crm.JasminReisen.GUI.BirthdayMessageFrame;

public class BirthdayMessageListener implements ActionListener {

	BirthdayMessageFrame bmf;

	public BirthdayMessageListener(BirthdayMessageFrame bmf) {
		this.bmf = bmf;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "Versenden":
			EmailFunctions.sendMultiPartMail(
					bmf.getSalutation().getSelectedItem() + " " + bmf.getName() + ",\n" + bmf.getMail(),
					"Geburtstagsgrüße mit kleiner Aufmerksamkeit", bmf.getAreaMessage().getText(), true);

			break;
		case "Abbrechen":
			bmf.dispose();
			break;

		}
	}

}
