package kr.hs.gms.board.service;

import java.util.List;

import kr.hs.gms.board.vo.BoardVO;

public interface BoardService {
	
	void createBoard(BoardVO vo);
	
	void modifyBoard(BoardVO vo);
	
	void removeBoard(BoardVO vo);
	
	BoardVO getBoard(BoardVO vo);
	
	List<BoardVO> getBoardList(BoardVO vo);
}
