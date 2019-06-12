create database school;
use school;
create  table columns(
  id int primary  key auto_increment,
  name varchar (50)  not null,
  description   varchar (250)
);
create  table  news (
  id int primary  key auto_increment,
  title varchar (50)  not null,
  description   varchar (250),
  content varchar (5000) ,
  createTime varchar (50),
  click int  default  0,
  column_id  int ,
  foreign  key column_id references  columns(id)
);