package org.bbs.service;

import java.util.List;

import org.bbs.entity.Reply;

/** 
* @author Ray: 
* @version 2017��7��11�� ����10:05:08 
* ��˵�� :�ظ�������
*/
public interface ReplyService {
	public void addReply(Reply reply);

    public List<Reply> listReplyByPostId(int postId);

    public void deleteReply(int replyId);
}
