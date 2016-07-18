package elaundry.clients.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import elaundry.clients.model.Clients;
import elaundry.generic.dao.GenericDao;

public class ClientsDao extends GenericDao<Clients, Long> implements ClientsDaoI {
	
	@SuppressWarnings("unchecked")
	public List<Clients> active() {
		Session session = (Session) getEm().getDelegate();
		
		List<Clients> clients = session.createCriteria(Clients.class)
				.add(Restrictions.isNotNull("name"))
				.list();
		
		return clients;
	}
	
	@SuppressWarnings("unchecked")
	public List<Clients> sqlList() {
		Session session = (Session) getEm().getDelegate();
		
		List<Clients> clients = new ArrayList<Clients>();
		
		List<Object []> results = session.createSQLQuery("select id, fullname, nationalid from clients")
				.list();
		
		Clients client;
		for(Object [] result : results){
			client = new Clients();
			if(result[0] != null)client.setId( ((BigInteger) result[0]).longValue());
			if(result[1] != null)client.setFullname( (String) result[1]);
			if(result[2] != null)client.setNationalid( ((BigInteger) result[2]).longValue());
			clients.add(client);
		}
		
		return clients;
	}

//	@SuppressWarnings("unchecked")
//	public List<Clients> active2() {
//		
//		List<Clients> clients = getEm().createNamedQuery(Clients.NQ_ALL)
//				.getResultList();
//		
//		return clients;
//	}
//
//	@SuppressWarnings("unchecked")
//	public Clients findByIdNq(Long id) {
//		
//		List<Clients> clients = getEm().createNamedQuery(Clients.NQ_FINDBYID)
//				.setParameter("id", id)
//				.getResultList();
//		
//		if(clients.isEmpty())
//			return null;
//		
//		return clients.get(0);
//	}

}
