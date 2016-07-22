package elaundry.user.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import elaundry.user.dao.UserDaoI;
import elaundry.user.model.User;

@Stateless
public class UserBean implements UserBeanI {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Inject
	private UserDaoI userDao;
	
	@PostConstruct
	public void init(){
		userDao.setEm(manager);		
	}
	
	public void create(User user){
		if(user == null)
			return;
		
		userDao.save(user);
	}
	
	public Boolean login(String username, String password, String usertype){
		
		Boolean Authentication = userDao.login(username, password, usertype);
		
		if(Authentication){
		return true;
		
		}else {
			return false;
			
		}
	}
	
	public List<User> list(){
		
		return userDao.list(new User());
	}

}
