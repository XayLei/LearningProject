package org.bbs.dao;

import java.util.List;

import org.bbs.entity.UserLoginLog;
import org.springframework.stereotype.Repository;

/** 
* @author Ray: 
* @version 2017年7月11日 下午9:21:19 
* 类说明 :
*/
@Repository
public interface UserLoginLogDao {
	public List<UserLoginLog> listAllUserLoginLog();

    public void addUserLoginLog(UserLoginLog userLoginLog);
}
