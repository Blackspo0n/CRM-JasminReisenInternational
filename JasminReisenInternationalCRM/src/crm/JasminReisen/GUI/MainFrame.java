package crm.JasminReisen.GUI;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import crm.JasminReisen.Config;
import crm.JasminReisen.Listener.MainFrameListener;

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
		JMenu loginMenu = new JMenu("Start");
		menuBar.add(loginMenu);
		
		JMenu coreDataMenu = new JMenu("Stammdaten");
		menuBar.add(coreDataMenu);
		
		// Menü Items Start
		JMenuItem loginItem = new JMenuItem("Anmelden");
		JMenuItem logoutItem = new JMenuItem("Abmelden");
		JMenuItem closeItem = new JMenuItem("Beenden");
		
		loginMenu.add(loginItem);
		loginMenu.add(logoutItem);
		loginMenu.addSeparator();
		loginMenu.add(closeItem);
		
		// Menü Items Stammdaten
		JMenuItem coreDataItem = new JMenuItem("Stammdaten Pflege");
		JMenuItem coreDataAnalyseItem = new JMenuItem("Stammdaten Auswertung");
		
		coreDataMenu.add(coreDataItem);
		coreDataMenu.add(coreDataAnalyseItem);
		
		
		this.setVisible(true);
		
		
	}

}
