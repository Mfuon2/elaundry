package elaundry.user.dao;

import java.util.List;

import javax.persistence.Query;

import elaundry.generic.dao.GenericDao;
import elaundry.user.model.User;


public class UserDao extends GenericDao <User, Long> implements UserDaoI{

	public Boolean login(String username, String password) {
		

		String hql = "FROM User u WHERE u.username=:username "
				+ "and u.password=:pwd";
		
		Query query = em.createQuery(hql)
				.setParameter("username", username)
				.setParameter("pwd", password);

		List<User> results = query.getResultList();

		
		System.out.println(results.isEmpty());
		
		if (results.isEmpty())
			return false;
		else
			return true;
	}

	

}
