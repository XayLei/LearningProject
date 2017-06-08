package org.seckill.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* @author Ray: 
* @version 2017��6��8�� ����2:00:18 
* ��˵�� :
* ����Ҫ����spring��Junit���ϣ�Junit����ʱ����springIOC����
*/

@RunWith(SpringJUnit4ClassRunner.class)
//����Junit spring�������ʼ�
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
	
	//ע��DAOʵ��������
	@Resource
	private SeckillDao seckillDao;

	@Test
	public void testReduceNumber() throws Exception{
		Date killTime = new Date();
		int updateCount = seckillDao.reduceNumber(1000L, killTime);
		System.out.println("updateCount=" + updateCount);
	}

	@Test
	public void testQueryById() {
		long id = 1000;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}

	@Test
	public void testQueryAll() {
		List<Seckill> seckills = seckillDao.queryAll(0, 100);
		for (Seckill seckill : seckills) {
			System.out.println(seckill);
		}
	}

}
