package com.stayhealthy.appt.helper;

import java.util.Properties;
import java.util.ResourceBundle;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import org.apache.log4j.Logger;
import com.sun.mail.smtp.SMTPMessage;

public class SendFeedbackMailHelper {

	public static String SendFeedback(String clientName, String clientEmailId, String mailSubject,
			String mailBody) {

		Logger logger = Logger.getLogger(SendFeedbackMailHelper.class);
		logger.info("Client Email: " + clientEmailId);

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		logger.info("Properties loaded...");

		String returnValue = null;

		String mailfrom = bundle.getString("MAIL_FROM");
		String mailfromPassword = bundle.getString("MAIL_PASSWORD");
		System.out.println("Sending to: " + mailfrom + "\nFrom email id: " + clientEmailId);
		logger.info("Sending to: " + mailfrom + ", From email id: " + clientEmailId);

		// We are using relay.jangosmtp.net for sending emails
		String smtphost = bundle.getString("smtphost");
		System.out.println("SMT Host: " + smtphost);

		// Set properties and their values
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "805");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailfrom, mailfromPassword);
			}
		});

		try {

			SMTPMessage message = new SMTPMessage(session);
			message.setFrom(new InternetAddress(mailfrom));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailfrom));

			message.setSubject(mailSubject);
			message.setText(mailBody);
			message.setNotifyOptions(SMTPMessage.NOTIFY_SUCCESS);
			int returnOption = message.getReturnOption();
			System.out.println("Return Option: " + returnOption);
			Transport.send(message);
			System.out.println("Received feedback");
			returnValue = "SentMail";
			logger.info("Hii, " + clientName + " we have received your valuable comment...");
		} catch (MessagingException e) {
			e.printStackTrace();
			logger.error(e + " Exception occured, Could not received your email");
			returnValue = "NotReceivedFeedback";
		}

		return returnValue;
	}

}
/*
 * try { // set properties values Properties propvals = new Properties();
 * propvals.put("mail.pop3.host", mailTo); propvals.put("mail.pop3.port",
 * "995"); propvals.put("mail.pop3.starttls.enable", "true"); Session
 * emailSessionObj = Session.getDefaultInstance(propvals); // Create POP3 store
 * object and connect with the server Store storeObj =
 * emailSessionObj.getStore("pop3s"); storeObj.connect(mailTo, clientEmailId,
 * password); // Create folder object and open it in read-only mode Folder
 * emailFolderObj = storeObj.getFolder("INBOX");
 * emailFolderObj.open(Folder.READ_ONLY); // Fetch messages from the folder and
 * print in a loop Message[] messageobjs = emailFolderObj.getMessages();
 * 
 * for (int i = 0, n = messageobjs.length; i < n; i++) { Message indvidualmsg =
 * messageobjs[i]; System.out.println("Printing individual messages");
 * System.out.println("No# " + (i + 1)); System.out.println("Email Subject: " +
 * indvidualmsg.getSubject()); System.out.println("Sender: " +
 * indvidualmsg.getFrom()[0]); System.out.println("Content: " +
 * indvidualmsg.getContent().toString());
 * 
 * } // Now close all the objects returnValue = "SentMail";
 * emailFolderObj.close(false); storeObj.close(); } catch
 * (NoSuchProviderException exp) { exp.printStackTrace(); logger.error(exp +
 * " Exception occured..."); } catch (MessagingException mex) {
 * mex.printStackTrace(); logger.error(mex + " Exception occured..."); } catch
 * (Exception ex) { ex.printStackTrace(); logger.error(ex +
 * " Exception occured..."); }
 * 
 * return returnValue; }
 */

/*
 * Properties props = new Properties(); props.put("mail.smtp.host",
 * "smtp.gmail.com"); props.put("mail.smtp.socketFactory.port", "465");
 * props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 * props.put("mail.smtp.auth", "true"); props.put("mail.smtp.port", "465");
 * Session session = Session.getDefaultInstance(props, new
 * javax.mail.Authenticator() { protected PasswordAuthentication
 * getPasswordAuthentication() { return new
 * PasswordAuthentication(clientEmailId, password); } });
 * 
 * // compose the message MimeMessage message = new MimeMessage(session);
 * message.setFrom(new InternetAddress(clientEmailId));
 * message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
 * // message.addRecipient(Message.RecipientType.CC,new // InternetAddress(cc));
 * // message.addRecipient(Message.RecipientType.BCC,new //
 * InternetAddress(bcc));
 * 
 * message.setSubject(mailSubject); message.setText(mailText);
 * 
 * // Send message Transport.send(message);
 * System.out.println("message sent successfully...."); logger.info("Hii, " +
 * clientName + " we riceived your valuable comment..."); returnMessage =
 * "SentMail";
 * 
 * }
 */