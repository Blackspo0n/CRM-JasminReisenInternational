package crm.JasminReisen.Functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbFunctions 
{
	private static Statement statement =null;
	private static Connection connection= null;
	private static String sql=null;
	private static ResultSet rs=null;
	
	public static Connection connect (String ipAdresse, String db, String port, String benutzerName, String passwort)
	{
		try
		{
			connection=DriverManager.getConnection(
					"jdbc:mysql://"+ipAdresse+":"+port + "/" + db +"?useSSL=false", benutzerName, passwort);
		statement = connection.createStatement();
		
		return connection;
		
		}
		catch (Exception e)
		{
			return null;
			//throw new IllegalStateException(e);
		}
	}
	
	public static void login (String username, String password)
	{
		sql = "Select * from Benutzer";
		
		
		try 
		{
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
