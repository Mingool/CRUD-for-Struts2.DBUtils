package com.giraffe.service;

import java.util.List;

import com.giraffe.entity.User;
import com.giraffe.entity.UserIntro;

public interface UserService {
	
	/**
	 * 查询出所有的User对象
	 * @return
	 */
	List<User> getAllUsers();
	
	/**
	 * 根据User的ID查询某个用户的详细信息
	 * @param userid
	 * @return
	 */
	User findUser(String userid);
	
	/**
	 * 通过User的ID查询UserIntro并返回
	 * @param userid
	 * @return
	 */
	UserIntro findUserIntro(String userid);
	
	/**
	 * 条件查询User
	 * @param sql
	 * @return
	 */
	List<User> queryUserByCondition(User user);
	
	/**
	 * 添加一个User
	 * @param user
	 */
	void addUser(User user);
	
	/**
	 * 更新User信息
	 * @param user
	 */
	void updateUser(User user);
	
	/**
	 * 删除User
	 */
	void deleteUser(String userid);
	
}
