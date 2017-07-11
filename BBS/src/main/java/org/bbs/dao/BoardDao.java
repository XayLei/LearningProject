package org.bbs.dao;

import java.util.List;

import org.bbs.entity.Board;
import org.springframework.stereotype.Repository;

/** 
* @author Ray: 
* @version 2017年7月11日 下午9:20:59 
* 类说明 :
*/
@Repository
public interface BoardDao {
	public void addBoard(Board board);

    public List<Board> listAllBoard();

    public Board listAllPostsOfBoard(int boardId);

    public Board findBoardByBoardId(int boardId);

    public Board findBoardByBoardName(String boardName);

    public void updateBoardByBoard(Board board);

    public void deleteBoardById(int boardId);
}
