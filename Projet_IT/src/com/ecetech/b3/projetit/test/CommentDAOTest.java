package com.ecetech.b3.projetit.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.b3.projetit.beans.Comment;
import com.ecetech.b3.projetit.beans.User;
import com.ecetech.b3.projetit.dao.CommentDAO;

public class CommentDAOTest {

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
