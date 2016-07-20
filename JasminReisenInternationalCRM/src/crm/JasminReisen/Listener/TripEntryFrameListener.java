package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.GUI.LoginFrame;
import crm.JasminReisen.GUI.TripEntryFrame;

public class TripEntryFrameListener implements ActionListener
{
	TripEntryFrame tripentryframe;
	
	public TripEntryFrameListener(TripEntryFrame tripentryframe)
	{
		this.tripentryframe = tripentryframe;
	}
	
	public void actionPerformed (ActionEvent event)
	{
		switch (event.getActionCommand()) 
		{
			case "Reise anlegen":
				DbFunctions.createTrip(tripentryframe);
		
			case "Zurücksetzen":
				tripentryframe.getTripNameField().setText("");
				tripentryframe.getZielortField().setText("");
				tripentryframe.getStartDate().getJFormattedTextField().setText("");
				tripentryframe.getEndDate().getJFormattedTextField().setText("");
				tripentryframe.getPlaetzeField().setText("");
				tripentryframe.getTransportmittelIdBox().setSelectedIndex(0);
				tripentryframe.getRegionBox().setSelectedIndex(0);
				tripentryframe.getThemaBox().setSelectedIndex(0);
				tripentryframe.getKlimaId().setText("");
				tripentryframe.getHotelIdBox().setSelectedIndex(0);
				tripentryframe.getPreisField().setText("");
				tripentryframe.getAvailableDate().getJFormattedTextField().setText("");
				tripentryframe.getBeschreibungArea().setText("");
				break;
						
		}
	}
}