package com.imooc.dao;

import java.util.List;

import com.imooc.bean.Message;

/**
 * @author xulei
 * 与message配置文件相对应的接口
 */
public interface IMessage {
	/**
	 * 在这个接口中要代言哪个配置文件中的SQL语句，就在接口中声明一个与SQL语句ID相同的方法
	 * SQL语句中参数的类型就是方法中的参数类型
	 * SQL语句的返回值类型就是方法中的返回类型
	 */
	public List<Message> queryMessageList(Message message);
}
