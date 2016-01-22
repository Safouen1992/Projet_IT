package com.ecetech.b3.projetit.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;


import com.ecetech.b3.projetit.beans.Comment;
import com.ecetech.b3.projetit.dao.CommentDAO;

public class CommentDAOTest {

	
	/**
	 * Test getComment
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGet() throws SQLException {
		Comment cat = new Comment();
		CommentDAO catDAO = new CommentDAO();
		ArrayList<Comment> cats = catDAO.getComment(cat);
		assertEquals( "J'y serais avec 2 potes" , cats.get(0).getContentComment());
	}
	
	/**
	 * Test insertComment
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testInsert() throws SQLException {
		Comment com = new Comment();
		CommentDAO comDAO = new CommentDAO();
		com.setIdComment(3);
		com.setIdParticipate(2);
		com.setContentComment("Moi je propose за");
		int i = comDAO.insertComment(com);
		assertEquals( 1 , i);
		comDAO.deleteComment(3);
	}
	
	/**
	 * Test updateComment
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testUpdate() throws SQLException {
		Comment com = new Comment();
		CommentDAO comDAO = new CommentDAO();
		com.setIdComment(3);
		com.setIdParticipate(2);
		com.setContentComment("Moi je propose за");
		comDAO.insertComment(com);
		com.setContentComment("Jeux de plateaux");
		int i = comDAO.updateComment(com);
		assertEquals( 1 , i);
		comDAO.deleteComment(3);
	}
	
	/**
	 * Test deleteComment
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testDelete() throws SQLException {
		Comment com = new Comment();
		com.setIdComment(3);
		com.setIdParticipate(2);
		com.setContentComment("Moi je propose за");
		CommentDAO comDAO = new CommentDAO();
		comDAO.insertComment(com);
		int i = comDAO.deleteComment(3);
		assertEquals( 1 , i);
	}
	
	/**
	 * Test a transaction
	 * 
	 * @throws SQLException
	 */
	@Test
	public void test() throws SQLException {
		Comment com = new Comment();
		ArrayList<Comment> coms = new ArrayList<Comment>();
		CommentDAO comDAO = new CommentDAO();
		
		comDAO.getComment(com);
		
		com.setIdComment(3);
		com.setIdParticipate(2);
		com.setContentComment("Moi je propose за");
		comDAO.insertComment(com);
		coms = comDAO.getAllComment();
		for(Comment c : coms)
			c.display();
		
		com.setContentComment("moi je propose ceci");
		comDAO.updateComment(com);
		coms = comDAO.getAllComment();
		for(Comment c : coms)
			c.display();
		
		comDAO.deleteComment(com.getIdComment());
		coms = comDAO.getAllComment();
		for(Comment c : coms)
			c.display();
	}

}
