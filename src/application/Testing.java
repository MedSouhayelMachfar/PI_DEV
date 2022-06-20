package application;

import entity.Event;
import java.sql.SQLException;

import entity.User;
import service.EventDAOImp;
import service.UserDAOImpl;

public class Testing {

	public static void main(String[] args) {
		UserDAOImpl u1 = new UserDAOImpl();

		User myUser = new User.UserBuilder().userId(1).firstName("malek").lastName("58").email("saa").password("azeaze").build();
		
		
		 EventDAOImp u2 =new EventDAOImp();
             //   Event myEvent= new Event.EventBuilder().eventId(1).eventName("Event").eventStartDate("2022-03-05").eventEndDate("2022-04-05").eventAgeRange(25).eventAddress("Tunis").eventMaxNumberParticipant(30).eventNumberReservation(25).eventDescription("firsttEvent").userId(1).build();
                
                
                
		try {
			System.out.println(u2.getAll());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
