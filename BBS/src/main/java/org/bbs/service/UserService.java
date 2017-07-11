package org.bbs.service;

import java.util.List;

import org.bbs.entity.User;

/** 
* @author Ray: 
* @version 2017��7��11�� ����10:03:15 
* ��˵�� :�û�����ӿڣ��ӿ��еĳ��󷽷���ӦDAO�еĸ�������
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
