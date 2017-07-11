package org.bbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.bbs.entity.Board;
import org.bbs.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ray:
 * @version 2017��7��11�� ����10:27:43 ��˵�� :
 */
@Controller
@RequestMapping(value = "/board")
public class BoardController {
	@Autowired
	BoardService boardService;

	// ��ʾ��Ӧ��������
	@RequestMapping(value = "/listPosts-{boardId}")
	public String intoBoard(@PathVariable int boardId, HttpServletRequest request) {
		Board board = boardService.listAllPostOfBoard(boardId);
		request.setAttribute("board", board);
		request.setAttribute("boardId", boardId);
		return "post/postMain";
	}
}
