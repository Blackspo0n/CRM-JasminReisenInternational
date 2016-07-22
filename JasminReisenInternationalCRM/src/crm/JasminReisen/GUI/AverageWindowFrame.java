package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.format.TextStyle;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import crm.JasminReisen.Config;
import crm.JasminReisen.Functions.DbFunctions;

public class AverageWindowFrame extends JDialog {
	
	
	public AverageWindowFrame() {

		setLayout(new BorderLayout());
		setSize(600, 250);
		setLocationRelativeTo(null);
		setTitle("Durchschnittsauswertung");
		setResizable(false);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Config.getBACKGROUND());
		centerPanel.setLayout(new GridLayout(0, 2, 10, 30));
		centerPanel.setBorder(new EmptyBorder(10,10,10,10));
		
		JLabel avgAgeLabel = new JLabel("Durchschnittliches Alter:");
		avgAgeLabel.setFont(Config.getFONT());
		JTextField txtavgAge = new JTextField();
		txtavgAge.setFont(Config.getFONT());
		txtavgAge.setEditable(false);
		
		JLabel avgTimespanLabel = new JLabel("Durchschnittliche Reisedauer:");
		avgTimespanLabel.setFont(Config.getFONT());
		JTextField txtavgTimespan = new JTextField();
		txtavgTimespan.setFont(Config.getFONT());
		
		txtavgTimespan.setEditable(false);
		
		JLabel avgCostPerDayLabel = new JLabel("Durchschnittliche Kosten Pro Tag:");
		avgCostPerDayLabel.setFont(Config.getFONT());
		JTextField txtavgCostPerDay = new JTextField();
		txtavgCostPerDay.setFont(Config.getFONT());
		txtavgCostPerDay.setEditable(false);

		centerPanel.add(avgAgeLabel);
		centerPanel.add(txtavgAge);
		centerPanel.add(avgTimespanLabel);
		centerPanel.add(txtavgTimespan);
		centerPanel.add(avgCostPerDayLabel);
		centerPanel.add(txtavgCostPerDay);
		add(centerPanel);
		
		ArrayList<Object> tmp = DbFunctions.getAverageData();
		txtavgAge.setText((String)tmp.get(0) + " Jahre");
		txtavgTimespan.setText((String)tmp.get(1) + " Tage");
		txtavgCostPerDay.setText((String)tmp.get(2) + " €/Tag");
		
		setVisible(true);
	}
}
