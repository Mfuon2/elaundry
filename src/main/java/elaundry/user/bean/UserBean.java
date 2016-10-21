package elaundry.user.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private EntityManager em;
	
	@Inject
	private UserDaoI userDao;
	
	@PostConstruct
	public void init(){
		userDao.setEm(em);		
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
	
	public String load(Long id){
		User users = userDao.findById(id);
		
		if(users != null)
			return users.getJson();
		else
			return "{}";
	}
	
	public List<User> list(){
		return userDao.list(new User());
	}
	public String listInJson(){
		List<User> users = userDao.sqlList();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = userDao.countAll();
		for(User user : users){
			sb.append(user.getJson());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	public boolean delete(Long id) {
		userDao.delete(id);
		
		return true;
	}	
}
