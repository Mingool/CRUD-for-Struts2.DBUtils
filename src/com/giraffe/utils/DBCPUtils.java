package com.giraffe.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils {
	
	private static DataSource ds;
	private static ThreadLocal<Connection> th = new ThreadLocal<Connection>();
	
	static{
		try{
			InputStream in = DBCPUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
			Properties prop = new Properties();
			prop.load(in);
			ds = BasicDataSourceFactory.createDataSource(prop);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/**
	 * 返回数据源
	 * @return
	 */
	public static DataSource getDataSource(){
		return ds;
	}
	
	/**
	 * 得到该线程的Connection
	 * @return
	 */
	public static Connection getThreadLocalConnection(){
		Connection conn = th.get();
		if(conn==null){
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			th.set(conn);
		}
		return conn;
	}
	
	/**
	 * 开启该线程的Connection的事务
	 */
	public static void startThreadLocalConnTransaction(){
		Connection conn = th.get();
		if(conn==null)
			conn = getThreadLocalConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 回滚该线程的Connection的事务
	 */
	public static void rollbackThreadLocalConn(){
		Connection conn = th.get();
		if(conn==null)
			conn = getThreadLocalConnection();
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 提交该线程的Connection的事务
	 */
	public static void commitThreadLocalConn(){
		Connection conn = th.get();
		if(conn==null)
			conn = getThreadLocalConnection();
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 释放该线程的Connection,使其回到连接池
	 */
	public static void releaseThreadLocalConn(){
		Connection conn = th.get();
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			th.remove();
		}
	}
}
