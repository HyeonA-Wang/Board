package kr.hs.gms.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kr.hs.gms.board.service.impl.BoardDAO;
import kr.hs.gms.board.vo.BoardVO;
import kr.hs.gms.users.vo.UserVO;

public class GetBoardController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 검색 처리");
		
		UserVO userSession = (UserVO) request.getSession().getAttribute("sessUser");
		ModelAndView mv = new ModelAndView();
		
		if(userSession != null) {
			//1. 검색할 게시글 번호 추출
			String seq = request.getParameter("seq");
			
			//2.DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.selectBoard(vo);
			
			//3. 검색 결과와 화면정보를 ModelAndView에 저장하여 리턴한다
			mv.addObject("board", board);
			mv.setViewName("board/getBoard");
		} else {
			mv.setViewName("redirect:login.do");
		}
		
		return mv;
	}
	
}
