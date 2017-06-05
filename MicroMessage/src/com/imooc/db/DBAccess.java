package com.imooc.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 訪問數據庫類
 *
 */
public class DBAccess {
	public SqlSession getSqlSession() throws IOException {
		//通过配置文件获取数据库连接信息
		String resource = "com/imooc/config/Configuration.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//通过配置信息得到一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过SqlSessionFactory打开一个数据库会话
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
}
