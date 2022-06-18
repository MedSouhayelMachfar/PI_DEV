package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Utilities
import utils.Datasource;

// Entity
import entity.User;

public class UserDAOImpl implements UserDAO {

	// CRUD - Retrieve
	@Override
	public User get(int id) throws SQLException {
		Connection con = Datasource.getConnection();
		User user = null;

		String sql = "SELECT * FROM user WHERE user_id = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			int userId = rs.getInt("user_id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String email = rs.getString("email");
			String etatC = rs.getString("etat_compte");
			String role = rs.getString("role");
			String image = rs.getString("user_image");

			user = new User.UserBuilder().userId(userId).firstName(firstName).lastName(lastName).email(email).etatCompte(etatC).role(role).user_image(image).build();
		}

		Datasource.closeResultSet(rs);
		Datasource.closePreparedStatement(ps);

		return user;
	}

	// CRUD - Retrieve All
	@Override
	public List<User> getAll() throws SQLException {

		Connection con = Datasource.getConnection();
		String sql = "SELECT * FROM user";

		List<User> users = new ArrayList<>();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(sql);
		User user;
		while (rs.next()) {
			int userId = rs.getInt("user_id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String email = rs.getString("email");
			String etatC = rs.getString("etat_compte");
			String role = rs.getString("role");
			String image = rs.getString("user_image");

			user = new User.UserBuilder().userId(userId).firstName(firstName).lastName(lastName).email(email).etatCompte(etatC).role(role).user_image(image).build();

			users.add(user);
		}

		return users;
	}

	// CRUD - Create or Update
	@Override
	public int save(User employee) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	// CRUD - Create
	@Override
	public int insert(User user) throws SQLException {
		Connection connection = Datasource.getConnection();
		int result = -1;
		if (connection != null) {
			String insertQuery = "INSERT INTO user (first_name, last_name, email, password, etat_compte, role, user_image) VALUES (?, ?, ?, ?, 'inactive', 'user', 'avatar.png')";
			PreparedStatement insertps = connection.prepareStatement(insertQuery);

			insertps.setString(1, user.getFirstName());
			insertps.setString(2, user.getLastName());
			insertps.setString(3, user.getEmail());
			insertps.setString(4, user.getPassword());

			result = insertps.executeUpdate();

			Datasource.closePreparedStatement(insertps);
		}

		return result;
	}

	// CRUD - Update
	@Override
	public int update(User user) throws SQLException {
		Connection connection = Datasource.getConnection();
		int result = -1;
		if (connection != null) {
			if (connection != null) {
				String sql = "UPDATE user set user_id = ?, first_name = ?, last_name = ?, email = ?, etat_compte = ? where id = ?";

				PreparedStatement ps = connection.prepareStatement(sql);

				ps.setInt(1, user.getUserId());
				ps.setString(2, user.getFirstName());
				ps.setString(3, user.getLastName());
				ps.setString(4, user.getEmail());
				ps.setString(5, user.getEtatCompte());

				result = ps.executeUpdate();

				Datasource.closePreparedStatement(ps);
			}
		}
		return result;
	}

	// CRUD - Delete
	@Override
	public int delete(User user) throws SQLException {
		Connection connection = Datasource.getConnection();

		String sql = "DELETE FROM user WHERE id = ?";

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setInt(1, user.getUserId());

		int result = ps.executeUpdate();

		Datasource.closePreparedStatement(ps);

		return result;
	}

}