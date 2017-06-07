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
	 * �����
	 * @param seckillId
	 * @param killTime
	 * @return
	 */
	int reduceNumber(long seckillId,Date killTime);
	
	/**
	 * ����successID��ѯ��ɱ��Seckill����
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * ����ƫ������ѯ��ɱ��Ʒ�б�
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(int offset,int limit);
}
