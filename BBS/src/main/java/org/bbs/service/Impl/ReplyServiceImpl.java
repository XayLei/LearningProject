package org.bbs.service.Impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.bbs.dao.PostDao;
import org.bbs.dao.ReplyDao;
import org.bbs.entity.Post;
import org.bbs.entity.Reply;
import org.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ray:
 * @version 2017年7月11日 下午10:18:11 类说明 :
 */
@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	ReplyDao replyDao;

	@Autowired
	PostDao postDao;

	public void addReply(Reply reply) {
		// 更新post信息
		Reply dbReply = reply;
		int postId = reply.getReplyPostId();
		Post post = postDao.findPostByPostId(postId);
		post.setPostReplyCount(post.getPostReplyCount() + 1);
		postDao.updatePostByPost(post);

		// 添加回复
		dbReply.setReplyCreateTime(new Timestamp(new Date().getTime()));
		replyDao.addReply(dbReply);
	}

	public List<Reply> listReplyByPostId(int replyPostId) {
		return replyDao.listReplyByPostId(replyPostId);
	}

	public void deleteReply(int replyId) {
		// 更新post信息
		Reply reply = replyDao.findReplyByReplyId(replyId);
		Post post = postDao.findPostByPostId(reply.getReplyPostId());
		post.setPostReplyCount(post.getPostReplyCount() - 1);
		postDao.updatePostByPost(post);

		// 删除回复
		replyDao.deleteReplyById(replyId);
	}
}
