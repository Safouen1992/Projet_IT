package com.ecetech.b3.projetit.connection;

import java.sql.*;

public class Connector {

	/**
	 * Attributes
	 */
	private static Connector instance = new Connector();
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/projetit";//37.187.53.240 : adresse de la machine localhost 127.0.0.1
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	/**
	 * Constructor
	 */
	private Connector() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to create a new connection with the defined attributes
	 * 
	 * @return Returns an active connection to the database
	 */
	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to Connect to Database.");
			System.out.println(e);
		}
		return connection;
	}

	/**
	 * Static method to retrieve a new connection
	 * 
	 * @return Returns an active connection to the database
	 */
	public static Connection getConnection() {
		return instance.createConnection();
	}
}