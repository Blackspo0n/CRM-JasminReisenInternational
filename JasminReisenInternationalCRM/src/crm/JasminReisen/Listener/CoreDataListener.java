package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import crm.JasminReisen.GUI.CoreDataFrame;

public class CoreDataListener implements ActionListener {
	
	CoreDataFrame cdf;
	
	public CoreDataListener(CoreDataFrame cdf) {
		this.cdf = cdf;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "Zurücksetzen": 
			break;
		}

	}

}
