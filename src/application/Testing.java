package application;

import java.sql.SQLException;

import entity.User;
import service.UserDAOImpl;

public class Testing {

	public static void main(String[] args) {
		UserDAOImpl u1 = new UserDAOImpl();
		User myUser = new User.UserBuilder().userId(1).firstName("malek").lastName("58").build();
		
		try {
			System.out.println(u1.update(myUser));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
