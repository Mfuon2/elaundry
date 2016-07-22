package elaundry.clientreport.bean;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import elaundry.clientreport.dao.ClientReportDaoI;
import elaundry.ticket.model.Ticket;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ClientReportBean implements ClientReportBeanI{
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject 
	private ClientReportDaoI clientReportDao;
	
	@PostConstruct
	private void init(){
		clientReportDao.setEm(em);
	}
	
	public void add(Ticket ticket){
		if(ticket == null || ticket.getTitle() == null)
			return;
		
		ticket = clientReportDao.add(ticket);
	}
	

}
