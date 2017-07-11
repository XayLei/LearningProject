package org.bbs.dao;

import java.util.List;

import org.bbs.entity.Post;
import org.springframework.stereotype.Repository;

/** 
* @author Ray: 
* @version 2017��7��11�� ����9:20:25 
* ��˵�� :
*/
@Repository
public interface PostDao {
	public void addPost(Post post);

    public Post findPostByPostId(int postId);

    public List<Post> listAllPostInfo();

    public void deletePostById(int postId);

    public void updatePostByPost(Post post);
}
