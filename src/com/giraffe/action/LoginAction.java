package com.giraffe.action;

import java.io.Serializable;

import com.giraffe.entity.Admin;
import com.giraffe.service.AdminService;
import com.giraffe.service.impl.AdminServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements Serializable {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	AdminService service = new AdminServiceImpl();
	
	/**
	 * �����û���¼
	 */
	public String login() throws Exception {
		Admin admin = service.login(this.username, this.password);
		if(admin == null){
			ActionContext.getContext().put("message", "�û�������������.");
			return "loginFailed";
		}
		ActionContext.getContext().getSession().put("admin", admin);
		return "loginOK";
	}
	
	/**
	 * �����û��˳���¼
	 * @return
	 */
	public String logout(){
		ActionContext.getContext().getSession().remove("admin");
		ActionContext.getContext().put("message", "�˳��ɹ�.");
		return "logout";
	}
}
