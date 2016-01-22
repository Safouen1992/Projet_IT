package com.ecetech.b3.projetit.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;


import com.ecetech.b3.projetit.beans.Participate;
import com.ecetech.b3.projetit.dao.ParticipateDAO;

public class ParticipateDAOTest {

	/**
	 * Test getParticipate
	 * @throws SQLException
	 */
	@Test
	public void testGet() throws SQLException {
		Participate par = new Participate();
		ParticipateDAO parDAO = new ParticipateDAO();
		ArrayList<Participate> pars = parDAO.getParticipate(par);
		assertEquals( 1 , pars.get(0).getIdEvent());
	}
	
	/**
	 * Test insertUser
	 * @throws SQLException
	 */
	@Test
	public void testInsert() throws SQLException {
		Participate par = new Participate();
		ParticipateDAO parDAO = new ParticipateDAO();
		par.setIdParticipate(6);
		par.setIdEvent(1);
		par.setIdUser(4);
		int i = parDAO.insertParticipate(par);
		assertEquals( 1 , i);
		parDAO.deleteParticipate(6);
	}
	
	/*@Test
	public void testUpdate() throws SQLException {
		Participate par = new Participate();
		ParticipateDAO parDAO = new ParticipateDAO();
		par.setIdParticipate(6);
		par.setIdEvent(1);
		par.setIdUser(4);
		parDAO.insertParticipate(par);
		int i = parDAO.updateParticipate(par);
		assert 1 == i;
		parDAO.deleteParticipate(6);
	}*/
	
	/**
	 * Test deleteUser
	 * @throws SQLException
	 */
	@Test
	public void testDelete() throws SQLException {
		Participate par = new Participate();
		par.setIdParticipate(6);
		par.setIdEvent(1);
		par.setIdUser(4);
		ParticipateDAO parDAO = new ParticipateDAO();
		parDAO.insertParticipate(par);
		int i = parDAO.deleteParticipate(6);
		assertEquals( 1 , i);
	}
	
	/**
	 * Test a transaction
	 * @throws SQLException
	 */
	@Test
	public void test() throws SQLException {
		Participate par = new Participate();
		ArrayList<Participate> pars = new ArrayList<Participate>();
		ParticipateDAO parDAO = new ParticipateDAO();
		
		parDAO.getParticipate(par);
		
		par.setIdParticipate(6);
		par.setIdEvent(1);
		par.setIdUser(4);
		parDAO.insertParticipate(par);
		pars = parDAO.getAllParticipate();
		for(Participate p : pars)
			p.display();
		
		par.setIdUser(3);
		parDAO.updateParticipate(par);
		pars = parDAO.getAllParticipate();
		for(Participate p : pars)
			p.display();
		
		parDAO.deleteParticipate(par.getIdParticipate());
		pars = parDAO.getAllParticipate();
		for(Participate p : pars)
			p.display();
	}

}
