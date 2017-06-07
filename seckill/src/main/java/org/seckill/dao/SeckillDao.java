package org.seckill.dao;

import java.util.Date;
import java.util.List;

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
	
	/**
	 * 根据偏移量查询秒杀商品列表
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(int offset,int limit);
}
