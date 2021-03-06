package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import crm.JasminReisen.Config;
import crm.JasminReisen.Functions.DbFunctions;
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

	private JMenu actionsMenu;
	private JMenuItem contactItem;
	private JMenuItem newsletterItem;
	private JMenuItem eMailItem;
	private JMenu analysisMenu;
	private JMenuItem mostBookedItem;

	private User loggedUser;
	private JPanel centerPanelNoLogin;
	private JMenuItem specEntryItem;
	private JPanel cardPanel;
	private CardLayout card;
	private JTable birthdayTable;
	private JPanel birthdayPanel;
	private JPanel upcomingBirthdayPanel;
	private JButton rabattCodeSenden;
	private JTabbedPane mainTabPanel;
	private JPanel TodoPanel;
	private JTable todotable;
	private JLabel pleaseLogIn;
	private JScrollPane todoScrollPane;
	private JTable upcomingBirthdayTable;
	private JScrollPane upcomingBirthdayScrollPane;
	private JButton TodoAnzeigen;
	private JMenuItem avgItem;
	private JMenuItem contactHistoryItem;

	public MainFrame() {

		try {
			BufferedImage whsLogo = ImageIO
					.read(new File("images/whslogo.png"));
			this.setIconImage(whsLogo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 700);
		setTitle("Jasmin Reisen International - Customer Relationship Management");
		setResizable(false);
		setBackground(Config.getBACKGROUND());
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);

		card = new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(card);
		this.add(cardPanel);

		// Images
		try {

			westPanel = new JPanel();
			westPanel.setSize(200, 600);
			add(westPanel, BorderLayout.WEST);

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

		actionsMenu = new JMenu("Aktionen");
		actionsMenu.setFont(Config.getFONT());
		menuBar.add(actionsMenu);
		contactItem = new JMenuItem("Kontakt erfassen");
		contactItem.setFont(Config.getFONT());
		actionsMenu.add(contactItem);
		contactItem.addActionListener(new MainFrameListener(this));
		newsletterItem = new JMenuItem("Newsletter versenden");
		newsletterItem.setFont(Config.getFONT());
		actionsMenu.add(newsletterItem);
		newsletterItem.addActionListener(new MainFrameListener(this));
		eMailItem = new JMenuItem("eMail versenden");
		eMailItem.setFont(Config.getFONT());
		actionsMenu.add(eMailItem);
		eMailItem.addActionListener(new MainFrameListener(this));
		
		

		analysisMenu = new JMenu("Auswertungen");
		analysisMenu.setFont(Config.getFONT());
		menuBar.add(analysisMenu);
		mostBookedItem = new JMenuItem("Meistgebuchte Reisen");
		mostBookedItem.setFont(Config.getFONT());
		analysisMenu.add(mostBookedItem);
		mostBookedItem.addActionListener(new MainFrameListener(this));


		avgItem = new JMenuItem("Durchschnittsauswertung");
		avgItem.setFont(Config.getFONT());
		analysisMenu.add(avgItem);
		avgItem.addActionListener(new MainFrameListener(this));

		contactHistoryItem = new JMenuItem("Kontakthistorie");
		contactHistoryItem.setFont(Config.getFONT());
		analysisMenu.add(contactHistoryItem);
		contactHistoryItem.addActionListener(new MainFrameListener(this));

		
		
		loginMenu.add(loginItem);
		loginMenu.add(logoutItem);
		loginMenu.addSeparator();
		loginMenu.add(closeItem);

		coreDataItem = new JMenuItem("Stammdatenpflege");
		coreDataItem.setFont(Config.getFONT());
		coreDataItem.addActionListener(new MainFrameListener(this));

		// Menue Action Listener
		loginItem.addActionListener(new MainFrameListener(this));
		logoutItem.addActionListener(new MainFrameListener(this));
		closeItem.addActionListener(new MainFrameListener(this));

		coreDataMenu.add(coreDataItem);

		specEntryItem = new JMenuItem("Spezifikationen Hinzufügen");
		specEntryItem.setFont(Config.getFONT());
		specEntryItem.addActionListener(new MainFrameListener(this));
		coreDataMenu.add(specEntryItem);

		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBackground(Config.getBACKGROUND());
		cardPanel.add(centerPanel, "login");

		mainTabPanel = new JTabbedPane();
		mainTabPanel.setFont(Config.getFONT());
		centerPanel.add(mainTabPanel, BorderLayout.CENTER);

		birthdayPanel = new JPanel();
		birthdayPanel.setBackground(Config.getBACKGROUND());
		birthdayPanel.setLayout(new BorderLayout());
		mainTabPanel.addTab("Geburtstag", null, birthdayPanel, null);

		JScrollPane birthdayScrollPane = new JScrollPane();
		birthdayPanel.add(birthdayScrollPane, BorderLayout.CENTER);

		birthdayTable = new JTable();
		birthdayTable.setShowGrid(false);
		birthdayTable.setFont(Config.getFONT());
		birthdayTable.setBackground(Config.getBACKGROUND());
		birthdayTable.getTableHeader().setReorderingAllowed(false);
		birthdayTable.setAutoCreateRowSorter(true);
		birthdayTable.setPreferredScrollableViewportSize(birthdayTable
				.getPreferredSize());
		birthdayTable.setFillsViewportHeight(true);
		birthdayTable.setRowHeight(21);
		birthdayTable
				.setModel(DbFunctions
						.getCustomersWithBirthdays("SELECT *, (YEAR(CURDATE()) - YEAR(GebDat)) AS Age FROM Kunden  WHERE MONTH(GebDat) = MONTH(CURDATE()) AND DAY(GebDat) = DAY(CURDATE())"));
		birthdayTable.getTableHeader().setFont(Config.getFONT());
		birthdayScrollPane.setViewportView(birthdayTable);

		rabattCodeSenden = new JButton("Rabattcode versenden");
		rabattCodeSenden.setFont(Config.getFONT());
		rabattCodeSenden.addActionListener(new MainFrameListener(this));
		birthdayPanel.add(rabattCodeSenden, BorderLayout.SOUTH);

		upcomingBirthdayPanel = new JPanel();
		upcomingBirthdayPanel.setBackground(Config.getBACKGROUND());
		upcomingBirthdayPanel.setLayout(new BorderLayout());
		
		upcomingBirthdayScrollPane = new JScrollPane();
		upcomingBirthdayPanel.add(upcomingBirthdayScrollPane,
				BorderLayout.CENTER);

		upcomingBirthdayTable = new JTable();
		upcomingBirthdayTable.setShowGrid(false);
		upcomingBirthdayTable.setFont(Config.getFONT());
		upcomingBirthdayTable.setBackground(Config.getBACKGROUND());
		upcomingBirthdayTable.getTableHeader().setReorderingAllowed(false);
		upcomingBirthdayTable.setAutoCreateRowSorter(true);
		upcomingBirthdayTable
				.setPreferredScrollableViewportSize(upcomingBirthdayTable
						.getPreferredSize());
		upcomingBirthdayTable.setFillsViewportHeight(true);
		upcomingBirthdayTable.setRowHeight(21);
		upcomingBirthdayTable
				.setModel(DbFunctions
						.getCustomersWithUpcomingBirthdays("SELECT *, (YEAR(CURDATE()) - YEAR(GebDat)) AS Age FROM Kunden WHERE  DATE_ADD(GebDat, INTERVAL YEAR(CURDATE())-YEAR(GebDat) + IF(DAYOFYEAR(CURDATE()) > DAYOFYEAR(GebDat),1,0)YEAR)BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY)"));
		upcomingBirthdayTable.getTableHeader().setFont(Config.getFONT());
		upcomingBirthdayScrollPane.setViewportView(upcomingBirthdayTable);

		TodoPanel = new JPanel();
		TodoPanel.setBackground(Config.getBACKGROUND());
		TodoPanel.setLayout(new BorderLayout());
		
		mainTabPanel.addTab("Anstehende Geburtstage", null, upcomingBirthdayPanel, null);
		mainTabPanel.addTab("Wiedervorlage", null, TodoPanel , null);
		
		
		todoScrollPane = new JScrollPane();
		TodoPanel.add(todoScrollPane, BorderLayout.CENTER);

		todotable = new JTable();
		todotable.setShowGrid(false);
		todotable.setFont(Config.getFONT());
		todotable.setBackground(Config.getBACKGROUND());
		todotable.getTableHeader().setReorderingAllowed(false);
		todotable.setAutoCreateRowSorter(true);
		todotable.setPreferredScrollableViewportSize(todotable.getPreferredSize());
		todotable.setFillsViewportHeight(true);
		todotable.setRowHeight(21);
		todotable.setModel(DbFunctions.getTodoList());
		todotable.getTableHeader().setFont(Config.getFONT());
		todoScrollPane.setViewportView(todotable);

		TodoAnzeigen = new JButton("Wiedervorlage anzeigen");
		TodoAnzeigen.setFont(Config.getFONT());
		TodoAnzeigen.addActionListener(new MainFrameListener(this));
		TodoPanel.add(TodoAnzeigen, BorderLayout.SOUTH);

		
		centerPanelNoLogin = new JPanel();
		centerPanelNoLogin.setLayout(new BorderLayout());
		centerPanelNoLogin.setBackground(Config.getBACKGROUND());
		centerPanelNoLogin.setVisible(false);
		cardPanel.add(centerPanelNoLogin, "logout");

		try {
			BufferedImage imageWHS = ImageIO.read(new File("images/whs.png"));
			BufferedImage imageCRM = ImageIO.read(new File("images/CRM.png"));
			JLabel imageWHSLabel = new JLabel(new ImageIcon(imageWHS));
			JLabel imageCRMLabel = new JLabel(new ImageIcon(imageCRM));
			centerPanelNoLogin.add(imageWHSLabel, BorderLayout.NORTH);
			centerPanelNoLogin.add(imageCRMLabel, BorderLayout.SOUTH);
		} catch (Exception e) {
			e.printStackTrace();
		}

		pleaseLogIn = new JLabel(
				"Bitte melden Sie sich an um fortzufahren");
		pleaseLogIn.setFont(Config.getFONT_SUPERSIZE());
		pleaseLogIn.setBackground(Config.getBACKGROUND());
		pleaseLogIn.setHorizontalAlignment(JLabel.CENTER);
		centerPanelNoLogin.add(pleaseLogIn, BorderLayout.CENTER);

		if (loggedUser != null) {
			card.show(cardPanel, "login");
		} else {
			card.show(cardPanel, "logout");
		}
		checkLoginState();

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

	public void setAverageCustomerEffortField(
			JTextField averageCustomerEffortField) {
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
			centerPanelNoLogin.setVisible(false);
			coreDataMenu.setEnabled(true);
			northPanel.setVisible(true);
			eastPanel.setVisible(true);
			logoutItem.setVisible(true);
			loginItem.setVisible(false);
			westPanel.setVisible(true);
			coreDataItem.setVisible(true);
			actionsMenu.setEnabled(true);
			analysisMenu.setEnabled(true);
		} else {
			centerPanelNoLogin.setVisible(true);
			imageWest.setText("");
			imageNorth.setText("");
			imageEast.setText("");
			coreDataMenu.setEnabled(false);
			loginItem.setVisible(true);
			logoutItem.setVisible(false);
			northPanel.setVisible(false);
			eastPanel.setVisible(false);
			westPanel.setVisible(false);
			coreDataItem.setVisible(false);
			actionsMenu.setEnabled(false);
			analysisMenu.setEnabled(false);
		}
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JPanel getCenterPanelNoLogin() {
		return centerPanelNoLogin;
	}

	public void setCenterPanelNoLogin(JPanel centerPanelNoLogin) {
		this.centerPanelNoLogin = centerPanelNoLogin;
	}

	public JMenuItem getSpecEntryItem() {
		return specEntryItem;
	}

	public void setSpecEntryItem(JMenuItem specEntryItem) {
		this.specEntryItem = specEntryItem;
	}

	public JPanel getCardPanel() {
		return cardPanel;
	}

	public void setCardPanel(JPanel cardPanel) {
		this.cardPanel = cardPanel;
	}

	public CardLayout getCard() {
		return card;
	}

	public void setCard(CardLayout card) {
		this.card = card;
	}

	public JTable getBirthdayTable() {
		return birthdayTable;
	}

	public void setBirthdayTable(JTable birthdayTable) {
		this.birthdayTable = birthdayTable;
	}

	public JPanel getBirthdayPanel() {
		return birthdayPanel;
	}

	public void setBirthdayPanel(JPanel birthdayPanel) {
		this.birthdayPanel = birthdayPanel;
	}

	public JMenu getActionsMenu() {
		return actionsMenu;
	}

	public void setActionsMenu(JMenu actionsMenu) {
		this.actionsMenu = actionsMenu;
	}

	public JMenuItem getContactItem() {
		return contactItem;
	}

	public void setContactItem(JMenuItem contactItem) {
		this.contactItem = contactItem;
	}

	public JMenuItem getNewsletterItem() {
		return newsletterItem;
	}

	public void setNewsletterItem(JMenuItem newsletterItem) {
		this.newsletterItem = newsletterItem;
	}

	public JMenuItem geteMailItem() {
		return eMailItem;
	}

	public void seteMailItem(JMenuItem eMailItem) {
		this.eMailItem = eMailItem;
	}

	public JMenu getAnalysisMenu() {
		return analysisMenu;
	}

	public void setAnalysisMenu(JMenu analysisMenu) {
		this.analysisMenu = analysisMenu;
	}

	public JMenuItem getMostBookedItem() {
		return mostBookedItem;
	}

	public void setMostBookedItem(JMenuItem mostBookedItem) {
		this.mostBookedItem = mostBookedItem;
	}

	public JPanel getUpcomingBirthdayPanel() {
		return upcomingBirthdayPanel;
	}

	public void setUpcomingBirthdayPanel(JPanel upcomingBirthdayPanel) {
		this.upcomingBirthdayPanel = upcomingBirthdayPanel;
	}

	public JButton getRabattCodeSenden() {
		return rabattCodeSenden;
	}

	public void setRabattCodeSenden(JButton rabattCodeSenden) {
		this.rabattCodeSenden = rabattCodeSenden;
	}

	public JTabbedPane getMainTabPanel() {
		return mainTabPanel;
	}

	public void setMainTabPanel(JTabbedPane mainTabPanel) {
		this.mainTabPanel = mainTabPanel;
	}

	public JPanel getTodoPanel() {
		return TodoPanel;
	}

	public void setTodoPanel(JPanel todoPanel) {
		TodoPanel = todoPanel;
	}

	public JTable getTodotable() {
		return todotable;
	}

	public void setTodotable(JTable todotable) {
		this.todotable = todotable;
	}

	public JLabel getPleaseLogIn() {
		return pleaseLogIn;
	}

	public void setPleaseLogIn(JLabel pleaseLogIn) {
		this.pleaseLogIn = pleaseLogIn;
	}

	public JScrollPane getTodoScrollPane() {
		return todoScrollPane;
	}

	public void setTodoScrollPane(JScrollPane todoScrollPane) {
		this.todoScrollPane = todoScrollPane;
	}

	public JTable getUpcomingBirthdayTable() {
		return upcomingBirthdayTable;
	}

	public void setUpcomingBirthdayTable(JTable upcomingBirthdayTable) {
		this.upcomingBirthdayTable = upcomingBirthdayTable;
	}

	public JScrollPane getUpcomingBirthdayScrollPane() {
		return upcomingBirthdayScrollPane;
	}

	public void setUpcomingBirthdayScrollPane(JScrollPane upcomingBirthdayScrollPane) {
		this.upcomingBirthdayScrollPane = upcomingBirthdayScrollPane;
	}

	public JButton getTodoAnzeigen() {
		return TodoAnzeigen;
	}

	public void setTodoAnzeigen(JButton todoAnzeigen) {
		TodoAnzeigen = todoAnzeigen;
	}
}