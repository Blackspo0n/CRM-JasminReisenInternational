package crm.JasminReisen.GUI;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import crm.JasminReisen.Config;


public class ContactDescriptionFrame extends JFrame {
	
	String description;
	
	public ContactDescriptionFrame() {
		
		this.setSize(600,400);
		this.setLayout(new BorderLayout());
		this.setTitle("Kontakthistorien Beschreibung");
		
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(1,4,10,10));
		this.add(gridPanel, BorderLayout.NORTH);
		
		JLabel descriptionLabel = new JLabel("Beschreibung:");
		descriptionLabel.setFont(Config.getFONT());
		descriptionLabel.setBackground(Config.getBACKGROUND());
		gridPanel.add(descriptionLabel);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBackground(Config.getBACKGROUND());
		this.add(centerPanel, BorderLayout.CENTER);
		
		JTextArea areaPanel = new JTextArea();
		areaPanel.setEditable(false);
		areaPanel.setFont(Config.getFONT_TEXTFIELD());
		centerPanel.add(areaPanel, BorderLayout.CENTER);
		
		
		this.setVisible(true);
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
