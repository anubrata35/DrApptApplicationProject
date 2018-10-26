package com.stayhealthy.appt.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.stayhealthy.appt.dao.DAOFactory;
import com.stayhealthy.appt.dao.LoginDAO;
import com.stayhealthy.appt.model.SignUpModel;

@WebServlet("/AccountDetailsServlet")
public class AccountDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(AccountDetailsServlet.class);

	protected void customMethod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession httpSession = request.getSession();
		String userID = (String) httpSession.getAttribute("userId");

		logger.info("Calling Account DAO for geting List of Appointment.");

		LoginDAO accountDAO = DAOFactory.getLoginDAO();
		List<SignUpModel> accountDetails = accountDAO.getAccountDetails(userID);

		logger.info("Account List Size::" + accountDetails.size());

		request.getSession().setAttribute("accountDetails", accountDetails);
		logger.info("Now forwarding to AccountDetailsPage.jsp");
		request.getRequestDispatcher("AccountDetailsPage.jsp").forward(request, response);
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
