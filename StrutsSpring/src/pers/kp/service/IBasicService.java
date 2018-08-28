package pers.kp.service;

import java.util.List;

import pers.kp.model.BasicBean;

public interface IBasicService {
	
void save(BasicBean basic) throws RuntimeException;
	
	void delete(BasicBean basic) throws RuntimeException;
	
	void update(BasicBean basic) throws RuntimeException;
	
	List<BasicBean> query();
	
	BasicBean queryById(int id);
}
