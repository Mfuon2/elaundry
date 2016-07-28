package elaundry.user.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import elaundry.generic.dao.GenericDao;
import elaundry.user.model.User;


public class UserDao extends GenericDao <User, Long> implements UserDaoI{

	@SuppressWarnings("unchecked")
	public Boolean login(String username, String password, String usertype) {
		

		String hql = "FROM User WHERE username=:username "
				+ "and password=:pwd "
				+ "and usertype=:usertype";
		
		Query query = em.createQuery(hql)
				.setParameter("username", username)
				.setParameter("pwd", password)
				.setParameter("usertype", usertype);
		
		List<User> results = query.getResultList();
		//System.out.println(results.isEmpty());
		
		if (results.isEmpty())
			return false;
		else
			return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> sqlList() {
		Session session = (Session) getEm().getDelegate();
		List<User> users = new ArrayList<User>();
		List<Object []> results = session.createSQLQuery("select id, fullname, username,password, email, usertype from users")
				.list();
		
		User user;
		for(Object [] result : results){
			user = new User();
			if(result[0] != null)user.setId( ((BigInteger) result[0]).longValue());
			if(result[1] != null)user.setFullname( (String) result[1]);
			if(result[2] != null)user.setUsername( (String) result[2]);
			if(result[3] != null)user.setPassword( (String) result[3]);
			if(result[4] != null)user.setEmail( (String) result[4]);
			if(result[5] != null)user.setUsertype( (String) result[5]);
			users.add(user);
		}
		return users;
	}

	

}
