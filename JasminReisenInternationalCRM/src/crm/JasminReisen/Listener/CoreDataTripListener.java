package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import org.jdatepicker.impl.JDatePanelImpl;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.GUI.CoreDataFrame;

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
			sql = "SELECT k.KlimaBeschreibung, r.*, t.* "
					+ "FROM Klima AS k, Reisen AS r, Transportmittel as t "
					+ "WHERE k.KlimaID = r.KlimaID AND t.TransportmittelID = r.TransportmittelID";
					
			if (! cdf.getTripNameField().getText().equals(""))	
				sql += " AND r.Name LIKE '%" + cdf.getTripNameField().getText() + "%'";
			if (! cdf.getTripDestinatonField().getText().equals(""))	
				sql += " AND r.Zielort LIKE '%" + cdf.getTripDestinatonField().getText() + "%'";
			if (! cdf.getTripRegionField().getText().equals(""))	
				sql += " AND r.Region LIKE '%" + cdf.getTripRegionField().getText() + "%'";
			if (! cdf.getTripHotelField().getText().equals(""))	
				sql += " AND r.Hotel LIKE '%" + cdf.getTripHotelField().getText() + "%'";
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
			//cdf.getCustomerTable().setModel(DbFunctions.getFilteredCustomers(sql));
			//cdf.getCustomerTable().repaint();
			break;
		}

	}

}
