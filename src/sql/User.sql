CREATE TABLE user (
  id INT(11) AUTO_INCREMENT,
  username VARCHAR(20) ,
  PASSWORD VARCHAR(20) ,
  gender VARCHAR(10) ,
  email VARCHAR(50) ,
  telephone VARCHAR(20) ,
  introduce VARCHAR(100), -- 介绍
  activeCode VARCHAR(50) , -- 激活码
  state INT(11) , -- 激活状态
  role VARCHAR(10) DEFAULT '普通用户', -- 角色
  registTime TIMESTAMP ,
  PRIMARY KEY (id)
);