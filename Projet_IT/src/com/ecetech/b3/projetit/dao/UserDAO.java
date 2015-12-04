package com.ecetech.b3.projetit.dao;

import java.sql.*;
import java.util.ArrayList;

import com.ecetech.b3.projetit.beans.*;
import com.ecetech.b3.projetit.connection.*;
import com.ecetech.b3.projetit.common.*;


public class UserDAO {
	
	private Connection connection;
	private Statement statement;
	private User user;

	public User getUser(int idUser) throws SQLException {
		String query = SQLQueries.GET_USER_QUERY + idUser;
		ResultSet rs = null;
		User user = null;
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				user = new User();
				user.setIdUser(rs.getInt("idUser"));
				user.setMailUser(rs.getString("mailUser"));
				user.setNomUser(rs.getString("nomUser"));
				user.setPasswordUser(rs.getString("passwordUser"));
				user.setOkUser(rs.getBoolean("okUser"));
				user.setAdminUser(rs.getBoolean("adminUser"));
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return user;
	}
}