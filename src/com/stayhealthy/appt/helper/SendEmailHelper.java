package com.stayhealthy.appt.helper;

import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import com.stayhealthy.appt.dao.DAOFactory;
import com.stayhealthy.appt.dao.LoginDAO;
import com.stayhealthy.appt.model.SignUpModel;

public class SendEmailHelper {

	public static String sendingMail(String userId, String date, String mailBody) {

		Logger logger = Logger.getLogger(SendEmailHelper.class);

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		logger.info("Properties loaded...");

		String returnMessage = null, emailId = null, userName = null;
		String from = bundle.getString("MAIL_FROM");
		final String password = bundle.getString("MAIL_PASSWORD");

		// Fetching email id for sending confirmation mail
		LoginDAO loginDAO = DAOFactory.getLoginDAO();
		List<SignUpModel> list = loginDAO.getAccountDetails(userId);
		for (SignUpModel model : list) {
			emailId = model.getEmail();
			userName = model.getFirstName() + " " + model.getLastName();
			System.out.println(emailId);
		}

		// Sending email
		String mailSubject = "Confirmation mail";
		String mailText = "Hii, " + userName + ", your appointment on " + date + " " + mailBody
				+ ". We would always like to serve our best services. Thank you for being a part of us...";

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		// compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
			// message.addRecipient(Message.RecipientType.CC,new
			// InternetAddress(cc));
			// message.addRecipient(Message.RecipientType.BCC,new
			// InternetAddress(bcc));

			message.setSubject(mailSubject);
			message.setText(mailText);

			// Send message
			Transport.send(message);
			System.out.println("message sent successfully....");
			logger.info("Confirmation Mail has been sent successfully to " + emailId);
			returnMessage = "SentMail";

		} catch (MessagingException mex) {
			mex.printStackTrace();
			returnMessage = "NotSentMail";
			logger.error(mex + " Exception occured...");
		}
		return returnMessage;
	}

	public static String sendMailFeedbackReply(String clientName, String emailId) {

		Logger logger = Logger.getLogger(SendEmailHelper.class);

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		logger.info("Properties loaded...");
		System.out.println("We are sending email to your email account: " + emailId);

		String returnMessage = null;
		try {

			String from = bundle.getString("MAIL_FROM");
			final String password = bundle.getString("MAIL_PASSWORD");

			// Sending email
			String mailSubject = "Feedback email";
			String mailText = "Hii, " + clientName
					+ ", we value your feedback, We are identifying your problem, please feel free, We will contact you as eaely as possible. Thank you soo muchfor your feedback...";

			// Get the session object
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, password);
				}
			});

			// compose the message

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailId));

			message.setSubject(mailSubject);
			message.setText(mailText);

			// Send message
			Transport.send(message);
			System.out.println("message sent successfully....");
			logger.info("Sent a greatfull email to " + emailId + " after receiving feedback");
			returnMessage = "SentMail";

		} catch (MessagingException mex) {
			mex.printStackTrace();
			returnMessage = "NotSentMail";
			logger.error(mex + " Exception occured...");
		}
		return returnMessage;
	}
}