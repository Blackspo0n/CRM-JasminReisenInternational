package crm.JasminReisen.GUI;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import crm.JasminReisen.Config;

public class MainFrame extends JFrame {
	
	public MainFrame () {
		
		this.setSize(800, 600);
		this.setLayout(new GridLayout(4,2,0,0));
		this.setBackground(Config.getBACKGROUND());
		
		
		//Menü Leiste
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(Config.getFONT());
		setJMenuBar(menuBar);
		
		// Menü Reiter
		JMenu customerMenu = new JMenu("Kunden");
		menuBar.add(customerMenu);
		
		JMenu tripMenu = new JMenu("Reisen");
		menuBar.add(tripMenu);
		
		// Menü Items für Kunden		
		JMenuItem customerCoreData = new JMenuItem("Kunden Stammdaten");
		customerMenu.add(customerCoreData);
		
		// Menü Items für Reisen
		JMenuItem tripCoreData = new JMenuItem("Reisen Stammdaten");
		tripMenu.add(tripCoreData);
		
		
		
		this.setVisible(true);
		
		
	}

}
