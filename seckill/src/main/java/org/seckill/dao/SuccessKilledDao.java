package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/** 
* @author Ray: 
* @version 2017年6月7日 下午2:35:21 
* 类说明 :
*/
public interface SuccessKilledDao {
	/**
	 * 插入购买明细
	 * @param seckillId
	 * @param userPhone
	 * @return插入的行数
	 */
	int insertSuccessKilled(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
	
	/**
	 * 根据ID查询SuccessKilled并携带秒杀产品对象实体
	 * @param seckillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}
