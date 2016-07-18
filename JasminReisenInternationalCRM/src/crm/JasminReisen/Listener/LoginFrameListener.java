package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import crm.JasminReisen.GUI.LoginFrame;

public class LoginFrameListener 
{
	LoginFrame loginframe;
	
	LoginFrameListener(LoginFrame loginframe)
	{
		this.loginframe = loginframe;
	}
	
	public void actionPerformed (ActionEvent event)
	{
		JButton button = (JButton) event.getSource();
		
		
	}
	
}
