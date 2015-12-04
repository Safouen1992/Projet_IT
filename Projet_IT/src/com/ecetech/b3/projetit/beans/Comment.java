package com.ecetech.b3.projetit.beans;

public class Comment {
	private int idComment;
	private String contenuComment;
	private int idEvent;

	/*
	 * builders
	 */
	public Comment(int idComment, String contenuComment, int idEvent) {
		super();
		this.idComment = idComment;
		this.contenuComment = contenuComment;
		this.idEvent = idEvent;
	}

	public Comment() {
		this(0, null, 0);
	}

	/*
	 * getters & setters
	 */
	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public String getContenuComment() {
		return contenuComment;
	}

	public void setContenuComment(String contenuComment) {
		this.contenuComment = contenuComment;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
}
