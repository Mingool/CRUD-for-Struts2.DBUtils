package com.giraffe.service;

import com.giraffe.entity.Admin;

public interface AdminService {
	
	/**
	 * �������Ա��¼����¼�ɹ�������Adminʵ�壬���򷵻�false
	 * @param username
	 * @param password
	 * @return
	 */
	Admin login(String username,String password);
}
