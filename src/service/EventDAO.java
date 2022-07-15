/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Event;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author user
 */
public interface EventDAO extends DAO<Event>{
	List<Event> getAllByUserConncet(int id) throws SQLException;


}
