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

import com.stayhealthy.appt.dao.AppointmentDAO;
import com.stayhealthy.appt.dao.DAOFactory;
import com.stayhealthy.appt.model.AppointmentModel;

@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(AppointmentServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");

		logger.info("Calling Appointment DAO for geting List of Appointment.");
		AppointmentDAO appointmentDAO = DAOFactory.getAppointmentDAO();
		List<AppointmentModel> appointmentList = appointmentDAO.getAppointmentList(userId);

		logger.info("Appointment List Size::" + appointmentList.size());

		request.getSession().setAttribute("appointmentList", appointmentList);

		logger.info("Now forwarding to home.jsp");
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
