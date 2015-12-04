package com.ecetech.b3.projetit.beans;

public class User {
	private int idUser;
	private String mailUser;
	private String nomUser;
	private String passwordUser;
	private boolean okUser;
	private boolean adminUser;

	/*
	 * builders
	 */
	public User(int idUser, String mailUser, String nomUser, String passwordUser, boolean okUser, boolean adminUser) {
		super();
		this.idUser = idUser;
		this.mailUser = mailUser;
		this.nomUser = nomUser;
		this.passwordUser = passwordUser;
		this.okUser = okUser;
		this.adminUser = adminUser;
	}

	public User() {
		this(0, null, null, null, false, false);
	}

	/*
	 * getters & setters
	 */
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getMailUser() {
		return mailUser;
	}

	public void setMailUser(String mailUser) {
		this.mailUser = mailUser;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public boolean isOkUser() {
		return okUser;
	}

	public void setOkUser(boolean okUser) {
		this.okUser = okUser;
	}

	public boolean isAdminUser() {
		return adminUser;
	}

	public void setAdminUser(boolean adminUser) {
		this.adminUser = adminUser;
	}
}
