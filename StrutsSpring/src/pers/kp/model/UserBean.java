package pers.kp.model;

import java.util.List;

public class UserBean {
	
	private int userid;
	
	private String username;
	
	private String sex;
	
	private int deptid;
	
	//·ÖÅä½ÇÉ«±àºÅ
	private List<Integer> depts;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public List<Integer> getDepts() {
		return depts;
	}

	public void setDepts(List<Integer> depts) {
		this.depts = depts;
	}
	
}
