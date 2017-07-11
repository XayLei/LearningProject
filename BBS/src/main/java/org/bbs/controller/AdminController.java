package org.bbs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bbs.entity.Board;
import org.bbs.entity.Post;
import org.bbs.entity.User;
import org.bbs.service.BoardService;
import org.bbs.service.PostService;
import org.bbs.service.ReplyService;
import org.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Ray:
 * @version 2017��7��11�� ����10:27:29 ��˵�� :
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	BoardService boardService;

	@Autowired
	UserService userService;

	@Autowired
	PostService postService;

	@Autowired
	ReplyService replyService;

	// ��̳��������
	@RequestMapping(value = "/manageCenter")
	public String manageCenter(HttpServletRequest request) {
		if (request.getSession().getAttribute("username").equals("admin")) {
			return "admin/manageCenter";
		}
		return "redirect:/error";
	}

	// ��̳����������
	@RequestMapping(value = "/manageBoard")
	public String manageBoard(HttpServletRequest request) {
		if (request.getSession().getAttribute("username").equals("admin")) {
			List<Board> boards = boardService.listAllBoard();
			request.setAttribute("boards", boards);
			return "admin/manageBoard";
		}
		return "redirect:/error";
	}

	// �����̳���
	@RequestMapping(value = "addBoard", method = RequestMethod.POST)
	public String addBoard(Board board, HttpServletRequest request) {
		if (board != null) {
			boardService.addBoardByBoard(board);
			return "redirect:/admin/manageBoard";
		}

		request.getSession().setAttribute("Msg", "��Ӱ�����");
		return "admin/error";
	}

	// �޸İ����Ϣ
	@RequestMapping(value = "updateBoard", method = RequestMethod.POST)
	public String updateBoard(Board board, HttpServletRequest request) {
		if (board != null) {
			boardService.updateBoardInfo(board);
			// �ɹ��������ݺ���תҳ��
			return "redirect:/admin/manageBoard";
		}

		// ��������ʧ����ת������ҳ��
		return "redirect:/error";
	}

	// �����û���Ϣ
	@RequestMapping(value = "manageUser")
	public String manageUser(HttpServletRequest request) {
		List<User> users = userService.getAllUser();
		if (users != null) {
			request.setAttribute("users", users);
			return "/admin/allUserInfo";
		}

		return "redirect:/error";
	}

	// �����������
	@RequestMapping(value = "managePost")
	public String managePost(HttpServletRequest request) {
		List<Post> posts = postService.listAllPost();
		if (posts != null) {
			request.setAttribute("posts", posts);
			return "/admin/allPostInfo";
		}

		return "redirect:/error";
	}

	// ɾ���Ѿ����������
	@RequestMapping(value = "deletePost")
	public String deletePost(int postId, int postBoardId) {
		postService.deletePost(postId);
		return "redirect:/board/listPosts-" + postBoardId;
	}

	// ɾ���ظ�
	@RequestMapping(value = "deleteReply")
	public String deleteReply(int replyId, int replyPostId) {
		replyService.deleteReply(replyId);
		return "redirect:/post/postContent-" + replyPostId;
	}

	// ɾ�����
	@RequestMapping(value = "deleteBoard")
	public String deleteBoard(int boardId) {
		boardService.deleteBoard(boardId);
		return "redirect:manageBoard";
	}
}