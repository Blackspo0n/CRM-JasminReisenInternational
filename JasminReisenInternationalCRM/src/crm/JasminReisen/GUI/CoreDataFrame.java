package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import crm.JasminReisen.Config;
import crm.JasminReisen.Functions.DbFunctions;

public class CoreDataFrame extends JFrame {

	public CoreDataFrame() {
		
		this.setSize(1200, 600);
		this.setResizable(false);
		this.setTitle("Stammdatenpflege");
		this.setBackground(Config.getBACKGROUND());
		Dimension windowSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width / 2 - windowSize.width / 2, screenSize.height / 2 - windowSize.height / 2);
		this.setLayout(new BorderLayout());
		
		// Panel
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Config.getBACKGROUND());
		this.add(contentPane, BorderLayout.CENTER);
		
		// Tabbed Pane
		JTabbedPane coreDataTab = new JTabbedPane(JTabbedPane.TOP);
		coreDataTab.setFont(Config.getFONT());
		coreDataTab.setBackground(Config.getBACKGROUND());
		this.add(coreDataTab);
		
		// Panels for Tabbed Pane Reisen
		JPanel tripPanel = new JPanel();
		tripPanel.setFont(Config.getFONT());
		tripPanel.setBackground(Config.getBACKGROUND());
		coreDataTab.addTab("Reisen", null, tripPanel, null);
		
		// Panels for Tabbed Pane Kunden
		JPanel customerPanel = new JPanel();
		customerPanel.setFont(Config.getFONT());
		customerPanel.setBackground(Config.getBACKGROUND());
		customerPanel.setLayout(new BorderLayout());
		customerPanel.setSize(1000, 400);
		coreDataTab.addTab("Kunden", null, customerPanel, null);
		
		// Panel for North of Kunden
		JPanel northPanelCustomer = new JPanel();
		northPanelCustomer.setSize(1200, 300);
		customerPanel.add(northPanelCustomer, BorderLayout.NORTH);
		northPanelCustomer.setLayout(new BorderLayout());
		
		// Panel for North of North of Kunden (beste Bezeichnung)
		JPanel northOfNorthOfCustomerPanel = new JPanel();
		northOfNorthOfCustomerPanel.setSize(1200, 30);
		northOfNorthOfCustomerPanel.setBackground(Config.getBACKGROUND());
		northPanelCustomer.add(northOfNorthOfCustomerPanel);
		
		JLabel headLineCustomer = new JLabel("Filter");
		headLineCustomer.setFont(Config.getFONT());
		northOfNorthOfCustomerPanel.add(headLineCustomer, BorderLayout.CENTER);
		
		// Panel for Center of North of Kunden (beste Bezeichnung2)
		JPanel centerOfNorthOfCustomerPanel = new JPanel();
		centerOfNorthOfCustomerPanel.setLayout(new GridLayout(5,2,5,5));
		
		
		//Table for Kunden
		JTable customerTable = new JTable();		
		JScrollPane customerScrollPane = new JScrollPane();
		customerPanel.add(customerScrollPane, BorderLayout.CENTER);
		
		customerTable.setShowGrid(false);
		customerTable.setFont(Config.getFONT());
		customerTable.setModel(DbFunctions.getFilteredCustomers("Momper"));	
		customerTable.setAutoCreateRowSorter(true);
		customerTable.setPreferredScrollableViewportSize(customerTable.getPreferredSize());
		customerTable.setFillsViewportHeight(true);
		customerTable.setRowHeight(21);
		customerScrollPane.setViewportView(customerTable);
		
		this.setVisible(true);
	}
}
