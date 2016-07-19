package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.Functions.LoginFunctions;
import crm.JasminReisen.GUI.CoreDataFrame;
import crm.JasminReisen.GUI.CustomerEntryFrame;
import crm.JasminReisen.GUI.LoginFrame;
import crm.JasminReisen.GUI.MainFrame;
import crm.JasminReisen.models.User;

public class CustomerEntryFrameListener implements ActionListener
{
	CustomerEntryFrame customerFrame;
	
	public CustomerEntryFrameListener(CustomerEntryFrame customerFrame)
	{
		this.customerFrame = customerFrame ;
	}
	
	public void actionPerformed (ActionEvent event)
	{
		switch (event.getActionCommand()) {
		case "Anlegen":
			DbFunctions.cre
			break;
		case "Speichern":
			break;
		case "Abbrechen":
			this.customerFrame.dispose();
			break;
		}
	}
	
}
