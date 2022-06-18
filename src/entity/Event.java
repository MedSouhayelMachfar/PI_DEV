/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author user
 */


public class Event {
    	// Properties
	private int eventsId;

  
	private String eventsName;
	private Date eventsDate;
	private int eventsDure;
	private String trancheAge;
	private String LienServeur;

        
        
        
          public Event() {
        super ();
    }

    public Event(int eventsId, String eventsName, Date eventsDate, int eventsDure, String trancheAge, String LienServeur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Event{" + "eventsId=" + eventsId + ", eventsName=" + eventsName + ", eventsDate=" + eventsDate + ", eventsDure=" + eventsDure + ", trancheAge=" + trancheAge + ", LienServeur=" + LienServeur + '}';
    }

    public Event(int eventsId, String eventsName, int eventsDure, String trancheAge, String LienServeur) {
        this.eventsId = eventsId;
        this.eventsName = eventsName;
        this.eventsDure = eventsDure;
        this.trancheAge = trancheAge;
        this.LienServeur = LienServeur;
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
    /**
     * @return the eventsId
     */
    public int getEventsId() {
        return eventsId;
    }

    /**
     * @param eventsId the eventsId to set
     */
    public void setEventsId(int eventsId) {
        this.eventsId = eventsId;
    }

    /**
     * @return the eventsName
     */
    public String getEventsName() {
        return eventsName;
    }

    /**
     * @param eventsName the eventsName to set
     */
    public void setEventsName(String eventsName) {
        this.eventsName = eventsName;
    }

    /**
     * @return the eventsDate
     */
    public Date getEventsDate() {
        return eventsDate;
    }

    /**
     * @param eventsDate the eventsDate to set
     */
    public void setEventsDate(Date eventsDate) {
        this.eventsDate = eventsDate;
    }

    /**
     * @return the eventsDure
     */
    public int getEventsDure() {
        return eventsDure;
    }

    /**
     * @param eventsDure the eventsDure to set
     */
    public void setEventsDure(int eventsDure) {
        this.eventsDure = eventsDure;
    }

    /**
     * @return the trancheAge
     */
    public String getTrancheAge() {
        return trancheAge;
    }

    /**
     * @param trancheAge the trancheAge to set
     */
    public void setTrancheAge(String trancheAge) {
        this.trancheAge = trancheAge;
    }

    /**
     * @return the LienServeur
     */
    public String getLienServeur() {
        return LienServeur;
    }

    /**
     * @param LienServeur the LienServeur to set
     */
    public void setLienServeur(String LienServeur) {
        this.LienServeur = LienServeur;
    }

    
}
