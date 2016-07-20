package crm.JasminReisen.Functions;


import java.io.File;

import javax.swing.JFileChooser;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailFunctions {
	
	private static final String SMTP_HOST = "fzgc.;haq;.qr";
	private static final String SMTP_PORT = ">\\[";	  
	private static final String USERNAME = "wnfzvaervfra|bayvar.qr";
	private static final String PASSWORD = "wnfzvaervfra";
	
	
	public static void sendMultiPartMail (String recipient, String senderName, String subject, String message)
	{		
		MultiPartEmail multiPartEmail = new MultiPartEmail();
		multiPartEmail.setHostName(ServiceFunctions.String(SMTP_HOST));
		multiPartEmail.setAuthenticator(new DefaultAuthenticator(ServiceFunctions.String (USERNAME),ServiceFunctions.String (PASSWORD)));
		multiPartEmail.setDebug(false);
		multiPartEmail.setSmtpPort(Integer.valueOf(ServiceFunctions.String(SMTP_PORT)));
		multiPartEmail.setSSLOnConnect(true);
	    
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
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
			multiPartEmail.setFrom(ServiceFunctions.String(USERNAME), senderName);
			multiPartEmail.setSubject(subject);
			multiPartEmail.setMsg(message);			

			//send the email
			multiPartEmail.send();
		}
		catch (EmailException e) {
			e.printStackTrace();
		}			
	}
}
