package com.ecetech.b3.projetit.beans;

import java.sql.Date;

public class Event {
	
	/**
	 * Attributes
	 */
	private int idEvent;
	private int idCategory;
	private int idUser;
	private String nameEvent;
	private Date dateEvent;
	private String placeEvent;
	private String contentEvent;
	
	/**
	 * 
	 * @return The id of an Event
	 */
	public int getIdEvent() {
		return idEvent;
	}
	/**
	 * 
	 * @param idEvent The id of an Event
	 */
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	/**
	 * 
	 * @return The id of the Category an Event is associated to
	 */
	public int getIdCategory() {
		return idCategory;
	}
	/**
	 * 
	 * @param idCategory The id of the Category an Event is associated to
	 */
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	/**
	 * 
	 * @return The id of the user who created the Event
	 */
	public int getIdUser() {
		return idUser;
	}
	/**
	 * 
	 * @param idUser The id of the user who created the Event
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * 
	 * @return The name  of an event
	 */
	public String getNameEvent() {
		return nameEvent;
	}
	/**
	 * 
	 * @param nameEvent The name  of an event
	 */
	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}
	/**
	 * 
	 * @return The date when an Event will take place
	 */
	public Date getDateEvent() {
		return dateEvent;
	}
	/**
	 * 
	 * @param dateEvent The date when an Event will take place
	 */
	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}
	/**
	 * 
	 * @return The place where an Event will take place
	 */
	public String getPlaceEvent() {
		return placeEvent;
	}
	/**
	 * 
	 * @param placeEvent The place where an Event will take place
	 */
	public void setPlaceEvent(String placeEvent) {
		this.placeEvent = placeEvent;
	}
	/**
	 * 
	 * @return The content of an Event
	 */
	public String getContentEvent() {
		return contentEvent;
	}
	/**
	 * 
	 * @param contentEvent The content of an Event
	 */
	public void setContentEvent(String contentEvent) {
		this.contentEvent = contentEvent;
	}
	
	/**
	 * Constructor
	 * @param idEvent
	 * 			The id of an Event
	 * @param idCategory
	 * 			The id of the Category an Event is associated to
	 * @param idUser
	 * 			The id of the user who created the Event
	 * @param nameEvent
	 * 			The name  of an event
	 * @param dateEvent
	 * 			The date when an Event will take place
	 * @param placeEvent
	 * 			The place where an Event will take place
	 * @param contentEvent
	 * 			The content of an Event
	 */
	public Event(int idEvent, int idCategory, int idUser, String nameEvent, Date dateEvent, String placeEvent,
			String contentEvent) {
		super();
		this.idEvent = idEvent;
		this.idCategory = idCategory;
		this.idUser = idUser;
		this.nameEvent = nameEvent;
		this.dateEvent = dateEvent;
		this.placeEvent = placeEvent;
		this.contentEvent = contentEvent;
	}
	/**
	 * Constructor null
	 */
	public Event() {
		this(0, 0, 0, null, null, null, null);
	}
	
	/**
	 * Display the attributes of an Event
	 */
	public void display() {
		System.out.println("idEvent: " + this.idEvent + ", idCategory: " + this.idCategory + ", idUSer: " + this.idUser + ", nameEvent: " + this.nameEvent +
				", dateEvent: " + this.dateEvent + ", placeEvent: " + this.placeEvent + ", contentEvent: " + this.contentEvent);
	}
	
}
