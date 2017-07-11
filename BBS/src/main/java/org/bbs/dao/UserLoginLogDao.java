package org.bbs.dao;

import java.util.List;

import org.bbs.entity.UserLoginLog;
import org.springframework.stereotype.Repository;

/** 
* @author Ray: 
* @version 2017��7��11�� ����9:21:19 
* ��˵�� :
*/
@Repository
public interface UserLoginLogDao {
	public List<UserLoginLog> listAllUserLoginLog();

    public void addUserLoginLog(UserLoginLog userLoginLog);
}
