package com.ecetech.b3.projetit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ecetech.b3.projetit.beans.Event;
import com.ecetech.b3.projetit.common.SQLQueries;
import com.ecetech.b3.projetit.connection.Connector;

public class EventDAO {

	/**
	 * Attributes
	 */
	private Connection connection;
	private Statement statement;

	/**
	 * Constructor
	 */
	public EventDAO() {
	}

	/**
	 * Retrieves a Event from the database and then creates a Category object
	 * to represent it
	 * 
	 * @param event
	 *            An object Event containing the informations sought
	 * @return A Category object with all its attributes from the database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<Event> getEvent(Event event) throws SQLException {
		PreparedStatement req = null;
		String query = SQLQueries.GET_EVENT_QUERY;
		ArrayList<Event> eves = new ArrayList<Event>();
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			if(0 == event.getIdEvent()){
				req.setString(1, "%");
			}else {
				req.setInt(1, event.getIdEvent());
			}
			if(0 == event.getIdCategory()){
				req.setString(2, "%");
			}else {
				req.setInt(2, event.getIdCategory());
			}
			if(0 == event.getIdUser()){
				req.setString(3, "%");
			}else {
				req.setInt(3, event.getIdUser());
			}
			if(null == event.getNameEvent()){
				req.setString(4, "%");
			}else {
				req.setString(4, "%" + event.getNameEvent() + "%");
			}
			if(null == event.getDateEvent()){
				req.setString(5, "%");
			}else {
				req.setString(5, "%" + event.getDateEvent() + "%");
			}
			if(null == event.getPlaceEvent()){
				req.setString(6, "%");
			}else {
				req.setString(6, "%" + event.getPlaceEvent() + "%");
			}
			if(null == event.getContentEvent()){
				req.setString(7, "%");
			}else {
				req.setString(7, "%" + event.getContentEvent() + "%");
			}
			ResultSet rs = req.executeQuery();
			while (rs.next()){
				Event eve = new Event();
				eve.setIdEvent(rs.getInt("idEvent"));
				eve.setIdCategory(rs.getInt("idCategory"));
				eve.setIdUser(rs.getInt("idUser"));
				eve.setNameEvent(rs.getString("nameEvent"));
				eve.setDateEvent(rs.getDate("dateEvent"));
				eve.setPlaceEvent(rs.getString("placeEvent"));
				eve.setContentEvent(rs.getString("contentEvent"));
				eves.add(eve);
			}
		} finally {
			if (req != null)
				req.close();
			connection.close();
		}
		return eves;
	}

	/**
	 * Retrieves all Event from the database and then puts them all in a list
	 * 
	 * @return A list of Event objects with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<Event> getAllEvent() throws SQLException {
		String query = SQLQueries.GET_ALL_EVENT_QUERY;
		ResultSet rs = null;
		ArrayList<Event> eves = new ArrayList<Event>();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				Event eve = new Event();
				eve.setIdEvent(rs.getInt("idEvent"));
				eve.setIdCategory(rs.getInt("idCategory"));
				eve.setIdUser(rs.getInt("idUser"));
				eve.setNameEvent(rs.getString("nameEvent"));
				eve.setDateEvent(rs.getDate("dateEvent"));
				eve.setPlaceEvent(rs.getString("placeEvent"));
				eve.setContentEvent(rs.getString("contentEvent"));
				eves.add(eve);
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return eves;
	}

	/**
	 * Inserts a new Comment into the database
	 * 
	 * @param event
	 *            The Comment to add to the database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void insertEvent(Event event) throws SQLException {
		PreparedStatement req = null;
		String query = SQLQueries.INSERT_EVENT_QUERY;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, event.getIdEvent());
			req.setInt(2, event.getIdCategory());
			req.setInt(3, event.getIdUser());
			req.setString(4, event.getNameEvent());
			req.setDate(5, event.getDateEvent());
			req.setString(6, event.getPlaceEvent());
			req.setString(7, event.getContentEvent());
			req.executeUpdate();
			System.out.println("Eventinserted : ");
			event.display();
		} finally {
			if (req != null)
				req.close();
			connection.close();
		}
	}

	/**
	 * Updates a Event already in the database
	 * 
	 * @param event
	 *            The updated Comment to send to the database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void updateEvent(Event event) throws SQLException {
		PreparedStatement req;
		String query = SQLQueries.UPDATE_EVENT_QUERY;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, event.getIdCategory());
			req.setInt(2, event.getIdUser());
			req.setString(3, event.getNameEvent());
			req.setDate(4, event.getDateEvent());
			req.setString(5, event.getPlaceEvent());
			req.setString(6, event.getContentEvent());
			req.setInt(7, event.getIdEvent());
			req.executeUpdate();
			System.out.println("Event updated :");
			event.display();
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}

	/**
	 * Deletes a Event from the database
	 * 
	 * @param idEvent
	 *            The identifying number of the room to delete
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void deleteEvent(int idEvent) throws SQLException {
		PreparedStatement req;
		String query = SQLQueries.DELETE_EVENT_QUERY;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, idEvent);
			req.executeUpdate();
			System.out.println("Event deleted : " + idEvent);
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}
}



