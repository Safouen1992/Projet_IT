package com.ecetech.b3.projetit.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.b3.projetit.beans.User;
import com.ecetech.b3.projetit.dao.UserDAO;

public class UserDAOTest {

	/**
	 * Test getUser
	 * @throws SQLException	
	 */
	@Test
	public void testGet() throws SQLException {
		User usr = new User();
		UserDAO usrDAO = new UserDAO();
		ArrayList<User> usrs = usrDAO.getUser(usr);
		assertEquals( "Pierre" , usrs.get(0).getNameUser());
	}
	
	/**
	 * Test insertUser
	 * @throws SQLException
	 */
	@Test
	public void testInsert() throws SQLException {
		User usr = new User();
		UserDAO usrDAO = new UserDAO();
		usr.setAdminUser(1);
		usr.setIdUser(5);
		usr.setMailUser("monMail@monhebergeur.com");
		usr.setNameUser("MrSmith");
		usr.setOkUser(1);
		usr.setPasswordUser("azertyuiop");
		int i = usrDAO.insertUser(usr);
		assertEquals( 1 , i);
		usrDAO.deleteUser(5);
	}
	
	/**
	 * Test updateUser
	 * @throws SQLException
	 */
	@Test
	public void testUpdate() throws SQLException {
		User usr = new User();
		UserDAO usrDAO = new UserDAO();
		usr.setAdminUser(1);
		usr.setIdUser(5);
		usr.setMailUser("monMail@monhebergeur.com");
		usr.setNameUser("MrSmith");
		usr.setOkUser(1);
		usr.setPasswordUser("azertyuiop");
		usrDAO.insertUser(usr);
		usr.setNameUser("John Smith");
		int i = usrDAO.updateUser(usr);
		assertEquals( 1 , i);
		usrDAO.deleteUser(5);
	}
	
	/**
	 * Test deleteUser
	 * @throws SQLException
	 */
	@Test
	public void testDelete() throws SQLException {
		User usr = new User();
		usr.setAdminUser(1);
		usr.setIdUser(5);
		usr.setMailUser("monMail@monhebergeur.com");
		usr.setNameUser("MrSmith");
		usr.setOkUser(1);
		usr.setPasswordUser("azertyuiop");
		UserDAO usrDAO = new UserDAO();
		usrDAO.insertUser(usr);
		int i = usrDAO.deleteUser(5);
		assertEquals( 1 , i);
	}
	
	/**
	 * Test a transaction
	 * @throws SQLException
	 */
	@Test
	public void test() throws SQLException {
		User usr = new User();
		ArrayList<User> usrs = new ArrayList<User>();
		UserDAO usrDAO = new UserDAO();
		
		usrDAO.getUser(usr);
		
		usr.setAdminUser(1);
		usr.setIdUser(5);
		usr.setMailUser("monMail@monhebergeur.com");
		usr.setNameUser("MrSmith");
		usr.setOkUser(1);
		usr.setPasswordUser("azertyuiop");
		usrDAO.insertUser(usr);
		usrs = usrDAO.getAllUser();
		for(User u : usrs)
			u.display();
		
		usr.setNameUser("John Smith");
		usrDAO.updateUser(usr);
		usrs = usrDAO.getAllUser();
		for(User u : usrs)
			u.display();
		
		usrDAO.deleteUser(usr.getIdUser());
		usrs = usrDAO.getAllUser();
		for(User u : usrs)
			u.display();
	}

}
