package com.stayhealthy.appt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stayhealthy.appt.dao.AppointmentDAO;
import com.stayhealthy.appt.dao.DAOFactory;
import com.stayhealthy.appt.model.DrDetailsModel;

@WebServlet("/OnChangeForBookApptServlet")
public class OnChangeForBookApptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void customMethod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String city = request.getParameter("city");
		String hosp = request.getParameter("hospital");

		System.out.println("city : " + city + ", Hospital : " + hosp);

		// make Database call and fetch data.
		AppointmentDAO drAppointmentDAO = DAOFactory.getAppointmentDAO();
		List<DrDetailsModel> drNameList = drAppointmentDAO.getDrForAppointment(city, hosp);

		request.getSession().setAttribute("DrDetailsList", drNameList);
		request.getRequestDispatcher("BookDrAppointment.jsp").forward(request, response);

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
