package elaundry.search.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import elaundry.search.dao.SearchDaoI;
import elaundry.ticket.model.Ticket;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SearchBean implements SearchBeanI{
	
	@PersistenceContext
	private EntityManager em;
		
	@Inject
	private SearchDaoI searchDao;
	
	@PostConstruct
	public void init(){
		searchDao.setEm(em);
	}

	public int countCustomerSearch(String confirmationLink, String search) {
		return searchDao.countCustomerSearch(confirmationLink, search);
	}

	public String servicesGivenInJson(String confirmationLink, String search) {
		Ticket filter = new Ticket();
		
		List<Ticket> services = searchDao.servicesGivenInJson(filter, confirmationLink, search);
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = searchDao.countCustomerSearch(confirmationLink, search);
		for(Ticket servicesGiven : services){
			sb.append(servicesGiven.getJson());
			
			count--;
			if(count>=1)
				sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
	
}
