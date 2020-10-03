package Bean;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingMail 
{
	final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	public void sendRegisterNotification(Method me)
	{
		//Need 2 JAR File For sending Mail from Your own Website
		// Get a Properties object		
	     Properties props = System.getProperties();
	     props.setProperty("mail.smtp.host", "smtp.gmail.com");
	     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	     props.setProperty("mail.smtp.socketFactory.fallback", "false");
	     props.setProperty("mail.smtp.port", "465");
	     props.setProperty("mail.smtp.socketFactory.port", "465");
	     props.put("mail.smtp.auth", "true");
	     props.put("mail.debug", "true");
	     props.put("mail.store.protocol", "pop3");
	     props.put("mail.transport.protocol", "smtp");
	     
	     final String username = "py06748@gmail.com";
	     final String password = "xxxxxxxxxxxx";
	     
	     try{
	     Session session = Session.getDefaultInstance(props, 
	                          new Authenticator(){
	                             protected PasswordAuthentication getPasswordAuthentication() {
	                                return new PasswordAuthentication(username, password);
	      }});

	   // -- Create a new message --
	     Message msg = new MimeMessage(session);

	  // -- Set the FROM and TO fields --
	     msg.setFrom(new InternetAddress("py06748@gmail.com"));
		 
	     msg.setRecipients(Message.RecipientType.TO, 
	                      InternetAddress.parse(me.getEmail(),false));
	     msg.setSubject("Registration Notification");
	     msg.setText("Thank u "+me.getName()+" For Register in My Website. Your Registration Email : "+me.getEmail()+" & Password : "+me.getPassword());
	     msg.setSentDate(new Date());
	     Transport.send(msg);
	     
	  }catch (MessagingException e){ System.out.println("Somthing Error, cause: " + e);}
		
	}
}

