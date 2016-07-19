package crm.JasminReisen.Functions;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;

import crm.JasminReisen.GUI.LoginFrame;
import crm.JasminReisen.models.User;

public class LoginFunctions {

	private static List<User> cachedUserList;
	
	public static User login(String user, String passwort) {
		if(cachedUserList == null) {
			cachedUserList = DbFunctions.getUserList();
		}
		
		for(User useritem: cachedUserList) {
			if(user == useritem.getBenutzerName() && passwort == useritem.getPasswort()) {

				return useritem;
			}
		}
		return null;
	}
}
