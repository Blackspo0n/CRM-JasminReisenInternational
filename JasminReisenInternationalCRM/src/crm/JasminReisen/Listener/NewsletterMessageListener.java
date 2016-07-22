package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.Functions.EmailFunctions;
import crm.JasminReisen.GUI.BirthdayMessageFrame;
import crm.JasminReisen.GUI.NewsletterMessageFrame;

public class NewsletterMessageListener implements ActionListener {

	NewsletterMessageFrame nmf;

	public NewsletterMessageListener(NewsletterMessageFrame nmf) {
		this.nmf = nmf;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "Versenden":
			
			DbFunctions.sendNewsletter(nmf);
		    JOptionPane.showMessageDialog(null, "Newsletter versendet", "Bestätigung",
		            JOptionPane.INFORMATION_MESSAGE);		   
			nmf.dispose();
			break;
		case "Abbrechen":
			nmf.dispose();
			break;

		}
	}

	public NewsletterMessageFrame getNmf() {
		return nmf;
	}

	public void setNmf(NewsletterMessageFrame nmf) {
		this.nmf = nmf;
	}
	
	

}
