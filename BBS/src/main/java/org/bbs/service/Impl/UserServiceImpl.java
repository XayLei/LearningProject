package org.bbs.service.Impl;

import java.util.List;

import org.bbs.dao.UserDao;
import org.bbs.entity.User;
import org.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
* @author Ray: 
* @version 2017年7月11日 下午10:12:15 
* 类说明 :
*/
@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userDao;

    public void addUser(User user) {
        if (user != null) {
            userDao.addUser(user);
        }
    }

    public void updateUserByUserName(User user) {
        if (user != null) {
            userDao.updateUserByUserName(user);
        }
    }

    public User getUserByUserName(String userName) {
        if (userName == null) {
            return null;
        }
        return userDao.findUserByUserName(userName);
    }

    public String getPassword(String userName) {
        if (userName == null) {
            return null;
        }
        return userDao.getUserPasswordByUserName(userName);
    }

    public void deleteUserByUserName(String userName) {

    }

    public void loginSuccess(User user) {

    }

    public List<User> getAllUser() {
        return userDao.getAllUserInfo();
    }

}
