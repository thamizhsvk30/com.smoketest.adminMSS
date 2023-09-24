package myPages;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
		
	    public static void sendEmail(String recipient, String subject, String body) {
	    

	  
	    	        final String username = "get"; // Replace with your email
	    	        final String password = "9585060295"; // Replace with your password

	    	        Properties props = new Properties();
	    	        props.put("mail.smtp.auth", "true");
	    	        props.put("mail.smtp.starttls.enable", "true");
	    	        props.put("mail.smtp.host", "support@worqhub.com"); // Replace with your SMTP server
	    	        props.put("mail.smtp.port", "587"); // Replace with your SMTP port

	    	        Session session = Session.getInstance(props, new Authenticator() {
	    	            protected PasswordAuthentication getPasswordAuthentication() {
	    	                return new PasswordAuthentication(username, password);
	    	            }
	    	        });

	    	        try {
	    	            Message message = new MimeMessage(session);
	    	            message.setFrom(new InternetAddress(username));
	    	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
	    	            message.setSubject(subject);
	    	            message.setText(body);

	    	            Transport.send(message);
	    	            System.out.println("Email sent successfully.");
	    	        } catch (MessagingException e) {
	    	            throw new RuntimeException(e);
	    	        }
	    }
}
