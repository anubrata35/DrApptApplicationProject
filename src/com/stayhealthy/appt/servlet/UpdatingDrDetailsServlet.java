package com.stayhealthy.appt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.stayhealthy.appt.dao.DAOFactory;

@WebServlet("/UpdatingDrDetailsServlet")
public class UpdatingDrDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(UpdatingDrDetailsServlet.class);

	public void customeMethod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession httpSession = request.getSession();
		int drPrimaryId = (int) httpSession.getAttribute("DrPrimaryId");

		String drName = request.getParameter("drName");
		String apptDay = request.getParameter("apptDay");
		String apptTime = request.getParameter("apptTime");
		String drStatus = request.getParameter("drStatus");
		String drSpecialization = request.getParameter("drSpecialization");
		String location = request.getParameter("location");
		String hospitalName = request.getParameter("hospitalName");
		String drLanguage = request.getParameter("drLanguage");

		if ((drName.trim().length() == 0) || (drName == null) || (apptDay.trim().length() == 0) || (apptDay == null)
				|| (apptTime.trim().length() == 0) || (apptTime == null) || (drStatus.trim().length() == 0)
				|| (apptTime == null) || (drStatus.trim().length() == 0) || (drStatus == null)
				|| (drSpecialization.trim().length() == 0) || (drSpecialization == null)
				|| (location.trim().length() == 0) || (location == null) || (hospitalName.trim().length() == 0)
				|| (hospitalName == null) || (drLanguage.trim().length() == 0) || (drLanguage == null)) {
			request.setAttribute("message", "Please Do not keep any fields blank...");
			request.getRequestDispatcher("updateDrDetailsPage.jsp").forward(request, response);
		} else {

			int insertedRows = DAOFactory.getAdminDAO().updateDr(drPrimaryId, drName, apptDay, apptTime, drStatus,
					drSpecialization, location, hospitalName, drLanguage);
			if (insertedRows != 0) {
				request.setAttribute("message", "Dr details has been updated successfully...");
				request.getRequestDispatcher("AdministratorHomePage.jsp").forward(request, response);
				logger.info("Dr details has been updated successfully by the Id " + drPrimaryId + " ...");
			} else {
				request.setAttribute("message", "No record is updated of selected Dr...");
				request.getRequestDispatcher("AdministratorHomePage.jsp").forward(request, response);
				logger.info("No record is updated of Dr " + drName + " ...");
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
