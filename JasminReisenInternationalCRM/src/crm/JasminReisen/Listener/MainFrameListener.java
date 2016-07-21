package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import crm.JasminReisen.GUI.CoreDataFrame;
import crm.JasminReisen.GUI.CustomerEntryFrame;
import crm.JasminReisen.GUI.LoginFrame;
import crm.JasminReisen.GUI.MainFrame;
import crm.JasminReisen.GUI.SpecEntryFrame;
import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.GUI.BirthdayMessageFrame;

public class MainFrameListener implements ActionListener {

	MainFrame mainFrame;
	SpecEntryFrame sef;

	public MainFrameListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		switch (event.getActionCommand()) {
		case "Beenden":
			System.exit(0);
			break;
		case "Anmelden":
			new LoginFrame(mainFrame); // nur als Test und bis anmelden fertig
										// ist
			break;
		case "Abmelden":
			mainFrame.dispose();
			new MainFrame(); // nur als Test und bis anmelden fertig ist
			break;
		case "Stammdatenpflege":
			new CoreDataFrame();
			break;
		case "Spezifikationen Hinzufügen":
			sef = new SpecEntryFrame();
			break;
		case "Rabattcode versenden":
			if (mainFrame.getBirthdayTable().getSelectedRow() != -1) {
				Integer kundenNummer = (Integer) mainFrame.getBirthdayTable()
						.getValueAt(mainFrame.getBirthdayTable().getSelectedRow(), 0);
				String kundenName = (String) mainFrame.getBirthdayTable().getValueAt(mainFrame.getBirthdayTable().getSelectedRow(), 1);
				String kundenMail = (String) mainFrame.getBirthdayTable().getValueAt(mainFrame.getBirthdayTable().getSelectedRow(), 4);
				Integer age = (Integer) mainFrame.getBirthdayTable().getValueAt(mainFrame.getBirthdayTable().getSelectedRow(), 3);
				new BirthdayMessageFrame(kundenNummer, kundenName, kundenMail, age);	
			} 

		}
	}
}
