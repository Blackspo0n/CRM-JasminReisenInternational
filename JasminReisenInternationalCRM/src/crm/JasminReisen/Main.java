package crm.JasminReisen;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.Functions.EmailFunctions;
import crm.JasminReisen.GUI.MainFrame;

public class Main {	
	
	public static void main(String[] args) 
	{		
		DbFunctions.connect();
		//EmailFunctions.sendMultiPartMail("tmueller@go4more.de", "Test", "Nachricht", true);
		new MainFrame();
	}

}
