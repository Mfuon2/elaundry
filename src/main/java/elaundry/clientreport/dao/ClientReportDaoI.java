package elaundry.clientreport.dao;

import javax.persistence.EntityManager;

import elaundry.ticket.model.Ticket;

public interface ClientReportDaoI {

	void setEm(EntityManager em);

	Ticket add(Ticket ticket);


}
