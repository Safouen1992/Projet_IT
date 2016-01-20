package com.ecetech.b3.projetit.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.b3.projetit.beans.User;
import com.ecetech.b3.projetit.dao.UserDAO;

public class UserDAOTest {

	@Test
	public void testGet() throws SQLException {
		User usr = new User();
		UserDAO usrDAO = new UserDAO();
		ArrayList<User> usrs = usrDAO.getUser(usr);
		assert "Pierre" == usrs.get(0).getNameUser();
	}
	
	@Test
	public void testInsert() throws SQLException {
		User usr = new User();
		UserDAO usrDAO = new UserDAO();
		usr.setAdminUser(1);
		usr.setIdUser(5);
		usr.setMailUser("monMail@monhebergeur.com");
		usr.setNameUser("Bouboule");
		usr.setOkUser(1);
		usr.setPasswordUser("azertyuiop");
		int i = usrDAO.insertUser(usr);
		assert 1 == i;
		usrDAO.deleteUser(5);
	}
	
	@Test
	public void testUpdate() throws SQLException {
		User usr = new User();
		UserDAO usrDAO = new UserDAO();
		usr.setAdminUser(1);
		usr.setIdUser(5);
		usr.setMailUser("monMail@monhebergeur.com");
		usr.setNameUser("Bouboule");
		usr.setOkUser(1);
		usr.setPasswordUser("azertyuiop");
		usrDAO.insertUser(usr);
		usr.setNameUser("Boulette");
		int i = usrDAO.updateUser(usr);
		assert 1 == i;
		usrDAO.deleteUser(5);
	}
	
	@Test
	public void testDelete() throws SQLException {
		User usr = new User();
		usr.setAdminUser(1);
		usr.setIdUser(5);
		usr.setMailUser("monMail@monhebergeur.com");
		usr.setNameUser("Bouboule");
		usr.setOkUser(1);
		usr.setPasswordUser("azertyuiop");
		UserDAO usrDAO = new UserDAO();
		int i = usrDAO.deleteUser(5);
		assert 1 == i;
	}
	
	@Test
	public void test() throws SQLException {
		User usr = new User();
		ArrayList<User> usrs = new ArrayList<User>();
		UserDAO usrDAO = new UserDAO();
		
		usrDAO.getUser(usr);
		
		usr.setAdminUser(1);
		usr.setIdUser(5);
		usr.setMailUser("monMail@monhebergeur.com");
		usr.setNameUser("Bouboule");
		usr.setOkUser(1);
		usr.setPasswordUser("azertyuiop");
		usrDAO.insertUser(usr);
		usrs = usrDAO.getAllUser();
		for(User u : usrs)
			u.display();
		
		usr.setNameUser("BouboulePartiManger");
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
