package crm.JasminReisen;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.GUI.MainFrame;

public class Main {
	
	
	public static void main(String[] args) 
	{
		
		DbFunctions.connect("193.175.199.130", "CRM", "3306", "whs", "whs2016");
		
		new MainFrame();
	}

}
