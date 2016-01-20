package com.ecetech.b3.projetit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ecetech.b3.projetit.beans.Category;
import com.ecetech.b3.projetit.common.SQLQueries;
import com.ecetech.b3.projetit.connection.Connector;

public class CategoryDAO {

	/**
	 * Attributes
	 */
	private Connection connection;
	private Statement statement;

	/**
	 * Constructor
	 */
	public CategoryDAO() {
	}

	/**
	 * Retrieves a Category from the database and then creates a Category object
	 * to represent it
	 * 
	 * @param category
	 *            An object Category containing the informations sought
	 * @return A Category object with all its attributes from the database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<Category> getCategory(Category category) throws SQLException {
		PreparedStatement req = null;
		String query = SQLQueries.GET_CATEGORY_QUERY;
		ArrayList<Category> cats = new ArrayList<Category>();
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			if(0 == category.getIdCategory()){
				req.setString(1, "%");
			}else {
				req.setInt(1, category.getIdCategory());
			}
			if(null == category.getNameCategory()){
				req.setString(2, "%");
			}else {
				req.setString(2, "%" + category.getNameCategory() + "%");
			}
			ResultSet rs = req.executeQuery();
			while (rs.next()){
				Category cat = new Category();
				cat.setIdCategory(rs.getInt("idCategory"));
				cat.setNameCategory(rs.getString("nameCategory"));
				cats.add(cat);
			}
		} finally {
			if (req != null)
				req.close();
			connection.close();
		}
		return cats;
	}

	/**
	 * Retrieves all Category from the database and then puts them all in a list
	 * 
	 * @return A list of Category objects with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<Category> getAllCategory() throws SQLException {
		String query = SQLQueries.GET_ALL_CATEGORY_QUERY;
		ResultSet rs = null;
		ArrayList<Category> cats = new ArrayList<Category>();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				Category cat = new Category();
				cat.setIdCategory(rs.getInt("idCategory"));
				cat.setNameCategory(rs.getString("nameCategory"));
				cats.add(cat);
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return cats;
	}

	/**
	 * Inserts a new Category into the database
	 * 
	 * @param category
	 *            The Category to add to the database
	 *@return The number of lines affected by the request
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public int insertCategory(Category category) throws SQLException {
		int result = -1;
		PreparedStatement req = null;
		String query = SQLQueries.INSERT_CATEGORY_QUERY;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, category.getIdCategory());
			req.setString(2, category.getNameCategory());
			result = req.executeUpdate();
			System.out.print("Category inserted: ");
			category.display();
		} finally {
			if (req != null)
				req.close();
			connection.close();
		}
		return result;
	}

	/**
	 * Updates a Category already in the database
	 * 
	 * @param category
	 *            The updated Category to send to the database
	 *@return The number of lines affected by the request
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public int updateCategory(Category category) throws SQLException {
		int result = -1;
		PreparedStatement req;
		String query = SQLQueries.UPDATE_CATEGORY_QUERY;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setString(1, category.getNameCategory());
			req.setInt(2, category.getIdCategory());
			result = req.executeUpdate();
			System.out.print("Category updated : ");
			category.display();
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
		return result;
	}

	/**
	 * Deletes a Category from the database
	 * 
	 * @param idCategory
	 *            The identifying number of the room to delete
	 *@return The number of lines affected by the request
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public int deleteCategory(int idCategory) throws SQLException {
		int result = -1;
		PreparedStatement req;
		String query = SQLQueries.DELETE_CATEGORY_QUERY;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, idCategory);
			result = req.executeUpdate();
			System.out.println("Category deleted : " + idCategory);
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
		return result;
	}
}

