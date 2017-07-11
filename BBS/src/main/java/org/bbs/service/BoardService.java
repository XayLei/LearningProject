package org.bbs.service;

import java.util.List;

import org.bbs.entity.Board;

/** 
* @author Ray: 
* @version 2017年7月11日 下午10:06:34 
* 类说明 :
*/
public interface BoardService {
	public void addBoardByBoard(Board board);

    public void deleteBoardByBoardName(String boardName);

    public List<Board> listAllBoard();

    public Board listAllPostOfBoard(int boardId);

    public Board intoBoardByBoardId(int boardId);

    public Board intoBoardByBoardName(String boardName);

    public void updatePostNum(int boardId);

    public void updateBoardInfo(Board board);

    public void deleteBoard(int boardId);
}
