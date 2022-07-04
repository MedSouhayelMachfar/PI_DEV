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
import entity.reservation;

public class ReservationDAOImpl implements ReservationDAO {
    	public static reservation reservationUser;


    @Override
    public reservation get(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<reservation> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int save(reservation t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(reservation reservation) throws SQLException {
         Connection connection = Datasource.getConnection();
        int result = -1;
        if (connection != null) {
            String insertQuery = "INSERT INTO reservation (user_id, event_id) VALUES (?, ?)";
            PreparedStatement insertps = connection.prepareStatement(insertQuery);

       
      
            insertps.setInt(1, EventDAOImp.Event.getEventId());
           
            insertps.setInt(2, AuthService.loggedInUser.getUserId());

            result = insertps.executeUpdate();

            Datasource.closePreparedStatement(insertps);
        }

        return result;
    }

    @Override
    public int update(reservation t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(reservation t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}