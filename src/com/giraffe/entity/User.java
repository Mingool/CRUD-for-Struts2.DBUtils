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
	 * 显示所有的用户
	 * @return
	 */
	public String listUsers(){
		List<User> list = service.getAllUsers();
		ActionContext.getContext().put("users", list);
		return SUCCESS;
	}
	/***********************************************************************************/
	/**
	 * 条件查询用户列表
	 * @return
	 */
	public String queryWhere(){
		List<User> list = service.queryUserByCondition(this);
		ActionContext.getContext().put("users", list);
		return SUCCESS;
	}
	/***********************************************************************************/
	/**
	 * 查看一个人员的详细信息
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
	 * 查看人员信息的时候下载简历
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
	 * 添加一个人员,在此之前xml文件已经对表单数据进行校验
	 * @return
	 */
	public String addUser(){
		service.addUser(this);
		return "addOK";
	}
	/***********************************************************************************/
	/**
	 * 更新人员信息之前先查找一下详细信息
	 * @return
	 */
	public String beforeUpdateUser(){
		if(this.id ==null || "".equals(this.id.trim()))
			return ERROR;
		User user = service.findUser(this.id);
		ActionContext.getContext().put("user", user);
		/* 生成token，以便防止表单数据重复提交 */
		String token = UUID.randomUUID().toString();
		ActionContext.getContext().put("token", token);
		ActionContext.getContext().getSession().put("token", token);
		return "updateOK";
	}
	
	/**
	 * 更新人员信息,在此之前xml文件已经对表单数据进行校验
	 * @return
	 */
	public String updateUser(){
		String jsp_token = ServletActionContext.getRequest().getParameter("token");
		String session_token = (String) ActionContext.getContext().getSession().get("token");
		if(session_token !=null && session_token.equals(jsp_token)){
			service.updateUser(this);
			return "saveOK";
		}
		ActionContext.getContext().put("message", "服务器忙，请耐心等待，不要重复提交表单");
		return "message";
	}
	/***********************************************************************************/
	/**
	 * 删除一个User和该User的简历信息
	 * @return
	 */
	public String deleteUser(){
		if(this.id ==null || "".equals(this.id.trim()))
			return ERROR;
		service.deleteUser(this.id);
		return "deleteOK";
	}
}
