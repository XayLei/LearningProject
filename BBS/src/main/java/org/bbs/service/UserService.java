package org.bbs.service;

import java.util.List;

import org.bbs.entity.User;

/** 
* @author Ray: 
* @version 2017年7月11日 下午10:03:15 
* 类说明 :用户服务接口，接口中的抽象方法对应DAO中的各个方法
*/
public interface UserService {
	public void addUser(User user);

    public void updateUserByUserName(User user);

    public User getUserByUserName(String userName);

    public void deleteUserByUserName(String userName);

    public void loginSuccess(User user);

    public String getPassword(String userName);

    public List<User> getAllUser();
}
