package com.giraffe.dao;

import java.sql.SQLException;

import com.giraffe.entity.UserIntro;

public interface UserIntroDao {
	
	/**
	 * 通过user的id来查询UserIntro
	 * @param userid
	 * @return
	 */
	UserIntro queryIntroByUserId(String userid);
	
	/**
	 * 更新UserIntro,通过自己的id
	 * @param intro
	 * @throws SQLException 
	 */
	void updateIntroById(UserIntro intro) throws SQLException;
	
	/**
	 * 新增一个UserIntro
	 * @param intro
	 * @throws SQLException 
	 */
	void addUserIntro(UserIntro intro) throws SQLException;
	
	/**
	 * 通过user的id删除UserIntro
	 * @param userid
	 * @throws SQLException 
	 */
	void deleteUserIntroByUserId(String userid) throws SQLException;
}
