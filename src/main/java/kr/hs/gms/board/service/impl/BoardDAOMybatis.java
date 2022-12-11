package kr.hs.gms.board.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.hs.gms.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAOMybatis extends SqlSessionDaoSupport{
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public BoardVO selectBoard(BoardVO vo) {
		System.out.println("===> Mybatis(방법1)로 selectBoard() 기능 처리");
		return (BoardVO) getSqlSession().selectOne("BoardDAO.selectBoard", vo);
	}
	
//	public List<BoardVO> selectBoardList(BoardVO vo) {
//		System.out.println("===> Mybatis(방법1)로 selectBoardList() 기능 처리");
//		List<BoardVO> retList = null;
//		if(vo.getSearchCondition().equals("TITLE")) {
//			retList = getSqlSession().selectOne("BoardDAO.selectBoardList_T", vo);
//		}else if(vo.getSearchCondition().equals("CONTENT")) {
//			retList = getSqlSession().selectOne("BoardDAO.selectBoardList_C", vo);
//		}
//		return retList;
//	}
	
	public List<BoardVO> selectBoardList(BoardVO vo) {
		System.out.println("===> Mybatis(방법1)로 selectBoardList() 기능 처리");
		return getSqlSession().selectList("BoardDAO.selectBoardList", vo);
	}
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis(방법1)로 insertBoard() 기능 처리");
		getSqlSession().insert("BoardDAO.deleteBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis(방법1)로 updateBoard() 기능 처리");
		getSqlSession().update("BoardDAO.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis(방법1)로 deleteBoard() 기능 처리");
		getSqlSession().delete("BoardDAO.deleteBoard", vo);
	}
}
