package elaundry.user.bean;

import java.util.List;

import elaundry.user.model.User;

public interface UserBeanI {
	
	void create(User user);
	
	Boolean login(String username, String password, String usertype);
	
	public List<User> list();

	public String listInJson();

	public String load(Long id);

	boolean delete(Long user);

}
