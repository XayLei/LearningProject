package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/** 
* @author Ray: 
* @version 2017��6��7�� ����2:35:21 
* ��˵�� :
*/
public interface SuccessKilledDao {
	/**
	 * ���빺����ϸ
	 * @param seckillId
	 * @param userPhone
	 * @return���������
	 */
	int insertSuccessKilled(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
	
	/**
	 * ����ID��ѯSuccessKilled��Я����ɱ��Ʒ����ʵ��
	 * @param seckillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}
