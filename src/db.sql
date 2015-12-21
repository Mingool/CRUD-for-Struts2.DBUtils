DROP DATABASE IF EXISTS xCRUD;

CREATE DATABASE xCRUD DEFAULT CHARACTER SET utf8;

USE xCRUD;

CREATE TABLE admin(
	id VARCHAR(100) PRIMARY KEY,
	username VARCHAR(100) NOT NULL UNIQUE,
	nickname VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL
)ENGINE=InnoDB;

INSERT INTO admin VALUES ('0be3e082-2b4c-4bed-b749-bd2e5a8c96d0','giraffe','��������Ա','12345');

CREATE TABLE user(
	id VARCHAR(100) PRIMARY KEY,
	username VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	nickname VARCHAR(100),
	gender VARCHAR(10) NOT NULL, # 0��ʾŮ 1��ʾ��
	birthday DATE,
	education VARCHAR(100), #�о��� ������ ר��
	telephone VARCHAR(100),
	hobby VARCHAR(100), # ����,����,������
	remark VARCHAR(255)  #���
)ENGINE=InnoDB;

CREATE TABLE user_intro(
	id VARCHAR(100) PRIMARY KEY,
	old_name VARCHAR(100), # �ϴ��ļ�������
	new_name VARCHAR(100), # UUID_�ϴ��ļ�������
	path VARCHAR(100), # �ļ��Ĵ洢·��
	user_id VARCHAR(100), # user��id
	CONSTRAINT user_user_intro_id FOREIGN KEY(user_id) REFERENCES user(id)
)ENGINE=InnoDB;

	
	
	
	
	
	