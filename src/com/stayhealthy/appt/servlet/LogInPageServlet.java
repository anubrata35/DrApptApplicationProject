package com.stayhealthy.appt.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.stayhealthy.appt.dao.DAOFactory;

@WebServlet("/LogInPageServlet")
public class LogInPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LogInPageServlet.class);

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("userId");
		String password = request.getParameter("password");

		if ((id.trim().length() == 0) || (id == null) || (password.trim().length() == 0) || (password == null)) {
			request.setAttribute("message", "Please enter your existing id and password to log in");
			logger.error("Please enter your existing id and password...");

			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} else {
			String logIn = DAOFactory.getLoginDAO().LogIn(id, password);
			if (logIn.equalsIgnoreCase("InvalidId")) {
				request.setAttribute("message", "Invalid user id..If you do not have account please sign up now");
				logger.error("Invalid user id:" + id + "If you do not have account please sign up now");

				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			} else if (logIn.equalsIgnoreCase("InvalidPassword")) {
				request.setAttribute("message",
						"Sorry, your password does not match ...</br>Please, enter valid password");

				logger.error(
						"Sorry, your password does not match for User :" + id + "...</br>Please, enter valid password");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			} else if (logIn.equalsIgnoreCase("ValidPasswordForAdminLogin")) {
				request.getSession().setAttribute("admin", id);
				logger.info("Admin :" + id
						+ "successfully logged in with admin credential, now going to admin's home page...");
				request.getRequestDispatcher("AdministratorHomePage.jsp").forward(request, response);
			} else {
				request.getSession().setAttribute("userId", id);

				logger.info("User :" + id
						+ "logged in successfully Now.  go to home page with appointment details values...");
				request.getRequestDispatcher("./AppointmentServlet").forward(request, response);
			}
		}

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
