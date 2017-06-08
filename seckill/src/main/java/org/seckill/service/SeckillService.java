package org.seckill.service;

import java.util.List;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

/**
 * 
 * ҵ��ӿڣ�վ�ڡ�ʹ���ߡ��ĽǶ�ȥ��ƽӿ� �������棺�����������ȡ��������������� ��������Ҫ�Ѻ�
 * 
 * @author Ray:
 * @version 2017��6��8�� ����9:00:36 ��˵�� :
 */
public interface SeckillService {

	/**
	 * ��ѯ������ɱ��¼
	 * 
	 * @return
	 */
	List<Seckill> getSeckillList();

	/**
	 * ��ѯ������ɱ��¼
	 * 
	 * @param seckillId
	 * @return
	 */
	Seckill getById(long seckillId);

	/**
	 * ��ɱ����ʱ�����ɱ�ӿڵ�ַ�� �������ϵͳʱ�����ɱʱ��
	 * 
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);

	/**
	 * ִ����ɱ����
	 * 
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, SeckillCloseException, RepeatKillException;
}
