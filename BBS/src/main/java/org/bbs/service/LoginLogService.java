package org.bbs.service;

import org.bbs.entity.UserLoginLog;

/** 
* @author Ray: 
* @version 2017年7月11日 下午10:07:53 
* 类说明 :用户登录日志服务接口
*/
public interface LoginLogService {
	public void listAllUserLoginLog();

    public void addUserLoginLog(UserLoginLog userLoginLog);
}
