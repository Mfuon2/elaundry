package elaundry.search.dao;

import java.math.BigInteger;
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
	public int countTickets(String confirmationLink, String search) {
		String code = "TCN";
		String assign = code+search;//tcn1004
		String status = "OPEN";
		
		Query query = em.createQuery("select count(id) from Ticket where assign=:assign AND status=:status ORDER BY days DESC");
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
		
		Query query = em.createQuery("from Ticket where assign=:assign AND status=:status ORDER BY days DESC");
		query.setParameter("assign", assign);
		query.setParameter("status",status);
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public int countOpenTickets() {
		//Query query = em.createQuery("select count(id) from Ticket");
		//List result = query.getResultList();
		
		List <BigInteger> result = em.createNativeQuery("select count(id) from ticket where status ='OPEN'").getResultList();
		System.out.println("======================================================="+(result.get(0)).intValue());
		return (result.get(0)).intValue();
		
	}
	
	@SuppressWarnings("unchecked")
	public int countAllTickets() {
		//Query query = em.createQuery("select count(id) from Ticket");
		//List result = query.getResultList();
		
		List <BigInteger> result = em.createNativeQuery("select count(id) from ticket").getResultList();
		System.out.println("======================================================="+(result.get(0)).intValue());
		return (result.get(0)).intValue();
		
	}


}
