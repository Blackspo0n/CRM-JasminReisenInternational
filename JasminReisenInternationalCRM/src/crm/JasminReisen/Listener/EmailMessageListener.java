package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.Functions.EmailFunctions;
import crm.JasminReisen.GUI.BirthdayMessageFrame;
import crm.JasminReisen.GUI.CoreDataFrame;
import crm.JasminReisen.GUI.EmailMessageFrame;

public class EmailMessageListener implements ActionListener {

	EmailMessageFrame emf;

	public EmailMessageListener(EmailMessageFrame emf) {
		this.emf = emf;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "Versenden":
			EmailFunctions.sendMultiPartMail(
					emf.getMail(), emf.getSubject(), emf.getSalutation().getSelectedItem() + " " + emf.getNameField().getText() + ",\n\n" + emf.getAreaMessage().getText(), false);
		    
			JOptionPane.showMessageDialog(null, "E-Mail versendet", "Bestätigung",
		            JOptionPane.INFORMATION_MESSAGE);		   
			emf.dispose();
			break;
		case "Abbrechen":
			emf.dispose();
			break;

		}
	}

}
