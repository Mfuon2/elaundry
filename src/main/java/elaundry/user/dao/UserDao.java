package elaundry.user.dao;

import java.util.List;

import javax.persistence.Query;

import elaundry.generic.dao.GenericDao;
import elaundry.user.model.User;


public class UserDao extends GenericDao <User, Long> implements UserDaoI{

	public Boolean login(String username, String password, String usertype) {
		

		String hql = "FROM User WHERE username=:username "
				+ "and password=:pwd "
				+ "and usertype=:usertype";
		
		Query query = em.createQuery(hql)
				.setParameter("username", username)
				.setParameter("pwd", password)
				.setParameter("usertype", usertype);
		

		List<User> results = query.getResultList();

		
		System.out.println(results.isEmpty());
		
		if (results.isEmpty())
			return false;
		else
			return true;
	}

	

}
