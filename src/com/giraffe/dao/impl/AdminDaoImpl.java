package com.giraffe.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.giraffe.dao.AdminDao;
import com.giraffe.entity.Admin;
import com.giraffe.utils.DBCPUtils;

public class AdminDaoImpl implements AdminDao {
	
	QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
	
	/**
	 * ¸ù¾Ýusername²éÑ¯Admin
	 */
	public Admin queryAdminByUsername(String username) {
		Admin admin = null;
		try {
			admin = qr.query("select * from admin where username=?", new BeanHandler<Admin>(Admin.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
}
