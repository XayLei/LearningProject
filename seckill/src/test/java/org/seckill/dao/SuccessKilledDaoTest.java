package org.seckill.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Ray:
 * @version 2017年6月8日 下午8:13:07 类说明 :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class SuccessKilledDaoTest {

	@Resource
	private SuccessKilledDao successKilledDao;

	/**
	 * 第一次运行：insertCount=1 第二次运行：insertCount=0 表示不允许同一手机号重复购买商品
	 */
	@Test
	public void testInsertSuccessKilled() {
		long id = 1001L;
		long phone = 17832332222L;
		int insertCount = successKilledDao.insertSuccessKilled(id, phone);
		System.out.println("insertCount=" + insertCount);
	}

	/**
	 * SuccessKilled [seckillId=1000, userPhone=17832332222, state=-1,
	 * createTime=Thu Jun 08 20:26:51 CST 2017]
	 * 
	 * Seckill [seckillId=1000, name=1000元秒杀iPhone 6s, number=100, startTime=Sun
	 * Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015,
	 * createTime=Tue Jun 06 21:10:45 CST 2017]
	 * 
	 * SuccessKilled [seckillId=1001, userPhone=17832332222, state=0,
	 * (通过在SuccessKilledDao中的insert语句中设置state的默认值为0，这里查询出的state就不再是-1了)
	 * createTime=Thu Jun 08 20:40:32 CST 2017]
	 * 
	 * Seckill [seckillId=1001, name=500元秒杀iPad Air, number=200, startTime=Sun
	 * Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015,
	 * createTime=Tue Jun 06 21:10:45 CST 2017]
	 */
	@Test
	public void testQueryByIdWithSeckill() {
		long id = 1001L;
		long phone = 17832332222L;
		SuccessKilled successKill = successKilledDao.queryByIdWithSeckill(id, phone);
		System.out.println(successKill);
		System.out.println(successKill.getSeckill());
	}

}
