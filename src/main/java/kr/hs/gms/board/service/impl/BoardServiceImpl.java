package kr.hs.gms.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.gms.board.service.BoardService;
import kr.hs.gms.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAOMybatis boardDAO;
	
	public void createBoard(BoardVO vo) {
		
		boardDAO.insertBoard(vo);
	}

	public void modifyBoard(BoardVO vo) {
		
		boardDAO.updateBoard(vo);
	}

	public void removeBoard(BoardVO vo) {
		
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		
		return boardDAO.selectBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		
		return boardDAO.selectBoardList(vo);
	}
}
