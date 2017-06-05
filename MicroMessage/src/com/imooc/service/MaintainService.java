package com.imooc.service;

import java.util.ArrayList;
import java.util.List;

import com.imooc.dao.MessageDao;

/**
 *ά����ز���������ɾ���������Ȳ���
 */
public class MaintainService {
	/**
	 * ɾ��������¼
	 * @param id ���ݿ��м�¼�����
	 */
	public void deleteOne(String id){
		if(id!=null && !"".equals(id.trim())){			
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id));
		}
	}
	
	/**
	 * ����ɾ����¼
	 * @param id ���ݿ��ж����¼�����ɵ��б�
	 */
	public void deleteBatch(String[] ids){
		MessageDao messageDao = new MessageDao();
		List<Integer> idList = new ArrayList<>();
		for (String id : ids) {
			idList.add(Integer.valueOf(id));
		}
		messageDao.deleteBatch(idList);
	}
}
