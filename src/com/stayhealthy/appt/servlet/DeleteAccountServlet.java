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

@WebServlet("/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
	Logger logger = Logger.getLogger(DeleteAccountServlet.class);
	private static final long serialVersionUID = 1L;

	public void customMethod(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession httpSession = request.getSession();
		String userId = (String) httpSession.getAttribute("userId");
		int deleteAccount = DAOFactory.getLoginDAO().deleteAccount(userId);
		int deleteAllappt = DAOFactory.getAppointmentDAO().deleteAllAppt(userId);

		if ((deleteAccount != 0) && (deleteAllappt != 0)) {
			httpSession.invalidate();
			request.setAttribute("message",
					"Account deleted Successfully and all your appointment has been cancelled...");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			logger.info("User account with booking appointment has been deleted, Deleted rows: " + deleteAccount
					+ deleteAllappt);
		} else if ((deleteAccount != 0) && (deleteAllappt == 0)) {
			httpSession.invalidate();
			request.setAttribute("message", "Account deleted Successfully...");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			logger.info("User account has been deleted, Deleted rows: " + deleteAccount);
		} else {
			request.setAttribute("message", "No records deleted...");
			request.getRequestDispatcher("AccountDetailsPage.jsp").forward(request, response);
			logger.info("No user account has been deleted...");
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
