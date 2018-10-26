package com.stayhealthy.appt.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.stayhealthy.appt.dao.AdminDAO;
import com.stayhealthy.appt.dao.DAOFactory;
import com.stayhealthy.appt.model.DrDetailsModel;

@WebServlet("/ListOfDrForDeleteServlet")
public class ListOfDrForDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(ListOfDrForDeleteServlet.class);

	public void customeMethod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminDAO adminDAO = DAOFactory.getAdminDAO();
		List<DrDetailsModel> drList = adminDAO.getDrList();
		logger.info("Dr list size: " + drList.size());

		request.getSession().setAttribute("drList", drList);
		request.getRequestDispatcher("deleteDr.jsp").forward(request, response);
		logger.info("Dr list is now Forwording to viewAllDrList.jsp page");

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
