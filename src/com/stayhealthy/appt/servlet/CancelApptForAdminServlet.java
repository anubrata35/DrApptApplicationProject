package com.stayhealthy.appt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.stayhealthy.appt.dao.DAOFactory;

@WebServlet("/CancelApptForAdminServlet")
public class CancelApptForAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(CancelApptForAdminServlet.class);

	public void customMethod(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		try {
			String patientNumber = request.getParameter("selectedAppt");
			int patientNumberId = Integer.parseInt(patientNumber);

			System.out.println("String: " + patientNumber);
			System.out.println("int: " + patientNumberId);

			if (patientNumberId <= 0) {
				request.setAttribute("message", "Please select appointment which you want to cancel...");
				request.getRequestDispatcher("viewPatientApptPage.jsp").forward(request, response);
			} else {
				int deletePatientAppt = DAOFactory.getAppointmentDAO().cancelAppontment(patientNumberId);
				if (deletePatientAppt != 0) {
					System.out.println("Your appointment has been cancelled successfully...");
					request.setAttribute("message",
							"The appointment has been successfully cancelled<br>Kindly relogin to check it out...");
					request.getRequestDispatcher("AdministratorHomePage.jsp").forward(request, response);
				} else {
					request.setAttribute("message", "No appointment has been cancelled...");
					request.getRequestDispatcher("viewPatientApptPage.jsp").forward(request, response);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Did not select any appointment to cancel");
			request.setAttribute("message", "Please select appointment which you want to cancel...");
			request.getRequestDispatcher("viewPatientApptPage.jsp").forward(request, response);
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
