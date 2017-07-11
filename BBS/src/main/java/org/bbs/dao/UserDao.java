package org.bbs.dao;

import java.util.List;

import org.bbs.entity.User;
import org.springframework.stereotype.Repository;

/** 
* @author Ray: 
* @version 2017��7��11�� ����8:39:03 
* ��˵�� :�û���dao��
*/
@Repository  //���ڱ�ע���ݷ������
public interface UserDao {
	public User findUserByUserName(String username);

    public User findUserByUserId(int id);

    public void addUser(User user);

    public void deleteUserByUserName(String username);

    public void updateUserByUserName(User user);

    public String getUserPasswordByUserName(String username);

    public List<User> getAllUserInfo();
}
