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
				tripentryframe.getReisebeginnField().setText("");
				tripentryframe.getReiseEndeField().setText("");
				tripentryframe.getPlaetzeField().setText("");
				tripentryframe.getTransportmittelIdField().setText("");
				tripentryframe.getRegionField().setText("");
				tripentryframe.getThemaField().setText("");
				tripentryframe.getHotelIdField().setText("");
				tripentryframe.getPreisField().setText("");
				tripentryframe.getBeschreibungArea().setText("");
				break;
						
		}
	}
}