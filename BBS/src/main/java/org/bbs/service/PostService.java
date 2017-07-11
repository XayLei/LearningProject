package org.bbs.service;

import java.util.List;

import org.bbs.entity.Post;

/** 
* @author Ray: 
* @version 2017��7��11�� ����10:04:56 
* ��˵�� :���ӷ�����
*/
public interface PostService {
	public void addPostByPost(Post post);

    public Post listPostContent(int postId);

    public List<Post> listAllPost();

    public void deletePost(int postId);
}
