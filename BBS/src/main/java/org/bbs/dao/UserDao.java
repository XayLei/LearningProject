package org.bbs.dao;

import java.util.List;

import org.bbs.entity.User;
import org.springframework.stereotype.Repository;

/** 
* @author Ray: 
* @version 2017年7月11日 下午8:39:03 
* 类说明 :用户表dao层
*/
@Repository  //用于标注数据访问组件
public interface UserDao {
	public User findUserByUserName(String username);

    public User findUserByUserId(int id);

    public void addUser(User user);

    public void deleteUserByUserName(String username);

    public void updateUserByUserName(User user);

    public String getUserPasswordByUserName(String username);

    public List<User> getAllUserInfo();
}
