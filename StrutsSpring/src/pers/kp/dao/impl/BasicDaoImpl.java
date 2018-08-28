package pers.kp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pers.kp.dao.IBasicDao;
import pers.kp.model.BasicBean;
import pers.kp.model.RoleBean;
@Repository
public class BasicDaoImpl implements IBasicDao {
	@Resource
	private JdbcTemplate template;
	
	private String sql;

	@Override
	public void save(BasicBean basic) throws RuntimeException {
		sql = "INSERT INTO KP_BASIC(BID,BNAME,PID)VALUES(SEQ_T_BASIC.NEXTVAL,?,?)";
		template.update(sql,basic.getBname(),basic.getPid());

	}

	@Override
	public void delete(BasicBean basic) throws RuntimeException {
		sql="DELETE FROM KP_BASIC WHERE BID=?";
		template.update(sql,basic.getBid());

	}

	@Override
	public void update(BasicBean basic) throws RuntimeException {
		sql="UPDATE KP_BASIC SET BNAME=?,PID=? WHERE BID=?";
		template.update(sql,basic.getBname(),basic.getBname(),basic.getBid());

	}

	@Override
	public List<BasicBean> query() {
		sql = "SELECT * FROM KP_BASIC";
		RowMapper<BasicBean> rowMapper = new BeanPropertyRowMapper<BasicBean>(BasicBean.class);
		return template.query(sql, rowMapper);
	}

	@Override
	public BasicBean queryById(int id) {
		
		sql = "SELECT * FROM KP_BASIC WHERE BID = ?";
		RowMapper<BasicBean> rowMapper = new BeanPropertyRowMapper<BasicBean>(BasicBean.class);
		return template.queryForObject(sql,  rowMapper,id);
	}
	

	
	
	
}
