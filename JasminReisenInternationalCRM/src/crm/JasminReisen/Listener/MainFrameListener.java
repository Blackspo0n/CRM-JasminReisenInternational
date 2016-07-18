package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import crm.JasminReisen.GUI.CoreDataFrame;
import crm.JasminReisen.GUI.LoginFrame;
import crm.JasminReisen.GUI.MainFrame;

public class MainFrameListener implements ActionListener {

	MainFrame mf;

	public MainFrameListener(MainFrame mf) {
		this.mf = mf;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		switch (event.getActionCommand()) {
		case "Beenden":
			System.exit(0);
			break;
		case "Anmelden":
			new LoginFrame(mf); // nur als Test und bis anmelden fertig ist
			break;
		case "Abmelden":
			mf.dispose();
			new MainFrame(); // nur als Test und bis anmelden fertig ist
			break;
		case "Stammdatenpflege":
			new CoreDataFrame();
			break;
		}

	}

}
