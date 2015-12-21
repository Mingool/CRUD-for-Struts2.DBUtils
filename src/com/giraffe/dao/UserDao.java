package com.giraffe.dao;

import java.util.List;

import com.giraffe.entity.User;

public interface UserDao {
	
	/**
	 * �������е�User����
	 * @return
	 */
	List<User> queryAllUsers();
	
	/**
	 * ����where������ѯUser
	 * @param sql
	 * @return
	 */
	List<User> queryUserWhere(String sql);
	
	/**
	 * ����User��ID��ѯUser
	 * @param userid
	 * @return
	 */
	User queryUserByUserID(String userid);
	
	/**
	 * ����User
	 * @throws Exception 
	 */
	void addUser(User user) throws Exception;
	
	/**
	 * ����User��Ϣ
	 * @param user
	 * @throws Exception 
	 */
	void updateUser(User user) throws Exception;
	
	/**
	 * ɾ��User
	 * @param user
	 * @throws Exception 
	 */
	void deleteUser(String id) throws Exception;
}
