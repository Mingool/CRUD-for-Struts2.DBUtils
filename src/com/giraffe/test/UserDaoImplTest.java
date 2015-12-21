package com.giraffe.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.giraffe.dao.UserDao;
import com.giraffe.dao.impl.UserDaoImpl;
import com.giraffe.entity.User;

public class UserDaoImplTest {
	
	private UserDao dao = new UserDaoImpl();
	
	@Test
	public void testQueryAllUsers() {
		List<User> list = dao.queryAllUsers();
		System.out.println(list==null?"Ϊ��":"��Ϊ��");
		if(list==null)
			return;
		for(User user : list){
			System.out.println(user);
		}
	}

	@Test
	public void testQueryUserWhere() {
		List<User> list = dao.queryUserWhere("where id='bf5342fd-642f-48b4-b7aa-d205f6bfcc10'");
		System.out.println(list==null?"Ϊ��":"��Ϊ��");
		if(list==null)
			return;
		for(User user : list){
			System.out.println(user);
		}
	}

	@Test
	public void testQueryUserByUserID() {
		User user = dao.queryUserByUserID("bf5342fd-642f-48b4-b7aa-d205f6bfcc10");
		System.out.println(user);
	}

	@Test
	public void testUpdateUser() throws Exception {
		User user = new User();
		user.setId("0709e695-e86d-47cd-aca8-f711871c7a5d");user.setUsername("feixue22");user.setPassword("4321");
		user.setNickname("��ѩ2�ĺ�");user.setGender("1");user.setBirthday(new Date());
		user.setEducation("daѧ");user.setTelephone("110");user.setHobby("����,����");
		//user.setPath("adasd");user.setFilename("dnz.zip");user.setRemark("hahhaha");
		dao.updateUser(user);
	}

	@Test
	public void testDeleteUser() {
		//dao.deleteUser("0709e695-e86d-47cd-aca8-f711871c7a5d");
	}
	
	@Test
	public void testAddUser() throws Exception {
		User user = new User();
		user.setId(UUID.randomUUID().toString());user.setUsername("feixue2");user.setPassword("5211314b");
		user.setNickname("��ɵ�ѩ");user.setGender("0");user.setBirthday(new Date());
		user.setEducation("�о���");user.setTelephone("15222989876");user.setHobby("����");
		//user.setPath("adasd");user.setFilename("dnz.zip");user.setRemark("whats the beauty!");
		dao.addUser(user);
	}

}
