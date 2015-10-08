package com.giraffe.dao;

import java.util.List;

import com.giraffe.entity.User;

public interface UserDao {
	
	/**
	 * 返回所有的User对象
	 * @return
	 */
	List<User> queryAllUsers();
	
	/**
	 * 根据where条件查询User
	 * @param sql
	 * @return
	 */
	List<User> queryUserWhere(String sql);
	
	/**
	 * 根据User的ID查询User
	 * @param userid
	 * @return
	 */
	User queryUserByUserID(String userid);
	
	/**
	 * 增加User
	 * @throws Exception 
	 */
	void addUser(User user) throws Exception;
	
	/**
	 * 更新User信息
	 * @param user
	 * @throws Exception 
	 */
	void updateUser(User user) throws Exception;
	
	/**
	 * 删除User
	 * @param user
	 * @throws Exception 
	 */
	void deleteUser(String id) throws Exception;
}
