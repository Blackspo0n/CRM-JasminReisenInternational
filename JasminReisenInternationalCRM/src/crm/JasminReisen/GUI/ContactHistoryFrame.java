package crm.JasminReisen.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import crm.JasminReisen.Config;
import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.Listener.ContactHistoryFrameListener;
import crm.JasminReisen.models.HistoryReise;

public class ContactHistoryFrame extends JFrame {

	
	private ArrayList<HistoryReise> reiseList;
	private JTable historyTable;
	private JTable historyTripTable;
	private JTabbedPane tabPanel;

	public ContactHistoryFrame(int customerID) {
		
		this.setTitle("Kontakthistorie");
		this.setSize(600, 400);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		
		tabPanel = new JTabbedPane();
		tabPanel.setFont(Config.getFONT());
		tabPanel.setBackground(Config.getBACKGROUND());
		this.add(tabPanel, BorderLayout.CENTER);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		tabPanel.addTab("Kundenkontakt", null, mainPanel, null);
		
		JPanel tripPanel = new JPanel();
		tripPanel.setLayout(new BorderLayout());
		tabPanel.addTab("Buchungen", null, tripPanel, null);
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,1,10,10));
		this.add(southPanel, BorderLayout.SOUTH);
		
		JButton openButton = new JButton("Öffnen");
		openButton.setFont(Config.getFONT());
		openButton.addActionListener(new ContactHistoryFrameListener(this));
		southPanel.add(openButton);
		
		historyTable = new JTable();
		JScrollPane historyScrollPane = new JScrollPane();
		mainPanel.add(historyScrollPane, BorderLayout.CENTER);

		historyTable.setShowGrid(false);
		historyTable.setFont(Config.getFONT());
		historyTable.setBackground(Config.getBACKGROUND());
		historyTable.getTableHeader().setReorderingAllowed(false);
		historyTable.setModel(DbFunctions.getContactHistory("select k.KundenID as KundenID, k.Kontaktdatum as Datum, "
				+ "a.AktionsName as Aktion, k.KontaktThema as Thema from Kontakthistorien as k, "
				+ "Aktionen as a where k.AktionsID = a.AktionsID and KundenID = " + customerID));
		historyTable.setAutoCreateRowSorter(true);
		historyTable.setPreferredScrollableViewportSize(historyTable.getPreferredSize());
		historyTable.setFillsViewportHeight(true);
		historyTable.setRowHeight(21);
		historyTable.getTableHeader().setFont(Config.getFONT());
		historyScrollPane.setViewportView(historyTable);
		
		historyTripTable = new JTable();
		JScrollPane historyTripScrollPane = new JScrollPane();
		tripPanel.add(historyTripScrollPane, BorderLayout.CENTER);

		historyTripTable.setShowGrid(false);
		historyTripTable.setFont(Config.getFONT());
		historyTripTable.setBackground(Config.getBACKGROUND());
		historyTripTable.getTableHeader().setReorderingAllowed(false);
		reiseList = new ArrayList<HistoryReise>();
		reiseList = DbFunctions.getHistoryReise(customerID);
		historyTripTable.setModel(DbFunctions.getTripHistory(reiseList));
		historyTripTable.setAutoCreateRowSorter(true);
		historyTripTable.setPreferredScrollableViewportSize(historyTripTable.getPreferredSize());
		historyTripTable.setFillsViewportHeight(true);
		historyTripTable.setRowHeight(21);
		historyTripTable.getTableHeader().setFont(Config.getFONT());
		historyTripScrollPane.setViewportView(historyTripTable);
		
		this.setVisible(true);
	}

	public ArrayList<HistoryReise> getReiseList() {
		return reiseList;
	}

	public void setReiseList(ArrayList<HistoryReise> reiseList) {
		this.reiseList = reiseList;
	}

	public JTable getHistoryTable() {
		return historyTable;
	}

	public void setHistoryTable(JTable historyTable) {
		this.historyTable = historyTable;
	}

	public JTable getHistoryTripTable() {
		return historyTripTable;
	}

	public void setHistoryTripTable(JTable historyTripTable) {
		this.historyTripTable = historyTripTable;
	}

	public JTabbedPane getTabPanel() {
		return tabPanel;
	}

	public void setTabPanel(JTabbedPane tabPanel) {
		this.tabPanel = tabPanel;
	}

}
