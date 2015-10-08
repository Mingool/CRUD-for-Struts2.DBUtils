DROP DATABASE IF EXISTS xCRUD;

CREATE DATABASE xCRUD DEFAULT CHARACTER SET utf8;

USE xCRUD;

CREATE TABLE admin(
	id VARCHAR(100) PRIMARY KEY,
	username VARCHAR(100) NOT NULL UNIQUE,
	nickname VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL
)ENGINE=InnoDB;

INSERT INTO admin VALUES ('0be3e082-2b4c-4bed-b749-bd2e5a8c96d0','giraffe','超级管理员','12345');

CREATE TABLE user(
	id VARCHAR(100) PRIMARY KEY,
	username VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	nickname VARCHAR(100),
	gender VARCHAR(10) NOT NULL, # 0表示女 1表示男
	birthday DATE,
	education VARCHAR(100), #研究生 本科生 专科
	telephone VARCHAR(100),
	hobby VARCHAR(100), # 足球,篮球,兵乓球
	remark VARCHAR(255)  #简介
)ENGINE=InnoDB;

CREATE TABLE user_intro(
	id VARCHAR(100) PRIMARY KEY,
	old_name VARCHAR(100), # 上传文件的名称
	new_name VARCHAR(100), # UUID_上传文件的名称
	path VARCHAR(100), # 文件的存储路径
	user_id VARCHAR(100), # user的id
	CONSTRAINT user_user_intro_id FOREIGN KEY(user_id) REFERENCES user(id)
)ENGINE=InnoDB;

	
	
	
	
	
	