package elaundry.clients.bean;
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

import elaundry.clients.dao.ClientsDaoI;
import elaundry.clients.model.Clients;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ClientsBean implements ClientsBeanI {

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private ClientsDaoI clientsDao;
	
	@PostConstruct
	private void init(){
		clientsDao.setEm(em);
	}
	
	public void add(Clients clients){
		if(clients == null || clients.getFullname() ==null)
			return;
		
		clients = clientsDao.save(clients);
	}
	
	public String load(Long id){
		Clients clients = clientsDao.findById(id);
		
		if(clients != null)
			return clients.getJson();
		else
			return "{}";
	}
	
	public List<Clients> list(){
		return clientsDao.list(new Clients());
	}
	
	public String listInJson(){
		Map<String, Object> filter = new HashMap<String, Object>();
		List<Clients> clients = clientsDao.sqlList();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = clientsDao.countAll();
		for(Clients client : clients){
			sb.append(client.getJson());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	public boolean delete(Long id) {
		clientsDao.delete(id);
		
		return true;
	}	
	
}
