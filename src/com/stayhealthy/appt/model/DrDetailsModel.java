package com.stayhealthy.appt.model;

import java.io.Serializable;

public class DrDetailsModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5279546792849000467L;
	
	private int pId;
	private String drName, appointMentDay, appointMentTime, drStatus, specialization, drChember, language, hospitalName;
	private byte[] profilePicture;
	private String contentType;

	public DrDetailsModel() {

	}

	public DrDetailsModel(int pId, String drName, String appointMentDay, String appointMentTime, String drStatus,
			String specialization, String drChember, String language, byte[] profilePicture) {
		this.pId = pId;
		this.drName = drName;
		this.appointMentDay = appointMentDay;
		this.appointMentTime = appointMentTime;
		this.drStatus = drStatus;
		this.specialization = specialization;
		this.drChember = drChember;
		this.language = language;
		this.profilePicture = profilePicture;
	}

	public DrDetailsModel(int pId, String drName, String appointMentDay, String appointMentTime, String drStatus,
			String specialization, String drChember, String hospitalName, String language) {
		this.pId = pId;
		this.drName = drName;
		this.appointMentDay = appointMentDay;
		this.appointMentTime = appointMentTime;
		this.drStatus = drStatus;
		this.specialization = specialization;
		this.drChember = drChember;
		this.hospitalName = hospitalName;
		this.language = language;
	}

	public DrDetailsModel(int pId, String drName, String appointMentDay, String appointMentTime, String drStatus,
			String specialization, String drChember, String language) {
		this.pId = pId;
		this.drName = drName;
		this.appointMentDay = appointMentDay;
		this.appointMentTime = appointMentTime;
		this.drStatus = drStatus;
		this.specialization = specialization;
		this.drChember = drChember;
		this.language = language;
	}

	public DrDetailsModel(String drName, String appointMentDay, String appointMentTime, String drStatus,
			String specialization, String drChember, String language) {
		this.drName = drName;
		this.appointMentDay = appointMentDay;
		this.appointMentTime = appointMentTime;
		this.drStatus = drStatus;
		this.specialization = specialization;
		this.drChember = drChember;
		this.language = language;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getDrName() {
		return drName;
	}

	public void setDrName(String drName) {
		this.drName = drName;
	}

	public String getAppointMentDay() {
		return appointMentDay;
	}

	public void setAppointMentDay(String appointMentDay) {
		this.appointMentDay = appointMentDay;
	}

	public String getAppointMentTime() {
		return appointMentTime;
	}

	public void setAppointMentTime(String appointMentTime) {
		this.appointMentTime = appointMentTime;
	}

	public String getDrStatus() {
		return drStatus;
	}

	public void setDrStatus(String drStatus) {
		this.drStatus = drStatus;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDrChember() {
		return drChember;
	}

	public void setDrChember(String drChember) {
		this.drChember = drChember;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getContentType() {

		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
