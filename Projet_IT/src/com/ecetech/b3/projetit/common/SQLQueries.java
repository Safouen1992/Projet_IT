package com.ecetech.b3.projetit.common;

public class SQLQueries {
	
	/*queries for Category*/
	public static final String GET_CATEGORY_QUERY = "SELECT DISTINCT * FROM category WHERE idCategory LIKE ? AND nameCategory LIKE ?";
	public static final String GET_ALL_CATEGORY_QUERY = "SELECT DISTINCT * FROM category";
	public static final String INSERT_CATEGORY_QUERY = "INSERT INTO category (`idCategory`, `nameCategory`) values (?,?)";
	public static final String UPDATE_CATEGORY_QUERY = "UPDATE category SET nameCategory=? WHERE idCategory=?";
	public static final String DELETE_CATEGORY_QUERY = "DELETE FROM category WHERE idCategory=?";
	
	/*queries for Comment*/
	public static final String GET_COMMENT_QUERY = "SELECT DISTINCT * FROM comment WHERE idComment LIKE ? AND idParticipate LIKE ? AND contentComment LIKE ?";
	public static final String GET_ALL_COMMENT_QUERY = "SELECT DISTINCT * FROM comment";
	public static final String INSERT_COMMENT_QUERY = "INSERT INTO comment (`idComment`, `idParticipate`, `contentComment`) values (?,?,?)";
	public static final String UPDATE_COMMENT_QUERY = "UPDATE comment SET contentComment=? WHERE idComment=?";
	public static final String DELETE_COMMENT_QUERY = "DELETE FROM comment WHERE idCategory=?";
	
	/*queries for Event*/
	public static final String GET_EVENT_QUERY = "SELECT DISTINCT * FROM event WHERE idEvent LIKE ? AND idCategory LIKE ? AND idUser LIKE ? AND nameEvent LIKE ? AND dateEvent LIKE ? AND placeEvent LIKE ? AND contentEvent LIKE ?";
	public static final String GET_ALL_EVENT_QUERY = "SELECT DISTINCT * FROM event";
	public static final String INSERT_EVENT_QUERY = "INSERT INTO event (`idEvent`, `idCategory`, `idUser`, `nameEvent`, `dateEvent`, `placeEvent`, `contentEvent`) values (?,?,?,?,?,?,?)";
	public static final String UPDATE_EVENT_QUERY = "UPDATE event SET nameEvent=?, dateEvent=?, placeEvent=?, contentEvent=? WHERE idEvent=?";
	public static final String DELETE_EVENT_QUERY = "DELETE FROM event WHERE idEvent=?";
	
	/*queries for Participate*/
	public static final String GET_PARTICIPATE_QUERY = "SELECT DISTINCT * FROM participate WHERE idParticipate LIKE ? AND idEvent LIKE ? AND idUser LIKE ?";
	public static final String GET_ALL_PARTICIPATE_QUERY = "SELECT DISTINCT * FROM participate";
	public static final String INSERT_PARTICIPATE_QUERY = "INSERT INTO participate (`idParticipate`, `idEvent`, `idUser`) values (?,?,?)";
	public static final String UPDATE_PARTICIPATE_QUERY = "UPDATE participate SET idEvent=?, idUser=? WHERE idParticipate=?";
	public static final String DELETE_PARTICIPATE_QUERY = "DELETE FROM participate WHERE idParticipate=?";
	
	/*queries for User*/
	public static final String GET_USER_QUERY = "SELECT DISTINCT * FROM user WHERE idUser LIKE ? AND nameUser LIKE ? AND passwordUser LIKE ? AND mailUser LIKE ? AND okUser LIKE ? AND adminUser LIKE ?";
	public static final String GET_ALL_USER_QUERY = "SELECT DISTINCT * FROM user";
	public static final String INSERT_USER_QUERY = "INSERT INTO user (`idUser`, `nameUser`, `passwordUser`, `mailUser`, `okUser`, `adminUser`) values (?,?,?,?,?,?)";
	public static final String UPDATE_USER_QUERY = "UPDATE user SET nameUser=?, passwordUser=?, mailUser=?, okUser=?, adminUser=? WHERE idUser=?";
	public static final String DELETE_USER_QUERY = "DELETE FROM user WHERE idUser=?";
}
