package org.bbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.bbs.entity.Reply;
import org.bbs.service.ReplyService;
import org.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Ray:
 * @version 2017年7月11日 下午10:24:10 类说明 :
 */
@Controller
@RequestMapping(value = "/reply")
public class ReplyController {
	@Autowired
	ReplyService replyService;

	@Autowired
	UserService userService;

	// 添加回复
	@RequestMapping(value = "addReply", method = RequestMethod.POST)
	public String addReply(Reply reply, HttpServletRequest request) {
		replyService.addReply(reply);
		return "redirect:/post/postContent-" + reply.getReplyPostId();
	}
}
