package kr.hs.gms.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kr.hs.gms.board.service.impl.BoardDAO;
import kr.hs.gms.board.vo.BoardVO;
import kr.hs.gms.users.vo.UserVO;

public class GetBoardListController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");
		
		UserVO userSession = (UserVO) request.getSession().getAttribute("sessUser");
		ModelAndView mv = new ModelAndView();
		
		if(userSession != null) {
			//1. 사용자 입력정보 추출
			//2. DB 연동 처리
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.selectBoardList(vo);
			
			//3. 검색 결과와 화면 정보를 ModelAndView에 저자하여 리턴한다
			mv.addObject("boardList", boardList);
			mv.setViewName("board/getBoardList");
		} else {
			mv.setViewName("redirect:login.do");
		}
		return mv;
	}
}
