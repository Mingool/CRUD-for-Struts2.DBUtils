package com.giraffe.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {

	private static DaoFactory factory = null;

	private DaoFactory() {
	}

	/**
	 * 得到工厂实例
	 * 
	 * @return
	 */
	public synchronized static DaoFactory getInstance() {
		if (factory == null)
			factory = new DaoFactory();
		return factory;
	}

	private static String UserDaoImplClassName;
	private static String UserIntroDaoImplClassName;
	private static String AdminDaoImplClassName;
	static {
		try {
			InputStream in = DaoFactory.class.getClassLoader()
					.getResourceAsStream("daoClass.properties");
			Properties props = new Properties();
			props.load(in);
			UserDaoImplClassName = props.getProperty("UserDao");
			UserIntroDaoImplClassName = props.getProperty("UserIntroDao");
			AdminDaoImplClassName = props.getProperty("AdminDao");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 返回UserDao的实例
	 * @return
	 */
	public UserDao getUserDao() {
		try {
			return (UserDao) Class.forName(UserDaoImplClassName).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 返回UserIntroDao的实例
	 * @return
	 */
	public UserIntroDao getUserIntroDao() {
		try {
			return (UserIntroDao) Class.forName(UserIntroDaoImplClassName).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 返回AdminDao的实例
	 * @return
	 */
	public AdminDao getAdminDao() {
		try {
			return (AdminDao) Class.forName(AdminDaoImplClassName).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
