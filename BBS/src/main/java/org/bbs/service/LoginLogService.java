package org.bbs.service;

import org.bbs.entity.UserLoginLog;

/** 
* @author Ray: 
* @version 2017��7��11�� ����10:07:53 
* ��˵�� :�û���¼��־����ӿ�
*/
public interface LoginLogService {
	public void listAllUserLoginLog();

    public void addUserLoginLog(UserLoginLog userLoginLog);
}
