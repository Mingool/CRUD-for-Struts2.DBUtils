package com.giraffe.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.giraffe.dao.UserIntroDao;
import com.giraffe.entity.UserIntro;
import com.giraffe.utils.DBCPUtils;

public class UserIntroDaoImpl implements UserIntroDao {

	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());

	public UserIntro queryIntroByUserId(String userid) {
		if (userid == null || "".equals(userid.trim()))
			return null;
		try {
			return qr
					.query("SELECT id,old_name AS oldFileName,new_name AS newFileName,path FROM user_intro WHERE user_id=?",
							new BeanHandler<UserIntro>(UserIntro.class), userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateIntroById(UserIntro intro) throws SQLException {
		if (intro == null)
			return;

		qr.update(
				DBCPUtils.getThreadLocalConnection(),
				"update user_intro set old_name=?,new_name=?,path=?,user_id=? where id=?",
				intro.getOldFileName(), intro.getNewFileName(),
				intro.getPath(), intro.getUser().getId(), intro.getId());

	}

	public void addUserIntro(UserIntro intro) throws SQLException {
		if (intro == null)
			return;

		qr.update(
				DBCPUtils.getThreadLocalConnection(),
				"insert into user_intro (id,old_name,new_name,path,user_id) values (?,?,?,?,?)",
				intro.getId(), intro.getOldFileName(), intro.getNewFileName(),
				intro.getPath(), intro.getUser().getId());

	}

	public void deleteUserIntroByUserId(String userid) throws SQLException {
		if (userid == null || "".equals(userid.trim()))
			return;

		qr.update(DBCPUtils.getThreadLocalConnection(),
				"delete from user_intro where user_id=?", userid);

	}
}
