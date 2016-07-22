package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AverageWindowFrame extends JDialog {
	
	public static void main(String[] args) {
		new AverageWindowFrame();
	}
	
	public AverageWindowFrame() {

		setLayout(new BorderLayout());
		setSize(400, 250);
		setLocationRelativeTo(null);
		setTitle("Durchschnittsauswertung");
		setResizable(false);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0, 2, 10, 30));
		centerPanel.setBorder(new EmptyBorder(10,10,10,10));
		
		JLabel avgAgeLabel = new JLabel("Durchschnittliches Alter:");
		JTextField txtavgAge = new JTextField();
		txtavgAge.setEditable(false);
		
		JLabel avgTimespanLabel = new JLabel("Durchschnittliches Reisedauer:");
		JTextField txtavgTimespan = new JTextField();
		txtavgTimespan.setEditable(false);
		
		JLabel avgCostPerDayLabel = new JLabel("Durchschnittliche Kosten Pro Tag");
		JTextField txtavgCostPerDay = new JTextField();
		txtavgCostPerDay.setEditable(false);

		centerPanel.add(avgAgeLabel);
		centerPanel.add(txtavgAge);
		centerPanel.add(avgTimespanLabel);
		centerPanel.add(txtavgTimespan);
		centerPanel.add(avgCostPerDayLabel);
		centerPanel.add(txtavgCostPerDay);
		add(centerPanel);
		
		setVisible(true);
	}
}
