package pers.kp.dao;

import java.util.List;

import pers.kp.model.BasicBean;

public interface IBasicDao {
	
	void save(BasicBean basic) throws RuntimeException;
	
	void delete(BasicBean basic) throws RuntimeException;
	
	void update(BasicBean basic) throws RuntimeException;
	
	List<BasicBean> query();
	
	BasicBean queryById(int id);
	
}
