package org.bbs.service.Impl;

import org.bbs.dao.UserLoginLogDao;
import org.bbs.entity.UserLoginLog;
import org.bbs.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
* @author Ray: 
* @version 2017��7��11�� ����10:21:31 
* ��˵�� :
*/
@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    UserLoginLogDao userLoginLogDao;

    public void listAllUserLoginLog() {

    }

    public void addUserLoginLog(UserLoginLog userLoginLog) {
        userLoginLogDao.addUserLoginLog(userLoginLog);
    }
}
