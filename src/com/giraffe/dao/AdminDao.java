package com.giraffe.dao;

import com.giraffe.entity.Admin;

public interface AdminDao {
	
	/**
	 * ͨ��username��ѯAdminȻ�󷵻�
	 * @return
	 */
	Admin queryAdminByUsername(String username);
}
