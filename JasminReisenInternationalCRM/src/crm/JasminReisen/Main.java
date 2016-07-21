package crm.JasminReisen;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.GUI.MainFrame;

public class Main {	
	
	public static void main(String[] args) 
	{		
		DbFunctions.connect();
		new MainFrame();
	}

}
