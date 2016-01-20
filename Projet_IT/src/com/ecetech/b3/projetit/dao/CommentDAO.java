package com.ecetech.b3.projetit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ecetech.b3.projetit.beans.Comment;
import com.ecetech.b3.projetit.common.SQLQueries;
import com.ecetech.b3.projetit.connection.Connector;

public class CommentDAO {

	/**
	 * Attributes
	 */
	private Connection connection;
	private Statement statement;

	/**
	 * Constructor
	 */
	public CommentDAO() {
	}

	/**
	 * Retrieves a Comment from the database and then creates a Category object
	 * to represent it
	 * 
	 * @param comment
	 *            An object Comment containing the informations sought
	 * @return A Category object with all its attributes from the database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<Comment> getComment(Comment comment) throws SQLException {
		PreparedStatement req = null;
		String query = SQLQueries.GET_COMMENT_QUERY;
		ArrayList<Comment> coms = new ArrayList<Comment>();
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			if(0 == comment.getIdComment()){
				req.setString(1, "%");
			}else {
				req.setInt(1, comment.getIdComment());
			}
			if(0 == comment.getIdParticipate()){
				req.setString(2, "%");
			}else {
				req.setInt(2, comment.getIdParticipate());
			}
			if(null == comment.getContentComment()){
				req.setString(3, "%");
			}else {
				req.setString(3, "%" + comment.getContentComment() + "%");
			}
			ResultSet rs = req.executeQuery();
			while (rs.next()){
				Comment com = new Comment();
				com.setIdComment(rs.getInt("idComment"));
				com.setIdParticipate(rs.getInt("idParticipate"));
				com.setContentComment(rs.getString("contentComment"));
				coms.add(com);
			}
		} finally {
			if (req != null)
				req.close();
			connection.close();
		}
		return coms;
	}

	/**
	 * Retrieves all Comment from the database and then puts them all in a list
	 * 
	 * @return A list of Comment objects with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<Comment> getAllComment() throws SQLException {
		String query = SQLQueries.GET_ALL_COMMENT_QUERY;
		ResultSet rs = null;
		ArrayList<Comment> coms = new ArrayList<Comment>();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				Comment com = new Comment();
				com.setIdComment(rs.getInt("idComment"));
				com.setIdParticipate(rs.getInt("idParticipate"));
				com.setContentComment(rs.getString("contentComment"));
				coms.add(com);
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return coms;
	}

	/**
	 * Inserts a new Comment into the database
	 * 
	 * @param comment
	 *            The Comment to add to the database
	 *@return The number of lines affected by the request
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public int insertComment(Comment comment) throws SQLException {
		int result = -1;
		PreparedStatement req = null;
		String query = SQLQueries.INSERT_COMMENT_QUERY;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, comment.getIdComment());
			req.setInt(2, comment.getIdParticipate());
			req.setString(3, comment.getContentComment());
			result = req.executeUpdate();
			System.out.print("Comment inserted : ");
			comment.display();
		} finally {
			if (req != null)
				req.close();
			connection.close();
		}
		return result;
	}

	/**
	 * Updates a Comment already in the database
	 * 
	 * @param comment
	 *            The updated Comment to send to the database
	 *@return The number of lines affected by the request
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public int updateComment(Comment comment) throws SQLException {
		int result = -1;
		PreparedStatement req;
		String query = SQLQueries.UPDATE_COMMENT_QUERY;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setString(1, comment.getContentComment());
			req.setInt(2, comment.getIdComment());
			result = req.executeUpdate();
			System.out.print("Comment updated :");
			comment.display();
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
		return result;
	}

	/**
	 * Deletes a Comment from the database
	 * 
	 * @param idComment
	 *            The identifying number of the room to delete
	 *@return The number of lines affected by the request
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public int deleteComment(int idComment) throws SQLException {
		int result = -1;
		PreparedStatement req;
		String query = SQLQueries.DELETE_COMMENT_QUERY;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, idComment);
			result = req.executeUpdate();
			System.out.print("Comment deleted : " + idComment);
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
		return result;
	}
}


