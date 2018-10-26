package com.stayhealthy.appt.model;

import java.io.Serializable;
import java.sql.Blob;

public class AdminLoginModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int drId;
	private String drName, apptDay, apptTime, status, specialization, chember, hospitalName, language;
	private Blob profilePic;

	public AdminLoginModel() {

	}

	public AdminLoginModel(int drId, String drName, String apptDay, String apptTime, String status,
			String specialization, String chember, String hospitalName, String language, Blob profilePic) {
		this.drId = drId;
		this.drName = drName;
		this.apptDay = apptDay;
		this.apptTime = apptTime;
		this.status = status;
		this.specialization = specialization;
		this.chember = chember;
		this.hospitalName = hospitalName;
		this.language = language;
		this.profilePic = profilePic;
	}

	public AdminLoginModel(String drName, String apptDay, String apptTime, String status, String specialization,
			String chember, String hospitalName, String language, Blob profilePic) {
		this.drName = drName;
		this.apptDay = apptDay;
		this.apptTime = apptTime;
		this.status = status;
		this.specialization = specialization;
		this.chember = chember;
		this.hospitalName = hospitalName;
		this.language = language;
		this.profilePic = profilePic;
	}

	public AdminLoginModel(int drId, String drName, String apptDay, String apptTime, String status,
			String specialization, String chember, String hospitalName, String language) {
		this.drId = drId;
		this.drName = drName;
		this.apptDay = apptDay;
		this.apptTime = apptTime;
		this.status = status;
		this.specialization = specialization;
		this.chember = chember;
		this.hospitalName = hospitalName;
		this.language = language;
	}

	public AdminLoginModel(int drId, Blob profilePic) {
		this.drId = drId;
		this.profilePic = profilePic;
	}

	public int getDrId() {
		return drId;
	}

	public void setDrId(int drId) {
		this.drId = drId;
	}

	public String getDrName() {
		return drName;
	}

	public void setDrName(String drName) {
		this.drName = drName;
	}

	public String getApptDay() {
		return apptDay;
	}

	public void setApptDay(String apptDay) {
		this.apptDay = apptDay;
	}

	public String getApptTime() {
		return apptTime;
	}

	public void setApptTime(String apptTime) {
		this.apptTime = apptTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getChember() {
		return chember;
	}

	public void setChember(String chember) {
		this.chember = chember;
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

	public Blob getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(Blob profilePic) {
		this.profilePic = profilePic;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
