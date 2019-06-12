mysql -uroot -proot
/* 详细数据库请采用 bookstore_teach */
/* 详细数据库请采用 bookstore_teach */
/* 详细数据库请采用 bookstore_teach */
/* 详细数据库请采用 bookstore_teach */
/* 详细数据库请采用 bookstore_teach */
/* 详细数据库请采用 bookstore_teach */
/* 详细数据库请采用 bookstore_teach */
/* 详细数据库请采用 bookstore_teach */
/* 详细数据库请采用 bookstore_teach */
/* 详细数据库请采用 bookstore_teach */
/* 详细数据库请采用 bookstore_teach */
/* 详细数据库请采用 bookstore_teach */
/* 详细数据库请采用 bookstore_teach */







/* 约束： 主键primary key、 非空not null 、唯一unique、外键foreign key、检查check、默认default
-- SQL 结构化查询语言	
		-- 厂商：MYSQL \ Oracle (甲骨文)数据库\ MSSQL(微软的SqlServer) asp\ IBM的DB2
					|--- 下载SqlServer：请访问：itellyou.cn  或  百度 MSDN  */
/* CSDN、博客园 、 51CTO  open-open.COM     itpub */
-- DDL数据定义语言   DML数据操纵语言  DCL数据控制语言   DQL数据查询语言   TCL Transaction 			事物控制语言   		ACDI

/* 对表的操作的关键字 ：  创建表  create table  表的名称(字段1 字段1的类型,(字段2 字段2的类型....); 
/* 				        修改表  alter table  表的名称(字段1 字段1的类型,(字段2 字段2的类型....); 
					删除表  drop
					查询表   select

	- 对表数据的操作的关键字      插入表  insert
						  修改表  update
					 	  删除表   delete
					   	  查询表   select

*/
/*
MySQL的分页语句：
		SELECT * FROM USER  LIMIT 1,2;
				limit 从哪里开始(但不包括当前数字), 要显示几条记录
						start		row

*/
-- 创建一个数据库
	create database bookstore;
	
-- 选择一个数据库
	use bookstore;
drop table if exists `category`;	
--  创建一个表 分类表
create table category(
	id varchar(100) primary key,
	name varchar(100) not null unique,-- unique 代表的是唯一，不重复
	description varchar(255) 
);

drop table if exists `user`;
--  创建一个表 用户表
create table user(
	id varchar(100) primary key,
	username varchar(100) not null unique,
	password varchar(100) not null,
	type varchar(20) not null,
	sex varchar(6)
	
);

drop table if exists `book`;

--  创建一个表 图书表
create table book(
	id varchar(100) primary key ,
	name varchar(100) not null,
	author varchar(100) not null,
	description  varchar(100) ,
	publish  varchar(100) not null ,
	price  float not null ,
	path  varchar(100) ,
	photoName  varchar(100) ,
	categoryId varchar(100) not null,
	foreign key(categoryId) references category(id)
);

insert into category(id,name,description) values('1','武侠','金庸巨作...');







