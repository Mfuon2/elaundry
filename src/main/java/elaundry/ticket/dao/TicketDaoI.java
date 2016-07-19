package elaundry.ticket.dao;

import java.util.List;

import elaundry.generic.dao.GenericDaoI;
import elaundry.ticket.model.Ticket;

public interface TicketDaoI extends GenericDaoI<Ticket, Long> {
	
	List<Ticket> active();
	
	List<Ticket> sqlList();
	
}
