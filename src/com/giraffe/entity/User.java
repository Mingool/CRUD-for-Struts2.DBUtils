package com.giraffe.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.giraffe.service.UserService;
import com.giraffe.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport implements Serializable {
	/* javaBean ORM database */
	private String id;
	private String username;
	private String password;
	private String nickname;
	private String gender;
	private java.util.Date birthday;
	private String education;
	private String telephone;
	private String hobby;
	private String remark;
	private UserIntro userIntro;
	/* other support field */
	private String[] hobbies;
	private InputStream inputStream;
	private Integer isUploadIntro;
	private File intro;
	private String introFileName;
	/* geting and setting method */
	public String getId() {
		return id;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public Integer getIsUploadIntro() {
		return isUploadIntro;
	}
	public void setIsUploadIntro(Integer isUploadIntro) {
		this.isUploadIntro = isUploadIntro;
	}
	public File getIntro() {
		return intro;
	}
	public void setIntro(File intro) {
		this.intro = intro;
	}
	public String getIntroFileName() {
		return introFileName;
	}
	public void setIntroFileName(String introFileName) {
		this.introFileName = introFileName;
	}
	public UserIntro getUserIntro() {
		return userIntro;
	}
	public void setUserIntro(UserIntro userIntro) {
		this.userIntro = userIntro;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", nickname=" + nickname + ", gender=" + gender
				+ ", birthday=" + birthday + ", education=" + education
				+ ", telephone=" + telephone + ", hobby=" + hobby + ", remark="
				+ remark + ", userIntro=" + userIntro + ", hobbies="
				+ Arrays.toString(hobbies) + ", isUploadIntro=" + isUploadIntro
				+ ", intro=" + intro + ", introFileName=" + introFileName + "]";
	}

	private UserService service = new UserServiceImpl();
	/***********************************************************************************/
	/**
	 * ��ʾ���е��û�
	 * @return
	 */
	public String listUsers(){
		List<User> list = service.getAllUsers();
		ActionContext.getContext().put("users", list);
		return SUCCESS;
	}
	/***********************************************************************************/
	/**
	 * ������ѯ�û��б�
	 * @return
	 */
	public String queryWhere(){
		List<User> list = service.queryUserByCondition(this);
		ActionContext.getContext().put("users", list);
		return SUCCESS;
	}
	/***********************************************************************************/
	/**
	 * �鿴һ����Ա����ϸ��Ϣ
	 * @return
	 */
	public String findUser(){
		if(this.id ==null || "".equals(this.id.trim()))
			return ERROR;
		User user = service.findUser(this.id);
		ActionContext.getContext().put("user", user);
		return "findUser";
	}
	
	/**
	 * �鿴��Ա��Ϣ��ʱ�����ؼ���
	 * @return
	 */
	public String download(){
		if(this.id ==null || "".equals(this.id.trim()))
			return ERROR;
		UserIntro intr = service.findUserIntro(this.id);
		try {
			this.inputStream = new FileInputStream( intr.getPath() + "\\" + intr.getNewFileName() );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return ERROR;
		}
		return "download";
	}
	/***********************************************************************************/
	/**
	 * ���һ����Ա,�ڴ�֮ǰxml�ļ��Ѿ��Ա����ݽ���У��
	 * @return
	 */
	public String addUser(){
		service.addUser(this);
		return "addOK";
	}
	/***********************************************************************************/
	/**
	 * ������Ա��Ϣ֮ǰ�Ȳ���һ����ϸ��Ϣ
	 * @return
	 */
	public String beforeUpdateUser(){
		if(this.id ==null || "".equals(this.id.trim()))
			return ERROR;
		User user = service.findUser(this.id);
		ActionContext.getContext().put("user", user);
		/* ����token���Ա��ֹ�������ظ��ύ */
		String token = UUID.randomUUID().toString();
		ActionContext.getContext().put("token", token);
		ActionContext.getContext().getSession().put("token", token);
		return "updateOK";
	}
	
	/**
	 * ������Ա��Ϣ,�ڴ�֮ǰxml�ļ��Ѿ��Ա����ݽ���У��
	 * @return
	 */
	public String updateUser(){
		String jsp_token = ServletActionContext.getRequest().getParameter("token");
		String session_token = (String) ActionContext.getContext().getSession().get("token");
		if(session_token !=null && session_token.equals(jsp_token)){
			service.updateUser(this);
			return "saveOK";
		}
		ActionContext.getContext().put("message", "������æ�������ĵȴ�����Ҫ�ظ��ύ��");
		return "message";
	}
	/***********************************************************************************/
	/**
	 * ɾ��һ��User�͸�User�ļ�����Ϣ
	 * @return
	 */
	public String deleteUser(){
		if(this.id ==null || "".equals(this.id.trim()))
			return ERROR;
		service.deleteUser(this.id);
		return "deleteOK";
	}
}
