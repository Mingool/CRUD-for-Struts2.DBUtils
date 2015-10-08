package com.giraffe.entity;

import java.io.Serializable;

public class UserIntro implements Serializable {
	private String id;
	private String oldFileName;
	private String newFileName;
	private String path;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOldFileName() {
		return oldFileName;
	}
	public void setOldFileName(String oldFileName) {
		this.oldFileName = oldFileName;
	}
	public String getNewFileName() {
		return newFileName;
	}
	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "UserIntro [id=" + id + ", oldFileName=" + oldFileName
				+ ", newFileName=" + newFileName + ", path=" + path + ", user="
				+ user + "]";
	}
	
	
}
