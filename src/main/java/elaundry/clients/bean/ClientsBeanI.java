package elaundry.clients.bean;

import java.util.List;

import elaundry.clients.model.Clients;

public interface ClientsBeanI {

	void add(Clients company);
	
	public String load(Long id);

	public List<Clients> list();
	
	boolean delete(Long id);

	public String listInJson();

}
