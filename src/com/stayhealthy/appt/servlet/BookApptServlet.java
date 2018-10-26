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

@WebServlet("/BookApptServlet")
public class BookApptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void customMethod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String selectedDr = request.getParameter("selectDoctor");
		String from = request.getParameter("from");
		if(from!=null){
			System.out.println("Comming from old booked appt list");
			request.setAttribute("from", "true");
		}
		if (selectedDr == null) {
			request.setAttribute("message", "Please select a Dr. for booking an Appointment...");
			request.getRequestDispatcher("BookDrAppointment.jsp").forward(request, response);
		} else {

			AppointmentDAO appointmentDAO = DAOFactory.getAppointmentDAO();
			List<DrDetailsModel> drDetails = appointmentDAO.getDrDetails(selectedDr);

			request.getSession().setAttribute("drDetails", drDetails);
			request.getRequestDispatcher("drDetailsForConfirmAppt.jsp").forward(request, response);
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
