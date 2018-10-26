package com.stayhealthy.appt.dao;

public class DAOFactory {

	private static LoginDAO loginDAO = new LoginDAO();
	private static AppointmentDAO appointmentDAO = new AppointmentDAO();
	private static AdminDAO adminDAO = new AdminDAO();

	public static LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public static AppointmentDAO getAppointmentDAO() {
		return appointmentDAO;
	}
	
	public static AdminDAO getAdminDAO(){
		return adminDAO;
	}

}
