package com.giraffe.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.giraffe.dao.UserDao;
import com.giraffe.entity.User;
import com.giraffe.utils.DBCPUtils;

public class UserDaoImpl implements UserDao {

	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());

	public List<User> queryAllUsers() {
		List<User> list = null;
		try {
			list = qr.query("select * from user", new BeanListHandler<User>(
					User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<User> queryUserWhere(String sql) {
		if (sql == null || sql.trim().equals(""))
			return queryAllUsers();

		List<User> list = null;
		try {
			list = qr.query("select * from user" + " " + sql,
					new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public User queryUserByUserID(String userid) {
		if (userid == null || userid.trim().equals(""))
			return null;
		List<User> list = queryUserWhere("where id=" + "'" + userid + "'");
		return (list == null || list.size() <= 0) ? null : list.get(0);
	}

	public void addUser(User user) throws SQLException {
		if (user == null)
			return;
		qr.update(
				DBCPUtils.getThreadLocalConnection(),
				"insert into user (id,username,password,nickname,gender,birthday,education,telephone,hobby,remark) values (?,?,?,?,?,?,?,?,?,?)",
				user.getId(), user.getUsername(), user.getPassword(),
				user.getNickname(), user.getGender(), user.getBirthday(),
				user.getEducation(), user.getTelephone(), user.getHobby(),
				user.getRemark());

	}

	public void updateUser(User user) throws SQLException {
		if (user == null)
			return;
		qr.update(
				DBCPUtils.getThreadLocalConnection(),
				"update user set password=?,nickname=?,gender=?,birthday=?,education=?,telephone=?,hobby=?,remark=? where id=?",
				user.getPassword(), user.getNickname(), user.getGender(),
				user.getBirthday(), user.getEducation(), user.getTelephone(),
				user.getHobby(), user.getRemark(), user.getId());

	}

	public void deleteUser(String id) throws SQLException {
		if (id == null || id.trim().equals(""))
			return;

		qr.update(DBCPUtils.getThreadLocalConnection(),
				"delete from user where id=?", id);

	}
}
