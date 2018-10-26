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
import com.stayhealthy.appt.model.DrDetailsModel;

@WebServlet("/UpdateDrDetailsServlet")
public class UpdateDrDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(UpdateDrDetailsServlet.class);

	public void customeMethod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession httpSession = request.getSession();
		String selectDoctor = request.getParameter("selectDoctor");

		String sessionData = (String) httpSession.getAttribute("admin");
		if (sessionData == null) {
			request.setAttribute("message", "Your session is timed out. Please, re-login. Thanks.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		System.out.println("Dr name: " + selectDoctor);

		if (selectDoctor == null) {
			request.setAttribute("message", "Please select the Dr you want to Update...");
			request.getRequestDispatcher("EditDrDetailsAdminPage.jsp").forward(request, response);
		} else {
			AppointmentDAO appointmentDAO = DAOFactory.getAppointmentDAO();
			List<DrDetailsModel> getDrDetails = appointmentDAO.getDrDetails(selectDoctor);
			httpSession.setAttribute("drDetails", getDrDetails);
			logger.info("Now forwarding to UpdateDrDetailsPage.jsp");
			request.getRequestDispatcher("updateDrDetailsPage.jsp").forward(request, response);
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
