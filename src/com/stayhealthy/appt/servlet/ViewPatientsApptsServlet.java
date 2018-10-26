package com.stayhealthy.appt.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.stayhealthy.appt.dao.AdminDAO;
import com.stayhealthy.appt.dao.DAOFactory;
import com.stayhealthy.appt.model.AppointmentModel;

@WebServlet("/ViewPatientsApptsServlet")
public class ViewPatientsApptsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void customMethod(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		AdminDAO adminDAO = DAOFactory.getAdminDAO();
		List<AppointmentModel> getPatientApptDetails = adminDAO.getPatientsAppts();
		request.getSession().setAttribute("patientsApptList", getPatientApptDetails);
		request.getRequestDispatcher("viewPatientApptPage.jsp").forward(request, response);

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
