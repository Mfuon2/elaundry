package elaundry.search.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import elaundry.ticket.model.Ticket;

public class SearchDao implements SearchDaoI {

	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("rawtypes")
	public int countCustomerSearch(String confirmationLink, String search) {
		String code = "TCN";
		String assign = code+search;//tcn1004
		String status = "OPEN";
		
		Query query = em.createQuery("select count(id) from Ticket where assign=:assign AND status=:status");
		query.setParameter("assign", assign);
		query.setParameter("status",status);
		List result = query.getResultList();
		
		return ((Long) result.get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> servicesGivenInJson(Ticket services, String confirmationLink, String search) {
		String code = "TCN";
		String assign = code+search;
		String status = "OPEN";
		
		Query query = em.createQuery("from Ticket where assign=:assign AND status=:status");
		query.setParameter("assign", assign);
		query.setParameter("status",status);
		
		return query.getResultList();
	}

}
