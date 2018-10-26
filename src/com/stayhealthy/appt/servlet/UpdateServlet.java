package com.stayhealthy.appt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.stayhealthy.appt.dao.DAOFactory;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	Logger logger = Logger.getLogger(UpdateServlet.class);

	private static final long serialVersionUID = 1L;

	protected void customMethod(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		try {

			HttpSession httpSession = request.getSession();
			String userId = (String) httpSession.getAttribute("userId");

			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String password = request.getParameter("password");
			String confirmPassword = request.getParameter("confirmpassword");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");
			String location = request.getParameter("location");
			String birthDate = request.getParameter("bday");
			String phoneNumberString = request.getParameter("phonenumber");
			long phoneNumber = Long.parseLong(phoneNumberString);
			String email = request.getParameter("email");

			if ((firstName == null) || (firstName.trim().length() == 0) || (lastName == null)
					|| (lastName.trim().length() == 0) || (userId == null) || (userId.trim().length() == 0)
					|| (password == null) || (password.trim().length() == 0) || (confirmPassword == null)
					|| (confirmPassword.trim().length() == 0) || (gender == null) || (address == null)
					|| (address.trim().length() == 0) || (location == null) || (birthDate == null)
					|| (birthDate.trim().length() == 0) || (phoneNumber == 0)) {

				request.setAttribute("message", "Please enter all the fields, Do not keep any fields blank...");
				logger.error("Please enter all the fields, Do not keep any fields blank...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AccountDetailsPage.jsp");
				dispatcher.forward(request, response);

			} else if (password.length() != confirmPassword.length() || password.length() < 8) {
				request.setAttribute("message", "Password should be the same and 8 characters long...");
				logger.error("Password should be the same and 8 characters long...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AccountDetailsPage.jsp");
				dispatcher.forward(request, response);
			} else if (email == null) {
				email = "";
			} else if (password.equals(confirmPassword)) {
				int updateValue = DAOFactory.getLoginDAO().updateAccount(phoneNumber, firstName, lastName, userId,
						confirmPassword, gender, address, location, birthDate, email);
				if (updateValue == 1) {
					request.setAttribute("message", "Values successfully updated...");
					logger.error("Your values has been successfully updated...");
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("message", "No values has been updated...");
					logger.error("No values has been updated...");
					RequestDispatcher dispatcher = request.getRequestDispatcher("AccountDetailsPage.jsp");
					dispatcher.forward(request, response);
				}
			} else {

				request.setAttribute("message", "Your password does not match...");
				logger.error("Your password does not match...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AccountDetailsPage.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Phone number and birth date must be in number...");
			logger.error("Numberformat exception occured: " + e);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AccountDetailsPage.jsp");
			dispatcher.forward(request, response);
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
