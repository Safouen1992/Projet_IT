package com.ecetech.b3.projetit.beans;

public class Participate {
	
	/**
	 * Attributes
	 */
	private int idParticipate;
	private int idEvent;
	private int idUser;
	
	/**
	 * 
	 * @return The id of the couple Event/User
	 */
	public int getIdParticipate() {
		return idParticipate;
	}
	/**
	 * 
	 * @param idParticipate The id of the couple Event/User
	 */
	public void setIdParticipate(int idParticipate) {
		this.idParticipate = idParticipate;
	}
	/**
	 * 
	 * @return The id of the Event in the couple Event/User
	 */
	public int getIdEvent() {
		return idEvent;
	}
	/**
	 * 
	 * @param idEvent The id of the Event in the couple Event/User
	 */
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	/**
	 * 
	 * @return The id of the User in the couple Event/User
	 */
	public int getIdUser() {
		return idUser;
	}
	/**
	 * 
	 * @param idUSer The id of the User in the couple Event/User
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	/**
	 * Constructor
	 * @param idParticipate
	 * 			The id of the couple Event/User
	 * @param idEvent
	 * 			The id of the Event in the couple Event/User
	 * @param idUSer
	 * 			The id of the User in the couple Event/User
	 */
	public Participate(int idParticipate, int idEvent, int idUser) {
		super();
		this.idParticipate = idParticipate;
		this.idEvent = idEvent;
		this.idUser = idUser;
	}
	/**
	 * Constructor null
	 */
	public Participate() {
		this(0, 0, 0);
	}
	
	/**
	 * Display the attributes of a Participate
	 */
	public void display() {
		System.out.println("idParticipate: " + this.idParticipate + ", idEvent: " + this.idEvent + ", idUser: " + this.idUser);
	}
	
}
