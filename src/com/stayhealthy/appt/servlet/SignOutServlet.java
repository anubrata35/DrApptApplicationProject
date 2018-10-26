package com.stayhealthy.appt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/SignOutServlet")
public class SignOutServlet extends HttpServlet {

	private static Logger logger = Logger.getLogger(SignOutServlet.class);

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession httpSession = request.getSession();
		String userId = (String) httpSession.getAttribute("userId");
		String admin = (String) httpSession.getAttribute("admin");

		logger.info("User :: " + userId + " is being logged out.");
		logger.info("Admin :: " + admin + " is being logged out.");

		httpSession.invalidate();
		request.setAttribute("message", "You have successfully logged out");
		logger.info("Logged out successfully now.");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
