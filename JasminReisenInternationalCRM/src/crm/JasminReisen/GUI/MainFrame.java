package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
import crm.JasminReisen.models.User;

public class MainFrame extends JFrame {

	private JPanel westPanel;
	private BufferedImage imageLeft;
	private BufferedImage imageRight;
	private BufferedImage imageTop;
	private JPanel northPanel;
	private JLabel imageWest;
	private JPanel eastPanel;
	private JLabel imageNorth;
	private JLabel imageEast;
	private JPanel centerPanel;
	private JPanel firstPanel;
	private JPanel lastPanel;
	private JLabel averageCustomerEffort;
	private JTextField averageCustomerEffortField;
	private JLabel averageTripDays;
	private JTextField averageTripDaysField;
	private JLabel averageHotelStars;
	private JTextField averageHotelStarsField;
	private JMenuBar menuBar;
	private JMenu loginMenu;
	private JMenu coreDataMenu;
	private JMenuItem loginItem;
	private JMenuItem logoutItem;
	private JMenuItem closeItem;
	private JMenuItem coreDataItem;
	private JMenuItem coreDataAnalyseItem;
	
	private User loggedUser;
	
	
	public MainFrame() {

		setSize(1200, 800);
		setTitle("Jasmin Reisen International - Customer Relationship Management");
		setResizable(false);
		setBackground(Config.getBACKGROUND());
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		westPanel = new JPanel();
		westPanel.setSize(200, 600);
		add(westPanel, BorderLayout.WEST);

		// Images
		try {

			imageLeft = ImageIO.read(new File("images/links2.jpg"));
			imageRight = ImageIO.read(new File("images/rechts2.jpg"));
			imageTop = ImageIO.read(new File("images/jasmin2.png"));
			
			northPanel = new JPanel();
			add(northPanel, BorderLayout.NORTH);
			
			imageWest = new JLabel(new ImageIcon(imageLeft));
			westPanel.add(imageWest);
			westPanel.setBackground(Config.getBACKGROUND());

			eastPanel = new JPanel();
			eastPanel.setSize(200, 600);
			eastPanel.setBackground(Config.getBACKGROUND());
			
			
			imageNorth = new JLabel(new ImageIcon(imageTop));
			northPanel.add(imageNorth);

			add(eastPanel, BorderLayout.EAST);

			imageEast = new JLabel(new ImageIcon(imageRight));
			eastPanel.add(imageEast);
		} catch (IOException e) {
			e.printStackTrace();
		}

		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(8, 1, 30, 15));
		centerPanel.setBackground(Config.getBACKGROUND());
		this.add(centerPanel, BorderLayout.CENTER);

		firstPanel = new JPanel();
		firstPanel.setBackground(Config.getBACKGROUND());
		centerPanel.add(firstPanel);

		lastPanel = new JPanel();
		lastPanel.setBackground(Config.getBACKGROUND());

		// Label

		averageCustomerEffort = new JLabel("Durchschnittlicher Kundenaufwand pro Tag", SwingConstants.CENTER);
		averageCustomerEffort.setFont(Config.getFONT());
		centerPanel.add(averageCustomerEffort);

		averageCustomerEffortField = new JTextField();
		averageCustomerEffortField.setFont(Config.getFONT());
		averageCustomerEffortField.setHorizontalAlignment(JLabel.CENTER);
		averageCustomerEffortField.setText("213" + " Euro");
		averageCustomerEffortField.setEditable(false);
		averageCustomerEffortField.setBackground(Config.getBACKGROUND());
		centerPanel.add(averageCustomerEffortField);

		averageTripDays = new JLabel("Durchschnittliche Reisetage", SwingConstants.CENTER);
		averageTripDays.setFont(Config.getFONT());
		centerPanel.add(averageTripDays);

		averageTripDaysField = new JTextField();
		averageTripDaysField.setFont(Config.getFONT());
		averageTripDaysField.setHorizontalAlignment(JLabel.CENTER);
		averageTripDaysField.setText("4.5" + " Tage");
		averageTripDaysField.setEditable(false);
		averageTripDaysField.setBackground(Config.getBACKGROUND());
		centerPanel.add(averageTripDaysField);

		averageHotelStars = new JLabel("Durchschnittliche Hotelsterne", SwingConstants.CENTER);
		averageHotelStars.setFont(Config.getFONT());
		centerPanel.add(averageHotelStars);

		averageHotelStarsField = new JTextField();
		averageHotelStarsField.setFont(Config.getFONT());
		averageHotelStarsField.setHorizontalAlignment(JLabel.CENTER);
		averageHotelStarsField.setText("4" + " Sterne");
		averageHotelStarsField.setEditable(false);
		averageHotelStarsField.setBackground(Config.getBACKGROUND());
		centerPanel.add(averageHotelStarsField);

		menuBar = new JMenuBar();
		menuBar.setFont(Config.getFONT());
		setJMenuBar(menuBar);

		loginMenu = new JMenu("Start");
		loginMenu.setFont(Config.getFONT());
		menuBar.add(loginMenu);

		coreDataMenu = new JMenu("Stammdaten");
		coreDataMenu.setFont(Config.getFONT());
		menuBar.add(coreDataMenu);

		loginItem = new JMenuItem("Anmelden");
		loginItem.setFont(Config.getFONT());
		logoutItem = new JMenuItem("Abmelden");
		logoutItem.setFont(Config.getFONT());
		closeItem = new JMenuItem("Beenden");
		closeItem.setFont(Config.getFONT());

		loginMenu.add(loginItem);
		loginMenu.add(logoutItem);
		loginMenu.addSeparator();
		loginMenu.add(closeItem);

		coreDataItem = new JMenuItem("Stammdatenpflege");
		coreDataItem.setFont(Config.getFONT());
		coreDataItem.addActionListener(new MainFrameListener(this));
		coreDataAnalyseItem = new JMenuItem("Stammdaten Auswertung");
		coreDataAnalyseItem.setFont(Config.getFONT());

		// Men� Action Listener
		loginItem.addActionListener(new MainFrameListener(this));
		logoutItem.addActionListener(new MainFrameListener(this));
		closeItem.addActionListener(new MainFrameListener(this));

		coreDataMenu.add(coreDataItem);
		coreDataMenu.add(coreDataAnalyseItem);
		centerPanel.add(lastPanel);

		setVisible(true);
	}

	public JPanel getWestPanel() {
		return westPanel;
	}

	public void setWestPanel(JPanel westPanel) {
		this.westPanel = westPanel;
	}

	public BufferedImage getImageLeft() {
		return imageLeft;
	}

	public void setImageLeft(BufferedImage imageLeft) {
		this.imageLeft = imageLeft;
	}

	public BufferedImage getImageRight() {
		return imageRight;
	}

	public void setImageRight(BufferedImage imageRight) {
		this.imageRight = imageRight;
	}

	public BufferedImage getImageTop() {
		return imageTop;
	}

	public void setImageTop(BufferedImage imageTop) {
		this.imageTop = imageTop;
	}

	public JPanel getNorthPanel() {
		return northPanel;
	}

	public void setNorthPanel(JPanel northPanel) {
		this.northPanel = northPanel;
	}

	public JLabel getImageWest() {
		return imageWest;
	}

	public void setImageWest(JLabel imageWest) {
		this.imageWest = imageWest;
	}

	public JPanel getEastPanel() {
		return eastPanel;
	}

	public void setEastPanel(JPanel eastPanel) {
		this.eastPanel = eastPanel;
	}

	public JLabel getImageNorth() {
		return imageNorth;
	}

	public void setImageNorth(JLabel imageNorth) {
		this.imageNorth = imageNorth;
	}

	public JLabel getImageEast() {
		return imageEast;
	}

	public void setImageEast(JLabel imageEast) {
		this.imageEast = imageEast;
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	public JPanel getFirstPanel() {
		return firstPanel;
	}

	public void setFirstPanel(JPanel firstPanel) {
		this.firstPanel = firstPanel;
	}

	public JPanel getLastPanel() {
		return lastPanel;
	}

	public void setLastPanel(JPanel lastPanel) {
		this.lastPanel = lastPanel;
	}

	public JLabel getAverageCustomerEffort() {
		return averageCustomerEffort;
	}

	public void setAverageCustomerEffort(JLabel averageCustomerEffort) {
		this.averageCustomerEffort = averageCustomerEffort;
	}

	public JTextField getAverageCustomerEffortField() {
		return averageCustomerEffortField;
	}

	public void setAverageCustomerEffortField(JTextField averageCustomerEffortField) {
		this.averageCustomerEffortField = averageCustomerEffortField;
	}

	public JLabel getAverageTripDays() {
		return averageTripDays;
	}

	public void setAverageTripDays(JLabel averageTripDays) {
		this.averageTripDays = averageTripDays;
	}

	public JTextField getAverageTripDaysField() {
		return averageTripDaysField;
	}

	public void setAverageTripDaysField(JTextField averageTripDaysField) {
		this.averageTripDaysField = averageTripDaysField;
	}

	public JLabel getAverageHotelStars() {
		return averageHotelStars;
	}

	public void setAverageHotelStars(JLabel averageHotelStars) {
		this.averageHotelStars = averageHotelStars;
	}

	public JTextField getAverageHotelStarsField() {
		return averageHotelStarsField;
	}

	public void setAverageHotelStarsField(JTextField averageHotelStarsField) {
		this.averageHotelStarsField = averageHotelStarsField;
	}

	public JMenu getLoginMenu() {
		return loginMenu;
	}

	public void setLoginMenu(JMenu loginMenu) {
		this.loginMenu = loginMenu;
	}

	public JMenu getCoreDataMenu() {
		return coreDataMenu;
	}

	public void setCoreDataMenu(JMenu coreDataMenu) {
		this.coreDataMenu = coreDataMenu;
	}

	public JMenuItem getLoginItem() {
		return loginItem;
	}

	public void setLoginItem(JMenuItem loginItem) {
		this.loginItem = loginItem;
	}

	public JMenuItem getLogoutItem() {
		return logoutItem;
	}

	public void setLogoutItem(JMenuItem logoutItem) {
		this.logoutItem = logoutItem;
	}

	public JMenuItem getCloseItem() {
		return closeItem;
	}

	public void setCloseItem(JMenuItem closeItem) {
		this.closeItem = closeItem;
	}

	public JMenuItem getCoreDataItem() {
		return coreDataItem;
	}

	public void setCoreDataItem(JMenuItem coreDataItem) {
		this.coreDataItem = coreDataItem;
	}

	public JMenuItem getCoreDataAnalyseItem() {
		return coreDataAnalyseItem;
	}

	public void setCoreDataAnalyseItem(JMenuItem coreDataAnalyseItem) {
		this.coreDataAnalyseItem = coreDataAnalyseItem;
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}
	
	public void checkLoginState() {
		if (loggedUser != null) {
			coreDataMenu.setEnabled(true);
			northPanel.setVisible(true);
			eastPanel.setVisible(true);
			logoutItem.setVisible(true);
			westPanel.setVisible(true);
			System.out.println("Logged In");
		} else {

			imageWest.setText("");
			imageNorth.setText("");
			imageEast.setText("");
			averageCustomerEffortField.setText("");
			averageTripDaysField.setText("");
			averageHotelStarsField.setText("");
			coreDataMenu.setEnabled(false);
			logoutItem.setVisible(false);
			northPanel.setVisible(false);
			eastPanel.setVisible(false);
			westPanel.setVisible(false);
			coreDataItem.setVisible(false);
			coreDataAnalyseItem.setVisible(false);
			System.out.println("Logged In Niet!");

		}
	}
}
