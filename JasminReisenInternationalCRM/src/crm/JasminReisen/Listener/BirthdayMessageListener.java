package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import crm.JasminReisen.Functions.DbFunctions;
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
					bmf.getMail(),"Geburtstagsgrüße mit kleiner Aufmerksamkeit", bmf.getSalutation().getSelectedItem() + " " + bmf.getNameField().getText() + ",\n\n" + bmf.getAreaMessage().getText(), true);
		    JOptionPane.showMessageDialog(null, "E-Mail versendet", "Bestätigung",
		            JOptionPane.INFORMATION_MESSAGE);
		    DbFunctions.safeVoucherCode(bmf.getKundenNummer(), bmf.getRabattCode());
			bmf.dispose();
			break;
		case "Abbrechen":
			bmf.dispose();
			break;

		}
	}

}
