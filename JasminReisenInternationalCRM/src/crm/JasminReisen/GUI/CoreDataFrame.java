package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
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
		coreDataTab.addTab("Kunden", null, customerPanel, null);
		
		// Panel for North of Kunden
		JPanel northPanelCustomer = new JPanel();
		northPanelCustomer.setSize(1200, 300);
		customerPanel.add(northPanelCustomer, BorderLayout.NORTH);
		
		// Panel for Center of Kunden
		JPanel centerPanelCustomer = new JPanel();
		customerPanel.add(centerPanelCustomer, BorderLayout.CENTER);
		
		//Table for Kunden
		JTable customerTable = new JTable();		
		JScrollPane customerScrollPane = new JScrollPane();
		centerPanelCustomer.add(customerScrollPane);
		
		customerTable = new JTable();
		customerTable.setShowGrid(false);
		customerTable.setFont(Config.getFONT());
		customerTable.setModel(DbFunctions.getFilteredCustomers("Momper"));	
		customerTable.setAutoCreateRowSorter(true);
		customerScrollPane.setViewportView(customerTable);
		
		this.setVisible(true);
	}
}
