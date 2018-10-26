package com.stayhealthy.appt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.log4j.Logger;
import com.stayhealthy.appt.dao.DAOFactory;

@WebServlet("/xyz")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxRequestSize = 1024 * 1024 * 32, maxFileSize = 1024 * 124 * 32)
public class InsertDrDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(InsertDrDetailsServlet.class);

	public void customMethod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String drName = request.getParameter("drName");
		String[] apptDay = request.getParameterValues("apptDay");
		String apptTime = request.getParameter("apptTime");
		String drStatus = request.getParameter("drStatus");
		String drSpecialization = request.getParameter("drSpecialization");
		String location = request.getParameter("location");
		String hospitalName = request.getParameter("hospitalName");
		String drLanguage = request.getParameter("drLanguage");

		Part imgagePart = request.getPart("photo");

		System.out.println("File Name =" + imgagePart.getName());
		System.out.println("Content Type =" + imgagePart.getContentType());
		System.out.println("File Size =" + imgagePart.getSize());

		if ((drName.trim().length() == 0) || (drName == null) || (apptDay == null) || (apptTime.trim().length() == 0)
				|| (apptTime == null) || (drStatus.trim().length() == 0) || (apptTime == null)
				|| (drStatus.trim().length() == 0) || (drStatus == null) || (drSpecialization.trim().length() == 0)
				|| (drSpecialization == null) || (location.trim().length() == 0) || (location == null)
				|| (hospitalName.trim().length() == 0) || (hospitalName == null) || (drLanguage.trim().length() == 0)
				|| (drLanguage == null)) {
			request.setAttribute("message", "Please enter all the data about the Dr...");
			request.getRequestDispatcher("insertDrDetailsPage.jsp").forward(request, response);
		} else {

			String drApptDays = "";
			for (String returnValues : apptDay) {
				drApptDays += returnValues + "-";
			}
			if (drApptDays.contains("-")) {
				drApptDays = drApptDays.substring(0, drApptDays.lastIndexOf("-"));
				System.out.println(drApptDays);

				int insertedRows = DAOFactory.getAdminDAO().insertDr(drName, drApptDays, apptTime, drStatus,
						drSpecialization, location, hospitalName, drLanguage, imgagePart, imgagePart.getContentType());
				if (insertedRows == 1) {
					request.setAttribute("message", "Details of the dr has been inserted successfully...");
					request.getRequestDispatcher("AdministratorHomePage.jsp").forward(request, response);
					logger.info("Details of the dr has been inserted successfully...");
				} else {
					request.setAttribute("message", "No record is inserted...");
					request.getRequestDispatcher("AdministratorHomePage.jsp").forward(request, response);
					logger.info("No record is inserted...");
				}
			}
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
