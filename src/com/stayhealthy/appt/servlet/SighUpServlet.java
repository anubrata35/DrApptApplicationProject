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

@WebServlet("/SighUpServlet")
public class SighUpServlet extends HttpServlet {

	Logger logger = Logger.getLogger(SighUpServlet.class);

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String userId = request.getParameter("userid");
			String password = request.getParameter("password");
			String confirmPassword = request.getParameter("confirmpassword");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");
			String location = request.getParameter("location");
			String birthDate = request.getParameter("bday");
			String phoneNumberString = request.getParameter("phonenumber");
			long phoneNumber = Long.parseLong(phoneNumberString);
			String email = request.getParameter("email");
			String checkbox = request.getParameter("checkbox");

			if ((firstName == null) || (firstName.trim().length() == 0) || (lastName == null)
					|| (lastName.trim().length() == 0) || (userId == null) || (userId.trim().length() == 0)
					|| (password == null) || (password.trim().length() == 0) || (confirmPassword == null)
					|| (confirmPassword.trim().length() == 0) || (gender == null) || (address == null)
					|| (address.trim().length() == 0) || (location == null) || (location.equalsIgnoreCase("0"))
					|| (birthDate == null) || (birthDate.trim().length() == 0) || (phoneNumber == 0)) {

				request.setAttribute("message", "Please enter all the fields, Do not keep any fields blank...");
				logger.error("Please enter all the fields, Do not keep any fields blank...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("SignUpPageJsp.jsp");
				dispatcher.forward(request, response);

			} else if (password.length() != confirmPassword.length() || password.length() < 8) {
				request.setAttribute("message", "Password should be the same and 8 characters long...");
				logger.error("Password should be the same and 8 characters long...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("SignUpPageJsp.jsp");
				dispatcher.forward(request, response);
			} else if (checkbox == null) {
				request.setAttribute("message", "You have to accept our terms and conditions...");
				logger.error("You have to accept our terms and conditions...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("SignUpPageJsp.jsp");
				dispatcher.forward(request, response);
			} else if (email == null) {
				email = "";
			} else if (password.equals(confirmPassword)) {
				String signUp = DAOFactory.getLoginDAO().insertUser(phoneNumber, firstName, lastName, userId, password,
						gender, address, location, birthDate, email);
				if (signUp.equalsIgnoreCase("Success")) {

					request.setAttribute("message",
							"Your account has been created succsessfully, <br>Please log in now...");
					logger.info(
							"Hello +" + userId + " your account has been created succsessfully, Please log in now...");
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("message", "The user id is already exist, please try different one...");
					logger.error("The user id is already exist, please try different one...");
					RequestDispatcher dispatcher = request.getRequestDispatcher("SignUpPageJsp.jsp");
					dispatcher.forward(request, response);
				}
			} else {

				request.setAttribute("message", "Your password does not match...");
				logger.error("Your password does not match...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("SignUpPageJsp.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message",
					"Please enter valid information and Phone number, birth date must be in number...");
			logger.error("Numberformat exception occured: " + e);
			RequestDispatcher dispatcher = request.getRequestDispatcher("SignUpPageJsp.jsp");
			dispatcher.forward(request, response);
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
