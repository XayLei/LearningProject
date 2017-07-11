package org.bbs.entity;

import java.sql.Timestamp;

/**
 * @author Ray:
 * @version 2017��7��11�� ����9:00:28 ��˵�� :�û���¼��־
 */
public class UserLoginLog {
	private int loginLogId;
	private String userName;
	private String loginIp;
	private Timestamp loginDateTime;
	private User user; // �û�����

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
