package com.ecetech.b3.projetit.common;

public class SQLQueries {
	
	/*queries for Category*/
	public static final String GET_USER_QUERY = "SELECT DISTINCT * FROM 'category' WHERE idCategory = ";
	public static final String GET_ALL_USER_QUERY = "SELECT DISTINCT * FROM 'category'";
	public static final String INSERT_CHAMBRE_QUERY = "INSERT INTO category ('idCategory', 'nomCategory') values (?,?)";
	public static final String UPDATE_USER = "SELECT 'category' SET nomCategory = ? WHERE idCategory = ";
	public static final String DELETE_CHAMBRE_QUERY = "DELETE FROM 'category' WHERE idCategory = ";
	
	/*queries for Comment*/
	
	/*queries for Event*/
	
	/*queries for User*/
	public static final String GET_USER_QUERY = "SELECT DISTINCT * FROM 'user' WHERE idUser = ";
	public static final String GET_ALL_USER_QUERY = "SELECT DISTINCT * FROM 'user'";
	public static final String INSERT_CHAMBRE_QUERY = "INSERT INTO 'user' ('idUser', 'nomUser', 'passwordUser', 'mailUser', 'okUser', 'adminUser') values (?,?,?,?,?,?)";
	public static final String UPDATE_USER = "SELECT 'user' SET mailUser = ?, nomUser = ?, passwordUser = ?, okUser = ?, adminUser = ?, WHERE idUser = ";
	public static final String DELETE_CHAMBRE_QUERY = "DELETE FROM 'user' WHERE idUser = ";
}
?