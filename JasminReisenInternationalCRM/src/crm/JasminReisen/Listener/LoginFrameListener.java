package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import crm.JasminReisen.GUI.LoginFrame;

public class LoginFrameListener implements ActionListener
{
	LoginFrame loginframe;
	
	public LoginFrameListener(LoginFrame loginframe)
	{
		this.loginframe = loginframe;
	}
	
	public void actionPerformed (ActionEvent event)
	{
		JButton button = (JButton) event.getSource();
		
		
	}
	
}
