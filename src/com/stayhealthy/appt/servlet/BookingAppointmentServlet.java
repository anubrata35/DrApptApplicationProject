package com.stayhealthy.appt.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
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
import com.stayhealthy.appt.helper.DateHelper;
import com.stayhealthy.appt.helper.SendEmailHelper;
import com.stayhealthy.appt.model.AppointmentModel;

@WebServlet("/BookingAppointmentServlet")
public class BookingAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(BookingAppointmentServlet.class);

	protected void customeMethod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String drApptDay = (String) session.getAttribute("drApptDay");
		String userId = (String) session.getAttribute("userId");
		String drName = (String) session.getAttribute("drName");
		String patientName = request.getParameter("patientName");
		String apptDate = request.getParameter("apptDate");
		Timestamp bookedAppt = new Timestamp(System.currentTimeMillis());

		String mailBody = "has been booked successfully";

		System.out.println(request.getParameter("apptDate"));
		System.out.println("Dr Appointment Day: " + drApptDay);
		System.out.println(request.getParameter("patientName"));

		if ((patientName.trim().length() == 0) || (patientName == null)) {
			request.setAttribute("message", "Please enter the name of the patient...");
			request.getRequestDispatcher("drDetailsForConfirmAppt.jsp").forward(request, response);
		} else if (apptDate == null) {
			request.setAttribute("message", "Please select the appointment date...");
			request.getRequestDispatcher("drDetailsForConfirmAppt.jsp").forward(request, response);
		} else {

			try {
				Date date = DateHelper.getAppointmentDate(apptDate);

				String dayofweek = DateHelper.getDayofWeek(date);
				System.out.println("User trying to book on " + dayofweek);
				if (drApptDay != null && drApptDay.toUpperCase().contains(dayofweek)) {

					System.out.println("1: Date: " + date);
					String returnString = DAOFactory.getAppointmentDAO().bookingAppointment(userId, patientName, drName,
							bookedAppt, date);

					// updating session for update user value
					logger.info("Calling Appointment DAO agin for updating List of Appointment...");
					AppointmentDAO appointmentDAO = DAOFactory.getAppointmentDAO();
					List<AppointmentModel> appointmentList = appointmentDAO.getAppointmentList(userId);

					logger.info("Updating Appointment List Size::" + appointmentList.size());

					request.getSession().setAttribute("appointmentList", appointmentList);

					if (returnString.equalsIgnoreCase("Success")) {
						try {
							// if main id is null till catch block will execute
							// to book the aapointment
							String mailStatus = SendEmailHelper.sendingMail(userId, apptDate, mailBody);
							if (mailStatus.equalsIgnoreCase("SentMail"))
								System.out.println(
										"Your appointment has been booked successfully, confirmation mail has been sent to you...");
							request.getRequestDispatcher("thankYouPage.jsp").forward(request, response);
						} catch (Exception e) {
							request.setAttribute("message", "Your appointment has been booked successfully...");
							request.getRequestDispatcher("thankYouPage.jsp").forward(request, response);
						}
						System.out.println("2");
					} else if (returnString.equalsIgnoreCase("UnsuccessSameEntry")) {
						request.setAttribute("message", "Already booked an appointment of same date...");
						request.getRequestDispatcher("drDetailsForConfirmAppt.jsp").forward(request, response);
					} else {
						request.setAttribute("message",
								"Patient list is full,<br>Please select another day for appointment...");
						request.getRequestDispatcher("drDetailsForConfirmAppt.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("message",
							"Please select valid day for appointment,<br>The Doctor you selected is not available that day...");
					request.getRequestDispatcher("drDetailsForConfirmAppt.jsp").forward(request, response);
				}
			} catch (Exception e) {
				request.setAttribute("message", "Error has occured, Please select valid date or refresh the page...");
				request.getRequestDispatcher("drDetailsForConfirmAppt.jsp").forward(request, response);
				e.printStackTrace();
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		customeMethod(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		customeMethod(request, response);
	}

}
