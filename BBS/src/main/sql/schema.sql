CREATE DATABASE IF NOT EXISTS bbs CHARACTER SET UTF8;
USE bbs;

#�û���Ϣ��
CREATE TABLE IF NOT EXISTS t_user(
user_id INT(10) NOT NULL AUTO_INCREMENT COMMENT '�û�id',
user_name VARCHAR(30) NOT NULL UNIQUE COMMENT '�û���',
password VARCHAR(30) NOT NULL DEFAULT '' COMMENT '����',
user_email VARCHAR(30) NOT NULL UNIQUE COMMENT '�û�����',
user_sex VARCHAR(30) NOT NULL COMMENT '�û��Ա�',
user_phone INT(11) DEFAULT NULL COMMENT '�绰����',
create_time DATETIME NOT NULL COMMENT '�û�����ʱ��',
user_type INT(2) NOT NULL DEFAULT '1' COMMENT '�û����� 0:����Ա 1:��ͨ�û�',
user_state INT(2) NOT NULL DEFAULT '0' COMMENT '�û�״̬ 0:���� 1:����',
credit INT(10) NOT NULL DEFAULT '100' COMMENT '�û�����',
last_login_time DATETIME DEFAULT NULL COMMENT '�û�������ʱ��',
last_ip VARCHAR(20) DEFAULT NULL COMMENT '�û�������ip',
PRIMARY KEY (`user_id`)
)ENGINE=InnoDB  DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

#��̳����
CREATE TABLE IF NOT EXISTS t_board(
board_id int(10) NOT NULL AUTO_INCREMENT COMMENT '��̳���id',
board_name VARCHAR(150) NOT NULL DEFAULT '' COMMENT '��̳�������',
board_desc VARCHAR(300) NOT NULL DEFAULT '' COMMENT '��̳�������',
board_post_num INT(10) NOT NULL DEFAULT '0' COMMENT '������Ŀ',
PRIMARY KEY  (`board_id`)
)ENGINE=InnoDB  DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

#��¼��־��
CREATE TABLE IF NOT EXISTS t_login_log(
login_log_id INT(10) NOT NULL AUTO_INCREMENT COMMENT '��־ID',
user_name VARCHAR(30) NOT NULL COMMENT '�û���',
login_ip VARCHAR(30) NOT NULL DEFAULT '' COMMENT '��¼IP',
login_datetime DATETIME NOT NULL COMMENT '��¼ʱ��',
PRIMARY KEY (`login_log_id`)
)ENGINE=InnoDB  DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

#���ӱ�
CREATE TABLE IF NOT EXISTS t_post(
post_id INT(10) NOT NULL AUTO_INCREMENT COMMENT '����ID',
post_board_id INT(10) NOT NULL default '0' COMMENT '��̳���ID',
post_user_name VARCHAR(30) NOT NULL default '0' COMMENT '����������',
post_title VARCHAR(50) NOT NULL COMMENT '��������',
post_content TEXT NOT NULL COMMENT '��������',
post_good_count INT(10) NOT NULL DEFAULT '0' COMMENT '����',
post_bad_count INT(10) NOT NULL DEFAULT  '0' COMMENT '����',
post_view_count INT(10) NOT NULL DEFAULT '0' COMMENT '��������',
post_reply_count INT(10) NOT NULL DEFAULT '0' COMMENT '������Ŀ',
post_status INT(2) NOT NULL default '0' COMMENT '����״̬:0:���� 1:����',
post_create_time DATETIME NOT NULL COMMENT '����ʱ��',
post_update_time DATETIME COMMENT '����ʱ��',
PRIMARY KEY  (`post_id`)
) ENGINE=InnoDB  DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

#�ظ���
CREATE TABLE IF NOT EXISTS t_reply(
reply_id INT(10) NOT NULL AUTO_INCREMENT COMMENT '�ظ�ID',
reply_post_id INT(10) NOT NULL COMMENT '���ظ����ӵ�ID',
reply_user_name VARCHAR(30) NOT NULL COMMENT '����������',
reply_content TEXT NOT NULL COMMENT '�ظ�����',
reply_good_count INT(10) NOT NULL DEFAULT '0' COMMENT '����',
reply_bad_count INT(10) NOT NULL DEFAULT  '0' COMMENT '����',
reply_create_time DATETIME NOT NULL COMMENT '�ظ�ʱ��',
PRIMARY KEY  (`reply_id`)
)ENGINE=InnoDB  DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
