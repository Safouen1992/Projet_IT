package com.ecetech.b3.projetit.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.b3.projetit.beans.Event;
import com.ecetech.b3.projetit.beans.Participate;
import com.ecetech.b3.projetit.dao.ParticipateDAO;

public class ParticipateDAOTest {

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
