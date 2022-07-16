package application;

import entity.Event;
import java.sql.SQLException;

import entity.User;
import java.sql.Date;
import service.EventDAOImp;
import service.UserDAOImpl;

public class Testing {

	public static void main(String[] args) {
             //Event event;
		UserDAOImpl u1 = new UserDAOImpl();

		
		 EventDAOImp u2 =new EventDAOImp();
             //   Event myEvent= new Event.EventBuilder().eventId(1).eventName("Event").eventStartDate("2022-03-05").eventEndDate("2022-04-05").eventAgeRange(25).eventAddress("Tunis").eventMaxNumberParticipant(30).eventNumberReservation(25).eventDescription("firsttEvent").userId(1).build();
                
                
                
	
               Event myEvent= new Event.EventBuilder().
                       eventName("Event melek").eventStartDate( new Date (2022-03-05)).
                       eventEndDate( new Date (2022-04-05)).eventAgeRange(15).
                       eventAddress("Tunis").eventMaxNumberParticipant(30).eventNumberReservation(25).
                       eventDescription("firsttnt").userId(1).build();
               
                
                
		try {
                   
                                   //System.out.println(u2.update(event));

               
                        System.out.println(u2.insert(myEvent));
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
