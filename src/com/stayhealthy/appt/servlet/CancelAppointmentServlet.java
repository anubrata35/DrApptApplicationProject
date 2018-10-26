package com.stayhealthy.appt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import com.stayhealthy.appt.dao.AppointmentDAO;
import com.stayhealthy.appt.dao.DAOFactory;
import com.stayhealthy.appt.helper.SendEmailHelper;
import com.stayhealthy.appt.model.AppointmentModel;

@WebServlet("/CancelAppointmentServlet")
public class CancelAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(CancelAppointmentServlet.class);

	public void customMethod(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession httpSession = request.getSession();
		String userId = (String) httpSession.getAttribute("userId");

		String mailBody = "has been cancelled successfully by you";

		try {
			String cancelledApptString = request.getParameter("cancelAppt");
			int cancelledAppt = Integer.parseInt(cancelledApptString);

			String apptScheduledOn = request.getParameter("apptScheduledOn");

			System.out.println("Patient number: " + cancelledAppt + ", Appointment booked on: " + apptScheduledOn);

			if (cancelledAppt <= 0) {
				request.setAttribute("message", "Please select appointment to cancel...");
				request.getRequestDispatcher("home.jsp").forward(request, response);
			} else {
				int deleteAppointment = DAOFactory.getAppointmentDAO().cancelAppontment(cancelledAppt);
				if (deleteAppointment != 0) {
					try {

						// updating session for update user value
						logger.info("Calling Appointment DAO agin for updating List of Appointment...");
						AppointmentDAO appointmentDAO = DAOFactory.getAppointmentDAO();
						List<AppointmentModel> appointmentList = appointmentDAO.getAppointmentList(userId);

						logger.info("Updating Appointment List Size::" + appointmentList.size());

						request.getSession().setAttribute("appointmentList", appointmentList);

						// if main id is null till catch block will execute
						// to book the aapointment
						String mailStatus = SendEmailHelper.sendingMail(userId, apptScheduledOn, mailBody);
						if (mailStatus.equalsIgnoreCase("SentMail"))
							System.out.println(
									"Your appointment has been cancelled successfully, confirmation mail has been sent to you...");
						request.setAttribute("message",
								"Your one appointment has been successfully cancelled<br>Kindly relogin to check it out...");
						request.getRequestDispatcher("home.jsp").forward(request, response);
					} catch (Exception e) {
						request.setAttribute("message",
								"Your one appointment has been successfully cancelled<br>Kindly relogin to check it out...");
						request.getRequestDispatcher("home.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("message", "No appointment has cancelled...");
					request.getRequestDispatcher("home.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Patient number has not been cast to int...");
			request.setAttribute("message", "Please select an appointment that you are going to be cancelled");
			request.getRequestDispatcher("home.jsp").forward(request, response);

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		customMethod(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		customMethod(request, response);

	}

}
