package com.giraffe.service;

import com.giraffe.entity.Admin;

public interface AdminService {
	
	/**
	 * 处理管理员登录，登录成功，返回Admin实体，否则返回false
	 * @param username
	 * @param password
	 * @return
	 */
	Admin login(String username,String password);
}
