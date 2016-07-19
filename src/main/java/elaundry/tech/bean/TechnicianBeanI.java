package elaundry.tech.bean;

import java.util.List;

import elaundry.tech.model.Technician;

public interface TechnicianBeanI {
	
	void add(Technician technician);
	
	public String  load(Long id);
	
	public List<Technician> list();
	
	boolean delete(Long id);
	
	public String listInJson();
	

}
