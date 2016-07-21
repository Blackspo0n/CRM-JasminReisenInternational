package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import org.jdatepicker.impl.JDatePanelImpl;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.GUI.CoreDataFrame;
import crm.JasminReisen.GUI.CustomerEntryFrame;
import crm.JasminReisen.GUI.TripEntryFrame;
import crm.JasminReisen.models.Reise;

public class CoreDataTripListener implements ActionListener {

	CoreDataFrame cdf;
	String sql;
	String bla;

	public CoreDataTripListener(CoreDataFrame cdf) {
		this.cdf = cdf;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		switch (event.getActionCommand()) {
		case "Zurücksetzen":
			cdf.getTripPastCheckbox().setSelected(false);
			cdf.getTripNameField().setText("");
			cdf.getTripDestinatonField().setText("");
			cdf.getTripRegionField().setText("");
			cdf.getTripHotelField().setText("");
			cdf.getTripPriceFromField().setText("");
			cdf.getTripPriceToField().setText("");
			cdf.getTripQuotaField().setText("");
			cdf.getClimatesBox().setSelectedIndex(0);
			cdf.getVehicleBox().setSelectedIndex(0);
			cdf.getModel().setDate(2016, 7, 22);
			cdf.getModelTripStart().setDate(2016, 7, 22);
			cdf.getModelTripEnd().setDate(2016, 7, 22);
			break;

		case "Suchen":
			sql = "SELECT * FROM Reisen AS r "
					+ "LEFT JOIN Hotels AS h ON r.HotelID = h.HotelID "
					+ "LEFT JOIN Klima AS k ON r.KlimaID = k.KlimaID "
					+ "LEFT JOIN Themen AS th  ON r.ThemaID = th.ThemenID "
					+ "LEFT JOIN Transportmittel AS t ON r.TransportmittelID = t.TransportmittelID "
					+ "LEFT JOIN Regionen AS re ON r.RegionID = re.RegionenID WHERE 1 = 1 /*keine lust auf komplizierte überprüfung der where */ ";
					
			if (! cdf.getTripNameField().getText().equals(""))	
				sql += " AND r.Name LIKE '%" + cdf.getTripNameField().getText() + "%'";
			if (! cdf.getTripDestinatonField().getText().equals(""))	
				sql += " AND r.Zielort LIKE '%" + cdf.getTripDestinatonField().getText() + "%'";
			if (! cdf.getTripRegionField().getText().equals(""))	
				sql += " AND r.RegionenName LIKE '%" + cdf.getTripRegionField().getText() + "%'";
			if (! cdf.getTripHotelField().getText().equals(""))	
				sql += " AND r.HotelName LIKE '%" + cdf.getTripHotelField().getText() + "%'";
			if (cdf.getClimatesBox().getSelectedIndex() != 0)	
				sql += " AND r.KlimaID = " + cdf.getClimatesBox().getSelectedIndex();
			if (cdf.getVehicleBox().getSelectedIndex() != 0)	
				sql += " AND r.TransportmittelID = " +cdf.getVehicleBox().getSelectedIndex();
			if (! cdf.getTripQuotaField().getText().equals(""))	
				sql += " AND r.Kontingent >= " + Integer.valueOf(cdf.getTripQuotaField().getText());
			if (cdf.getDatePickerTripStart().getModel().getValue() != null)
				sql += " AND r.Reisebeginn > '" + cdf.getDatePickerTripStart().getModel().getValue() + "'";
			if (cdf.getDatePickerTripEnd().getModel().getValue() != null)
				sql += " AND r.Reiseende < '" + cdf.getDatePickerTripStart().getModel().getValue() + "'";
			if (!cdf.getTripPriceFromField().getText().equals(""))
				sql += " AND r.Preis >= " + Double.valueOf(cdf.getTripPriceFromField().getText());
			if (!cdf.getTripPriceToField().getText().equals(""))
				sql += " AND r.Preis <= " + Double.valueOf(cdf.getTripPriceToField().getText());
			
			System.out.println(sql);
			cdf.getTripTable().setModel(DbFunctions.getFilteredTrips(sql));
			cdf.getTripTable().repaint();
			break;
		case "Reise anlegen":
			System.out.println("rzegs");
			TripEntryFrame.getInstance();
			break;
		case "Bearbeiten":
			if (cdf.getTripTable().getSelectedRow() != -1) {
				
				Integer ReiseId = (Integer) cdf.getTripTable().getValueAt(cdf.getTripTable().getSelectedRow(), 0);
				TripEntryFrame.getInstanceWithTrip(DbFunctions.getReise(ReiseId));
			} else {
				JOptionPane.showMessageDialog(null, "Bitte wählen Sie zuerst eine Reise aus!");
			}
			break;
		}

	}

}
