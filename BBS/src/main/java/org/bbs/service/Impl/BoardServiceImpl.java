package org.bbs.service.Impl;

import java.util.List;

import org.bbs.dao.BoardDao;
import org.bbs.entity.Board;
import org.bbs.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ray:
 * @version 2017年7月11日 下午10:20:12 类说明 :
 */
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;

	public void addBoardByBoard(Board board) {
		if (board != null) {
			boardDao.addBoard(board);
		}
	}

	public void deleteBoardByBoardName(String boardName) {

	}

	public List<Board> listAllBoard() {
		return boardDao.listAllBoard();
	}

	public Board listAllPostOfBoard(int boardId) {
		return boardDao.listAllPostsOfBoard(boardId);
	}

	public Board intoBoardByBoardId(int boardId) {
		return boardDao.findBoardByBoardId(boardId);
	}

	public void updatePostNum(int boardId) {
		Board board = boardDao.findBoardByBoardId(boardId);
		board.setBoardPostNum(board.getBoardPostNum() + 1);
		boardDao.updateBoardByBoard(board);
	}

	public Board intoBoardByBoardName(String boardName) {
		return boardDao.findBoardByBoardName(boardName);
	}

	public void updateBoardInfo(Board board) {
		boardDao.updateBoardByBoard(board);
	}

	public void deleteBoard(int boardId) {
		boardDao.deleteBoardById(boardId);
	}

}
