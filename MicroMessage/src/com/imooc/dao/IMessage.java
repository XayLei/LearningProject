package com.imooc.dao;

import java.util.List;

import com.imooc.bean.Message;

/**
 * @author xulei
 * ��message�����ļ����Ӧ�Ľӿ�
 */
public interface IMessage {
	/**
	 * ������ӿ���Ҫ�����ĸ������ļ��е�SQL��䣬���ڽӿ�������һ����SQL���ID��ͬ�ķ���
	 * SQL����в��������;��Ƿ����еĲ�������
	 * SQL���ķ���ֵ���;��Ƿ����еķ�������
	 */
	public List<Message> queryMessageList(Message message);
}
