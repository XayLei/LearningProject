package com.imooc.service;

import java.util.ArrayList;
import java.util.List;

import com.imooc.dao.MessageDao;

/**
 *维护相关操作，例如删除、新增等操作
 */
public class MaintainService {
	/**
	 * 删除单条记录
	 * @param id 数据库中记录的序号
	 */
	public void deleteOne(String id){
		if(id!=null && !"".equals(id.trim())){			
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id));
		}
	}
	
	/**
	 * 批量删除记录
	 * @param id 数据库中多个记录序号组成的列表
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
