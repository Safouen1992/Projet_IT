package com.ecetech.b3.projetit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ecetech.b3.projetit.beans.Participate;
import com.ecetech.b3.projetit.common.SQLQueries;
import com.ecetech.b3.projetit.connection.Connector;

public class ParticipateDAO {

	/**
	 * Attributes
	 */
	private Connection connection;
	private Statement statement;

	/**
	 * Constructor
	 */
	public ParticipateDAO() {
	}

	/**
	 * Retrieves a Participate from the database and then creates a Category object
	 * to represent it
	 * 
	 * @param participate
	 *            An object Participate containing the informations sought
	 * @return A Participate object with all its attributes from the database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<Participate> getParticipate(Participate participate) throws SQLException {
		PreparedStatement req = null;
		String query = SQLQueries.GET_PARTICIPATE_QUERY;
		ArrayList<Participate> pars = new ArrayList<Participate>();
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			if(0 == participate.getIdParticipate()){
				req.setString(1, "%");
			}else {
				req.setInt(1, participate.getIdParticipate());
			}
			if(0 == participate.getIdEvent()){
				req.setString(2, "%");
			}else {
				req.setInt(2, participate.getIdEvent());
			}
			if(0 == participate.getIdUser()){
				req.setString(3, "%");
			}else {
				req.setInt(3, participate.getIdUser());
			}
			ResultSet rs = req.executeQuery();
			while (rs.next()){
				Participate par = new Participate();
				par.setIdParticipate(rs.getInt("idParticipate"));
				par.setIdEvent(rs.getInt("idEvent"));
				par.setIdUser(rs.getInt("idUser"));
				pars.add(par);
			}
		} finally {
			if (req != null)
				req.close();
			connection.close();
		}
		return pars;
	}

	/**
	 * Retrieves all Participate from the database and then puts them all in a list
	 * 
	 * @return A list of Participate objects with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<Participate> getAllParticipate() throws SQLException {
		String query = SQLQueries.GET_ALL_PARTICIPATE_QUERY;
		ResultSet rs = null;
		ArrayList<Participate> pars = new ArrayList<Participate>();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				Participate par = new Participate();
				par.setIdParticipate(rs.getInt("IdParticipate"));
				par.setIdEvent(rs.getInt("IdEvent"));
				par.setIdUser(rs.getInt("IdUser"));
				pars.add(par);
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return pars;
	}

	/**
	 * Inserts a new Participate into the database
	 * 
	 * @param participate
	 *            The Participate to add to the database
	 * @return The number of lines affected by the request
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public int insertParticipate(Participate participate) throws SQLException {
		int result = -1;
		PreparedStatement req = null;
		String query = SQLQueries.INSERT_PARTICIPATE_QUERY;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, participate.getIdParticipate());
			req.setInt(2, participate.getIdEvent());
			req.setInt(3, participate.getIdUser());
			result = req.executeUpdate();
			System.out.print("Participate inserted: ");
			participate.display();
		} finally {
			if (req != null)
				req.close();
			connection.close();
		}
		return result;
	}

	/**
	 * Updates a Participate already in the database
	 * 
	 * @param participate
	 *            The updated Participate to send to the database
	 *@return The number of lines affected by the request
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public int updateParticipate(Participate participate) throws SQLException {
		int result = -1;
		PreparedStatement req;
		String query = SQLQueries.UPDATE_PARTICIPATE_QUERY;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, participate.getIdEvent());
			req.setInt(2, participate.getIdUser());
			req.setInt(3, participate.getIdParticipate());
			result = req.executeUpdate();
			System.out.print("Category updated : ");
			participate.display();
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
		return result;
	}

	/**
	 * Deletes a Participate from the database
	 * 
	 * @param idParticipate
	 *            The identifying number of the room to delete
	 *@return The number of lines affected by the request
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public int deleteParticipate(int idParticipate) throws SQLException {
		int result = -1;
		PreparedStatement req;
		String query = SQLQueries.DELETE_PARTICIPATE_QUERY;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, idParticipate);
			result = req.executeUpdate();
			System.out.println("Participate deleted : " + idParticipate);
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
		return result;
	}
}

