package com.giraffe.service.impl;

import com.giraffe.dao.AdminDao;
import com.giraffe.dao.DaoFactory;
import com.giraffe.dao.impl.AdminDaoImpl;
import com.giraffe.entity.Admin;
import com.giraffe.service.AdminService;

public class AdminServiceImpl implements AdminService {
	
	AdminDao dao = DaoFactory.getInstance().getAdminDao();
	
	/**
	 * 处理管理员登录
	 */
	public Admin login(String username, String password) {
		if(username==null || username.trim().equals(""))
			return null;
		Admin adm =  dao.queryAdminByUsername(username);
		if(adm != null && adm.getPassword().equals(password))
			return adm;
		
		return null;
	}
}
