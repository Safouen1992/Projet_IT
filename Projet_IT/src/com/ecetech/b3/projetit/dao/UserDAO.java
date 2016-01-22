package com.ecetech.b3.projetit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ecetech.b3.projetit.beans.User;
import com.ecetech.b3.projetit.common.SQLQueries;
import com.ecetech.b3.projetit.connection.Connector;

public class UserDAO {

	/**
	 * Attributes
	 */
	private Connection connection;
	private Statement statement;

	/**
	 * Constructor
	 */
	public UserDAO() {
	}

	/**
	 * Retrieves a User from the database which match the query and then creates objects
	 * to represent them
	 * 
	 * @param user
	 *            An object User containing the informations sought
	 * @return A list of User objects with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<User> getUser(User user) throws SQLException {
		PreparedStatement req = null;
		String query = SQLQueries.GET_USER_QUERY;
		ArrayList<User> usrs = new ArrayList<User>();
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			if(0 == user.getIdUser()){
				req.setString(1, "%");
			}else {
				req.setInt(1, user.getIdUser());
			}
			if(null == user.getNameUser()){
				req.setString(2, "%");
			}else {
				req.setString(2, "%" + user.getNameUser() + "%");
			}
			if(null == user.getPasswordUser()){
				req.setString(3, "%");
			}else {
				req.setString(3, "%" + user.getPasswordUser() + "%");
			}
			if(null == user.getMailUser()){
				req.setString(4, "%");
			}else {
				req.setString(4, "%" + user.getMailUser() + "%");
			}
			if(-1 == user.getOkUser()){
				req.setString(5, "%");
			}else {
				req.setInt(5, user.getOkUser());
			}
			if(-1 == user.getAdminUser()){
				req.setString(6, "%");
			}else {
				req.setInt(6, user.getAdminUser());
			}
			ResultSet rs = req.executeQuery();
			while (rs.next()){
				User usr = new User();
				usr.setIdUser(rs.getInt("IdUser"));
				usr.setNameUser(rs.getString("nameUser"));
				usr.setPasswordUser(rs.getString("passwordUser"));
				usr.setMailUser(rs.getString("mailUser"));
				usr.setOkUser(rs.getInt("okUser"));
				usr.setAdminUser(rs.getInt("adminUser"));
				usrs.add(usr);
			}
		} catch(SQLException e){
			usrs.clear();
			User usr = new User();
			usr.setIdUser(-1);
			usrs.add(usr);
		} finally {
			if (req != null)
				req.close();
			if(connection != null)
				connection.close();
		}
		return usrs;
	}

	/**
	 * Retrieves all User from the database and then puts them all in a list
	 * 
	 * @return A list of User objects with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<User> getAllUser() throws SQLException {
		String query = SQLQueries.GET_ALL_USER_QUERY;
		ResultSet rs = null;
		ArrayList<User> usrs = new ArrayList<User>();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				User usr = new User();
				usr.setIdUser(rs.getInt("IdUser"));
				usr.setNameUser(rs.getString("nameUser"));
				usr.setPasswordUser(rs.getString("passwordUser"));
				usr.setMailUser(rs.getString("mailUser"));
				usr.setOkUser(rs.getInt("okUser"));
				usr.setAdminUser(rs.getInt("adminUser"));
				usrs.add(usr);
			}
		} catch(SQLException e){
			usrs.clear();
			User usr = new User();
			usr.setIdUser(-1);
			usrs.add(usr);
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			if(connection != null)
				connection.close();
		}
		return usrs;
	}

	/**
	 * Inserts a new User into the database
	 * 
	 * @param user
	 *            The User to add to the database
	 *@return The number of lines affected by the request
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public int insertUser(User user) throws SQLException {
		int result = -1;
		PreparedStatement req = null;
		String query = SQLQueries.INSERT_USER_QUERY;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, user.getIdUser());
			req.setString(2, user.getNameUser());
			req.setString(3, user.getPasswordUser());
			req.setString(4, user.getMailUser());
			req.setInt(5, user.getOkUser());
			req.setInt(6, user.getAdminUser());
			result = req.executeUpdate();
			System.out.print("User inserted: ");
			user.display();
		} catch(SQLException e){
			result = -1;
		} finally {
			if (req != null)
				req.close();
			if(connection != null)
				connection.close();
		}
		return result;
	}

	/**
	 * Updates a User already in the database
	 * 
	 * @param user
	 *            The User Participate to send to the database
	 *@return The number of lines affected by the request
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public int updateUser(User user) throws SQLException {
		int result = -1;
		PreparedStatement req;
		String query = SQLQueries.UPDATE_USER_QUERY;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setString(1, user.getNameUser());
			req.setString(2, user.getPasswordUser());
			req.setString(3, user.getMailUser());
			req.setInt(4, user.getOkUser());
			req.setInt(5, user.getAdminUser());
			req.setInt(6, user.getIdUser());
			result = req.executeUpdate();
			System.out.print("User updated : ");
			user.display();
		} catch(SQLException e){
			result = -1;
		} finally {
			if (statement != null)
				statement.close();
			if(connection != null)
				connection.close();
		}
		return result;
	}

	/**
	 * Deletes a User from the database
	 * 
	 * @param idUser
	 *            The identifying number of the room to delete
	 *@return The number of lines affected by the request
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public int deleteUser(int idUser) throws SQLException {
		int result = -1;
		PreparedStatement req;
		String query = SQLQueries.DELETE_USER_QUERY;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, idUser);
			result = req.executeUpdate();
			System.out.println("Participate deleted : " + idUser);
		} catch(SQLException e){
			result = -1;
		} finally {
			if (statement != null)
				statement.close();
			if(connection != null)
				connection.close();
		}
		return result;
	}
}

