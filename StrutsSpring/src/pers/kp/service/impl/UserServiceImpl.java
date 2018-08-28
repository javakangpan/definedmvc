package pers.kp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.kp.dao.IUserDao;
import pers.kp.model.UserBean;
import pers.kp.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao dao;

	@Override
	public void save(UserBean user) throws RuntimeException {
		dao.save(user);
		if(user.getDepts()!=null&&user.getDepts().size()>0){
			for(Integer roleid:user.getDepts()){
				
				dao.saveUserAndRoleId(roleid);
			}
		}
		
		
	}

	@Override
	public void delete(UserBean user) throws RuntimeException {
		dao.delete(user);
		dao.delete(user.getUserid());
		
		
		
	}

	@Override
	public void update(UserBean user) throws RuntimeException {
		dao.update(user);
		
	}

	@Override
	public List<UserBean> query() {
		
		return dao.query();
	}

	@Override
	public UserBean queryById(int id) {
		
		return dao.queryById(id);
	}

	@Override
	public void saveUserAndRoleId(int roleid) throws RuntimeException {
		dao.saveUserAndRoleId(roleid);
		
	}

	@Override
	public void delete(int userid) throws RuntimeException {
		dao.delete(userid);
		
	}
}
