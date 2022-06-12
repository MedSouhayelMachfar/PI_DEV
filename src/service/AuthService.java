package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;
import utils.Datasource;

public class AuthService {
	
	// Sign up user
	public static int signUp(User user) throws SQLException {
		Connection con = Datasource.getConnection();
		
		ResultSet rs;
		String selectQuery = "SELECT * FROM USER WHERE email = ?";
		PreparedStatement selectps = con.prepareStatement(selectQuery);
		selectps.setString(1, user.getEmail());
		rs = selectps.executeQuery();
		int errorCode;
		
		if (rs.isBeforeFirst()) {
			errorCode = 2;
			System.out.println("User already exists !");
		} else {
			errorCode = new UserDAOImpl().insert(user);
		}

		Datasource.closeResultSet(rs);
		Datasource.closePreparedStatement(selectps);
		
		return errorCode;
	}
	
	
	// log in user
	public static boolean logInUser(String email, String password) throws SQLException {
		Connection con = Datasource.getConnection();
		
		ResultSet rs;
		String selectQuery = "SELECT * FROM USER WHERE email = ?";
		PreparedStatement selectps = con.prepareStatement(selectQuery);
		selectps.setString(1, email);
		rs = selectps.executeQuery();
		boolean isCorrect = false;
		if (!rs.isBeforeFirst()) {
			System.out.println("User not found in the data base !");
		} else {
			
			while (rs.next()) {
				String retrivedPassword = rs.getString("password");
				if(retrivedPassword.equals(password)) {
					System.out.println("You are logged in !");
					isCorrect = true;
				} else {
					System.out.println("Password did not match !");
				}
			}
		}

		Datasource.closeResultSet(rs);
		Datasource.closePreparedStatement(selectps);
		return isCorrect;
	}
}
