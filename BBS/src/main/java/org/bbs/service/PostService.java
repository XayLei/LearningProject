package org.bbs.service;

import java.util.List;

import org.bbs.entity.Post;

/** 
* @author Ray: 
* @version 2017年7月11日 下午10:04:56 
* 类说明 :帖子服务类
*/
public interface PostService {
	public void addPostByPost(Post post);

    public Post listPostContent(int postId);

    public List<Post> listAllPost();

    public void deletePost(int postId);
}
