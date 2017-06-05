package com.imooc.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * �L���������
 *
 */
public class DBAccess {
	public SqlSession getSqlSession() throws IOException {
		//ͨ�������ļ���ȡ���ݿ�������Ϣ
		String resource = "com/imooc/config/Configuration.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//ͨ��������Ϣ�õ�һ��SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//ͨ��SqlSessionFactory��һ�����ݿ�Ự
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
}
