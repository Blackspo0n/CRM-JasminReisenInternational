package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import crm.JasminReisen.Config;
import crm.JasminReisen.Listener.MainFrameListener;

public class MainFrame extends JFrame {

	public MainFrame() {

		this.setSize(1200, 800);
		this.setTitle("Jasmin Reisen International - Customer Relationship Management");
		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width / 2 - windowSize.width / 2, screenSize.height / 2 - windowSize.height / 2);
		this.setResizable(false);
		this.setBackground(Config.getBACKGROUND());
		this.setLayout(new BorderLayout());

		// Panels
		JPanel westPanel = new JPanel();
		westPanel.setSize(200, 600);
		this.add(westPanel, BorderLayout.WEST);

		// Images
		try {
			BufferedImage imageLeft = ImageIO.read(new File("images/links2.jpg"));
			BufferedImage imageRight = ImageIO.read(new File("images/rechts2.jpg"));
			BufferedImage imageTop = ImageIO.read(new File("images/jasmin2.png"));
			
			JPanel northPanel = new JPanel();
			this.add(northPanel, BorderLayout.NORTH);
			
			// westPanel Label for image
			JLabel imageWest = new JLabel(new ImageIcon(imageLeft));
			westPanel.add(imageWest);
			westPanel.setBackground(Config.getBACKGROUND());

			JPanel eastPanel = new JPanel();
			eastPanel.setSize(200, 600);
			eastPanel.setBackground(Config.getBACKGROUND());
			
			
			JLabel imageNorth = new JLabel(new ImageIcon(imageTop));
			northPanel.add(imageNorth);

			this.add(eastPanel, BorderLayout.EAST);

			// eastPanel Label for image
			JLabel imageEast = new JLabel(new ImageIcon(imageRight));
			eastPanel.add(imageEast);
		} catch (IOException e) {
			e.printStackTrace();
		}

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(8, 1, 30, 15));
		centerPanel.setBackground(Config.getBACKGROUND());
		this.add(centerPanel, BorderLayout.CENTER);

		JPanel firstPanel = new JPanel();
		firstPanel.setBackground(Config.getBACKGROUND());
		centerPanel.add(firstPanel);

		JPanel lastPanel = new JPanel();
		lastPanel.setBackground(Config.getBACKGROUND());

		// Label

		JLabel averageCustomerEffort = new JLabel("Durchschnittlicher Kundenaufwand pro Tag", SwingConstants.CENTER);
		averageCustomerEffort.setFont(Config.getFONT());
		centerPanel.add(averageCustomerEffort);

		// JTextField
		JTextField averageCustomerEffortField = new JTextField();
		averageCustomerEffortField.setFont(Config.getFONT());
		averageCustomerEffortField.setHorizontalAlignment(JLabel.CENTER);
		averageCustomerEffortField.setText("213" + " Euro");
		averageCustomerEffortField.setEditable(false);
		averageCustomerEffortField.setBackground(Config.getBACKGROUND());
		centerPanel.add(averageCustomerEffortField);

		// Label
		JLabel averageTripDays = new JLabel("Durchschnittliche Reisetage", SwingConstants.CENTER);
		averageTripDays.setFont(Config.getFONT());
		centerPanel.add(averageTripDays);

		// JTextField
		JTextField averageTripDaysField = new JTextField();
		averageTripDaysField.setFont(Config.getFONT());
		averageTripDaysField.setHorizontalAlignment(JLabel.CENTER);
		averageTripDaysField.setText("4.5" + " Tage");
		averageTripDaysField.setEditable(false);
		averageTripDaysField.setBackground(Config.getBACKGROUND());
		centerPanel.add(averageTripDaysField);

		// Label
		JLabel averageHotelStars = new JLabel("Durchschnittliche Hotelsterne", SwingConstants.CENTER);
		averageHotelStars.setFont(Config.getFONT());
		centerPanel.add(averageHotelStars);

		// JTextField
		JTextField averageHotelStarsField = new JTextField();
		averageHotelStarsField.setFont(Config.getFONT());
		averageHotelStarsField.setHorizontalAlignment(JLabel.CENTER);
		averageHotelStarsField.setText("4" + " Sterne");
		averageHotelStarsField.setEditable(false);
		averageHotelStarsField.setBackground(Config.getBACKGROUND());
		centerPanel.add(averageHotelStarsField);

		// Men� Leiste
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(Config.getFONT());
		setJMenuBar(menuBar);

		// Men� Reiter
		JMenu loginMenu = new JMenu("Start");
		loginMenu.setFont(Config.getFONT());
		menuBar.add(loginMenu);

		JMenu coreDataMenu = new JMenu("Stammdaten");
		coreDataMenu.setFont(Config.getFONT());
		menuBar.add(coreDataMenu);

		// Men� Items Start
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

		// Men� Items Stammdaten
		JMenuItem coreDataItem = new JMenuItem("Stammdatenpflege");
		coreDataItem.setFont(Config.getFONT());
		coreDataItem.addActionListener(new MainFrameListener(this));
		JMenuItem coreDataAnalyseItem = new JMenuItem("Stammdaten Auswertung");
		coreDataAnalyseItem.setFont(Config.getFONT());

		// Men� Action Listener
		loginItem.addActionListener(new MainFrameListener(this));
		logoutItem.addActionListener(new MainFrameListener(this));
		closeItem.addActionListener(new MainFrameListener(this));

		coreDataMenu.add(coreDataItem);
		coreDataMenu.add(coreDataAnalyseItem);

		centerPanel.add(lastPanel);

		this.setVisible(true);

	}

}
