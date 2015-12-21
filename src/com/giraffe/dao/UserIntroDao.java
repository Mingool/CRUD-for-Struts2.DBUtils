package com.giraffe.dao;

import java.sql.SQLException;

import com.giraffe.entity.UserIntro;

public interface UserIntroDao {
	
	/**
	 * ͨ��user��id����ѯUserIntro
	 * @param userid
	 * @return
	 */
	UserIntro queryIntroByUserId(String userid);
	
	/**
	 * ����UserIntro,ͨ���Լ���id
	 * @param intro
	 * @throws SQLException 
	 */
	void updateIntroById(UserIntro intro) throws SQLException;
	
	/**
	 * ����һ��UserIntro
	 * @param intro
	 * @throws SQLException 
	 */
	void addUserIntro(UserIntro intro) throws SQLException;
	
	/**
	 * ͨ��user��idɾ��UserIntro
	 * @param userid
	 * @throws SQLException 
	 */
	void deleteUserIntroByUserId(String userid) throws SQLException;
}
