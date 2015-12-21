package com.giraffe.service;

import java.util.List;

import com.giraffe.entity.User;
import com.giraffe.entity.UserIntro;

public interface UserService {
	
	/**
	 * ��ѯ�����е�User����
	 * @return
	 */
	List<User> getAllUsers();
	
	/**
	 * ����User��ID��ѯĳ���û�����ϸ��Ϣ
	 * @param userid
	 * @return
	 */
	User findUser(String userid);
	
	/**
	 * ͨ��User��ID��ѯUserIntro������
	 * @param userid
	 * @return
	 */
	UserIntro findUserIntro(String userid);
	
	/**
	 * ������ѯUser
	 * @param sql
	 * @return
	 */
	List<User> queryUserByCondition(User user);
	
	/**
	 * ���һ��User
	 * @param user
	 */
	void addUser(User user);
	
	/**
	 * ����User��Ϣ
	 * @param user
	 */
	void updateUser(User user);
	
	/**
	 * ɾ��User
	 */
	void deleteUser(String userid);
	
}
