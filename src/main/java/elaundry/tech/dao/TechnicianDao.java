package elaundry.tech.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import elaundry.clients.model.Clients;
import elaundry.generic.dao.GenericDao;
import elaundry.tech.model.Technician;

public class TechnicianDao extends GenericDao<Technician, Long> implements TechnicianDaoI {
	

	@SuppressWarnings("unchecked")
	public List<Technician> active() {
		Session session = (Session) getEm().getDelegate();
		
		List<Technician> tech = session.createCriteria(Clients.class)
				.add(Restrictions.isNotNull("name"))
				.list();
		
		return tech;
	}
	
	@SuppressWarnings("unchecked")
	public List<Technician> sqlList() {
		Session session = (Session) getEm().getDelegate();
		
		List<Technician> tech = new ArrayList<Technician>();
		
		List<Object []> results = session.createSQLQuery("select id, fullname, techid, nationalid from technician")
				.list();
		
		Technician techs;
		for(Object [] result : results){
			techs = new Technician();
			if(result[0] != null)techs.setId( ((BigInteger) result[0]).longValue());
			if(result[1] != null)techs.setFullname( (String) result[1]);
			if(result[2] != null)techs.setTechid( (String) result[2]);
			if(result[3] != null)techs.setNationalid( ((BigInteger) result[3]).longValue());
			tech.add(techs);
		}
		
		return tech;
	}
}
