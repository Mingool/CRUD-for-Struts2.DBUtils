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
	 * 处理用户登录
	 */
	public String login() throws Exception {
		Admin admin = service.login(this.username, this.password);
		if(admin == null){
			ActionContext.getContext().put("message", "用户名或密码有误.");
			return "loginFailed";
		}
		ActionContext.getContext().getSession().put("admin", admin);
		return "loginOK";
	}
	
	/**
	 * 处理用户退出登录
	 * @return
	 */
	public String logout(){
		ActionContext.getContext().getSession().remove("admin");
		ActionContext.getContext().put("message", "退出成功.");
		return "logout";
	}
}
