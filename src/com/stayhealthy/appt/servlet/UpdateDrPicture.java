package com.stayhealthy.appt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.log4j.Logger;
import com.stayhealthy.appt.dao.DAOFactory;

@WebServlet("/UpdateDrPicture")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxRequestSize = 1024 * 1024 * 32, maxFileSize = 1024 * 124 * 32)

public class UpdateDrPicture extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(UpdateDrPicture.class);

	public UpdateDrPicture() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession httpSession = request.getSession();
		int drPrimaryId = (int) httpSession.getAttribute("DrPrimaryId");

		System.out.println("Dr id: " + drPrimaryId);

		Part imgagePart = request.getPart("photo");

		System.out.println("File Name =" + imgagePart.getName());
		System.out.println("Content Type =" + imgagePart.getContentType());
		System.out.println("File Size =" + imgagePart.getSize());

		int updatePicture = DAOFactory.getAdminDAO().updateDrPicture(drPrimaryId, imgagePart,
				imgagePart.getContentType());
		if (updatePicture != 0) {
			request.setAttribute("message", "Dr profile Picture has been successfully changed...");
			request.getRequestDispatcher("AdministratorHomePage.jsp").forward(request, response);
			logger.info("Dr profile Picture has been successfully changed...");
		} else {
			request.setAttribute("message", "No Dr's profile Picture has been changed...");
			request.getRequestDispatcher("AdministratorHomePage.jsp").forward(request, response);
			logger.info("No Dr's profile Picture has been changed...");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
