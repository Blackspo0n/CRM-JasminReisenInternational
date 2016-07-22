package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import crm.JasminReisen.Config;
import crm.JasminReisen.models.HistoryReise;

public class TripInfoFrame extends JFrame {
	
	public TripInfoFrame(HistoryReise reise) {
		
		this.setTitle("Reise Daten");
		this.setSize(1000,200);
		this.setLayout(new BorderLayout());
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3,4,10,10));
		mainPanel.setBackground(Config.getBACKGROUND());
		mainPanel.setBorder(new EmptyBorder(20,20,20,20));
		this.add(mainPanel, BorderLayout.CENTER);
		
		JLabel tripName = new JLabel("Reisename");
		tripName.setFont(Config.getFONT());
		mainPanel.add(tripName);
		
		JTextField tripNameField = new JTextField(reise.getReiseName());
		tripNameField.setFont(Config.getFONT());
		tripNameField.setEditable(false);
		mainPanel.add(tripNameField);	
		
		JLabel tripDestination = new JLabel("Zielort");
		tripDestination.setFont(Config.getFONT());
		mainPanel.add(tripDestination);
		
		JTextField tripDestinationField = new JTextField(reise.getZielOrt());
		tripDestinationField.setFont(Config.getFONT());
		tripDestinationField.setEditable(false);
		mainPanel.add(tripDestinationField);
		
		JLabel hotelName = new JLabel("Hotelname");
		hotelName.setFont(Config.getFONT());
		mainPanel.add(hotelName);
		
		JTextField hotelNameField = new JTextField(reise.getHotel());
		hotelNameField.setFont(Config.getFONT());
		hotelNameField.setEditable(false);
		mainPanel.add(hotelNameField);	
		
		JLabel tripPrice = new JLabel("Preis");
		tripPrice.setFont(Config.getFONT());
		mainPanel.add(tripPrice);
		
		JTextField priceField = new JTextField("" + reise.getPreis() + " Euro");
		priceField.setFont(Config.getFONT());
		priceField.setEditable(false);
		mainPanel.add(priceField);
		
		JLabel tripStartName = new JLabel("Reisebeginn");
		tripStartName.setFont(Config.getFONT());
		mainPanel.add(tripStartName);
		
		System.out.println(reise.getReiseBeginn());
		String temp1 = new SimpleDateFormat("dd.MM.yyyy").format(reise.getReiseBeginn());
		
		JTextField tripStartField = new JTextField(temp1);
		tripStartField.setFont(Config.getFONT());
		tripStartField.setEditable(false);
		mainPanel.add(tripStartField);
		
		JLabel tripEndName = new JLabel("Reiseende");
		tripEndName.setFont(Config.getFONT());
		mainPanel.add(tripEndName);
		
		String temp2 = new SimpleDateFormat("dd.MM.yyyy").format(reise.getReiseEnde());
		
		JTextField tripEndField = new JTextField(temp2);
		tripEndField.setFont(Config.getFONT());
		tripEndField.setEditable(false);
		mainPanel.add(tripEndField);
		
		this.setVisible(true);
		
	}
	
}
