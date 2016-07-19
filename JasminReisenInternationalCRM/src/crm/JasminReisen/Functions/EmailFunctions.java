package crm.JasminReisen.Functions;
import java.io.File;

import javax.swing.JFileChooser;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailFunctions {
	
	private static final String SMTP_HOST = "smtp.1und1.com";
	private static final int SMTP_PORT = 465;	  
	private static final String USERNAME = "jasminreisen@online.de";
	private static final String PASSWORD = "wnfzvaervfra";
	
	
	public static void sendMultiPartMail (String recipient, String senderName, String subject, String message)
	{		
		MultiPartEmail multiPartEmail = new MultiPartEmail();
		multiPartEmail.setHostName(SMTP_HOST);
		multiPartEmail.setAuthenticator(new DefaultAuthenticator(USERNAME,String (PASSWORD)));
		multiPartEmail.setDebug(false);
		multiPartEmail.setSmtpPort(SMTP_PORT);
		multiPartEmail.setSSLOnConnect(true);
	    
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("D:/Google Drive/WHS-Job/Campuswoche/"));
		chooser.showDialog(null, "Anhang wählen");
		try
		{
			attachment.setPath(chooser.getSelectedFile().getAbsolutePath());		
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setName(chooser.getSelectedFile().getName());
			// add the attachment
			multiPartEmail.attach(attachment);
		}
		catch (NullPointerException | EmailException e)
		{}		

		// Create the email message	
		try
		{
			multiPartEmail.addTo(recipient);
			multiPartEmail.setFrom(USERNAME, senderName);
			multiPartEmail.setSubject(subject);
			multiPartEmail.setMsg(message);			

			//send the email
			multiPartEmail.send();
		}
		catch (EmailException e) {
			e.printStackTrace();
		}			
	}
	
	private static String String (String s)
	{		
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);         
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            s = replaceCharAt (s, i, c);            
        }
        return s;
    }
	
	private static String replaceCharAt(String s, int pos, char c) 
	{
		   return s.substring(0,pos) + c + s.substring(pos+1);
	}
}
