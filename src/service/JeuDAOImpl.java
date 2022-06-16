package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import entity.Jeu;
import utils.Datasource;



public class JeuDAOImpl implements JeuDAO {
	

	Connection con = Datasource.getConnection();
	@Override
	public Jeu get(int id) throws SQLException {
		Connection con = Datasource.getConnection();
		Jeu Jeu = null;

		String sql = "SELECT id_jeu, nom, categorie_jeu, url_image FROM Jeu WHERE id = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			int JeuId = rs.getInt("id_jeu");
			String name = rs.getString("nom");
			String cat = rs.getString("categorie_jeu");
			String img = rs.getString("url_image");
			
			
			Jeu = new Jeu(JeuId, name, cat,img);
		}

		Datasource.closeResultSet(rs);
		Datasource.closePreparedStatement(ps);

		return Jeu;
	}

	@Override
	public List<Jeu> getAll() throws SQLException {
		Connection con = Datasource.getConnection();
		String sql = "SELECT id_jeu, nom, categorie_jeu, url_image FROM jeu";

		List<Jeu> jeu = new ArrayList<>();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int JeuId = rs.getInt("id_jeu");
			String name = rs.getString("nom");
			String cat = rs.getString("categorie_jeu");
			String img = rs.getString("url_image");

			Jeu Jeu = new Jeu(JeuId, name, cat,img);

			jeu.add(Jeu);
		}

		return jeu;
	}

	@Override
	public int save(Jeu t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Jeu t) throws SQLException {
		Connection con = Datasource.getConnection();

		String sql = "INSERT INTO jeu (id_jeu, nom, categorie_jeu, url_image) VALUES (?, ?, ?, ?)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, t.getID());
		ps.setString(2, t.getTitle());
		ps.setString(3, t.getCategorie());
		ps.setString(4, t.getUrl());

		int result = ps.executeUpdate();

		Datasource.closePreparedStatement(ps);

		return result;
	}

	@Override
	public int update(Jeu t) throws SQLException {
		Connection connection = Datasource.getConnection();

		String sql = "UPDATE jeu set id_jeu = ?, nom = ?, categorie_jeu = ?, url_image = ? where id = ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, t.getID());
		ps.setString(2, t.getTitle());
		ps.setString(3, t.getCategorie());
		ps.setString(4, t.getUrl());

		int result = ps.executeUpdate();
		
		Datasource.closePreparedStatement(ps);
		
		return result;
	}

	@Override
	public int delete(Jeu t) throws SQLException {
		Connection connection = Datasource.getConnection();
		String sql = "DELETE FROM jeu WHERE id = ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, t.getID());
		
		int result = ps.executeUpdate();
		
		Datasource.closePreparedStatement(ps);
		
		return result;
	}

}
