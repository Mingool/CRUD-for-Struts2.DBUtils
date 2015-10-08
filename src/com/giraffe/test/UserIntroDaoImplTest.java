package com.giraffe.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

import com.giraffe.dao.impl.UserIntroDaoImpl;
import com.giraffe.entity.User;
import com.giraffe.entity.UserIntro;

public class UserIntroDaoImplTest {
	
	UserIntroDaoImpl dao = new UserIntroDaoImpl();

	@Test
	public void testQueryIntroByUserId() {
		UserIntro intro = dao.queryIntroByUserId("bf5342fd-642f-48b4-b7aa-d205f6bfcc10");
		System.out.println(intro);
	}

	@Test
	public void testUpdateIntroById() throws SQLException {
		UserIntro intro = new UserIntro();
		intro.setId("4729d247-a6ca-4cc1-ba1e-e2731f8586ac");
		intro.setOldFileName("oldname_re");
		intro.setNewFileName("newname_re");
		intro.setPath("path_re");
		User u = new User();u.setId("4f3ae86e-78c0-4d88-a761-2bcfc7b6b121");
		intro.setUser(u);
		dao.updateIntroById(intro);
	}

	@Test
	public void testAddUserIntro() throws SQLException {
		UserIntro intro = new UserIntro();
		intro.setId(UUID.randomUUID().toString());
		intro.setOldFileName("oldname");
		intro.setNewFileName("newname");
		intro.setPath("path");
		User u = new User();u.setId("bf5342fd-642f-48b4-b7aa-d205f6bfcc10");
		intro.setUser(u);
		dao.addUserIntro(intro);
	}

	@Test
	public void testDeleteUserIntroByUserId() throws SQLException {
		dao.deleteUserIntroByUserId("bf5342fd-642f-48b4-b7aa-d205f6bfcc10");
	}
}
