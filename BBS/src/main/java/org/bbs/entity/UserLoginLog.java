package org.bbs.entity;

import java.sql.Timestamp;

/**
 * @author Ray:
 * @version 2017年7月11日 下午9:00:28 类说明 :用户登录日志
 */
public class UserLoginLog {
	private int loginLogId;
	private String userName;
	private String loginIp;
	private Timestamp loginDateTime;
	private User user; // 用户属性

	public int getLoginLogId() {
		return loginLogId;
	}

	public void setLoginLogId(int loginLogId) {
		this.loginLogId = loginLogId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Timestamp getLoginDateTime() {
		return loginDateTime;
	}

	public void setLoginDateTime(Timestamp loginDateTime) {
		this.loginDateTime = loginDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserLoginLog [loginLogId=" + loginLogId + ", userName=" + userName + ", loginIp=" + loginIp
				+ ", loginDateTime=" + loginDateTime + "]";
	}
}
