package com.stayhealthy.appt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import com.stayhealthy.appt.helper.DateHelper;
import com.stayhealthy.appt.model.AppointmentModel;
import com.stayhealthy.appt.model.DrDetailsModel;

public class AppointmentDAO extends BaseDAO {

	private static Logger logger = Logger.getLogger(AppointmentDAO.class);

	public List<AppointmentModel> getAppointmentList(String userId) {

		List<AppointmentModel> listofAppointments = new ArrayList<AppointmentModel>();
		Connection con = getConnection();

		String sql = "select * from TAPPOINTMENT_MANAGER where USER_ID = '" + userId + "'";

		logger.debug("SQL for Appintment " + sql);
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("inc_id");
				String patient_name = rs.getString("patient_name");
				String dr_name = rs.getString("dr_name");
				Timestamp booked_appt = rs.getTimestamp("booked_appt");
				int patient_number = rs.getInt("patient_number");
				Date fixappt_date = rs.getDate("fixappt_date");

				AppointmentModel appointmentModel = new AppointmentModel(id, patient_number, userId, patient_name,
						dr_name, fixappt_date, booked_appt);
				listofAppointments.add(appointmentModel);
			}
		} catch (SQLException e) {
			logger.error("SQLException occured while fetching apppointment .", e);
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("Exception occured while fetching apppointment .", e);
		}

		closeConnection();

		return listofAppointments;

	}

	public List<DrDetailsModel> getDrForAppointment(String cityName, String hosp) {

		List<DrDetailsModel> listofDoctors = new ArrayList<DrDetailsModel>();

		getConnection();

		try {
			Statement stmt = con.createStatement();
			String sql = "select * from DrDetails where 1=1 ";

			if (cityName != null)
				sql = sql + " AND dr_chember = '" + cityName + "'";

			if (hosp != null)
				sql = sql + " and hospital_name ='" + hosp + "' ";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int drId = rs.getInt("dr_id");
				String drName = rs.getString("dr_name");
				String appointmentDay = rs.getString("appointment_day");
				String appointmentTime = rs.getString("appointment_time");
				String drStatus = rs.getString("dr_status");
				String specialistOf = rs.getString("specialist_of");
				String drChember = rs.getString("dr_chember");
				String drLanguage = rs.getString("dr_language");

				DrDetailsModel detailsModel = new DrDetailsModel(drId, drName, appointmentDay, appointmentTime,
						drStatus, specialistOf, drChember, drLanguage);
				listofDoctors.add(detailsModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while fetching docotrs name .", e);
		}

		closeConnection();
		return listofDoctors;

	}

	public List<DrDetailsModel> getDrDetails(String dr) {
		List<DrDetailsModel> arrayList = new ArrayList<DrDetailsModel>();

		try {
			getConnection();
			PreparedStatement pStmt = con.prepareStatement("select * from DrDetails where dr_name = ?");
			pStmt.setString(1, dr);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int drId = rs.getInt("dr_id");
				String drName = rs.getString("dr_name");
				String appointmentDay = rs.getString("appointment_day");
				String appointmentTime = rs.getString("appointment_time");
				String drStatus = rs.getString("dr_status");
				String specialistOf = rs.getString("specialist_of");
				String drChember = rs.getString("dr_chember");
				String hospitalName = rs.getString("HOSPITAL_NAME");
				String drLanguage = rs.getString("dr_language");

				byte[] image = rs.getBytes("PROFILE_PICTURE");

				DrDetailsModel drDetailsModel = new DrDetailsModel(drId, drName, appointmentDay, appointmentTime,
						drStatus, specialistOf, drChember, hospitalName, drLanguage);

				drDetailsModel.setProfilePicture(image);
				arrayList.add(drDetailsModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while fetching docotrs name .", e);
		}

		closeConnection();
		return arrayList;
	}

	public String bookingAppointment(String userId, String patientName, String drName, Timestamp bookedAppt,
			Date fixApptDate) {
		PreparedStatement stmt = null;
		String returnString = null;

		AppointmentModel appointmentModel = new AppointmentModel(userId, patientName, drName, fixApptDate, bookedAppt);

		String sql = "insert into TAPPOINTMENT_MANAGER(inc_id, USER_ID," + " patient_name, dr_name, "
				+ " booked_appt, patient_number, fixappt_date)" + "values(appointmentIncrement_id.nextval, '"
				+ appointmentModel.getUserID() + "', '" + appointmentModel.getPatientName() + "', " + "'"
				+ appointmentModel.getDrName() + "', ? , patientNumberSeq.nextval, ?)";

		try {

			getConnection();

			PreparedStatement checkingDuplicateAppt = con.prepareStatement(
					"select patient_name, dr_name from TAPPOINTMENT_MANAGER where USER_ID = ? and to_char(fixappt_date ,'YYYY-MM-dd') = '"
							+ DateHelper.getDateInformat(appointmentModel.getFixApptDate()) + "'");
			checkingDuplicateAppt.setString(1, appointmentModel.getUserID());
			System.out.println(
					"Checking fetchig date: " + new java.sql.Date(appointmentModel.getFixApptDate().getTime()));
			ResultSet result = checkingDuplicateAppt.executeQuery();
			if (result.next()) {
				String patientNameCheck = result.getString("patient_name");
				String drNameCheck = result.getString("dr_name");

				if (patientNameCheck.equalsIgnoreCase(appointmentModel.getPatientName())
						&& (drNameCheck.equalsIgnoreCase(appointmentModel.getDrName()))) {
					returnString = "UnsuccessSameEntry";// Already booked an
														// appointment of same
														// date
					logger.error("Already booked an appointment of same date...");
					System.err.println("Already booked an appointment of same date...");
				}
			} else {
				Statement countCheckSQL = con.createStatement();
				String countSQL = "select count(patient_name) from TAPPOINTMENT_MANAGER "
						+ " where to_char( fixappt_date ,'YYYY-MM-dd') = '"
						+ DateHelper.getDateInformat(appointmentModel.getFixApptDate()) + "'";

				System.out.println(countSQL);
				ResultSet rs = countCheckSQL.executeQuery(countSQL);
				if (rs.next()) {
					int patientNameResult = rs.getInt(1);
					System.out.println("Patient Number is: " + patientNameResult + " for the day: "
							+ appointmentModel.getFixApptDate());
					logger.error("Patient number: " + patientNameResult);
					if (patientNameResult <= 12) {
						stmt = con.prepareStatement(sql);
						System.out.println(sql);
						stmt.setTimestamp(1, appointmentModel.getBookAppt());
						stmt.setDate(2, new java.sql.Date(appointmentModel.getFixApptDate().getTime()));

						stmt.executeUpdate();
						logger.info("Patient number is less than 12, booking appointment...");

						returnString = "Success";
					} else {
						returnString = "Unsuccess";// Choose another day,
													// patient
						// names are full for that day
						logger.error("Patient is full, select another date...");
					}
				} else {
					stmt = con.prepareStatement(sql);
					System.out.println(sql);
					stmt.setTimestamp(1, appointmentModel.getBookAppt());
					stmt.setDate(2, new java.sql.Date(appointmentModel.getFixApptDate().getTime()));

					stmt.executeUpdate();
					returnString = "Success";
					logger.info("Booking an appointment with new date...");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while fetching patientNumber .", e);
		}

		return returnString;
	}

	public int cancelAppontment(int patientNumber) {
		getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = con.prepareStatement("delete from TAPPOINTMENT_MANAGER where patient_number = ?");
			stmt.setInt(1, patientNumber);
			rs = stmt.executeUpdate();
			logger.info("Cancelled an appointment with the patient number " + patientNumber);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while deleting an appointment " + e);
		}

		closeConnection();
		return rs;
	}

	public int deleteAllAppt(String userId) {
		getConnection();
		int deleteAllappt = 0;
		try {
			PreparedStatement stmt = con.prepareStatement("delete from TAPPOINTMENT_MANAGER where USER_ID = ?");
			stmt.setString(1, userId);
			deleteAllappt = stmt.executeUpdate();
			logger.info("Deleted all appoints with the user id " + userId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured while deleting appointment " + e);
		}

		closeConnection();
		return deleteAllappt;
	}
}
