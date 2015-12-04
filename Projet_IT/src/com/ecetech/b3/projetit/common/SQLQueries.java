package com.ecetech.b3.projetit.common;

public class SQLQueries {
	
	/*queries for Category*/
	
	/*queries for Comment*/
	public static final String GET_Comment_QUERY = "SELECT DISTINCT * FROM `comment` WHERE comment.idComment=";
	public static final String GET_ALL_COMMENT_QUERY = "SELECT DISTINCT * FROM `comment` ";
	public static final String INSERT_COMMENT_QUERY = "INSERT INTO `comment`(`idComment`, `idEvent`, `contenuComment`) VALUES (?,?,?)";
	public static final String UPDATE_COMMENT_QUERY = "UPDATE `comment` SET contenuComment=? WHERE idComment=";
	public static final String DELETE_COMMENT_QUERY = "DELETE FROM `comment` WHERE idComment=";;

	/*queries for Event*/
	
	/*queries for User*/
	public static final String GET_USER_QUERY = "SELECT DISTINCT * FROM 'user' WHERE user.idUser = ";
	public static final String GET_ALL_USER_QUERY = "SELECT DISTINCT * FROM 'user'";
}
