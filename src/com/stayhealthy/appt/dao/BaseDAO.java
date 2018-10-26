package com.stayhealthy.appt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

public class BaseDAO {

	private static Logger logger = Logger.getLogger(BaseDAO.class);
	private static ResourceBundle bundle = null;

	static {
		bundle = ResourceBundle.getBundle("application");
		logger.info("properties loaded...");

		try {
			Class.forName(bundle.getString("DB_DRIVER"));
		} catch (ClassNotFoundException e) {
			logger.error("ClassNotFoundException occured while loading the driver .", e);
			e.printStackTrace();
		}
	}

	protected Connection con = null;

	protected Connection getConnection() {

		String url = bundle.getString("DB_URL");
		String user = bundle.getString("DB_USER");
		String password = bundle.getString("DB_PASSWORD");
		try {
			con = DriverManager.getConnection(url, user, password);
			logger.info("Connection established.");
		} catch (SQLException e) {
			logger.error("SQLException occured while opening new Connection .", e);
			e.printStackTrace();
		}
		return con;

	}

	protected void closeConnection() {
		try {
			if (!con.isClosed())
				con.close();
		} catch (SQLException e) {
			logger.error("Exception occured while Closing Connection .", e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("Exception occured while Closing Connection .", e);
			e.printStackTrace();
		}

		logger.info("Connection is closed now.");
	}

	public static void main(String[] args) {

		BaseDAO dao = new BaseDAO();

		dao.getConnection();
		dao.closeConnection();

	}

}
