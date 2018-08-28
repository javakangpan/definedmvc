package pers.kp.service;

import java.util.List;

import pers.kp.model.RoleBean;

public interface IRoleService {
void save(RoleBean role) throws RuntimeException;
	
	void delete(RoleBean role) throws RuntimeException;
	
	void update(RoleBean role) throws RuntimeException;
	
	List<RoleBean> query();
	
	RoleBean queryById(int id);
}
