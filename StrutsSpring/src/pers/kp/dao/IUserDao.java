package pers.kp.dao;

import java.util.List;

import pers.kp.model.RoleBean;
import pers.kp.model.UserBean;

public interface IUserDao {

	void save(UserBean user) throws RuntimeException;
	
	void delete(UserBean user) throws RuntimeException;
	
	void update(UserBean user) throws RuntimeException;
	
	List<UserBean> query();
	
	UserBean queryById(int id);
	
	void saveUserAndRoleId(int roleid) throws RuntimeException;
	
	void delete(int userid) throws RuntimeException;
	
	
}
