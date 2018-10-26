package com.stayhealthy.appt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.stayhealthy.appt.helper.SendEmailHelper;
import com.stayhealthy.appt.helper.SendFeedbackMailHelper;

@WebServlet("/CustomarFeedbackServlet")
public class CustomarFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(CustomarFeedbackServlet.class);

	public void CustumMethod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String clientName = request.getParameter("clientName");
		String clientEmail = request.getParameter("emailId");
		String mailSubject = request.getParameter("mailSubject");
		String mailBody = request.getParameter("mailBody");

		try {
			String mobileNumberString = request.getParameter("mobileNumber");
			Long mobileNumber = Long.parseLong(mobileNumberString);

			if ((clientName.trim().length() == 0) || (clientName == null) || (clientEmail.trim().length() == 0)
					|| (clientEmail == null) || (mailSubject.trim().length() == 0) || (mailSubject == null)
					|| (mailBody.trim().length() == 0) || (mailBody == null) || (mobileNumber == 0)) {
				request.setAttribute("message", "Please enter value for all the fields...");
				request.getRequestDispatcher("contactUsPage.jsp").forward(request, response);
			} else {
				try {
					String sendFeedback = SendFeedbackMailHelper.SendFeedback(clientName, clientEmail, mailSubject,
							mailBody);
					if (sendFeedback.equalsIgnoreCase("SentMail")) {
						try {
							String replyFeedback = SendEmailHelper.sendMailFeedbackReply(clientName, clientEmail);
							if (replyFeedback.equalsIgnoreCase("SentMail")) {
								logger.error("Sent reply email after getting feedback...");
								request.getRequestDispatcher("thankYouPageForFeedback.jsp").forward(request, response);
							} else {
								logger.error("Could not reply your email...");
								request.setAttribute("message",
										"We received your mail but Could not reply your email...<br>No need to worry, we will contact you soon over the phone...");
								request.getRequestDispatcher("contactUsPage.jsp").forward(request, response);
							}
						} catch (Exception e) {
							e.printStackTrace();
							logger.error("Thanks for your feedback...");
							request.getRequestDispatcher("thankYouPageForFeedback.jsp").forward(request, response);
						}
					} else {
						logger.error("Did not recieve any feedback...");
						request.setAttribute("message",
								"Could not recieve any feedback, Hope you entered all valid details...");
						request.getRequestDispatcher("contactUsPage.jsp").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("You could not mail us due to : " + e + " error...");
					request.setAttribute("message",
							"We are unable to receive your mail us due to some internal error...");
					request.getRequestDispatcher("contactUsPage.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("Mobile number must be in number: " + e);
			request.setAttribute("message", "Mobile number must be in number...");
			request.getRequestDispatcher("contactUsPage.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustumMethod(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustumMethod(request, response);

	}

}
