package pers.kp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pers.kp.dao.IRoleDao;
import pers.kp.model.RoleBean;
@Repository
public class RoleDaoImpl implements IRoleDao {
	@Resource
	private JdbcTemplate template;
	
	String sql=null;
	@Override
	public void save(RoleBean role) throws RuntimeException {
		
		sql = "INSERT INTO KP_ROLE(ROLEID,ROLENAME)VALUES(SEQ_T_ROLE.NEXTVAL,?)";
		template.update(sql, role.getRolename());
	}

	@Override
	public void delete(RoleBean role) throws RuntimeException {
		
		sql = "DELETE FROM KP_ROLE WHERE ROLEID = ?";
		template.update(sql,role.getRoleid());
	}

	@Override
	public void update(RoleBean role) throws RuntimeException {
	
		sql="UPDATE KP_ROLE SET ROLENAME=? WHERE ROLEID = ?";
		template.update(sql, role.getRolename(),role.getRoleid());
	}

	@Override
	public List<RoleBean> query() {
		
		sql = "SELECT * FROM KP_ROLE";
		RowMapper<RoleBean> rowMapper = new BeanPropertyRowMapper<RoleBean>(RoleBean.class);
		return template.query(sql, rowMapper);
	}

	@Override
	public RoleBean queryById(int id) {
		
		sql = "SELECT * FROM KP_ROLE WHERE ROLEID = ?";
		RowMapper<RoleBean> rowMapper = new BeanPropertyRowMapper<RoleBean>(RoleBean.class);
		return template.queryForObject(sql,  rowMapper,id);
	}
	
}
