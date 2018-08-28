package pers.kp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pers.kp.dao.IUserDao;

import pers.kp.model.UserBean;
@Repository
public class UserDaoImpl implements IUserDao {
	@Resource
	private JdbcTemplate template;
	private String sql;

	@Override
	public void save(UserBean user) throws RuntimeException {
		
		sql="INSERT INTO KP_USER(USERID,USERNAME,SEX,DEPTID)VALUES(SEQ_KP_USER.NEXTVAL,?,?,?)";
		template.update(sql, user.getUsername(),user.getSex(),user.getDeptid());
	}

	@Override
	public void delete(UserBean user) throws RuntimeException {
		
		sql = "DELETE FROM KP_USER WHERE userid = ?";
		
		template.update(sql, user.getUserid());
	}

	@Override
	public void update(UserBean user) throws RuntimeException {
		
		sql = "UPDATE KP_USER SET USERNAME=?,SEX=?,DEPTID=? WHERE USERID=?";
		template.update(sql, user.getUsername(),user.getSex(),user.getDeptid(),user.getUserid());
	}

	@Override
	public List<UserBean> query() {
		sql = "SELECT * FROM KP_USER";
		RowMapper<UserBean> rowMapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
		return template.query(sql, rowMapper);
	}

	@Override
	public UserBean queryById(int id) {
		sql = "SELECT * FROM KP_USER WHERE USERID = ?";
		RowMapper<UserBean> rowMapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
		return template.queryForObject(sql, rowMapper,id);
	}

	@Override
	public void saveUserAndRoleId(int roleid) throws RuntimeException {
		sql = "INSERT INTO KP_USER_ROLE(USERID,ROLEID)VALUES(SEQ_KP_USER.CURRVAL,?)";
		template.update(sql, roleid);
		
	}

	@Override
	public void delete(int userid) throws RuntimeException {
		sql="delete from kp_user_role where userid =?";
		template.update(sql,userid);
		
	}

	

}
