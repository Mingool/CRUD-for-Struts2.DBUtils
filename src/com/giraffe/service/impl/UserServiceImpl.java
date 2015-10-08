package com.giraffe.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.giraffe.dao.DaoFactory;
import com.giraffe.dao.UserDao;
import com.giraffe.dao.UserIntroDao;
import com.giraffe.dao.impl.UserDaoImpl;
import com.giraffe.dao.impl.UserIntroDaoImpl;
import com.giraffe.entity.User;
import com.giraffe.entity.UserIntro;
import com.giraffe.service.UserService;
import com.giraffe.utils.DBCPUtils;
import com.giraffe.utils.MD5Utils;
import com.giraffe.utils.UploadUtils;

public class UserServiceImpl implements UserService {
	
	private UserDao userdao = DaoFactory.getInstance().getUserDao();
	private UserIntroDao introdao = DaoFactory.getInstance().getUserIntroDao();
	
	/**
	 * 显示所有的User
	 */
	public List<User> getAllUsers() {
		return userdao.queryAllUsers();
	}
	
	/**
	 * 根据User的ID查询User的详细信息,包括UserIntro
	 * @param userid
	 * @return
	 */
	public User findUser(String userid){
		User user = userdao.queryUserByUserID(userid);
		UserIntro intro = introdao.queryIntroByUserId(userid);
		user.setUserIntro(intro);
		return user;
	}
	
	/**
	 * 根据User的ID查询UserIntro然后返回，如果该User没上传简历则返回null
	 */
	public UserIntro findUserIntro(String userid) {
		return introdao.queryIntroByUserId(userid);
	}
	
	/**
	 * 条件查询User
	 */
	public List<User> queryUserByCondition(User user) {
		String nickname = user.getNickname();
		String gender = user.getGender();
		String education = user.getEducation();
		Integer isUpload = user.getIsUploadIntro();
		
		StringBuffer sb = new StringBuffer("where 1=1 ");
		if( nickname!=null && !nickname.trim().equals("") )
			sb.append("and nickname like '%"+nickname.trim()+"%' ");
		if( gender!=null && !gender.trim().equals("") )
			sb.append("and gender='"+gender+"' ");
		if( education!=null && !education.trim().equals(""))
			sb.append("and education='"+education+"' ");
		/* 联合查询  */
		if( isUpload!=null && isUpload==1 )
			sb.append("and id IN(SELECT user_id FROM user_intro WHERE path IS NOT NULL) ");
		if( isUpload!=null && isUpload==0 )
			sb.append("and id NOT IN(SELECT user_id FROM user_intro WHERE path IS NOT NULL) ");
		
		return userdao.queryUserWhere(sb.toString());
	}
	
	/**
	 * 添加一个User,包括添加简历信息
	 */
	public void addUser(User user) {
		/* work the userid field */
		user.setId(UUID.randomUUID().toString());
		/* work the password field */
		user.setPassword( MD5Utils.encode(user.getPassword()) );
		/* work the hobby field */
		if( user.getHobbies() != null){
			String[] hobbies = user.getHobbies();
			StringBuffer sb = new StringBuffer();
			for(int i=0 ; i<hobbies.length ; i++){
				if( i > 0 )
					sb.append(",");
				sb.append(hobbies[i]);
			}
			user.setHobby(sb.toString());
		}
		
		/* work the fileupload field */
		UserIntro userintro = null;
		
		if(user.getIntro()!=null){//用户上传了文件
			userintro = new UserIntro();
			userintro.setId( UUID.randomUUID().toString() );
			userintro.setOldFileName( user.getIntroFileName() );
			userintro.setNewFileName( UUID.randomUUID().toString() + "_" + user.getIntroFileName() );
			String storePath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/intros");
			userintro.setPath( UploadUtils.mkDirs( storePath , user.getIntroFileName() ) );
			userintro.setUser( user );
			user.setUserIntro( userintro );
			/* store the file to the server disk */
			File file = user.getIntro();
			try {
				FileUtils.copyFile(file, new File( userintro.getPath() + "\\" + userintro.getNewFileName() ));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/* start the database transaction */
		DBCPUtils.startThreadLocalConnTransaction();
		try {
			userdao.addUser(user);
			if(userintro!=null)
				introdao.addUserIntro(userintro);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			DBCPUtils.rollbackThreadLocalConn();
		} finally{
			DBCPUtils.commitThreadLocalConn();
			DBCPUtils.releaseThreadLocalConn();
		}
	}
	
	/**
	 * 更新User的信息,包括简历信息
	 */
	public void updateUser(User user) {
		/* work the password field */
		user.setPassword( MD5Utils.encode(user.getPassword()) );
		/* work the hobby field */
		if( user.getHobbies() != null){
			String[] hobbies = user.getHobbies();
			StringBuffer sb = new StringBuffer();
			for(int i=0 ; i<hobbies.length ; i++){
				if( i > 0 )
					sb.append(",");
				sb.append(hobbies[i]);
			}
			user.setHobby(sb.toString());
		}
		/* work the fileupload field */
		boolean hasUpload = false;
		UserIntro userintro = introdao.queryIntroByUserId( user.getId() );
		
		if(user.getIntro()!=null){ //用户上传了文件
			if(userintro == null){
				/* User hadn't upload files in the past */
				userintro.setId( UUID.randomUUID().toString() );
			}else{
				/* User had uploaded files in the past */
				hasUpload = true;
			}
			userintro.setOldFileName( user.getIntroFileName() );
			userintro.setNewFileName( UUID.randomUUID().toString() + "_" + user.getIntroFileName() );
			String storePath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/intros");
			userintro.setPath( UploadUtils.mkDirs( storePath , user.getIntroFileName() ) );
			
			userintro.setUser( user );
			user.setUserIntro( userintro );
			
			/* store the file to the server disk */
			File file = user.getIntro();
			try {
				FileUtils.copyFile(file, new File( userintro.getPath() + "\\" + userintro.getNewFileName() ));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/* start the database transaction */
		DBCPUtils.startThreadLocalConnTransaction();
		try {
			userdao.updateUser(user);
			
			if(user.getIntro()!=null){//用户上传了文件
				if(hasUpload){
					introdao.updateIntroById(userintro);
				}else{
					introdao.addUserIntro(userintro);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			DBCPUtils.rollbackThreadLocalConn();
		} finally{
			DBCPUtils.commitThreadLocalConn();
			DBCPUtils.releaseThreadLocalConn();
		}
	}
	
	/**
	 * 删除User
	 */
	public void deleteUser(String userid) {
		DBCPUtils.startThreadLocalConnTransaction();
		try {
			introdao.deleteUserIntroByUserId(userid);
			userdao.deleteUser(userid);
		} catch (Exception e) {
			e.printStackTrace();
			DBCPUtils.rollbackThreadLocalConn();
		} finally{
			DBCPUtils.commitThreadLocalConn();
			DBCPUtils.releaseThreadLocalConn();
		}
	}
}
