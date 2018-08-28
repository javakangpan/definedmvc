package pers.kp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.kp.dao.IBasicDao;
import pers.kp.dao.IRoleDao;
import pers.kp.model.RoleBean;
import pers.kp.service.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService {
	@Resource
	private IRoleDao dao;

	@Override
	public void save(RoleBean role) throws RuntimeException {
		dao.save(role);
		
	}

	@Override
	public void delete(RoleBean role) throws RuntimeException {
		dao.delete(role);
		
	}

	@Override
	public void update(RoleBean role) throws RuntimeException {
		dao.update(role);
		
	}

	@Override
	public List<RoleBean> query() {
		
		return dao.query();
	}

	@Override
	public RoleBean queryById(int id) {
		
		return dao.queryById(id);
	}
}
