package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.GUI.ContactDescriptionFrame;
import crm.JasminReisen.GUI.ContactHistoryFrame;
import crm.JasminReisen.GUI.TripEntryFrame;
import crm.JasminReisen.GUI.TripInfoFrame;
import crm.JasminReisen.models.HistoryReise;

public class ContactHistoryFrameListener implements ActionListener {

	ContactHistoryFrame chf;

	public ContactHistoryFrameListener(ContactHistoryFrame chf) {
		this.chf = chf;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getActionCommand()) {
		case "Öffnen":
			if (chf.getHistoryTable().getSelectedRow() != -1) {
				
				String giveAwayReise = "";
				
				String theme = (String) chf.getHistoryTable().getValueAt(chf.getHistoryTable().getSelectedRow(), 2);
				
				for (String description :DbFunctions.getListDescriptions()) {
					if (description.substring(7, description.indexOf("Beschreibung:")).equals(theme)) {
						giveAwayReise = description;
					}
				}
				new ContactDescriptionFrame(giveAwayReise);
			} else if (chf.getHistoryTripTable().getSelectedRow() != -1) {
				HistoryReise giveAwayReise = new HistoryReise();
				ArrayList<HistoryReise> hr = chf.getReiseList();
				Date reiseBeginn = (Date) chf.getHistoryTripTable().getValueAt(chf.getHistoryTripTable().getSelectedRow(), 0);
				String reiseZielort = (String) chf.getHistoryTripTable().getValueAt(chf.getHistoryTripTable().getSelectedRow(), 1);
				String reiseHotel = (String) chf.getHistoryTripTable().getValueAt(chf.getHistoryTripTable().getSelectedRow(), 2);
				System.out.println(reiseBeginn + reiseZielort + reiseHotel);
				for (HistoryReise reise:hr) {
					if (reise.getHotel().equals(reiseHotel) && reise.getReiseBeginn().compareTo(reiseBeginn) == 0 && reise.getZielOrt().equals(reiseZielort)) {
						giveAwayReise = reise;
					}
				}
				new TripInfoFrame(giveAwayReise);
			} else {
				JOptionPane.showMessageDialog(null, "Bitte wählen Sie zuerst eine Zeile aus!");
			}
			break;
		}
	}

}
