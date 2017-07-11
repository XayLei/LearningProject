package org.bbs.dao;

import java.util.List;

import org.bbs.entity.Reply;
import org.springframework.stereotype.Repository;

/** 
* @author Ray: 
* @version 2017年7月11日 下午9:20:38 
* 类说明 :
*/
@Repository
public interface ReplyDao {
	public void addReply(Reply reply);

    public List<Reply> listReplyByPostId(int postId);

    public void deleteReplyById(int postId);

    public Reply findReplyByReplyId(int replyId);
}
