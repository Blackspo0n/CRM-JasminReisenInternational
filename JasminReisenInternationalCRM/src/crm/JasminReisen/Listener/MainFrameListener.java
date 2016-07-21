package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import crm.JasminReisen.GUI.CoreDataFrame;
import crm.JasminReisen.GUI.LoginFrame;
import crm.JasminReisen.GUI.MainFrame;
import crm.JasminReisen.GUI.SpecEntryFrame;

public class MainFrameListener implements ActionListener {

	MainFrame mainFrame;
	SpecEntryFrame sef;

	public MainFrameListener(MainFrame mf) {
		this.mainFrame = mf;
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
			int reply = JOptionPane.showConfirmDialog(null, "Möchten Sie den Rabattcode wirklich versenden?", "Achtung", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Rabattcode versendet!");
				
			} 
		}
	}
}
