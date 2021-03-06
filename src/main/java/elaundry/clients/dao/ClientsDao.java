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
		
		List<Object []> results = session.createSQLQuery("select id, fullname, clientid, nationalid, phone_no, email from clients")
				.list();
		
		Clients client;
		for(Object [] result : results){
			client = new Clients();
			if(result[0] != null)client.setId( ((BigInteger) result[0]).longValue());
			if(result[1] != null)client.setFullname( (String) result[1]);
			if (result[2] != null)client.setClientid( (String) result[2]);
			if(result[3] != null)client.setNationalid( ((String) result[3]));
			//if(result[3] != null)client.setNationalid( ((BigInteger) result[3]).longValue());
			if (result[4] != null)client.setPhoneNo( (String) result[4]);
			if (result[5] != null)client.setEmail( (String) result[5]);
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
