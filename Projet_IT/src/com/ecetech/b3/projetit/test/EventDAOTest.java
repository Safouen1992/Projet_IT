package com.ecetech.b3.projetit.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.b3.projetit.beans.Event;
import com.ecetech.b3.projetit.dao.EventDAO;

public class EventDAOTest {
	
	@Test
	public void testGet() throws SQLException {
		Event eve = new Event();
		EventDAO eveDAO = new EventDAO();
		ArrayList<Event> eves = eveDAO.getEvent(eve);
		assert "J'y serais avec 2 potes" == eves.get(0).getContentEvent();
	}
	
	@Test
	public void testInsert() throws SQLException {
		Event eve = new Event();
		EventDAO eveDAO = new EventDAO();
		eve.setIdEvent(9);
		eve.setContentEvent("un évènement lambda");
		eve.setDateEvent(new Date(1212, 12, 20));
		eve.setIdCategory(3);
		eve.setIdUser(2);
		eve.setNameEvent("maths");
		eve.setPlaceEvent("p317");
		int i = eveDAO.insertEvent(eve);
		assert 1 == i;
		eveDAO.deleteEvent(9);
	}
	
	@Test
	public void testUpdate() throws SQLException {
		Event eve = new Event();
		EventDAO eveDAO = new EventDAO();
		eve.setIdEvent(9);
		eve.setContentEvent("un évènement lambda");
		eve.setDateEvent(new Date(1212, 12, 20));
		eve.setIdCategory(3);
		eve.setIdUser(2);
		eve.setNameEvent("maths");
		eve.setPlaceEvent("p317");
		eveDAO.insertEvent(eve);
		eve.setContentEvent("Jeux de plateaux");
		int i = eveDAO.updateEvent(eve);
		assert 1 == i;
		eveDAO.deleteEvent(9);
	}
	
	@Test
	public void testDelete() throws SQLException {
		Event eve = new Event();
		eve.setIdEvent(9);
		eve.setContentEvent("un évènement lambda");
		eve.setDateEvent(new Date(1212, 12, 20));
		eve.setIdCategory(3);
		eve.setIdUser(2);
		eve.setNameEvent("maths");
		eve.setPlaceEvent("p317");
		EventDAO eveDAO = new EventDAO();
		int i = eveDAO.deleteEvent(9);
		assert 1 == i;
	}

	@Test
	public void test() throws SQLException {
		Event eve = new Event();
		ArrayList<Event> eves = new ArrayList<Event>();
		EventDAO eveDAO = new EventDAO();
		
		eveDAO.getEvent(eve);
		for(Event e : eves)
			e.display();
		
		eve.setIdEvent(9);
		eve.setContentEvent("un évènement lambda");
		eve.setDateEvent(new Date(1212, 12, 20));
		eve.setIdCategory(3);
		eve.setIdUser(2);
		eve.setNameEvent("maths");
		eve.setPlaceEvent("p317");
		eveDAO.insertEvent(eve);
		eves = eveDAO.getAllEvent();
		for(Event e : eves)
			e.display();
		
		eve.setNameEvent("physique");
		eveDAO.updateEvent(eve);
		eves = eveDAO.getAllEvent();
		for(Event e : eves)
			e.display();
		
		eveDAO.deleteEvent(eve.getIdEvent());
		eves = eveDAO.getAllEvent();
		for(Event e : eves)
			e.display();
	}

}
