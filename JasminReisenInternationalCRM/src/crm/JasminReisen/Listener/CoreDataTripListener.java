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

			String priceStart = cdf.getTripPriceFromField().getText();
			String priceEnd = cdf.getTripPriceToField().getText();
			double priceEndDouble = 0;
			double priceStartDouble = 0;
			if (!priceStart.equals("")) {
				priceStartDouble = Double.parseDouble(priceStart);
				priceStart.replace(",", ".");
			}
			if (!priceEnd.equals("")) {
				priceEndDouble = Double.parseDouble(priceEnd);
				priceEnd.replace(",", ".");
			}
			sql = "SELECT k.KlimaBeschreibung, r.*, t.* FROM Klima AS k Reisen AS r Transportmittel as t WHERE r.Name LIKE '%"
					+ cdf.getTripNameField().getText() + "%' AND r.Zielort LIKE '%"
					+ cdf.getTripDestinatonField().getText() + "%' AND r.Reisebeginn > '"
					+ (Date) cdf.getDatePickerTripStart().getModel().getValue() + "' AND r.Reiseende < '"
					+ (Date) cdf.getDatePickerTripEnd().getModel().getValue() + "' AND r.Region LIKE '%"
					+ cdf.getTripRegionField().getText() + "%' AND r.Hotel LIKE '%" + cdf.getTripHotelField().getText()
					+ "%' AND r.Preis < '" + priceEndDouble + "' AND r.Preis > '" + priceStartDouble
					+ "' AND Kontingent LIKE '%" + cdf.getTripQuotaField().getText() + "%' AND r.KlimaID = '"
					+ cdf.getClimatesBox().getSelectedIndex() + "' AND r.KlimaID = k.KlimaID AND r.TransportID = '"
					+ cdf.getVehicleBox().getSelectedIndex() + "' AND r.TransportID = t.TransportID";
			System.out.println(sql);
			cdf.getCustomerTable().setModel(DbFunctions.getFilteredCustomers(sql));
			cdf.getCustomerTable().repaint();
			break;
		}

	}

}
