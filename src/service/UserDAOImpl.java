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

		String sql = "SELECT user_id, first_name, last_name, email, etat_compte FROM user WHERE id = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			int userId = rs.getInt("user_id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String email = rs.getString("email");
			boolean etatC = rs.getBoolean("etatCompte");

			user = new User(userId, firstName, lastName, email, etatC);
		}

		Datasource.closeResultSet(rs);
		Datasource.closePreparedStatement(ps);
		Datasource.closeConnection(con);

		return user;
	}

	// CRUD - Retrieve All
	@Override
	public List<User> getAll() throws SQLException {

		Connection con = Datasource.getConnection();
		String sql = "SELECT user_id, first_name, last_name, email, etat_compte FROM user";

		List<User> users = new ArrayList<>();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int userId = rs.getInt("user_id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String email = rs.getString("email");
			boolean etatC = rs.getBoolean("etat_compte");

			User user = new User(userId, firstName, lastName, email, etatC);

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
		Connection con = Datasource.getConnection();

		String insertQuery = "INSERT INTO user (first_name, last_name, email, password, etat_compte) VALUES (?, ?, ?, ?, 'inactive')";
		PreparedStatement insertps = con.prepareStatement(insertQuery);

		insertps.setString(1, user.getFirstName());
		insertps.setString(2, user.getLastName());
		insertps.setString(3, user.getEmail());
		insertps.setString(4, user.getPassword());

		int result = insertps.executeUpdate();

		Datasource.closePreparedStatement(insertps);		
		return result;
	}

	// CRUD - Update
	@Override
	public int update(User user) throws SQLException {
		Connection connection = Datasource.getConnection();

		String sql = "UPDATE user set user_id = ?, first_name = ?, last_name = ?, email = ?, etat_compte = ? where id = ?";

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setInt(1, user.getUserId());
		ps.setString(2, user.getFirstName());
		ps.setString(3, user.getLastName());
		ps.setString(4, user.getEmail());
		ps.setBoolean(5, user.isEtatCompte());

		int result = ps.executeUpdate();

		Datasource.closePreparedStatement(ps);
		Datasource.closeConnection(connection);

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
		Datasource.closeConnection(connection);

		return result;
	}

}