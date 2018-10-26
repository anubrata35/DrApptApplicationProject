package com.stayhealthy.appt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.Part;
import org.apache.log4j.Logger;
import com.stayhealthy.appt.model.AdminLoginModel;
import com.stayhealthy.appt.model.AppointmentModel;
import com.stayhealthy.appt.model.DrDetailsModel;

public class AdminDAO extends BaseDAO {

	Logger logger = Logger.getLogger(AdminDAO.class);

	public int insertDr(String drName, String apptDay, String apptTime, String status, String specialization,
			String chember, String hospitalName, String language, Part profilePicPart, String contentType) {

		int insertDr = 0;
		AdminLoginModel adminLoginModel = new AdminLoginModel(drName, apptDay, apptTime, status, specialization,
				chember, hospitalName, language, null);

		try {
			getConnection();
			PreparedStatement stmt = con.prepareStatement(
					"insert into drdetails(dr_id, dr_name, appointment_day, appointment_time, dr_status, "
							+ "specialist_of, dr_chember, hospital_name, dr_language, profile_Picture, content_type) "
							+ "values(dr_id.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
			stmt.setString(1, adminLoginModel.getDrName());
			stmt.setString(2, adminLoginModel.getApptDay());
			stmt.setString(3, adminLoginModel.getApptTime());
			stmt.setString(4, adminLoginModel.getStatus());
			stmt.setString(5, adminLoginModel.getSpecialization());
			stmt.setString(6, adminLoginModel.getChember());
			stmt.setString(7, adminLoginModel.getHospitalName());
			stmt.setString(8, adminLoginModel.getLanguage());
			if (profilePicPart != null) {
				stmt.setBlob(9, profilePicPart.getInputStream());
			} else {
				stmt.setBytes(9, new byte[0]);
			}
			stmt.setString(10, contentType);

			insertDr = stmt.executeUpdate();
			logger.info(insertDr + " Rows has been inserted...");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured: " + e);
		}

		closeConnection();
		return insertDr;
	}

	public int updateDr(int drId, String drName, String apptDay, String apptTime, String status, String specialization,
			String chember, String hospitalName, String language) {

		int updateDr = 0;
		AdminLoginModel adminLoginModel = new AdminLoginModel(drId, drName, apptDay, apptTime, status, specialization,
				chember, hospitalName, language);

		try {
			getConnection();
			PreparedStatement stmt = con.prepareStatement(
					"update drdetails set dr_name = ?, appointment_day = ?, appointment_time = ?, dr_status = ?, specialist_of = ?, "
							+ "dr_chember = ?, hospital_name = ?, dr_language = ? where dr_id = ?");
			stmt.setString(1, adminLoginModel.getDrName());
			stmt.setString(2, adminLoginModel.getApptDay());
			stmt.setString(3, adminLoginModel.getApptTime());
			stmt.setString(4, adminLoginModel.getStatus());
			stmt.setString(5, adminLoginModel.getSpecialization());
			stmt.setString(6, adminLoginModel.getChember());
			stmt.setString(7, adminLoginModel.getHospitalName());
			stmt.setString(8, adminLoginModel.getLanguage());
			stmt.setInt(9, drId);

			updateDr = stmt.executeUpdate();
			logger.info(updateDr + " Rows of Dr " + adminLoginModel.getDrName() + " has been updated successfully...");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured: " + e);
		}

		closeConnection();
		return updateDr;
	}

	public int updateDrPicture(int drId, Part profilePicPart, String contentType) {

		int updateDr = 0;
		AdminLoginModel adminLoginModel = new AdminLoginModel(drId, null);

		try {
			getConnection();
			PreparedStatement stmt = con
					.prepareStatement("update drdetails set profile_Picture = ?, content_type = ? where dr_id = ?");

			if (profilePicPart != null) {
				stmt.setBlob(1, profilePicPart.getInputStream());
			} else {
				stmt.setBytes(1, new byte[0]);
			}
			stmt.setString(2, contentType);
			stmt.setInt(3, drId);

			updateDr = stmt.executeUpdate();
			logger.info("Profile picture of Dr " + adminLoginModel.getDrName() + " has been changed successfully...");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occured: " + e);
		}

		closeConnection();
		return updateDr;
	}

	public int deleteDr(int id) {
		getConnection();
		int returnValue = 0;
		try {
			PreparedStatement stmt = con.prepareStatement("delete from DrDetails where dr_id = ?");
			stmt.setInt(1, id);
			returnValue = stmt.executeUpdate();
			logger.info("Dr with id " + id + " has been deleted successfully...");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception Occured: " + e);
		}

		closeConnection();
		return returnValue;
	}

	public int deleteDrFromApptTable(String drName) {
		getConnection();
		int returnValue = 0;
		try {
			PreparedStatement stmt = con.prepareStatement("delete from TAPPOINTMENT_MANAGER where dr_name = ?");
			stmt.setString(1, drName);
			returnValue = stmt.executeUpdate();
			logger.info("Dr with name " + drName + " has been deleted successfully...");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception Occured: " + e);
		}

		closeConnection();
		return returnValue;
	}

	public List<DrDetailsModel> getDrList() {

		ArrayList<DrDetailsModel> drList = new ArrayList<DrDetailsModel>();
		getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from DrDetails");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int drId = rs.getInt("dr_id");
				String drName = rs.getString("dr_name");
				String appointmentDay = rs.getString("appointment_day");
				String appointmentTime = rs.getString("appointment_time");
				String drStatus = rs.getString("dr_status");
				String specialistOf = rs.getString("specialist_of");
				String drChember = rs.getString("dr_chember");
				String hospitalName = rs.getString("hospital_name");
				String drLanguage = rs.getString("dr_language");

				DrDetailsModel drDetailsModel = new DrDetailsModel(drId, drName, appointmentDay, appointmentTime,
						drStatus, specialistOf, drChember, hospitalName, drLanguage);
				drList.add(drDetailsModel);
			}
			logger.info("Fetched all doctors...");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception Occured when fetching Dr list: " + e);
		}
		closeConnection();
		return drList;
	}

	public List<AppointmentModel> getPatientsAppts() {
		ArrayList<AppointmentModel> apptList = new ArrayList<AppointmentModel>();
		getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from TAPPOINTMENT_MANAGER order by fixappt_date");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int incId = rs.getInt("inc_id");
				String patientUserId = rs.getString("USER_ID");
				String patientName = rs.getString("patient_name");
				String drName = rs.getString("dr_name");
				Timestamp bookedAppt = rs.getTimestamp("booked_appt");
				int patientNumber = rs.getInt("patient_number");
				Date fixapptDate = rs.getDate("fixappt_date");

				AppointmentModel appointmentModel = new AppointmentModel(incId, patientNumber, patientUserId,
						patientName, drName, fixapptDate, bookedAppt);
				apptList.add(appointmentModel);
			}
			logger.info("Fetched all appointmentsOfPatients...");
		}

		catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception Occured when fetching patients appt list: " + e);
		}
		closeConnection();
		return apptList;
	}

}
