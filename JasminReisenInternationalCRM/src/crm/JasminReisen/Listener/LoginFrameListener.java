package crm.JasminReisen.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import crm.JasminReisen.Functions.LoginFunctions;
import crm.JasminReisen.GUI.CoreDataFrame;
import crm.JasminReisen.GUI.LoginFrame;
import crm.JasminReisen.GUI.MainFrame;
import crm.JasminReisen.models.User;

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
		case "Einloggen":
			User lu = LoginFunctions.login(loginframe.getTxtUser().getText(), loginframe.getTxtPassword().getText());
			
			if(lu != null) {
				this.loginframe.getMainFrame().setLoggedUser(lu);
				this.loginframe.getMainFrame().checkLoginState();
				this.loginframe.dispose();
			}
			else {
				JOptionPane.showMessageDialog(this.loginframe, "Der Login war nicht erfolgreich. Bitte überprüfen Sie Ihre Anmeldedaten.", "Login", JOptionPane.ERROR_MESSAGE);
				
			}
			break;
		}
	}
	
}
