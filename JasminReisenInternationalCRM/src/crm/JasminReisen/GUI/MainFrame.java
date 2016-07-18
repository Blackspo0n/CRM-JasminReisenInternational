package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import crm.JasminReisen.Config;
import crm.JasminReisen.Listener.MainFrameListener;

public class MainFrame extends JFrame {
	
	public MainFrame () {
		
		this.setSize(800, 600);
        Dimension windowSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width/2 - windowSize.width/2, screenSize.height/2 - windowSize.height/2);
		this.setResizable(false);
		this.setBackground(Config.getBACKGROUND());
		this.setLayout(new BorderLayout());
		
		//Panels
		JPanel westPanel = new JPanel();
		westPanel.setSize(200, 600);
		this.add(westPanel, BorderLayout.WEST);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setSize(200,600);
		this.add(eastPanel, BorderLayout.EAST);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(4,1,5,5));
		this.add(centerPanel, BorderLayout.CENTER);
		
		//Label
		JLabel averageCustomerEffort = new JLabel("Durchschnittlicher Kundenaufwand pro Tag");
		centerPanel.add(averageCustomerEffort);
		
		//JTextField
		JTextField averageCustomerEffortField = new JTextField();
		averageCustomerEffortField.setEditable(false);
		centerPanel.add(averageCustomerEffortField);
		
		//Label
		JLabel averageTripDays = new JLabel("Durchschnittliche Reisetage");
		centerPanel.add(averageTripDays);
		
		//JTextField
		JTextField averageTripDaysField = new JTextField();
		averageTripDaysField.setEditable(false);
		centerPanel.add(averageTripDaysField);
		
		//Menü Leiste
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(Config.getFONT());
		setJMenuBar(menuBar);
		
		// Menü Reiter
		JMenu loginMenu = new JMenu("Start");
		loginMenu.setFont(Config.getFONT());
		menuBar.add(loginMenu);
		
		JMenu coreDataMenu = new JMenu("Stammdaten");
		coreDataMenu.setFont(Config.getFONT());
		menuBar.add(coreDataMenu);
		
		// Menü Items Start
		JMenuItem loginItem = new JMenuItem("Anmelden");
		loginItem.setFont(Config.getFONT());
		JMenuItem logoutItem = new JMenuItem("Abmelden");
		logoutItem.setFont(Config.getFONT());
		JMenuItem closeItem = new JMenuItem("Beenden");
		closeItem.setFont(Config.getFONT());
		
		loginMenu.add(loginItem);
		loginMenu.add(logoutItem);
		loginMenu.addSeparator();
		loginMenu.add(closeItem);
		
		// Menü Items Stammdaten
		JMenuItem coreDataItem = new JMenuItem("Stammdaten Pflege");
		coreDataItem.setFont(Config.getFONT());
		JMenuItem coreDataAnalyseItem = new JMenuItem("Stammdaten Auswertung");
		coreDataAnalyseItem.setFont(Config.getFONT());
		
		// Menü Action Listener
		loginItem.addActionListener(new MainFrameListener(this));
		logoutItem.addActionListener(new MainFrameListener(this));
		closeItem.addActionListener(new MainFrameListener(this));
		
		coreDataMenu.add(coreDataItem);
		coreDataMenu.add(coreDataAnalyseItem);
		
		
		this.setVisible(true);
		
		
	}

}
