package com.stayhealthy.appt.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class AppointmentModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id, patientNumber;
	private String userID, patientName, drName;
	private Date fixApptDate;
	private Timestamp bookAppt;

	public AppointmentModel() {
	}

	public AppointmentModel(String userID, String patientName, String drName, Date fixApptDate, Timestamp bookAppt) {
		this.userID = userID;
		this.patientName = patientName;
		this.drName = drName;
		this.fixApptDate = fixApptDate;
		this.bookAppt = bookAppt;
	}

	public AppointmentModel(int id, int patientNumber, String userID, String patientName, String drName,
			Date fixApptDate, Timestamp bookAppt) {
		this.id = id;
		this.patientNumber = patientNumber;
		this.userID = userID;
		this.patientName = patientName;
		this.drName = drName;
		this.fixApptDate = fixApptDate;
		this.bookAppt = bookAppt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(int patientNumber) {
		this.patientNumber = patientNumber;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDrName() {
		return drName;
	}

	public void setDrName(String drName) {
		this.drName = drName;
	}

	public Date getFixApptDate() {
		return fixApptDate;
	}

	public void setFixApptDate(Date fixApptDate) {
		this.fixApptDate = fixApptDate;
	}

	public Timestamp getBookAppt() {
		return bookAppt;
	}

	public void setBookAppt(Timestamp bookAppt) {
		this.bookAppt = bookAppt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
