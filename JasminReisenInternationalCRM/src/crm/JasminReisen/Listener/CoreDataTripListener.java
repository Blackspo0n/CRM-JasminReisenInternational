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
			cdf.getCustomerTable().setModel(DbFunctions.getFilteredCustomers(sql));
			cdf.getCustomerTable().repaint();
			break;
		}

	}

}
