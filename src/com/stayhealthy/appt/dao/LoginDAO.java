package com.stayhealthy.appt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.stayhealthy.appt.model.SignUpModel;

public class LoginDAO extends BaseDAO {

	Logger logger = Logger.getLogger(LoginDAO.class);

	@SuppressWarnings("finally")
	public String insertUser(long phoneNumber, String firstName, String lastName, String userId, String password,
			String gender, String address, String location, String birtDate, String email) {

		Connection connection = null;
		String returnValue = null;

		try {

			SignUpModel signUp = new SignUpModel(phoneNumber, firstName, lastName, userId, password, gender, address,
					location, birtDate, email);

			connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet checkExshistingUSer = stmt
					.executeQuery("select USER_ID from USERSIGNUP where USER_ID = '" + signUp.getUserId() + "'");
			if (checkExshistingUSer.next()) {
				returnValue = "Unsuccess";
			} else {

				String sql = "insert into USERSIGNUP(PK_ID, FIRST_NAME, LAST_NAME, USER_ID, PASSWORD, GENDER, ADDRESS, LOCATION, BIRTH_DATE, PHONE_NUMBER, EMAIL, ROLL)"
						+ " values( USER_sequence.NEXTVAL,'" + signUp.getFirstName() + "', '" + signUp.getLastName()
						+ "', '" + signUp.getUserId() + "', '" + signUp.getPassword() + "' , '" + signUp.getGender()
						+ "', '" + signUp.getAddress() + "', '" + signUp.getLocation() + "', '" + signUp.getBirtDate()
						+ "', " + signUp.getPhoneNumber() + ", '" + signUp.getEmail() + "', 'USER')";

				System.out.println(sql);
				stmt.executeUpdate(sql);
				returnValue = "Success";
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Sql connection does not established: ");
		} finally {
			closeConnection();
			return returnValue;
		}
	}

	@SuppressWarnings("finally")
	public String LogIn(String userId, String Password) {

		String returnValue = null;
		Connection connection = null;
		try {

			connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("select ROLL, PASSWORD from USERSIGNUP where USER_ID =?");
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String roll = rs.getString("ROLL");
				String password = rs.getString("PASSWORD");
				if (password.equals(Password) && (roll.equalsIgnoreCase("user"))) {
					returnValue = "ValidPasswordForUserLogin";
				} else if (password.equals(Password) && (roll.equalsIgnoreCase("admin"))) {
					returnValue = "ValidPasswordForAdminLogin";
				} else {
					returnValue = "InvalidPassword";
				}
			} else {
				returnValue = "InvalidId";
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {

			}

			closeConnection();
			return returnValue;

		}
	}

	public List<SignUpModel> getAccountDetails(String userID) {

		List<SignUpModel> accountDetailsList = new ArrayList<SignUpModel>();

		Connection con = getConnection();
		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from USERSIGNUP where USER_ID = '" + userID + "'");
			if (rs.next()) {
				String userId = rs.getString("USER_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String password = rs.getString("PASSWORD");
				String gender = rs.getString("GENDER");
				String address = rs.getString("ADDRESS");
				String location = rs.getString("LOCATION");
				String bDay = rs.getString("BIRTH_DATE");
				long phoneNumber = rs.getLong("PHONE_NUMBER");
				String email = rs.getString("EMAIL");

				SignUpModel signUpModel = new SignUpModel(phoneNumber, firstName, lastName, userId, password, gender,
						address, location, bDay, email);
				accountDetailsList.add(signUpModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("SQL Exception occured: " + e);
		}

		closeConnection();
		return accountDetailsList;
	}

	public int updateAccount(long phoneNumber, String firstName, String lastName, String userId, String password,
			String gender, String address, String location, String birtDate, String email) {
		int rs = 0;
		Connection con = getConnection();
		try {

			SignUpModel signUpModel = new SignUpModel(phoneNumber, firstName, lastName, userId, password, gender,
					address, location, birtDate, email);

			PreparedStatement pstmt = con.prepareStatement(
					"update USERSIGNUP set FIRST_NAME = ?, LAST_NAME = ?, PASSWORD = ?, GENDER = ?, ADDRESS = ?, LOCATION = ?, "
							+ "BIRTH_DATE = ?, PHONE_NUMBER = ?, EMAIL = ? where USER_ID = ?");
			pstmt.setString(1, signUpModel.getFirstName());
			pstmt.setString(2, signUpModel.getLastName());
			pstmt.setString(3, signUpModel.getPassword());
			pstmt.setString(4, signUpModel.getGender());
			pstmt.setString(5, signUpModel.getAddress());
			pstmt.setString(6, signUpModel.getLocation());
			pstmt.setString(7, signUpModel.getBirtDate());
			pstmt.setLong(8, signUpModel.getPhoneNumber());
			pstmt.setString(9, signUpModel.getEmail());
			pstmt.setString(10, userId);

			rs = pstmt.executeUpdate();

			/*
			 * Statement stmt = con.createStatement(); rs = stmt.executeUpdate(
			 * "update USERSIGNUP set FIRST_NAME = '" +
			 * signUpModel.getFirstName() + "', LAST_NAME = '" +
			 * signUpModel.getLastName() + "', PASSWORD = '" +
			 * signUpModel.getPassword() + "', GENDER = '" +
			 * signUpModel.getGender() + "', ADDRESS = '" +
			 * signUpModel.getAddress() + "', LOCATION = '" +
			 * signUpModel.getLocation() + "', BIRTH_DATE = '" +
			 * signUpModel.getBirtDate() + "', PHONE_NUMBER = " +
			 * signUpModel.getPhoneNumber() + " where USER_ID = '" +
			 * signUpModel.getUserId() + "'");
			 */
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Sql connection does not established: " + e);
		}

		closeConnection();
		return rs;
	}

	public int deleteAccount(String userId) {

		getConnection();

		int deleteAccount = 0;
		try {
			PreparedStatement stmt = con.prepareStatement("delete from USERSIGNUP where USER_ID = ?");
			stmt.setString(1, userId);
			deleteAccount = stmt.executeUpdate();

		} catch (Exception e) {
			logger.error("Sql connection does not established: " + e.getMessage());
			e.printStackTrace();
		}
		closeConnection();
		return deleteAccount;
	}

}
