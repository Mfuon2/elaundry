package elaundry.search.dao;

import java.util.List;

import javax.persistence.EntityManager;

import elaundry.ticket.model.Ticket;

public interface SearchDaoI {
	
	void setEm(EntityManager em);
	
	int countCustomerSearch(String confirmationLink, String search);
	List<Ticket> servicesGivenInJson(Ticket services, String confirmationLink, String search);
	
}
