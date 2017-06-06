package org.seckill.dao;

import java.util.Date;

import org.seckill.entity.Seckill;

/**
 * @author xulei
 *
 */
public interface SeckillDao {
	
	/**
	 * 减库存
	 * @param seckillId
	 * @param killTime
	 * @return
	 */
	int reduceNumber(long seckillId,Date killTime);
	
	/**
	 * 根据successID查询秒杀的Seckill对象
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);
}
