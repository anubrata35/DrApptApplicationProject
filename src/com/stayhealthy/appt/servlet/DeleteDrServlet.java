package com.stayhealthy.appt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.stayhealthy.appt.dao.DAOFactory;

@WebServlet("/DeleteDrServlet")
public class DeleteDrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(DeleteDrServlet.class);

	public void customMethod(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		try {
			String drIdString = request.getParameter("drId");
			int drId = (int) Integer.parseInt(drIdString);

			String drName = (String) request.getAttribute("drName");

			System.out.println("Dr Name: " + drName + ", Dr Id: " + drId);

			int returnValueForDrId = DAOFactory.getAdminDAO().deleteDr(drId);
			int returnValueForDrName = DAOFactory.getAdminDAO().deleteDrFromApptTable(drName);

			if ((returnValueForDrId != 0) && (returnValueForDrName != 0)) {
				request.setAttribute("message",
						"The Dr's appointments with Dr details are deleted from your account...");
				request.getRequestDispatcher("AdministratorHomePage.jsp").forward(request, response);
				logger.info("The Dr's appointments with Dr details are deleted from your account...");

			} else if ((returnValueForDrId != 0) && (returnValueForDrName == 0)) {
				request.setAttribute("message", "The Dr details are deleted from your account...");
				request.getRequestDispatcher("AdministratorHomePage.jsp").forward(request, response);
				logger.info("The Dr details are deleted from your account...");
			} else {
				request.setAttribute("message", "No Dr is deleted due to internal error, Please contact us...");
				request.getRequestDispatcher("deleteDr.jsp").forward(request, response);
				logger.info("No Dr is deleted due to internal error, Please contact us...");
			}
		} catch (Exception e) {
			request.setAttribute("message", "Please select Dr you want to delete...");
			request.getRequestDispatcher("deleteDr.jsp").forward(request, response);
			e.printStackTrace();
			logger.error("Did not select Dr. " + e + " Exception occured");
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
