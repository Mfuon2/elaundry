package elaundry.user.dao;

import java.util.List;

import elaundry.generic.dao.GenericDaoI;
import elaundry.user.model.User;

public interface UserDaoI extends GenericDaoI<User, Long> {

	Boolean login(String username, String password, String usertype);

	List<User> sqlList();
}
