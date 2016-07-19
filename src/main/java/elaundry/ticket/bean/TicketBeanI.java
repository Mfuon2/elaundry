package elaundry.ticket.bean;

import java.util.List;

import elaundry.ticket.model.Ticket;

public interface TicketBeanI {
	
    void add(Ticket ticket);
	
	public String  load(Long id);
	
	public List<Ticket> list();
	
	boolean delete(Long id);
	
	public String listInJson();

}
