package elaundry.tech.dao;

import java.util.List;

import elaundry.generic.dao.GenericDaoI;
import elaundry.tech.model.Technician;

public interface TechnicianDaoI extends GenericDaoI<Technician, Long>  {

    List<Technician> active();
	
	List<Technician> sqlList();

}
