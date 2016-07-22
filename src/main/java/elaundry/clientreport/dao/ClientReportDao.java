package elaundry.clientreport.dao;

import javax.persistence.EntityManager;

import elaundry.ticket.model.Ticket;

public class ClientReportDao implements ClientReportDaoI{
	
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public Ticket add(Ticket ticket) {
		return em.merge(ticket);
	}

}