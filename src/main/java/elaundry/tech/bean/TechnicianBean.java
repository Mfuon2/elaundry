package elaundry.tech.bean;

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

import elaundry.tech.dao.TechnicianDaoI;
import elaundry.tech.model.Technician;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TechnicianBean implements TechnicianBeanI {
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private TechnicianDaoI technicianDao;
	
	@PostConstruct
	public void init(){
		technicianDao.setEm(em);
	}
	
	public void add(Technician technician){
		if(technician == null || technician.getFullname() == null)
			return;
		
		technicianDao.save(technician);
	}
	
	public String load(Long id){
		Technician techs = technicianDao.findById(id);
		
		if(techs != null)
			return techs.getJson();
		else
			return "{}";
	}
	
	public List<Technician> list(){
		return technicianDao.list(new Technician());
	}
	public String listInJson(){
		Map<String, Object> filter = new HashMap<String, Object>();
		List<Technician> techs = technicianDao.sqlList();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = technicianDao.countAll();
		for(Technician tech : techs){
			sb.append(tech.getJson());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	public boolean delete(Long id) {
		technicianDao.delete(id);
		
		return true;
	}	

}
