package org.bbs.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.bbs.entity.User;
import org.bbs.entity.UserLoginLog;
import org.bbs.service.LoginLogService;
import org.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Ray:
 * @version 2017��7��11�� ����10:23:44 ��˵�� :
 */

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private LoginLogService loginLogService;

	// �û���¼
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String userLogin(User loginUser, HttpServletRequest request, RedirectAttributes redirect) {
		// ͨ���û�������User����
		User user = userService.getUserByUserName(loginUser.getUserName());
		String password = "";
		if (user != null) {
			password = userService.getPassword(user.getUserName());
		}

		// �жϵ�¼��Ϣ�Ƿ���ȷ
		if (user != null && loginUser.getPassword().equals(password)) {

			// ��ȡ��¼������Ϣ
			String lastIp = request.getRemoteAddr();
			String userName = user.getUserName();
			Timestamp lastLoginTime = new Timestamp(new Date().getTime());

			// �����û���Ϣ
			user.setLastIp(lastIp);
			user.setLastLoginTime(lastLoginTime);
			user.setCredit(5 + user.getCredit());
			userService.updateUserByUserName(user);

			// �����û���¼��־
			UserLoginLog userLoginLog = new UserLoginLog();
			userLoginLog.setUserName(userName);
			userLoginLog.setLoginIp(lastIp);
			userLoginLog.setLoginDateTime(lastLoginTime);
			loginLogService.addUserLoginLog(userLoginLog);

			// ��½�ɹ�����ת����ҳ
			request.getSession().setAttribute("username", user.getUserName());
			return "redirect:/main";
		}

		// ��¼ʧ�ܣ���תҳ��
		request.setAttribute("Msg", "��¼ʧ��");
		return "error";
	}

	// �û�ע��
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String userRegister(User userRegister, HttpServletRequest request) {
		User user = userRegister;
		if (user != null) {
			try {
				String username = user.getUserName();
				String ip = request.getRemoteAddr();

				// ������ݿ���û�и��û�������ע�ᣬ������תҳ��
				if (userService.getUserByUserName(username) == null) {

					// ����û�
					user.setLastIp(ip);
					Timestamp createLoginTime = new Timestamp(new Date().getTime());
					user.setCreateTime(createLoginTime);
					user.setLastLoginTime(createLoginTime);
					userService.addUser(user);

					// ����û���¼��־
					UserLoginLog userLoginLog = new UserLoginLog();
					userLoginLog.setUserName(username);
					userLoginLog.setLoginIp(ip);
					userLoginLog.setLoginDateTime(createLoginTime);
					loginLogService.addUserLoginLog(userLoginLog);

					// ע��ɹ���ת
					request.setAttribute("username", username);
					return "index";
				} else {
					request.setAttribute("Msg", "ע��ʧ�ܣ��û����ѱ�ռ�ã�");
					return "error";
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("Msg", "����δ֪����");
				return "error";
			}
		}

		request.setAttribute("Msg", "����δ֪����");
		return "error";
	}

	// ��ʾ������Ϣ
	@RequestMapping(value = "/listUserInfo")
	public String listUserInfo(String username, HttpServletRequest request) {
		User user = userService.getUserByUserName(username);
		request.setAttribute("user", user);
		return "user/userInfo";
	}

	// �޸ĸ�����Ϣҳ��
	@RequestMapping(value = "/userUpdateInfo", method = RequestMethod.GET)
	public String userUpdateInfoPage(String username, HttpServletRequest request) {
		User user = userService.getUserByUserName(username);
		request.setAttribute("user", user);
		return "user/userUpdateInfo";
	}

	// �ύ�û��޸���Ϣ
	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	public String updateUserInfo(User user, RedirectAttributes redirectAttributes) {
		User newUser = user;
		userService.updateUserByUserName(newUser);
		redirectAttributes.addAttribute("username", newUser.getUserName());
		return "redirect:listUserInfo";
	}

	// �û�ע������
	@RequestMapping(value = "/loginOut")
	public String loginOut(HttpServletRequest request) {
		request.getSession().removeAttribute("username");
		return "index";
	}
}
