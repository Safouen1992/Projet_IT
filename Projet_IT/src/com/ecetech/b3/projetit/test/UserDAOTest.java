package com.ecetech.b3.projetit.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.b3.projetit.beans.Participate;
import com.ecetech.b3.projetit.beans.User;
import com.ecetech.b3.projetit.dao.UserDAO;

public class UserDAOTest {

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
