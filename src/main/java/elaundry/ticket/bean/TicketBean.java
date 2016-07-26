package elaundry.ticket.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import elaundry.ticket.dao.TicketDaoI;
import elaundry.ticket.model.Ticket;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TicketBean implements TicketBeanI {
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private TicketDaoI ticketDao;
	
	@PostConstruct
	public void init(){
		ticketDao.setEm(em);
	}
	
	public void add(Ticket ticket){
		if(ticket == null || ticket.getTitle() == null)
			return;
		
		ticketDao.save(ticket);
	}
	
	public String load(Long id){
		Ticket ticket = ticketDao.findById(id);
		
		if(ticket != null)
			return ticket.getJson();
		else
			return "{}";
	}
	
	public List<Ticket> list(){
		return ticketDao.list(new Ticket());
	}
	public String listInJson(){
		Map<String, Object> filter = new HashMap<String, Object>();
		List<Ticket> techs = ticketDao.sqlList();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = ticketDao.countAll();
		for(Ticket tech : techs){
			sb.append(tech.getJson());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	public boolean delete(Long id) {
		ticketDao.delete(id);
		
		return true;
	}	

}
