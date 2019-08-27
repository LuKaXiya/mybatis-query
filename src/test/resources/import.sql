-- SET DATABASE SQL SYNTAX MYS TRUE;
drop table t_user if exists;
create table t_user (id bigint generated by default as identity (start with 1), account varchar(255), user_name varchar(255), password varchar(255), nick_name varchar(255), user_level varchar(255), mobile varchar(255), email varchar(255), memo varchar(255), valid boolean not null, primary key (id));

INSERT INTO t_user (id, account, user_name, mobile, email, nick_name, password, user_level, valid) VALUES (1, 'daniel','daniel.hu', '18812341234', 'daniel@xx.com', '别名', '123456', '高级', true);
INSERT INTO t_user (id, account, user_name, mobile, email, nick_name, password, user_level, valid) VALUES (2, 'user1','赵云', '18812341235', 'test1@qq.com', '别名1', '123456', '普通', true);
INSERT INTO t_user (id, account, user_name, mobile, email, nick_name, password, user_level, valid) VALUES (3, 'user2','张飞', '18812341236', 'test2@qq.com', '别名2', '123456', '普通', true);
INSERT INTO t_user (id, account, user_name, mobile, email, nick_name, password, user_level, valid) VALUES (4, 'user3','关羽', '18812341237', 'test3@qq.com', '别名3', '123456', '普通', true);
