package crm.JasminReisen.GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import crm.JasminReisen.Config;
import crm.JasminReisen.Functions.DbFunctions;


public class MeistGebuchteReisenFrame extends JFrame {

	public MeistGebuchteReisenFrame() {

		setLayout(new BorderLayout());
		setSize(500, 400);
		setLocationRelativeTo(null);
		setTitle("Auswertungen");
		
		JScrollPane scrollpane = new JScrollPane();
		JTable mostBuys = new JTable();
	
		mostBuys.getTableHeader().setReorderingAllowed(false);
		mostBuys.setAutoCreateRowSorter(true);
		mostBuys.setPreferredScrollableViewportSize(mostBuys.getPreferredSize());
		mostBuys.setFillsViewportHeight(true);
		mostBuys.setRowHeight(21);
		mostBuys.setModel(DbFunctions.getMeistgebuchteReisen());
		scrollpane.setViewportView(mostBuys);
		
		add(scrollpane, BorderLayout.CENTER);
		
		setVisible(true);
	}
}
