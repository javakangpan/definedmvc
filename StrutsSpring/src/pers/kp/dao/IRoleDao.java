package pers.kp.dao;

import java.util.List;

import pers.kp.model.RoleBean;

public interface IRoleDao {
	void save(RoleBean role) throws RuntimeException;
	
	void delete(RoleBean role) throws RuntimeException;
	
	void update(RoleBean role) throws RuntimeException;
	
	List<RoleBean> query();
	
	RoleBean queryById(int id);
}
