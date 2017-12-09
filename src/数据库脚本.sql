-- 删除数据库
DROP DATABASE classtest;
-- 创建数据库
CREATE DATABASE classtest;
-- 使用数据库
USE classtest;
-- 删除数据表


-- 创建数据表
-- 1、创建管理员表
CREATE TABLE admins (
  aid                  VARCHAR(50) NOT NULL ,
  password             VARCHAR(32)NOT NULL ,
  lastdate             DATETIME,
  name                 VARCHAR(50),
  flag                 INT,
  statu               INT,
  grade                VARCHAR(50),
  CONSTRAINT  pk_aid PRIMARY KEY (aid)
);
-- 2、学生表
CREATE TABLE students (
  sid                  VARCHAR(50) not null,
  password             VARCHAR(32) NOT NULL ,
  name                 VARCHAR(50),
  grade                VARCHAR(50),
  phone                VARCHAR(32),
  flag                 INT,
  statu                INT,
  lastdate             DATETIME,
  CONSTRAINT  pk_sid PRIMARY KEY (sid)
);
-- 3、老师表
create table teachers
(
  tid                  varchar(50) not null,
  password             varchar(32) not null,
  name                 VARCHAR(50),
  lastdate              DATETIME,
  CONSTRAINT pk_tid PRIMARY KEY (tid)
);

-- 4 课程表
CREATE TABLE courages(
  number           INT NOT NULL AUTO_INCREMENT ,
  grade            VARCHAR(50) NOT NULL ,
  lesson            VARCHAR(50),
  week              VARCHAR(32),
  site              VARCHAR(50),
  teacher           VARCHAR(50),
  CONSTRAINT pk_number PRIMARY KEY (number)

);
-- 5 平时分表
CREATE TABLE mark(
  number           VARCHAR(32) NOT NULL ,
  sid           VARCHAR(50) NOT NULL ,
  stept         VARCHAR(50),
  courage       VARCHAR(50),
  grade          INT,
  CONSTRAINT pk_number PRIMARY KEY (number)
);
-- 6 缺到表
CREATE TABLE absent(
  number               INT NOT NULL  AUTO_INCREMENT,
  sid                  VARCHAR(50) not null,
  name                 VARCHAR(50),
  grade                VARCHAR(50),
  flag                 INT,
  statu                INT,
  lastdate             VARCHAR(50),
  CONSTRAINT  pk_number PRIMARY KEY (number)
);

-- 增加测试数据
-- 管理员ID:admin ,管理员密码:ylcto
INSERT INTO admins(aid,password,name,flag,statu)VALUES ('123','7C9C0B787D24816FE630FC8619564306','谢鸿慧','1','1');

INSERT INTO students(sid,password,name,grade,phone)VALUEs ('6020162319','E12E14D131531B24934F5B4B9C969541','谢鸿慧','软件学院-1610','17370043344');
INSERT INTO students(sid,password,name,grade,phone)VALUEs ('6020162307','B356F009590E3BEED7905F63042004D5','康金涌','软件学院-1610','15270789442');
INSERT INTO students(sid,password,name,grade,phone)VALUEs ('6020162310','6B989FE907205092F1F8C5911BE685B0','刘君伟','软件学院-1610','15797952980');
INSERT INTO students(sid,password,name,grade,phone)VALUEs ('6020162327','54F3DDD6BED97B7DB47CF861055A7A52','毛昊罡','软件学院-1610','13979060307');
INSERT INTO teachers(tid,password,name)VALUES ('12341234','ED2B1F468C5F915F3F1CF75D7068BAAE','谢鸿慧');

INSERT INTO courages(number,grade,lesson,week,site,teacher)VALUES (1,'软件学院-1610','java程序设计','3-8','5-232','杨红云');
INSERT INTO courages(number,grade,lesson,week,site,teacher)VALUES (2,'软件学院-1610','大学英语听说','3-10','5-142','陈子安');
INSERT INTO courages(number,grade,lesson,week,site,teacher)VALUES (3,'软件学院-1610','数据库','3-14','1-232','刘明');
INSERT INTO courages(number,grade,lesson,week,site,teacher)VALUES (4,'软件学院-1610','数据结构','3-16','2-232','张三');
-- 提交
COMMIT ;