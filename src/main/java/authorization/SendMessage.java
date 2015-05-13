package authorization;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Multipart;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.*;

public class SendMessage {
	public void sendMessage(String toWho, String subject, String message)
			throws MessagingException {
		Properties mailProps = new Properties();
		mailProps.put("mail.smtp.host", "smtp.mail.ru");
		mailProps.put("username", "team_puzzle@mail.ua");
		mailProps.put("password", "puzart6$2015");
		mailProps.put("mail.smtp.port",465);
		mailProps.put("mail.smtp.auth", "true");
		
//		mailProps.setProperty("mail.transport.protocol", "smtp");
//		mailProps.setProperty("mail.smtp.host", "mail.ca.extmedia.com");
//		mailProps.setProperty("mail.user", "@");
//		mailProps.setProperty("mail.password", "pass");
		
		Session mailSession = Session.getDefaultInstance(mailProps,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						String myEmail = "team_puzzle@mail.ua";
						String passwordMail = "puzart6$2015";
						return (new PasswordAuthentication(myEmail,
								passwordMail));
					}
				});
		MimeMessage mimeMessage = new MimeMessage(mailSession);
		mimeMessage.setFrom(new InternetAddress("email"));
		String[] emails = { toWho, "Diesel31ks@mail.ru" };
		InternetAddress dests[] = new InternetAddress[emails.length];
		for (int i = 0; i < emails.length; i++) {
			dests[i] = new InternetAddress(emails[i].trim().toLowerCase());
		}
		mimeMessage.setRecipients(Message.RecipientType.TO, dests);
		mimeMessage.setSubject("", "KOI8-R");
		Multipart mp = new MimeMultipart();
		MimeBodyPart mbp1 = new MimeBodyPart();
		mbp1.setText(
				" CMSPuzzle-1.0-SNAPSHOT. <a href=\"/CMSPuzzle-1.0-SNAPSHOT/login.jsp\" >Log in</a>",
				"KOI8-R");
		mp.addBodyPart(mbp1);
		mimeMessage.setContent(mp);
		mimeMessage.setSentDate(new java.util.Date());
		Transport.send(mimeMessage);
	}
}
