package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author xulei
 *�Ի�ҳ��ĳ�ʼ������
 *�������ҳ���������ʾ���룬��˵����talk.jsp��jscrollpane1.css�ļ��������
 *�����ʽ����notepad++�򿪣���UTF-8������棬�ٸ����빤�̣������Ϳ��Խ���˽��
 */
@SuppressWarnings("serial")
public class initTalkServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ñ����ʽ
		req.setCharacterEncoding("UTF-8");
		//��ҳ����ת
		req.getRequestDispatcher("/WEB-INF/jsps/front/talk.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
