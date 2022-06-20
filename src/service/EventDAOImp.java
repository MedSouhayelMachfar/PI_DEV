/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;



import entity.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.Datasource;

/**
 *
 * @author user
 */
public class EventDAOImp implements EventDAO {

    public Event get(int id) throws SQLException {
        Connection con = Datasource.getConnection();
        Event event = null;

        String sql = "SELECT Id_Events, Nom_Event, Date_Debut, Dure, Tranche_Age,Lien_Serveur FROM evenement WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            int eventsId = rs.getInt("Id_Events");
            String eventsName = rs.getString("Nom_Event");
            Date eventsDate = rs.getDate("Date_Debut");
            int eventsDure = rs.getInt("Dure");
            String trancheAge = rs.getString("Tranche_Age");
            String LienServeur = rs.getString("Lien_Serveur");

            event = new Event(eventsId, eventsName, eventsDate, eventsDure, trancheAge, LienServeur);
        }

        Datasource.closeResultSet(rs);
        Datasource.closePreparedStatement(ps);
        Datasource.closeConnection(con);

        return event;
    }

    @Override
    public List<Event> getAll() throws SQLException {

        Connection con = Datasource.getConnection();
        String sql = "SELECT Id_Events, Nom_Event, Date_Debut, Dure, Tranche_Age,Lien_Serveur FROM evenement";

        List<Event> events = new ArrayList<>();

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int eventsId = rs.getInt("Id_Events");
            String eventsName = rs.getString("Nom_Event");
            Date eventsDate = rs.getDate("Date_Debut");
            int eventsDure = rs.getInt("Dure");
            String trancheAge = rs.getString("Tranche_Age");
            String LienServeur = rs.getString("Lien_Serveur");
            Event event = new Event(eventsId,
                    eventsName, eventsDate, eventsDure, trancheAge, LienServeur);

            events.add(event);
        }

        return events;
    }

    // CRUD - Create or Update
    @Override
    public int save(Event event) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

// CRUD - Create
    @Override
    public int insert(Event event) throws SQLException {
        Connection con = Datasource.getConnection();

        String sql = "INSERT INTO evenement (Id_Events, Nom_Event, Date_Debut, Dure, Tranche_Age,Lien_Serveur) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, event.getEventsId());
        ps.setString(2, event.getEventsName());
        ps.setDate(3, (java.sql.Date) event.getEventsDate());
        ps.setInt(4, event.getEventsDure());

        ps.setString(6, event.getTrancheAge());
        ps.setString(6, event.getLienServeur());

        int result = ps.executeUpdate();

        Datasource.closePreparedStatement(ps);
        Datasource.closeConnection(con);

        return result;
    }
// CRUD - Update

    @Override
    public int update(Event event) throws SQLException {
        Connection connection = Datasource.getConnection();

        String sql = "UPDATE evenement set Id_Events = ?, Nom_Event = ?, Date_Debut = ?, Dure = ?, Tranche_Age = ?, Lien_Serveur = ? where id = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, event.getEventsId());
        ps.setString(2, event.getEventsName());
        ps.setDate(3, (java.sql.Date) event.getEventsDate());
        ps.setInt(4, event.getEventsDure());

        ps.setString(6, event.getTrancheAge());
        ps.setString(6, event.getLienServeur());

        int result = ps.executeUpdate();

        Datasource.closePreparedStatement(ps);
        Datasource.closeConnection(connection);

        return result;
    }

    // CRUD - Delete
    @Override
    public int delete(Event event) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
