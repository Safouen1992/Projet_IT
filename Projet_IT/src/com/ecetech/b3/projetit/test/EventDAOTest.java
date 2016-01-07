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
