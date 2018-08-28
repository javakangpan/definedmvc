package pers.kp.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import pers.kp.model.BasicBean;
import pers.kp.model.RoleBean;
import pers.kp.model.UserBean;
import pers.kp.service.IBasicService;
import pers.kp.service.IRoleService;
import pers.kp.service.IUserService;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class UserAciton extends ActionSupport implements ModelDriven<UserBean> {
	//资源注释标记应用程序需要的资源。 
//	该注释可以应用于应用程序组件类，
//	或者应用于组件类的字段或方法。 
//	当注释应用于字段或方法时，
//	容器将在初始化组件时将所请求资源的实例注入到应用程序组件中。
//	如果注释应用于组件类，则注释声明应用程序将在运行时查找的资源。
	@Resource
	private IUserService userservice;
	@Resource
	private IRoleService roleservice;
	@Resource
	private IBasicService basicservice;
	
	private List<UserBean> list;
	private UserBean user=new UserBean();
	private List<RoleBean> roleList;
	private List<BasicBean> basicList;
	
	
	public String save(){
		userservice.save(user);
		return "query";
	}
	
	public String query(){
		setList(userservice.query());
		return super.SUCCESS;
	}
	public String getData(){
		roleList=roleservice.query();
		basicList=basicservice.query();
		return "add";
	}

	public String delete(){
		userservice.delete(user);
		return "query";
	}
	
	public List<UserBean> getList() {
		return list;
	}

	public void setList(List<UserBean> list) {
		this.list = list;
	}

	public List<RoleBean> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleBean> roleList) {
		this.roleList = roleList;
	}

	public List<BasicBean> getBasicList() {
		return basicList;
	}

	public void setBasicList(List<BasicBean> basicList) {
		this.basicList = basicList;
	}

	@Override
	public UserBean getModel() {
		
		return user;
	}
	
	
}
