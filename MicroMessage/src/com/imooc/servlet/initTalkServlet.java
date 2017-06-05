package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author xulei
 *对话页面的初始化设置
 *在浏览器页面中如果显示乱码，则说明是talk.jsp与jscrollpane1.css文件编码错误
 *解决方式：用notepad++打开，以UTF-8编码另存，再覆盖入工程，这样就可以解决了解决
 */
@SuppressWarnings("serial")
public class initTalkServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		//向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsps/front/talk.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
