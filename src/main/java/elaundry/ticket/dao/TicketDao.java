package elaundry.ticket.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import elaundry.generic.dao.GenericDao;
import elaundry.ticket.model.Ticket;

public class TicketDao extends GenericDao<Ticket, Long> implements TicketDaoI {

	@SuppressWarnings("unchecked")
	public List<Ticket> active() {
		Session session = (Session) getEm().getDelegate();
		
		List<Ticket> ticket = session.createCriteria(Ticket.class)
				.add(Restrictions.isNotNull("name"))
				.list();
		
		return ticket;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ticket> sqlList(){
		
		Session session = (Session) getEm().getDelegate();
		
		List<Ticket> ticket = new ArrayList<Ticket>();
		
		List<Object []> results = session.createSQLQuery("select id, title,reportedby, descr, status, assign, priority, postdate,updatedby,updatetime,days from ticket ")
				.list();
		
		Ticket tickets;
		for(Object [] result : results){
			tickets = new Ticket();
			if(result[0] != null)tickets.setId( ((BigInteger) result[0]).longValue());
			if(result[1] != null)tickets.setTitle( (String) result[1]);
			if(result[2] != null)tickets.setReportedby( (String) result[2]);
			if(result[3] != null)tickets.setDescr( (String) result[3]);
			if(result[4] != null)tickets.setStatus( (String) result[4]);
			if(result[5] != null)tickets.setAssign( (String) result[5]);
			if(result[6] != null)tickets.setPriority( (String) result[6]);
			if(result[7] != null)tickets.setPostdate( (String) result[7]);
			if(result[8] != null)tickets.setUpdatedby( (String) result[8]);
			if(result[9] != null)tickets.setUpdatetime( (String) result[9]);
			if(result[10] != null)tickets.setDays( ((BigInteger) result[10]).longValue());
			ticket.add(tickets);
		}
			return ticket;
	}
		
}

