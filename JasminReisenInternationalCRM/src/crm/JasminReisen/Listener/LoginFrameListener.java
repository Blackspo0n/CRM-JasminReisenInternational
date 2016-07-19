package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import crm.JasminReisen.GUI.CoreDataFrame;
import crm.JasminReisen.GUI.LoginFrame;
import crm.JasminReisen.GUI.MainFrame;

public class LoginFrameListener implements ActionListener
{
	LoginFrame loginframe;
	
	public LoginFrameListener(LoginFrame loginframe)
	{
		this.loginframe = loginframe;
	}
	
	public void actionPerformed (ActionEvent event)
	{
		switch (event.getActionCommand()) {
		case "Beenden":
			break;
		}

	}
	
}
