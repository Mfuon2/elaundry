package elaundry.clients.dao;

import java.util.List;

import elaundry.clients.model.Clients;
import elaundry.generic.dao.GenericDaoI;

public interface ClientsDaoI extends GenericDaoI<Clients, Long> {
	
    List<Clients> active();
	
//	List<Clients> active2();
//	
//	Clients findByIdNq(Long id);
	
	List<Clients> sqlList();

}
