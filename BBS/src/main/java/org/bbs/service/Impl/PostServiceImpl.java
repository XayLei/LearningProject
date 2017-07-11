package org.bbs.service.Impl;

import java.util.List;

import org.bbs.dao.BoardDao;
import org.bbs.dao.PostDao;
import org.bbs.entity.Board;
import org.bbs.entity.Post;
import org.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ray:
 * @version 2017��7��11�� ����10:16:29 
 * ��˵�� :
 */
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostDao postDao;

	@Autowired
	BoardDao boardDao;

	public void addPostByPost(Post post) {
		postDao.addPost(post);
	}

	public Post listPostContent(int postId) {
		return postDao.findPostByPostId(postId);
	}

	public List<Post> listAllPost() {
		return postDao.listAllPostInfo();
	}

	public void deletePost(int postId) {
		// ����Board����
		int boardId = postDao.findPostByPostId(postId).getPostBoardId();
		Board board = boardDao.findBoardByBoardId(boardId);
		board.setBoardPostNum(board.getBoardPostNum() - 1);
		boardDao.updateBoardByBoard(board);

		// ɾ��post
		postDao.deletePostById(postId);
	}
}
