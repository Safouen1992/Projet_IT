package com.ecetech.b3.projetit.beans;

public class User {
	
	/**
	 * Attributes
	 */
	private int idUser;
	private String nameUser;
	private String passwordUser;
	private String mailUser;
	private int okUser;
	private int adminUser;
	
	/**
	 * 
	 * @return The id of an User
	 */
	public int getIdUser() {
		return idUser;
	}
	/**
	 * 
	 * @param idUser The id of an User
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	/**
	 * 
	 * @return The name of an User
	 */
	public String getNameUser() {
		return nameUser;
	}
	/**
	 * 
	 * @param nameUser The name of an User
	 */
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	/**
	 * 
	 * @return The password of an User
	 */
	public String getPasswordUser() {
		return passwordUser;
	}
	/**
	 * 
	 * @param passwordUser The password of an User
	 */
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	/**
	 * 
	 * @return The mail of an User
	 */
	public String getMailUser() {
		return mailUser;
	}
	/**
	 * 
	 * @param mailUser The mail of an User
	 */
	public void setMailUser(String mailUser) {
		this.mailUser = mailUser;
	}
	/**
	 * 
	 * @return integer to see if a User is recognized : 1/yes, 0/no, -1/no value
	 */
	public int getOkUser() {
		return okUser;
	}
	/**
	 * 
	 * @param okUser integer to see if a User is recognized : 1/yes, 0/no, -1/no value
	 */
	public void setOkUser(int okUser) {
		this.okUser = okUser;
	}
	/**
	 * 
	 * @return integer to see if a User is an administrator : 1/yes, 0/no, -1/no value
	 */
	public int getAdminUser() {
		return adminUser;
	}
	/**
	 * 
	 * @param adminUser integer to see if a User is an administrator : 1/yes, 0/no, -1/no value
	 */
	public void setAdminUser(int adminUser) {
		this.adminUser = adminUser;
	}
	
	/**
	 * Constructor
	 * @param idUser
	 * 			The id of an User
	 * @param nameUser
	 * 			The name of an User
	 * @param passwordUser
	 * 			The password of an User
	 * @param mailUser
	 * 			The mail of an User
	 * @param okUser
	 * 			okUser boolean to see if a User is recognized
	 * @param adminUser
	 * 			adminUser boolean to see if a User is an administrator
	 */
	public User(int idUser, String nameUser, String passwordUser, String mailUser, int okUser, int adminUser) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.passwordUser = passwordUser;
		this.mailUser = mailUser;
		this.okUser = okUser;
		this.adminUser = adminUser;
	}
	/**
	 * Constructor null
	 */
	public User() {
		this(0, null, null, null, -1, -1);
	}
	
	/**
	 * Display the attributes of an User
	 */
	public void display() {
		System.out.println("idUser: " + this.idUser + ", nameUser: " + this.nameUser + ", passwordUser: *******" + ", mailUser: "
			+ this.mailUser + ", okUser: " + this.okUser + ", adminUser: " + this.adminUser);
	}
	
}
