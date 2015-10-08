package com.giraffe.dao;

import com.giraffe.entity.Admin;

public interface AdminDao {
	
	/**
	 * 通过username查询Admin然后返回
	 * @return
	 */
	Admin queryAdminByUsername(String username);
}
