package org.bbs.service;

import java.util.List;

import org.bbs.entity.Reply;

/** 
* @author Ray: 
* @version 2017年7月11日 下午10:05:08 
* 类说明 :回复服务类
*/
public interface ReplyService {
	public void addReply(Reply reply);

    public List<Reply> listReplyByPostId(int postId);

    public void deleteReply(int replyId);
}
