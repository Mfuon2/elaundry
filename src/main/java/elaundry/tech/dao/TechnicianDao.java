package elaundry.tech.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import elaundry.generic.dao.GenericDao;
import elaundry.tech.model.Technician;

public class TechnicianDao extends GenericDao<Technician, Long> implements TechnicianDaoI {
	

	@SuppressWarnings("unchecked")
	public List<Technician> active() {
		Session session = (Session) getEm().getDelegate();
		
		List<Technician> tech = session.createCriteria(Technician.class)
				.add(Restrictions.isNotNull("name"))
				.list();
		
		return tech;
	}
	
	@SuppressWarnings("unchecked")
	public List<Technician> sqlList() {
		Session session = (Session) getEm().getDelegate();
		
		List<Technician> tech = new ArrayList<Technician>();
		
		List<Object []> results = session.createSQLQuery("select id, fullname, techid, nationalid, phone_no, email from technician")
				.list();
		
		Technician techs;
		for(Object [] result : results){
			techs = new Technician();
			if(result[0] != null)techs.setId( ((BigInteger) result[0]).longValue());
			if(result[1] != null)techs.setFullname( (String) result[1]);
			if(result[2] != null)techs.setTechid( (String) result[2]);
			if(result[3] != null)techs.setNationalid( ((BigInteger) result[3]).longValue());
			if(result[4] != null)techs.setPhoneNo( (String) result[4]);
			if(result[5] != null)techs.setEmail( (String) result[5]);
			
			tech.add(techs);
		}
		
		return tech;
	}
}
