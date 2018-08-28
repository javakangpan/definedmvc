package pers.kp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.kp.dao.IBasicDao;
import pers.kp.model.BasicBean;
import pers.kp.service.IBasicService;
@Service
public class BasicServiceImpl implements IBasicService {
	@Resource
	private IBasicDao dao;

	@Override
	public void save(BasicBean basic) throws RuntimeException {
		dao.save(basic);
		
	}

	@Override
	public void delete(BasicBean basic) throws RuntimeException {
		
		dao.delete(basic);
	}

	@Override
	public void update(BasicBean basic) throws RuntimeException {
		dao.update(basic);
		
	}

	@Override
	public List<BasicBean> query() {
		
		return dao.query();
	}

	@Override
	public BasicBean queryById(int id) {
		
		return dao.queryById(id);
	}
	
	
	
}
