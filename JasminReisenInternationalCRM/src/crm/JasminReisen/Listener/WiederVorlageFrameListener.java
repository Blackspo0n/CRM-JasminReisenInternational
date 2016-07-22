package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.GUI.CustomerEntryFrame;
import crm.JasminReisen.GUI.LoginFrame;
import crm.JasminReisen.GUI.WiederVorlageFrame;
import crm.JasminReisen.models.Reise;

public class WiederVorlageFrameListener implements ActionListener
{
	WiederVorlageFrame WiederVorlageFrame;
	
	public WiederVorlageFrameListener(WiederVorlageFrame tripentryframe)
	{
		this.WiederVorlageFrame = tripentryframe;
	}
	
	public void actionPerformed (ActionEvent event)
	{
		
		switch (event.getActionCommand()) 
		{
			case "Auf Erledigt setzen":
				System.out.println(this.WiederVorlageFrame.getIdConext());
				
				if(DbFunctions.setWiederVorlageReaded(this.WiederVorlageFrame.getIdConext())) {
					this.WiederVorlageFrame.dispose();
					this.WiederVorlageFrame.getMainFrame().getTodotable().setModel(DbFunctions.getTodoList());
					this.WiederVorlageFrame.getMainFrame().getTodotable().repaint();
				}
				else {
					JOptionPane.showMessageDialog(this.WiederVorlageFrame, "Wiedervorlage konnte nicht auf Erledigt gesetzt werden");
				}
				break;

			case "Abbrechen":
				this.WiederVorlageFrame.dispose();
				break;
						
		}
	}
	
}