package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import crm.JasminReisen.Config;
import crm.JasminReisen.Functions.DbFunctions;

public class CoreDataFrame extends JDialog {

	private JPanel contentPane;
	private JTabbedPane coreDataTab;
	private JPanel tripPanel;
	private JPanel customerPanel;
	private JPanel northPanelCustomer;
	private JPanel centerOfNorthOfCustomerPanel;
	private JLabel headLineCustomer;
	private JButton searchButton;
	private JLabel emptyLabel;
	private JButton resetButton;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel vornameLabel;
	private JTextField vornameTextField;
	private JLabel strasseLabel;
	private JTextField strasseTextField;
	private JLabel ortLabel;
	private JTextField ortTextField;
	private JLabel plzLabel;
	private JTextField plzTextField;
	private JLabel landLabel;
	private JTextField landTextField;
	private JLabel telefonLabel;
	private JTextField telefonTextField;
	private JLabel mailLabel;
	private JTextField mailTextField;
	private JTable customerTable;
	private JScrollPane customerScrollPane;

	public CoreDataFrame() {
		
		this.setSize(1200, 600);
		this.setResizable(false);
		this.setTitle("Stammdatenpflege");
		this.setBackground(Config.getBACKGROUND());
		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width / 2 - windowSize.width / 2, screenSize.height / 2 - windowSize.height / 2);
		this.setLayout(new BorderLayout());
		
		contentPane = new JPanel();
		contentPane.setBackground(Config.getBACKGROUND());
		this.add(contentPane, BorderLayout.CENTER);
		
		coreDataTab = new JTabbedPane(JTabbedPane.TOP);
		coreDataTab.setFont(Config.getFONT());
		coreDataTab.setBackground(Config.getBACKGROUND());
		this.add(coreDataTab);
		
		tripPanel = new JPanel();
		tripPanel.setFont(Config.getFONT());
		tripPanel.setBackground(Config.getBACKGROUND());
		coreDataTab.addTab("Reisen", null, tripPanel, null);
		
		customerPanel = new JPanel();
		customerPanel.setFont(Config.getFONT());
		customerPanel.setBackground(Config.getBACKGROUND());
		customerPanel.setLayout(new BorderLayout());
		coreDataTab.addTab("Kunden", null, customerPanel, null);
		
		northPanelCustomer = new JPanel();
		northPanelCustomer.setSize(1200, 400);
		customerPanel.add(northPanelCustomer, BorderLayout.NORTH);
		northPanelCustomer.setLayout(new BorderLayout());
	
		
		centerOfNorthOfCustomerPanel = new JPanel();
		centerOfNorthOfCustomerPanel.setLayout(new GridLayout(5,4,5,5));
		centerOfNorthOfCustomerPanel.setBackground(Config.getBACKGROUND());
		northPanelCustomer.add(centerOfNorthOfCustomerPanel);

		
		headLineCustomer = new JLabel("Filter");
		headLineCustomer.setFont(Config.getHEADLINE());
		headLineCustomer.setBackground(Config.getBACKGROUND());
		centerOfNorthOfCustomerPanel.add(headLineCustomer);
		
		searchButton = new JButton("Suchen");
		searchButton.setFont(Config.getFONT());
		searchButton.setBackground(Config.getBACKGROUND());
		centerOfNorthOfCustomerPanel.add(searchButton);
		
		emptyLabel = new JLabel("");
		emptyLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(emptyLabel);
		
		resetButton = new JButton("Zurücksetzen");
		resetButton.setFont(Config.getFONT());
		resetButton.setBackground(Config.getBACKGROUND());
		centerOfNorthOfCustomerPanel.add(resetButton);
		
		nameLabel = new JLabel("Name");
		nameLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(nameLabel);
		
		nameTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(nameTextField);
		
		vornameLabel = new JLabel("Vorname");
		vornameLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(vornameLabel);
		
		vornameTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(vornameTextField);

		strasseLabel = new JLabel("Strasse");
		strasseLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(strasseLabel);
		
		strasseTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(strasseTextField);
		
		ortLabel = new JLabel("Ort");
		ortLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(ortLabel);
		
		ortTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(ortTextField);
		
		plzLabel = new JLabel("PLZ");
		plzLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(plzLabel);
		
		plzTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(plzTextField);
		
		landLabel = new JLabel("Land");
		landLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(landLabel);
		
		landTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(landTextField);
		
		telefonLabel = new JLabel("Telefon");
		telefonLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(telefonLabel);
		
		telefonTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(telefonTextField);
		
		mailLabel = new JLabel("E-Mail");
		mailLabel.setFont(Config.getFONT());
		centerOfNorthOfCustomerPanel.add(mailLabel);
		
		mailTextField = new JTextField();
		centerOfNorthOfCustomerPanel.add(mailTextField);

		
		customerTable = new JTable();		
		customerScrollPane = new JScrollPane();
		customerPanel.add(customerScrollPane, BorderLayout.CENTER);
		
		customerTable.setShowGrid(false);
		customerTable.setFont(Config.getFONT());
		customerTable.setModel(DbFunctions.getFilteredCustomers("Momper"));	
		customerTable.setAutoCreateRowSorter(true);
		customerTable.setPreferredScrollableViewportSize(customerTable.getPreferredSize());
		customerTable.setFillsViewportHeight(true);
		customerTable.setRowHeight(21);
		customerTable.getTableHeader().setFont(Config.getFONT());
		customerScrollPane.setViewportView(customerTable);
		
		this.setVisible(true);
	}
}
