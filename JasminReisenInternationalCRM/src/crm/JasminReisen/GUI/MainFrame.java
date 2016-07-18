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
		
		
		//Men� Leiste
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(Config.getFONT());
		setJMenuBar(menuBar);
		
		// Men� Reiter
		JMenu customerMenu = new JMenu("Kunden");
		menuBar.add(customerMenu);
		
		JMenu tripMenu = new JMenu("Reisen");
		menuBar.add(tripMenu);
		
		// Men� Items f�r Kunden		
		JMenuItem customerCoreData = new JMenuItem("Kunden Stammdaten");
		customerMenu.add(customerCoreData);
		
		// Men� Items f�r Reisen
		JMenuItem tripCoreData = new JMenuItem("Reisen Stammdaten");
		tripMenu.add(tripCoreData);
		
		
		
		this.setVisible(true);
		
		
	}

}
