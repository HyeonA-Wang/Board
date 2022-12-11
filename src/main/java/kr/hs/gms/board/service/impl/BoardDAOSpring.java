package kr.hs.gms.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.hs.gms.board.vo.BoardRowMapper;
import kr.hs.gms.board.vo.BoardVO;

//@Repository("boardDAO")
public class BoardDAOSpring {
	
	
	
	private final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC";
	private final String BOARD_LIST_T = "SELECT * FROM BOARD WHERE TITLE LIKE '%' || ? || '%' ORDER BY SEQ DESC";
	private final String BOARD_LIST_C = "SELECT * FROM BOARD WHERE CONTENT LIKE '%' || ? || '%' ORDER BY SEQ DESC";
	private final String BOARD_INFO = "SELECT * FROM BOARD WHERE SEQ = ?";
	private final String BOARD_INSERT = "INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT) VALUES ((SELECT NVL(MAX(SEQ), 0) + 1 FROM BOARD), ?, ?, ?)";
	private final String BOARD_UPDATE = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, WRITER = ? WHERE SEQ = ?";
	private final String BOARD_DELETE = "DELETE FROM BOARD WHERE SEQ = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public BoardVO selectBoard(BoardVO vo) {
		System.out.println("===> JDBC Template로 selectBoard() 기능 처리");
		
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_INFO, args, new BoardRowMapper());
	}
	
	public List<BoardVO> selectBoardList(BoardVO vo) {
		System.out.println("===> JDBC Template로 selectBoardList() 기능 처리");
		
		Object[] args = {vo.getSearchKeyword()};
		
		System.out.println(vo.toString());
		
		if(vo.getSearchCondition().equals("TITLE")) {
			return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
		}else if(vo.getSearchCondition().equals("CONTENT")) {
			return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		}
		if(vo.getSearchCondition() == null) {
			return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		}
		
		return null;
	}
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC Template로 insertBoard() 기능 처리");
		
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC Template로 updateBoard() 기능 처리");
		
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getWriter(), vo.getSeq());
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC Template로 deleteBoard() 기능 처리");
		
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
}
