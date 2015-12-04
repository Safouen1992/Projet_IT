package com.ecetech.b3.projetit.beans;

import java.util.Date;

public class Event {
	private int idEvent;
	private String contenuEvent;
	private String lieuEvent;
	private String nomEvent;
	private Date dateEvent;
	private int idCategory;
	private int idUser;

	/*
	 * builders
	 */
	public Event(int idEvent, String contenuEvent, String lieuEvent, String nomEvent, Date dateEvent, int idCategory,
			int idUser) {
		super();
		this.idEvent = idEvent;
		this.contenuEvent = contenuEvent;
		this.lieuEvent = lieuEvent;
		this.nomEvent = nomEvent;
		this.dateEvent = dateEvent;
		this.idCategory = idCategory;
		this.idUser = idUser;
	}

	public Event() {
		this(0, null, null, null, null, 0, 0);
	}

	/*
	 * getters & setters
	 */
	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public String getContenuEvent() {
		return contenuEvent;
	}

	public void setContenuEvent(String contenuEvent) {
		this.contenuEvent = contenuEvent;
	}

	public String getLieuEvent() {
		return lieuEvent;
	}

	public void setLieuEvent(String lieuEvent) {
		this.lieuEvent = lieuEvent;
	}

	public String getNomEvent() {
		return nomEvent;
	}

	public void setNomEvent(String nomEvent) {
		this.nomEvent = nomEvent;
	}

	public Date getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
