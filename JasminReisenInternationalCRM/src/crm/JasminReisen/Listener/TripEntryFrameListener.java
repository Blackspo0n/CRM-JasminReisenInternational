package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.GUI.CustomerEntryFrame;
import crm.JasminReisen.GUI.LoginFrame;
import crm.JasminReisen.GUI.TripEntryFrame;
import crm.JasminReisen.models.Reise;

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
			case "Anlegen":
				updateTripContext();
				
				try {
					DbFunctions.createTrip(this.tripentryframe.getTripContext());
					this.tripentryframe.dispose();
					new TripEntryFrame(new Reise());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Die Reise konnte nicht angelegt werden.");
				}
				break;

			case "Speichern":
				updateTripContext();
				
				try {
					DbFunctions.saveTrip(this.tripentryframe.getTripContext());
					this.tripentryframe.dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Die Reise konnte nicht gesspeichert werden.");
				}
				break;
			case "Abbrechen":
				this.tripentryframe.dispose();
				TripEntryFrame.setInstance(null);
				break;
						
		}
	}
	
	private void updateTripContext() {
		this.tripentryframe.getTripContext().setName(this.tripentryframe.getTripNameField().getText());
		this.tripentryframe.getTripContext().setBeschreibung(this.tripentryframe.getBeschreibungArea().getText());
		try {
			this.tripentryframe.getTripContext().setReiseBeginn(new SimpleDateFormat("yyyy-MM-dd").parse(this.tripentryframe.getStartDate().getJFormattedTextField().getText()));
			this.tripentryframe.getTripContext().setReiseEnde(new SimpleDateFormat("yyyy-MM-dd").parse(this.tripentryframe.getEndDate().getJFormattedTextField().getText()));
			this.tripentryframe.getTripContext().setVerfuegbarAb(new SimpleDateFormat("yyyy-MM-dd").parse(this.tripentryframe.getAvailableDate().getJFormattedTextField().getText()));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.tripentryframe.getTripContext().setGruppengroesse((this.tripentryframe.getGruppenGroesseField().getText().equals("") ? Integer.parseInt(this.tripentryframe.getGruppenGroesseField().getText()) : 0));

		this.tripentryframe.getTripContext().setHotelID(this.tripentryframe.getHotelIdBox().getSelectedIndex());
		this.tripentryframe.getTripContext().setKlimaID(this.tripentryframe.getKlimaIdBox().getSelectedIndex());
		this.tripentryframe.getTripContext().setThemaID(this.tripentryframe.getThemaBox().getSelectedIndex());
		this.tripentryframe.getTripContext().setRegionID(this.tripentryframe.getRegionBox().getSelectedIndex());
		this.tripentryframe.getTripContext().setTransportmittelID(this.tripentryframe.getTransportmittelIdBox().getSelectedIndex());
		
		this.tripentryframe.getTripContext().setPreis(Double.parseDouble(this.tripentryframe.getPreisField().getText()));
		this.tripentryframe.getTripContext().setKontingent((this.tripentryframe.getKontigentField().getText().equals("") ? Integer.parseInt(this.tripentryframe.getKontigentField().getText()) : 0));
		this.tripentryframe.getTripContext().setVerfuegbarePlaetze((this.tripentryframe.getPlaetzeField().getText().equals("") ? Integer.parseInt(this.tripentryframe.getPlaetzeField().getText()) : 0));
		this.tripentryframe.getTripContext().setZielOrt(this.tripentryframe.getZielortField().getText());
	}
}