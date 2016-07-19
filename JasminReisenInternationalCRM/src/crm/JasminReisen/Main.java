package crm.JasminReisen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import crm.JasminReisen.Functions.DbFunctions;
import crm.JasminReisen.GUI.MainFrame;

public class Main {
	
	
	public static void main(String[] args) 
	{
		
		DbFunctions.connect("193.175.199.130", "CRM", "3306", "whs", "whs2016");
		
		
		
		new MainFrame();

	}

}
